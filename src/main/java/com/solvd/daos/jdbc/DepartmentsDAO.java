package com.solvd.daos.jdbc;

import com.solvd.BasicConnectionPool;
import com.solvd.daos.IDepartmentDAO;
import com.solvd.models.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentsDAO implements IDepartmentDAO {
    static BasicConnectionPool connectionPool = BasicConnectionPool.create();

    @Override
    public Department getEntityById(int id) {
        Department department = new Department();
        String sql = "SELECT * FROM mydb.Departments WHERE id=?";
        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                department.setName(rs.getString("name"));
                //department.setLocationID(rs.getInt("locations_id"));
                department.setId(rs.getInt("id"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            connectionPool.releaseConnection(connection);
        }

        return department;
    }

    @Override
    public List<Department> getEntities() {
        List<Department> departmentList = new ArrayList<>();
        String sql = "SELECT * FROM mydb.Departments";
        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Department department = new Department();
                department.setName(rs.getString("name"));
                //department.setLocationID(rs.getInt("locations_id"));
                department.setId(rs.getInt("id"));
                departmentList.add(department);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return departmentList;
    }

    @Override
    public Department insert(Department department) {
        String sql = "INSERT INTO mydb.Departments (name, locations_id) VALUES (?,?)";
        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, department.getName());
           // ps.setInt(2, department.getLocationID());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                department.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return department;
    }

    @Override
    public Department update(int id, Department department) {
        String sql = "UPDATE mydb.Departments SET name=?, locations_id=? WHERE id=?";
        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, department.getName());
           // ps.setInt(2, department.getLocationID());
            ps.setInt(3, id);
            ps.executeUpdate();
            department.setId(id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return department;
    }

    @Override
    public boolean removeById(int id) {
        String sql = "DELETE FROM mydb.Departments WHERE id=?";
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
