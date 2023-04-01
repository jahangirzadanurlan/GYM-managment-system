package util;

import model.Client;
import service.impl.ClientServiceImpl;

public class Menu {
    public static int homePage() {
        System.out.println("---------| Home Page |---------");
        System.out.println("""
                0.Exit
                1.Register gym member
                2.Show all members
                3.Enter the gym
                4.Update departures""");
        return InputUtil.requiredInputInt("Choose option: ");
    }

    public static void start() {
        ClientServiceImpl clientService = new ClientServiceImpl();
        while (true) {
            int choose = homePage();
            if (choose == 0) {
                System.out.println("Bye bye..");
                System.exit(-1);
            } else if (choose == 1) {
                clientService.registerClient();
            } else if (choose == 2) {
                System.out.println(clientService.showAllClient());
            } else if (choose == 3) {
                String fin = InputUtil.requiredInputString("Enter Client fin: ");
                int departures = clientService.findDeparturesByFin(fin);
                if (departures > 0) {
                    clientService.increaseDeparture(fin);
                    String name = clientService.showAllClient().stream()
                            .filter(i -> i.getFin().equals(fin))
                            .map(i->i.getName())
                            .findFirst().get();
                    String surname = clientService.showAllClient().stream()
                            .filter(i -> i.getFin().equals(fin))
                            .map(Client::getSurname)
                            .findFirst().get();
                    System.out.println("----" + name + " " + surname + " - " + clientService.findDeparturesByFin(fin) + " departures left");
                }else{
                    System.out.println("---- Rejected ----");
                }
            } else if (choose == 4) {
                clientService.updateClient();
            } else {
                System.out.println("Wrong oprion!!!");
            }
        }

    }

}
