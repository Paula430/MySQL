package com.solvd.daos.jdbc;

import com.solvd.BasicConnectionPool;
import com.solvd.daos.ILocationDAO;
import com.solvd.models.Location;
import com.solvd.models.Location;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LocationsDAO implements ILocationDAO {
    static BasicConnectionPool connectionPool = BasicConnectionPool.create();

    @Override
    public Location getEntityById(int id) {
        Location location = new Location();
        String sql = "SELECT * FROM mydb.Locations WHERE id=?";
        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                location.setCity(rs.getString("city"));
                location.setStreet(rs.getString("street"));
                location.setId(rs.getInt("id"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            connectionPool.releaseConnection(connection);
        }

        return location;
    }

    @Override
    public List<Location> getEntities() {
        List<Location> locationList = new ArrayList<>();
        String sql = "SELECT * FROM mydb.Locations";
        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Location location = new Location();
                location.setCity(rs.getString("city"));
                location.setStreet(rs.getString("street"));

                location.setId(rs.getInt("id"));
                locationList.add(location);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return locationList;
    }

    @Override
    public Location insert(Location location) {
        String sql = "INSERT INTO mydb.Locations (city, street) VALUES (?,?)";
        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, location.getCity());
            ps.setString(2, location.getStreet());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                location.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return location;
    }

    @Override
    public Location update(int id, Location location) {
        String sql = "UPDATE mydb.Locations SET city=?, street=? WHERE id=?";
        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, location.getCity());
            ps.setString(2, location.getStreet());
            ps.setInt(3, id);
            ps.executeUpdate();
            location.setId(id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return location;
    }

    @Override
    public boolean removeById(int id) {
        String sql = "DELETE FROM mydb.Locations WHERE id=?";
        Connection connection = connectionPool.getConnection();
        boolean rowDeleted=false;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            int rs = ps.executeUpdate();
            if (rs > 0) {
                rowDeleted=true;
            } else {
                rowDeleted= false;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return rowDeleted;
    }
}
