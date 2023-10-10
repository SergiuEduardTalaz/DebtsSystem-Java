package ro.fortech.academy.debts.business.entities;

public class Recovery {
    private final String cntrNumber;
    private final String dbtrName;
    private final String dbtTotal;
    private final String payorNot;
    private final String payingWay;
    private final String payingDate;
    private final String percentageDiscount;
    private final String installmentsNumber;

    public Recovery(String cntrNumber, String dbtrName, String dbtTotal, String payorNot, String payingWay, String payingDate, String percentageDiscount, String installmentsNumber) {
        this.cntrNumber = cntrNumber;
        this.dbtrName = dbtrName;
        this.dbtTotal = dbtTotal;
        this.payorNot = payorNot;
        this.payingWay = payingWay;
        this.payingDate = payingDate;
        this.percentageDiscount = percentageDiscount;
        this.installmentsNumber = installmentsNumber;
    }
    public String toString() {
        return "Recovery{" +
                "cntrNumber='" + cntrNumber + '\'' +
                ", dbtrName='" + dbtrName + '\'' +
                ", dbtTotal='" + dbtTotal + '\'' +
                ", payorNot='" + payorNot + '\'' +
                ", payingWay='" + payingWay + '\'' +
                ", payingDate='" + payingDate + '\'' +
                ", percentageDiscount='" + percentageDiscount + '\'' +
                ", installmentsNumber='" + installmentsNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Recovery recovery = (Recovery) o;

        if (!cntrNumber.equals(recovery.cntrNumber)) return false;
        if (!dbtrName.equals(recovery.dbtrName)) return false;
        if (!dbtTotal.equals(recovery.dbtTotal)) return false;
        if (!payorNot.equals(recovery.payorNot)) return false;
        if (!payingWay.equals(recovery.payingWay)) return false;
        if (!payingDate.equals(recovery.payingDate)) return false;
        if (!percentageDiscount.equals(recovery.percentageDiscount)) return false;
        return installmentsNumber.equals(recovery.installmentsNumber);
    }

    @Override
    public int hashCode() {
        int result = cntrNumber.hashCode();
        result = 31 * result + dbtrName.hashCode();
        result = 31 * result + dbtTotal.hashCode();
        result = 31 * result + payorNot.hashCode();
        result = 31 * result + payingWay.hashCode();
        result = 31 * result + payingDate.hashCode();
        result = 31 * result + percentageDiscount.hashCode();
        result = 31 * result + installmentsNumber.hashCode();
        return result;
    }
}
