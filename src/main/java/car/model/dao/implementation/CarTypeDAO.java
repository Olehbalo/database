package car.model.dao.implementation;

import car.model.dao.AbstractDAO;
import car.model.entity.CarType;
import car.persistant.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarTypeDAO implements AbstractDAO<CarType> {
    private static final String GET_ALL = "SELECT * FROM projectlab.car";
    private static final String GET_BY_ID = "SELECT * FROM projectlab.car WHERE id=?";
    private static final String CREATE = "INSERT projectlab.car "
            + "(`type`,  `car_id`) VALUES (?,  ?)";
    private static final String UPDATE = "UPDATE projectlab.car"
            + " SET type=?,  car_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM projectlab.car WHERE id=?";

    @Override
    public List<CarType> findAll() throws SQLException {
        List<CarType> amenities = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                CarType carType = new CarType(
                        resultSet.getInt("id"),
                        resultSet.getString("type"),
                        resultSet.getInt("car_id")
                );
                amenities.add(carType);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return amenities;
    }

    @Override
    public CarType findById(Integer id) throws SQLException {
        CarType carType = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                carType = new CarType(
                        resultSet.getInt("id"),
                        resultSet.getString("type"),
                        resultSet.getInt("car_id")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return carType;
    }

    @Override
    public void create(CarType carType) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, String.valueOf(carType.getType()));
            statement.setString(2, String.valueOf(carType.getCarId()));
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Integer id, CarType carType) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, carType.getType());
            statement.setInt(2, carType.getCarId());
            statement.setInt(3, carType.getId());
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
