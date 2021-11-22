package car.model.dao.implementation;

import car.model.dao.AbstractDAO;
import car.model.entity.Comment;
import car.persistant.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class СommentDAO implements AbstractDAO<Comment> {
    private static final String GET_ALL = "SELECT * FROM projectlab.car";
    private static final String GET_BY_ID = "SELECT * FROM projectlab.car WHERE id=?";
    private static final String CREATE = "INSERT projectlab.car "
            + "(`name`, `messange`, `customer_id`) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE projectlab.car"
            + " SET name=?, messange=?, customer_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM projectlab.car WHERE id=?";

    @Override
    public List<Comment> findAll() throws SQLException {
        List<Comment> amenities = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Comment comment = new Comment(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("message"),
                        resultSet.getInt("customer_id")
                );
                amenities.add(comment);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return amenities;
    }

    @Override
    public Comment findById(Integer id) throws SQLException {
        Comment comment = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                comment = new Comment(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("message"),
                        resultSet.getInt("customer_id")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return comment;
    }

    @Override
    public void create(Comment comment) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, String.valueOf(comment.getName()));
            statement.setString(2, String.valueOf(comment.getMessage()));
            statement.setString(3, String.valueOf(comment.getCustomerId()));
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Integer id, Comment comment) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, comment.getName());
            statement.setString(2, comment.getMessage());
            statement.setInt(3, comment.getCustomerId());
            statement.setInt(4, comment.getId());
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
