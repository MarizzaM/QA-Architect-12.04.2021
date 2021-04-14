package com.company;

import java.sql.*;
import java.util.ArrayList;

public class CalculatorDAO {

    private String m_conn;

    public CalculatorDAO(String m_conn) {
        this.m_conn = m_conn;
    }

    public void selectQuery(String query){

        try (Connection conn = DriverManager.getConnection(m_conn)) {

            if (conn != null) {

                String sql = query;

                Statement stmt = conn.createStatement();

                ResultSet rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    System.out.println(rs.getInt("Id") + "\t" +
                            rs.getString("name") + "\t" +
                            rs.getDouble("Input1") + "\t" +
                            rs.getDouble("Input2") + "\t" +
                            rs.getDouble("Input3") + "\t" +
                            rs.getDouble("Result1") + "\t" +
                            rs.getString("Exception")
                    );
                }
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateQuery(String query){

        try (Connection conn = DriverManager.getConnection(m_conn)) {

            if (conn != null) {

                String sql = query;

                Statement stmt = conn.createStatement();

                int result = stmt.executeUpdate(sql); // not expect result
                System.out.println(result + " record updated.");
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public ArrayList<Calculator> select(String query){

        ArrayList<Calculator> customers = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(m_conn)) {

            if (conn != null) {

                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                while (rs.next()) {
                    Calculator e = new Calculator(
                            rs.getInt("Id"),
                            rs.getString("name"),
                            rs.getDouble("Input1"),
                            rs.getDouble("Input2"),
                            rs.getDouble("Input3"),
                            rs.getDouble("Result1"),
                            rs.getString("Exception"));
                    customers.add(e);
                }
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return  customers;
    }

    public Calculator selectById(int id){

        try (Connection conn = DriverManager.getConnection(m_conn)) {

            if (conn != null) {

                String sql = String.format("Select * from testdata where id = %d", id );

                Statement stmt = conn.createStatement();

                ResultSet rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    Calculator e = new Calculator(
                            rs.getInt("Id"),
                            rs.getString("name"),
                            rs.getDouble("Input1"),
                            rs.getDouble("Input2"),
                            rs.getDouble("Input3"),
                            rs.getDouble("Result1"),
                            rs.getString("Exception"));
                    return e;
                }
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
