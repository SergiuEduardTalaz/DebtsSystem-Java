package ro.fortech.academy.debts;

import ro.fortech.academy.debts.business.services.BackOffice;
import ro.fortech.academy.debts.business.services.PersonService;
import ro.fortech.academy.debts.persistence.*;
import ro.fortech.academy.debts.presentation.PersonController;
import ro.fortech.academy.debts.presentation.PersonModel;
import ro.fortech.academy.debts.presentation.PersonView;
import ro.fortech.academy.debts.presentation.UserInterface;

public class Main {
    public static void main(String[] args) {
        ClientDataAccessObject clientDataAccessObject= new ClientDataAccessObject();
        DebtorDataAccessObject debtorDataAccessObject= new DebtorDataAccessObject();
        ContractDataAccessObject contractDataAccessObject= new ContractDataAccessObject();
        BillDataAccessObject billDataAccessObject= new BillDataAccessObject();
        RecoveryDataAccessObject recoveryDataAccessObject= new RecoveryDataAccessObject();
        BackOffice backOffice = new BackOffice (clientDataAccessObject, debtorDataAccessObject, contractDataAccessObject, billDataAccessObject, recoveryDataAccessObject);
        UserInterface userInterface = new UserInterface (backOffice);

        public static void main (String[] args) {
            PersonService service = new PersonService(new PersonDaoPostgresImpl());
            service.update("   '; DROP table cars_tmp;update persons set adress ='aaaa' WHERE ''='", "adddress");
            PersonModel model = new PersonModel(service.getAllPersons());

            PersonView view = new PersonView(model.getPersonList());

            PersonController controller = new PersonController(view, model, service);
            view.setController(controller);
        }

        userInterface.printGreetingMessage();
        userInterface.showMainMenu();
        userInterface.printBackDetails();
        userInterface.printBackoffDetails();
        userInterface.printBckDetails();
        userInterface.printBackoDetails();
        userInterface.printBackofDetails();
    }
}