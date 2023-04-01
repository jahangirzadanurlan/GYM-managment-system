package service.impl;

import model.Client;
import repository.ClientRepository;
import repository.impl.ClientRepositoryImpl;
import service.ClientService;
import util.InputUtil;

import java.time.LocalDate;
import java.util.List;

public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    public ClientServiceImpl() {
        clientRepository=new ClientRepositoryImpl();
    }
    @Override
    public void registerClient() {
        clientRepository.registerClient(fillClient());
    }

    private Client fillClient() {
        String name= InputUtil.requiredInputString("Enter the name: ");
        String surname= InputUtil.requiredInputString("Enter the surname: ");
        String fin= InputUtil.requiredInputString("Enter the fin: ");
        String serialNumber= InputUtil.requiredInputString("Enter the serial number(passport): ");
        int departure=InputUtil.requiredInputInt("Enter the departures: ");
        LocalDate registerDate=InputUtil.requiredInputDate("Enter register date(yyyy-MM-dd): ");
        LocalDate updateDate=LocalDate.now();
        LocalDate memberExpirationDate=InputUtil.requiredInputDate("Enter member expiration date date(yyyy-MM-dd): ");
        int amount =InputUtil.requiredInputInt("Enter the amount: ");

        return new Client(name,surname,fin,serialNumber,departure,registerDate,updateDate,memberExpirationDate,amount);
    }

    @Override
    public void updateClient() {
        String fin=InputUtil.requiredInputString("Enter Client fin: ");
        if(showAllClient().stream().anyMatch(i->i.getFin().equals(fin))){
            int departures=InputUtil.requiredInputInt("Add number of departures: ");
            LocalDate updateDate=InputUtil.requiredInputDate("Enter update date(yyyy-MM-dd): ");
            LocalDate membershipExpirationDate=InputUtil.requiredInputDate("Enter the membership expiration date(yyyy-MM-dd): ");

            clientRepository.updateClient(fin,departures,updateDate,membershipExpirationDate);
        }else {
            System.out.println("Member not found!");
        }
    }

    @Override
    public void increaseDeparture(String fin) {
        clientRepository.increaseDeparture(fin);
    }

    @Override
    public int findDeparturesByFin(String fin) {
        return clientRepository.findDeparturesById(fin);
    }

    @Override
    public List<Client> showAllClient() {
        return clientRepository.showAllClient();
    }
}
