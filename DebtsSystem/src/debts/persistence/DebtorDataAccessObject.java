package ro.fortech.academy.debts.persistence;

import ro.fortech.academy.debts.business.entities.Debtor;
import ro.fortech.academy.debts.business.entities.InvalidCNPException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DebtorDataAccessObject {
    public List<Debtor> loadAllDebtors() {
        List<Debtor> debtors = new ArrayList<>();
        try (FileReader fileReader = new FileReader("resources/debtors.txt")) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String currentLine = bufferedReader.readLine();
            while (!"---".equals(currentLine)) {
                try {
                    Debtor currentDebtor = readDebtors(bufferedReader);
                    debtors.add(currentDebtor);
                } catch (InvalidCNPException exception) {
                    //ignore
                }
                currentLine = bufferedReader.readLine();
            }
        } catch (IOException exception) {
            System.out.println("The file can't be found!");
            throw new RuntimeException(exception);
        }
        return debtors;
    }

    public void saveAllDebtors(List<Debtor> debtors) {
        try (FileWriter fileWriter = new FileWriter("resources/debtors.txt")) {
            PrintWriter printWriter = new PrintWriter(fileWriter);
            for (Debtor currentDebtor : debtors) {
                writeDebtor(printWriter, currentDebtor);
            }
            printWriter.println("---");
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
    private static Debtor readDebtors(BufferedReader bufferedReader) throws IOException, InvalidCNPException {
        String CNP = bufferedReader.readLine();
        String firstName = bufferedReader.readLine();
        String lastName = bufferedReader.readLine();
        String birthday = bufferedReader.readLine();
        String status = bufferedReader.readLine();
        return new Debtor(CNP, firstName, lastName, birthday, status);
    }

    private void writeDebtor(PrintWriter printWriter, Debtor debtor) {
        printWriter.println("+++");
        printWriter.println(debtor.getCNP());
        printWriter.println(debtor.getfirstName());
        printWriter.println(debtor.getlastName());
        printWriter.println(debtor.getbirthday());
        printWriter.println(debtor.getstatus());
    }
}
