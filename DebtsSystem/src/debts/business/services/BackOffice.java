package ro.fortech.academy.debts.business.services;

import ro.fortech.academy.debts.business.entities.*;
import ro.fortech.academy.debts.persistence.*;

import java.util.List;

public class BackOffice {
    private final ClientDataAccessObject clientDataAccessObject;
    private final DebtorDataAccessObject debtorDataAccessObject;
    private final ContractDataAccessObject contractDataAccessObject;
    private final BillDataAccessObject billDataAccessObject;
    private final RecoveryDataAccessObject recoveryDataAccessObject;

    public BackOffice( ClientDataAccessObject clientDataAccessObject, DebtorDataAccessObject debtorDataAccessObject, ContractDataAccessObject contractDataAccessObject, BillDataAccessObject billDataAccessObject, RecoveryDataAccessObject recoveryDataAccessObject) {
        this.clientDataAccessObject = clientDataAccessObject;
        this.debtorDataAccessObject = debtorDataAccessObject;
        this.contractDataAccessObject = contractDataAccessObject;
        this.billDataAccessObject = billDataAccessObject;
        this.recoveryDataAccessObject = recoveryDataAccessObject;
    }
    public List<Debtor> getBack() {
        List<Debtor> back = debtorDataAccessObject.loadAllDebtors();
        return back;
    }
    public void addNewIndebted(Debtor newIndebted) {
        List<Debtor> back = debtorDataAccessObject.loadAllDebtors();
        back.add(newIndebted);
        debtorDataAccessObject.saveAllDebtors(back);
    }

    public void removeExistingIndebted(String CNP) {
        List<Debtor> back = debtorDataAccessObject.loadAllDebtors();
        int index = getIndebtedIndex(back, CNP);
        if (index != -1) {
            back.remove(index);
            debtorDataAccessObject.saveAllDebtors(back);
        }
    }

    private int getIndebtedIndex(List<Debtor> back, String CNP) {
        for (int currentIndex = 0; currentIndex < back.size(); currentIndex++) {
            Debtor currentIndebted = back.get(currentIndex);
            if (currentIndebted.getCNP().equals(CNP)) {
                return currentIndex;
            }
        }
        return -1;
    }

   public List<Client> getBackoff() {

        return clientDataAccessObject.loadAllClients();
    }
    public List<Contract> getBck() {

        return contractDataAccessObject.loadAllContracts();
    }
    public List<Bill> getBacko() {

        return billDataAccessObject.loadAllBills();
    }
    public List<Recovery> getBackof() {

        return recoveryDataAccessObject.loadAllRecoveries();
    }

    public List<Debtor> getback() {

        return debtorDataAccessObject.loadAllDebtors();
    }
}
