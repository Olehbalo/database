package car.model.dao.implementation;

import car.model.dao.AbstractDAO;
import car.model.entity.Customer;
import car.persistant.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO implements AbstractDAO<Customer> {
    private static final String GET_ALL = "SELECT * FROM projectlab.car";
    private static final String GET_BY_ID = "SELECT * FROM projectlab.car WHERE id=?";
    private static final String CREATE = "INSERT projectlab.car "
            + "(`firs_name`, `last_name`, `email`) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE projectlab.car"
            + " SET first_name=?, last_name=?, email=? WHERE id=?";
    private static final String DELETE = "DELETE FROM projectlab.car WHERE id=?";

    @Override
    public List<Customer> findAll() throws SQLException {
        List<Customer> amenities = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Customer customer = new Customer(
                        resultSet.getInt("id"),
                        resultSet.getString("firs_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("email")
                );
                amenities.add(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return amenities;
    }

    @Override
    public Customer findById(Integer id) throws SQLException {
        Customer customer = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                customer = new Customer(
                        resultSet.getInt("id"),
                        resultSet.getString("firs_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("email")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public void create(Customer customer) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, String.valueOf(customer.getFirstName()));
            statement.setString(2, String.valueOf(customer.getLastName()));
            statement.setString(3, String.valueOf(customer.getEmail()));
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Integer id, Customer customer) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, customer.getFirstName());
            statement.setString(2, customer.getLastName());
            statement.setString(3, customer.getEmail());
            statement.setInt(4, customer.getId());
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(DELETE)) {
            statement.setInt(1, id);
            System.out.println(statement);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
