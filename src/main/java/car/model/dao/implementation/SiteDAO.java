package car.model.dao.implementation;

import car.model.dao.AbstractDAO;
import car.model.entity.Site;
import car.persistant.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SiteDAO implements AbstractDAO<Site> {
    private static final String GET_ALL = "SELECT * FROM projectlab.car";
    private static final String GET_BY_ID = "SELECT * FROM projectlab.car WHERE id=?";
    private static final String CREATE = "INSERT projectlab.car "
            + "(`car_dealership_id`, `car_id` VALUES (?, ?)";
    private static final String UPDATE = "UPDATE projectlab.car"
            + " SET car_dealership_idroom_id=?, car_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM projectlab.car WHERE id=?";

    @Override
    public List<Site> findAll() throws SQLException {
        List<Site> amenities = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Site site = new Site(
                        resultSet.getInt("id"),
                        resultSet.getInt("car_dealership_id"),
                        resultSet.getInt("car_id")
                );
                amenities.add(site);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return amenities;
    }

    @Override
    public Site findById(Integer id) throws SQLException {
        Site site = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                site = new Site(
                        resultSet.getInt("id"),
                        resultSet.getInt("car_dealership_id"),
                        resultSet.getInt("car_id")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return site;
    }

    @Override
    public void create(Site site) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, String.valueOf(site.getCarDealershipId()));
            statement.setString(2, String.valueOf(site.getCarId()));
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Integer id, Site site) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setInt(1, site.getCarDealershipId());
            statement.setInt(2, site.getCarId());
            statement.setInt(3, site.getId());
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
