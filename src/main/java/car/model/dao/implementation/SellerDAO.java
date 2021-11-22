package car.model.dao.implementation;

import car.model.dao.AbstractDAO;
import car.model.entity.Seller;
import car.persistant.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SellerDAO implements AbstractDAO<Seller> {
    private static final String GET_ALL = "SELECT * FROM projectlab.car";
    private static final String GET_BY_ID = "SELECT * FROM projectlab.car WHERE id=?";
    private static final String CREATE = "INSERT projectlab.car "
            + "(`firs_name`, `email`, `last_name`, `phone_number`) VALUES (?, ?, ?,?)";
    private static final String UPDATE = "UPDATE projectlab.car"
            + " SET firs_name=?, email=?, last_name=? ,phone_number=? WHERE id=?";
    private static final String DELETE = "DELETE FROM projectlab.car WHERE id=?";

    @Override
    public List<Seller> findAll() throws SQLException {
        List<Seller> amenities = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Seller seller = new Seller(
                        resultSet.getInt("id"),
                        resultSet.getString("firs_name"),
                        resultSet.getString("email"),
                        resultSet.getString("last_name"),
                        resultSet.getInt("phone_number")
                );
                amenities.add(seller);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return amenities;
    }

    @Override
    public Seller findById(Integer id) throws SQLException {
        Seller seller = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                seller = new Seller(
                        resultSet.getInt("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("email"),
                        resultSet.getString("last_name"),
                        resultSet.getInt("phone_number")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return seller;
    }

    @Override
    public void create(Seller seller) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, String.valueOf(seller.getFirstName()));
            statement.setString(2, String.valueOf(seller.getEmail()));
            statement.setString(3, String.valueOf(seller.getLastName()));
            statement.setString(4, String.valueOf(seller.getPhoneNumber()));
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Integer id, Seller seller) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, seller.getFirstName());
            statement.setString(2, seller.getEmail());
            statement.setString(3, seller.getLastName());
            statement.setInt(3, seller.getPhoneNumber());
            statement.setInt(4, seller.getId());
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
