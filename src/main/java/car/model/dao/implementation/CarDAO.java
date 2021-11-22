package car.model.dao.implementation;

import car.model.dao.AbstractDAO;
import car.model.entity.Car;
import car.persistant.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarDAO implements AbstractDAO<Car> {
    private static final String GET_ALL = "SELECT * FROM projectlab.car";
    private static final String GET_BY_ID = "SELECT * FROM projectlab.car WHERE id=?";
    private static final String CREATE = "INSERT projectlab.car "
            + "(`brand`, `graduathion_year`, `ser_num`,`is_new`, `is_sold`, `comment_id`, `seller_id` ) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE projectlab.car"
            + " SET brand=?, graduathion_year=?, ser_num=?, is_new=?, is_sold=?, comment_id=?, seller_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM projectlab.car WHERE id=?";

    @Override
    public List<Car> findAll() throws SQLException {
        List<Car> amenities = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Car car = new Car(
                        resultSet.getInt("id"),
                        resultSet.getString("brand"),
                        resultSet.getInt("graduathion_year"),
                        resultSet.getInt("ser_num"),
                        resultSet.getBoolean("is_new"),
                        resultSet.getBoolean("is_sold"),
                        resultSet.getInt("comment_id "),
                        resultSet.getInt("seller_id")
                );
                amenities.add(car);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return amenities;
    }

    @Override
    public Car findById(Integer id) throws SQLException {
        Car car = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                car = new Car(
                        resultSet.getInt("id"),
                        resultSet.getString("brand"),
                        resultSet.getInt("graduathion_year"),
                        resultSet.getInt("ser_num"),
                        resultSet.getBoolean("is_new"),
                        resultSet.getBoolean("is_sold"),
                        resultSet.getInt("comment_id "),
                        resultSet.getInt("seller_id")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return car;
    }

    @Override
    public void create(Car car) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, String.valueOf(car.getBrand()));
            statement.setString(2, String.valueOf(car.getGraduathionYear()));
            statement.setString(3, String.valueOf(car.getSerNum()));
            statement.setString(4, String.valueOf(car.getIsNew()));
            statement.setString(5, String.valueOf(car.getIsSold()));
            statement.setString(6, String.valueOf(car.getCommentId()));
            statement.setString(7, String.valueOf(car.getSellerId()));
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Integer id, Car car) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, car.getBrand());
            statement.setInt(2, car.getGraduathionYear());
            statement.setInt(3, car.getSerNum());
            statement.setBoolean(4, car.getIsNew());
            statement.setBoolean(5, car.getIsSold());
            statement.setInt(6, car.getCommentId());
            statement.setInt(7, car.getSellerId());
            statement.setInt(8, car.getId());
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
