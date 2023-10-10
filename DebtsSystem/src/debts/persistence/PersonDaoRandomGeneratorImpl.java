package ro.fortech.academy.debts.persistence;

import ro.fortech.academy.debts.util.RandomUtil;

import java.util.ArrayList;
import java.util.List;

public class PersonDaoRandomGeneratorImpl implements PersonDao {
    public List<Person> getAllPersons() {
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            String cnp = String.valueOf(RandomUtil.getRandomInteger());
            String firstName = RandomUtil.getRandomString(20);
            String lastName = RandomUtil.getRandomString(25);
            String address = RandomUtil.getRandomString(50);
            String phone = String.valueOf(RandomUtil.getRandomInteger());
            String email = RandomUtil.getRandomString(30);
            persons.add(new Person(cnp, firstName, lastName, address, phone, email));
        }
        return persons;
    }

    @Override
    public void updateValues(String cnp, String adress) {

    }
}
