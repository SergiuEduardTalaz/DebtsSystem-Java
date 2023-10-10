package ro.fortech.academy.debts.presentation;

import ro.fortech.academy.debts.business.entities.*;
import ro.fortech.academy.debts.business.services.BackOffice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class UserInterface {
    private final BufferedReader bufferedReader;
    private final BackOffice backOffice;

    public UserInterface(BackOffice backOffice) {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        this.backOffice = backOffice;
    }

    public void printGreetingMessage() {
        System.out.println("Hello from BackOffice!");
    }
    private String readLine() {
        try {
            return bufferedReader.readLine();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
    public void showMainMenu() {
        String option;
        do {
            printOptions();
            System.out.print("Please choose your option: ");
            option = readLine();
            System.out.println("Your option is: " + option);
            handleOption(option);
        } while (shouldContinue(option));
    }
    private void printOptions() {
        System.out.println("----------------------------");
        System.out.println("1 - Print back data");
        System.out.println("2 - Add new indebted");
        System.out.println("3 - Remove existing indebted");
        System.out.println("0 - Exit application");
        System.out.println("----------------------------");
    }
    private void handleOption(String option) {
        switch (option) {
            case "1":
                handlePrintBackData();
                break;
            case "2":
                handleAddNewIndebted();
                break;
            case "3":
                handleRemoveExistingIndebted();
                break;
            case "0":
                handleExitApplication();
                break;
            default:
                handleInvalidOption(option);
        }
    }
    private void handlePrintBackData() {
        System.out.println("Print back data...");
        List<Debtor> back = backOffice.getback();
        printBackData(back);
    }

    private void printBackData(List<Debtor> back) {
        for (Debtor currentIndebted : back) {
            System.out.println(currentIndebted.toString());
        }
    }

    private void handleAddNewIndebted() {
        System.out.println("Add new indebted...");
        try {
        Debtor newIndebted = readDebtor();
        backOffice.addNewIndebted(newIndebted);
        } catch (InvalidCNPException exception) {
            System.out.println(exception.getCNP() + " is not a valid CNP.");
        }
    }

    private Debtor readDebtor() throws InvalidCNPException {
        System.out.print("Please enter CNP: ");
        String CNP = readLine();
        System.out.print("Please enter first name: ");
        String firstName = readLine();
        System.out.print("Please enter last name: ");
        String lastName = readLine();
        System.out.print("Please enter birthday: ");
        String birthday = readLine();
        System.out.print("Please enter status: ");
        String status = readLine();

        Debtor debtor = new Debtor(CNP, firstName, lastName, birthday, status);
        return debtor;
    }

    private void handleRemoveExistingIndebted() {
        System.out.println("Remove existing indebted...");
        System.out.print("Please enter CNP: ");
        String CNP = readLine();
        backOffice.removeExistingIndebted(CNP);
    }

    private void handleExitApplication() {
        System.out.println("Exit application...");
        System.out.println("Bye bye!");
    }

    private void handleInvalidOption(String option) {
        System.out.println(option + " is invalid.");
    }

    private boolean shouldContinue(String option) {
        return !"0".equals(option);
    }
    public void printBackDetails() {
        List<Debtor> back = backOffice.getBack();
        printListOfDebtors(back);
    }
    private void printListOfDebtors(List<Debtor> back) {
        for (Debtor currentDebtor : back) {
            System.out.println(currentDebtor.toString());
        }
    }

    public void printBackoffDetails() {
        List<Client> backoff = backOffice.getBackoff();
        printListOfClients(backoff);
    }
    private void printListOfClients(List<Client> backoff) {
        for (Client currentClient : backoff) {
            System.out.println(currentClient.toString());
        }
    }

    public void printBckDetails() {
        List<Contract> bck = backOffice.getBck();
        printListOfContracts(bck);
    }
    private void printListOfContracts(List<Contract> bck) {
        for (Contract currentContract : bck) {
            System.out.println(currentContract.toString());
        }
    }

    public void printBackoDetails() {
        List<Bill> backo = backOffice.getBacko();
        printListOfBills(backo);
    }
    private void printListOfBills(List<Bill> backo) {
        for (Bill currentBill : backo) {
            System.out.println(currentBill.toString());
        }
    }

    public void printBackofDetails() {
        List<Recovery> backof = backOffice.getBackof();
        printListOfRecoveries(backof);
    }
    private void printListOfRecoveries(List<Recovery> backof) {
        for (Recovery currentRecovery : backof) {
            System.out.println(currentRecovery.toString());
        }
    }
}

