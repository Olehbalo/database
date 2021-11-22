package car.model.dao.implementation;

import car.model.dao.AbstractDAO;
import car.model.entity.Characteristic;
import car.persistant.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CharacteristicDAO implements AbstractDAO<Characteristic> {
    private static final String GET_ALL = "SELECT * FROM projectlab.car";
    private static final String GET_BY_ID = "SELECT * FROM projectlab.car WHERE id=?";
    private static final String CREATE = "INSERT projectlab.car "
            + "(`drive`, `color`, `car_body`,`transmission`, `car_id`) VALUES (?, ?, ?, ?,?)";
    private static final String UPDATE = "UPDATE projectlab.car"
            + " SET drive=?, color=?, car_body=?, transmission=?, car_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM projectlab.car WHERE id=?";

    @Override
    public List<Characteristic> findAll() throws SQLException {
        List<Characteristic> amenities = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Characteristic characteristic = new Characteristic(
                        resultSet.getInt("id"),
                        resultSet.getString("drive"),
                        resultSet.getString("color"),
                        resultSet.getString("car_body"),
                        resultSet.getString("transmission"),
                        resultSet.getInt("car_id")

                );
                amenities.add(characteristic);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return amenities;
    }

    @Override
    public Characteristic findById(Integer id) throws SQLException {
        Characteristic characteristic = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                characteristic = new Characteristic(
                        resultSet.getInt("id"),
                        resultSet.getString("drive"),
                        resultSet.getString("color"),
                        resultSet.getString("car_body"),
                        resultSet.getString("transmission"),
                        resultSet.getInt("car_id")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return characteristic;
    }

    @Override
    public void create(Characteristic characteristic) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, String.valueOf(characteristic.getDrive()));
            statement.setString(2, String.valueOf(characteristic.getColor()));
            statement.setString(3, String.valueOf(characteristic.getCarBody()));
            statement.setString(4, String.valueOf(characteristic.getTransmission()));
            statement.setString(5, String.valueOf(characteristic.getCarId()));
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Integer id, Characteristic characteristic) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, characteristic.getDrive());
            statement.setString(2, characteristic.getColor());
            statement.setString(3, characteristic.getCarBody());
            statement.setString(4, characteristic.getTransmission());
            statement.setInt(5, characteristic.getCarId());
            statement.setInt(6, characteristic.getId());
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
