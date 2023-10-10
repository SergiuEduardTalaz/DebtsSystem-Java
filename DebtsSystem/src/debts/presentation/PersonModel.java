package ro.fortech.academy.debts.presentation;

import ro.fortech.academy.debts.persistence.Person;

import java.util.List;

public class PersonModel {
    private List<Person> personList;

    public PersonModel(List<Person> personList) {
        this.personList = personList;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }
}
