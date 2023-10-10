package ro.fortech.academy.debts.business.entities;

public class Debtor {
    private String CNP;
    private String firstName;
    private String lastName;
    private String birthday;
    private String status;
    public Debtor(String CNP, String firstName, String lastName, String birthday, String status) throws InvalidCNPException {
        validateCNP(CNP);
        this.CNP = CNP;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.status = status;
    }
    @Override
    public String toString() {
        return "Debtor{" +
                "CNP='" + CNP + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday='" + birthday + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Debtor debtor = (Debtor) o;

        if (!CNP.equals(debtor.CNP)) return false;
        if (!firstName.equals(debtor.firstName)) return false;
        if (!lastName.equals(debtor.lastName)) return false;
        if (!birthday.equals(debtor.birthday)) return false;
        return status.equals(debtor.status);
    }
    @Override
    public int hashCode() {
        int result = CNP.hashCode();
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + birthday.hashCode();
        result = 31 * result + status.hashCode();
        return result;
    }
    private void validateCNP(String CNP) throws InvalidCNPException {
        if (!isValidCNP(CNP)) {
            throw new InvalidCNPException(CNP);
        }
    }
    private boolean isValidCNP(String CNP) {
        return CNP.length() == 13;
    }

    public String getCNP(){
        return CNP;
    }
    public void setCNP(String CNP) {
        this.CNP = CNP;
    }
    public String getfirstName(){
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getlastName(){
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getbirthday(){
        return birthday;
    }
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    public String getstatus(){
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}