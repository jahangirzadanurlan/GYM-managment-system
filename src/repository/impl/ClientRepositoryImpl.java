package repository.impl;

import model.Client;
import queries.ClientQueries;
import repository.ClientRepository;
import repository.DBConnection;

import java.sql.*;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class ClientRepositoryImpl implements ClientRepository {
    @Override
    public boolean registerClient(Client client) {
        try (Connection connection = DBConnection.connect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(ClientQueries.REGISTER_CLIENT);
            preparedStatement.setString(1, client.getName());
            preparedStatement.setString(2, client.getSurname());
            preparedStatement.setString(3, client.getFin());
            preparedStatement.setString(4, client.getSerialNumber());
            preparedStatement.setInt(5, client.getDeparture());
            preparedStatement.setDate(6, Date.valueOf(client.getRegisterDate()));
            preparedStatement.setDate(7, Date.valueOf(client.getUpdateDate()));
            preparedStatement.setDate(8, Date.valueOf(client.getMemberExpiration()));
            preparedStatement.setInt(9, client.getAmount());

            int val = preparedStatement.executeUpdate();

            return val > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateClient(int id, int departure, LocalDate updateDate, LocalDate memberExpirationDate) {
        try (Connection connection = DBConnection.connect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(ClientQueries.UPDATE_CLIENT);
            preparedStatement.setInt(1, departure);
            preparedStatement.setDate(2, Date.valueOf(updateDate));
            preparedStatement.setDate(3, Date.valueOf(memberExpirationDate));
            preparedStatement.setInt(4, id);


            int val = preparedStatement.executeUpdate();
            return val > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean increaseDeparture(String fin) {
        try (Connection connection = DBConnection.connect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(ClientQueries.INCREASE_DEPARTURE);
            preparedStatement.setString(1, fin);

            int val = preparedStatement.executeUpdate();
            return val > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public int findDeparturesById(String fin) {
        try (Connection connection = DBConnection.connect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(ClientQueries.FIND_DEPARTURE_BY_FIN);
            preparedStatement.setString(1, fin);

            ResultSet resultSet = preparedStatement.executeQuery();
            int val = 0;
            while (resultSet.next()){
                val=resultSet.getInt("departures");
            }

            return val;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Client> showAllClient() {
        try (Connection connection = DBConnection.connect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(ClientQueries.SHOW_ALL_CLIENT);

            List<Client> clients = new LinkedList<>();
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String fin = resultSet.getString("fin");
                String serialNumber = resultSet.getString("serialNumber");
                int departures = resultSet.getInt("departures");
                Date registerDate = resultSet.getDate("registerDate");
                Date updateDate = resultSet.getDate("updateDate");
                Date memberExpirationDate = resultSet.getDate("memberexpirationdate");
                int amount = resultSet.getInt("amount");

                clients.add(new Client(name, surname, fin, serialNumber, departures, registerDate.toLocalDate(), updateDate.toLocalDate(), memberExpirationDate.toLocalDate(), amount));
            }

            return clients;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
