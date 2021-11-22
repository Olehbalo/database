package car.model.dao.implementation;

import car.model.dao.AbstractDAO;
import car.model.entity.CarDealership;
import car.persistant.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarDealershipDAO implements AbstractDAO<CarDealership> {
    private static final String GET_ALL = "SELECT * FROM projectlab.car";
    private static final String GET_BY_ID = "SELECT * FROM projectlab.car WHERE id=?";
    private static final String CREATE = "INSERT projectlab.car "
            + "(`site`, `email`, `car_id`, `addres_id`) VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE projectlab.car"
            + " SET site=?, email=?, car_id=?, addres_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM projectlab.car WHERE id=?";

    @Override
    public List<CarDealership> findAll() throws SQLException {
        List<CarDealership> amenities = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                CarDealership carDealership = new CarDealership(
                        resultSet.getInt("id"),
                        resultSet.getString("site`"),
                        resultSet.getString("email`"),
                        resultSet.getInt("car_id"),
                        resultSet.getInt("addres_id")
                );
                amenities.add(carDealership);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return amenities;
    }

    @Override
    public CarDealership findById(Integer id) throws SQLException {
        CarDealership carDealership = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                carDealership = new CarDealership(
                        resultSet.getInt("id"),
                        resultSet.getString("site"),
                        resultSet.getString("email"),
                        resultSet.getInt("car_id"),
                        resultSet.getInt("addres_id")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return carDealership;
    }

    @Override
    public void create(CarDealership carDealership) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, String.valueOf(carDealership.getSite()));
            statement.setString(1, String.valueOf(carDealership.getEmail()));
            statement.setString(2, String.valueOf(carDealership.getCarId()));
            statement.setString(3, String.valueOf(carDealership.getAddresId()));
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Integer id, CarDealership carDealership) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, carDealership.getSite());
            statement.setString(2, carDealership.getEmail());
            statement.setInt(3, carDealership.getCarId());
            statement.setInt(4, carDealership.getAddresId());
            statement.setInt(5, carDealership.getId());
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

