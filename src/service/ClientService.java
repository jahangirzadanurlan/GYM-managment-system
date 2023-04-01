package service;

import model.Client;

import java.sql.ResultSet;
import java.util.List;

public interface ClientService {
    void registerClient();
    void updateClient();
    void increaseDeparture(String fin);
    int findDeparturesByFin(String fin);
    List<Client> showAllClient();
}
