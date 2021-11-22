package car.model.dao.implementation;

import car.model.dao.AbstractDAO;
import car.model.entity.Addres;
import car.persistant.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddresDAO implements AbstractDAO<Addres> {
    private static final String GET_ALL = "SELECT * FROM projectlab.addres";
    private static final String GET_BY_ID = "SELECT * FROM projectlab.addres WHERE id=?";
    private static final String CREATE = "INSERT projectlab.addres "
            + "(`city`, `stret`) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE projectlab.addres"
            + " SET city=?,  street=? WHERE id=?";
    private static final String DELETE = "DELETE FROM projectlab.addres WHERE id=?";

    @Override
    public List<Addres> findAll() throws SQLException {
        List<Addres> amenities = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Addres addres = new Addres(
                        resultSet.getInt("id"),
                        resultSet.getString("city"),
                        resultSet.getString("street")
                );
                amenities.add(addres);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return amenities;
    }

    @Override
    public Addres findById(Integer id) throws SQLException {
        Addres addres = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                addres = new Addres(
                        resultSet.getInt("id"),
                        resultSet.getString("city"),
                        resultSet.getString("street")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return addres;
    }

    @Override
    public void create(Addres addres) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, String.valueOf(addres.getCity()));
            statement.setString(2, String.valueOf(addres.getStreet()));
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Integer id, Addres addres) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, addres.getCity());
            statement.setString(2, addres.getStreet());
            statement.setInt(3, addres.getId());
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
