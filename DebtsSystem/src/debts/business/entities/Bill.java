package ro.fortech.academy.debts.business.entities;

public class Bill {
    private final String billNumber;
    private final String ctrNumber;
    private final String debtBill;
    private final String dueDate;
    private final String typeService;

    public Bill(String billNumber, String ctrNumber, String debtBill, String dueDate, String typeService) {
        this.billNumber = billNumber;
        this.ctrNumber = ctrNumber;
        this.debtBill = debtBill;
        this.dueDate = dueDate;
        this.typeService = typeService;
    }
    public String toString() {
        return "Bill{" +
                "billNumber='" + billNumber + '\'' +
                ", ctrNumber='" + ctrNumber + '\'' +
                ", debtBill='" + debtBill + '\'' +
                ", dueDate='" + dueDate + '\'' +
                ", typeService='" + typeService + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bill bill = (Bill) o;

        if (!billNumber.equals(bill.billNumber)) return false;
        if (!ctrNumber.equals(bill.ctrNumber)) return false;
        if (!debtBill.equals(bill.debtBill)) return false;
        if (!dueDate.equals(bill.dueDate)) return false;
        return typeService.equals(bill.typeService);
    }

    @Override
    public int hashCode() {
        int result = billNumber.hashCode();
        result = 31 * result + ctrNumber.hashCode();
        result = 31 * result + debtBill.hashCode();
        result = 31 * result + dueDate.hashCode();
        result = 31 * result + typeService.hashCode();
        return result;
    }
}
