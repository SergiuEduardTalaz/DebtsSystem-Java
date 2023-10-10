package ro.fortech.academy.debts.business.entities;

public class Client {
    private final String idClient;
    private final String clientName;
    private final String serviceType;
    private final String debtorsNumber;
    private final String debtsTotal;

    public Client(String idClient, String clientName, String serviceType, String debtorsNumber, String debtsTotal) {
        this.idClient = idClient;
        this.clientName = clientName;
        this.serviceType = serviceType;
        this.debtorsNumber = debtorsNumber;
        this.debtsTotal = debtsTotal;
    }
    @Override
    public String toString() {
        return "Client{" +
                "idClient='" + idClient + '\'' +
                ", clientName='" + clientName + '\'' +
                ", serviceType='" + serviceType + '\'' +
                ", debtorsNumber='" + debtorsNumber + '\'' +
                ", debtsTotal='" + debtsTotal + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (!idClient.equals(client.idClient)) return false;
        if (!clientName.equals(client.clientName)) return false;
        if (!serviceType.equals(client.serviceType)) return false;
        if (!debtorsNumber.equals(client.debtorsNumber)) return false;
        return debtsTotal.equals(client.debtsTotal);
    }

    @Override
    public int hashCode() {
        int result = idClient.hashCode();
        result = 31 * result + clientName.hashCode();
        result = 31 * result + serviceType.hashCode();
        result = 31 * result + debtorsNumber.hashCode();
        result = 31 * result + debtsTotal.hashCode();
        return result;
    }
}
