package com.solvd.daos.jdbc;

import com.solvd.BasicConnectionPool;
import com.solvd.daos.IClientDAO;
import com.solvd.models.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO implements IClientDAO {
    static BasicConnectionPool connectionPool = BasicConnectionPool.create();

    @Override
    public Client getEntityById(int id) {
        Client client = new Client();
        String sql = "SELECT * FROM mydb.Clients WHERE id=?";
        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                client.setName(rs.getString("name"));
                client.setEmail(rs.getString("email"));
                client.setPhoneNumber(rs.getString("phone_number"));
                client.setLastName(rs.getString("last_name"));
                client.setId(rs.getInt("id"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            connectionPool.releaseConnection(connection);
        }

        return client;
    }

    @Override
    public List<Client> getEntities() {
        List<Client> clientList = new ArrayList<>();
        String sql = "SELECT * FROM mydb.Clients";
        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Client client = new Client();
                client.setName(rs.getString("name"));
                client.setEmail(rs.getString("email"));
                client.setPhoneNumber(rs.getString("phone_number"));
                client.setLastName(rs.getString("last_name"));
                client.setId(rs.getInt("id"));
                clientList.add(client);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return clientList;
    }

    @Override
    public Client insert(Client client) {
        String sql = "INSERT INTO mydb.Clients (name, last_name, email, phone_number) VALUES (?,?,?,?)";
        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, client.getName());
            ps.setString(2, client.getLastName());
            ps.setString(3, client.getEmail());
            ps.setString(4, client.getPhoneNumber());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                client.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return client;
    }

    @Override
    public Client update(int id, Client client) {
        String sql = "UPDATE mydb.Clients SET name=?, last_name=?, email=?, phone_number=? WHERE id=?";
        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, client.getName());
            ps.setString(2, client.getLastName());
            ps.setString(3, client.getEmail());
            ps.setString(4, client.getPhoneNumber());
            ps.setInt(5, id);
            ps.executeUpdate();
            client.setId(id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return client;
    }

    @Override
    public boolean removeById(int id) {
        String sql = "DELETE FROM mydb.Clients WHERE id=?";
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
