package ro.fortech.academy.debts.business.services;

import ro.fortech.academy.debts.persistence.Person;
import ro.fortech.academy.debts.persistence.PersonDao;

import java.util.List;
import java.util.stream.Collectors;

public class PersonService {
    private PersonDao personDao;

    public PersonService(PersonDao personDao) {
        this.personDao = personDao;
    }

    public List<Person> getAllPersons() {
        List<Person> list = personDao.getAllPersons();
        return list.stream().sorted().collect(Collectors.toList());
    }

    public void update(String cnp, String address) {
        personDao.updateValues(cnp, address);
    }
}
