package ro.fortech.academy.debts.persistence;

import ro.fortech.academy.debts.util.DBUtil;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonDaoPostgresImpl implements PersonDao {
    public List<Person> getAllPersons() {
        List<Person> persons = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet rs =null;
        try {
            connection = DBUtil.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery("SELECT * from persons");
            while (rs.next()) {
                String cnp = rs.getString("cnp");
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);
                String address = rs.getString(4);
                String phone = rs.getString(5);
                String email = rs.getString(6);
                //String cnp, String firstName, String lastName, String address, String phone, String email)
                Person person = new Person(cnp, firstName, lastName, address, phone, email);
                persons.add(person);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.closeConnection(connection);
        }
        return persons;
    }

    @Override
    public void updateValues(String cnp, String adress) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DBUtil.getConnection();
            statement = connection.prepareStatement("update persons set adress = ? where cnp = ?");
            statement.setString(1, adress);
            statement.setString(2, cnp);
            int noOfUpdates = statement.executeUpdate();
            System.out.println("NUmber of updated records = " + noOfUpdates);
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(connection);
        }
    }
}
