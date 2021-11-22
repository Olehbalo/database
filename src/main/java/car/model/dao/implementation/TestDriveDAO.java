package car.model.dao.implementation;

import car.model.dao.AbstractDAO;
import car.model.entity.TestDrive;
import car.persistant.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestDriveDAO implements AbstractDAO<TestDrive> {
    private static final String GET_ALL = "SELECT * FROM projectlab.car";
    private static final String GET_BY_ID = "SELECT * FROM projectlab.car WHERE id=?";
    private static final String CREATE = "INSERT projectlab.car "
            + "(`brand`, `card_id`) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE projectlab.car"
            + " SET brand=?, car_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM projectlab.car WHERE id=?";

    @Override
    public List<TestDrive> findAll() throws SQLException {
        List<TestDrive> amenities = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                TestDrive testDrive = new TestDrive(
                        resultSet.getInt("id"),
                        resultSet.getString("brand"),
                        resultSet.getInt("car_id")
                );
                amenities.add(testDrive);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return amenities;
    }

    @Override
    public TestDrive findById(Integer id) throws SQLException {
        TestDrive testDrive = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                testDrive = new TestDrive(
                        resultSet.getInt("id"),
                        resultSet.getString("brand"),
                        resultSet.getInt("car_id")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return testDrive;
    }

    @Override
    public void create(TestDrive testDrive) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, String.valueOf(testDrive.getBrand()));
            statement.setString(2, String.valueOf(testDrive.getCarId()));
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Integer id, TestDrive testDrive) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, testDrive.getBrand());
            statement.setInt(2, testDrive.getCarId());
            statement.setInt(3, testDrive.getId());
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
