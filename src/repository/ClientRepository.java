package repository;

import model.Client;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.List;

public interface ClientRepository {
    boolean registerClient(Client client);
    boolean updateClient(int departure, int id, LocalDate updateDate,LocalDate memberExpirationDate);
    boolean increaseDeparture(String fin);
    int findDeparturesById(String fin);
    List<Client> showAllClient();
}
