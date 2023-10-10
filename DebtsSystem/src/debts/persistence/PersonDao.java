package ro.fortech.academy.debts.persistence;

import java.util.List;

public class PersonDao {
    List<Person> getAllPersons();

    void updateValues(String cnp, String adress);
}
