package ro.fortech.academy.debts.business.entities;

public class Contract {
    private final String ctrNumber;
    private final String debtorName;
    private final String clntName;
    private final String billsNumbers;
    private final String debtTotal;
    private final String contractStatus;

    public String getCtrNumber() {
        return ctrNumber;
    }

    public String getDebtorName() {
        return debtorName;
    }

    public String getClntName() {
        return clntName;
    }

    public String getBillsNumbers() {
        return billsNumbers;
    }

    public String getDebtTotal() {
        return debtTotal;
    }

    public String getContractStatus() {
        return contractStatus;
    }

    public Contract(String ctrNumber, String debtorName, String clntName, String billsNumbers, String debtTotal, String contractStatus) {
        this.ctrNumber = ctrNumber;
        this.debtorName = debtorName;
        this.clntName = clntName;
        this.billsNumbers = billsNumbers;
        this.debtTotal = debtTotal;
        this.contractStatus = contractStatus;
    }
    public String toString() {
        return "Contract{" +
                "ctrNumber='" + ctrNumber + '\'' +
                ", debtorName='" + debtorName + '\'' +
                ", clntName='" + clntName + '\'' +
                ", billsNumbers='" + billsNumbers + '\'' +
                ", debtTotal='" + debtTotal + '\'' +
                ", contractStatus='" + contractStatus + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contract contract = (Contract) o;

        if (!ctrNumber.equals(contract.ctrNumber)) return false;
        if (!debtorName.equals(contract.debtorName)) return false;
        if (!clntName.equals(contract.clntName)) return false;
        if (!billsNumbers.equals(contract.billsNumbers)) return false;
        if (!debtTotal.equals(contract.debtTotal)) return false;
        return contractStatus.equals(contract.contractStatus);
    }

    @Override
    public int hashCode() {
        int result = ctrNumber.hashCode();
        result = 31 * result + debtorName.hashCode();
        result = 31 * result + clntName.hashCode();
        result = 31 * result + billsNumbers.hashCode();
        result = 31 * result + debtTotal.hashCode();
        result = 31 * result + contractStatus.hashCode();
        return result;
    }

}
