package ro.fortech.academy.debts.persistence;

import ro.fortech.academy.debts.business.entities.Client;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDataAccessObject {
    public List<Client> loadAllClients() {
        List<Client> clients = new ArrayList<>();
        try (FileReader fileReader = new FileReader("resources/clients-in.txt")) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String currentLine = bufferedReader.readLine();
            while (!"---".equals(currentLine)) {
                Client currentClient = readClient(bufferedReader);
                clients.add(currentClient);
                currentLine = bufferedReader.readLine();
            }
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        return clients;
    }


    private Client readClient(BufferedReader bufferedReader) throws IOException {
        String idClient = bufferedReader.readLine();
        String clientName = bufferedReader.readLine();
        String serviceType = bufferedReader.readLine();
        String debtorsNumber = bufferedReader.readLine();
        String debtsTotal = bufferedReader.readLine();
        return new Client(idClient, clientName, serviceType, debtorsNumber, debtsTotal);
    }

}

