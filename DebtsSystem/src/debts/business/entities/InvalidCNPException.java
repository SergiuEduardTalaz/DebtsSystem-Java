package ro.fortech.academy.debts.business.entities;

public class InvalidCNPException extends Exception {
    private final String CNP;

    public InvalidCNPException(String CNP) {
        this.CNP = CNP;
    }

    public String getCNP() {
        return CNP;
    }
}
