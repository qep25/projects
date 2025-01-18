/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;

import bean.calculatorProcess;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import util.DBConnection;

/**
 *
 * @author hasif
 */
public class calculatorDAO {

    public String updateConstraints() {

        return "SUCCESS";
    }

    public calculatorProcess getYearData(int i) throws SQLException {
        
        calculatorProcess cp = new calculatorProcess();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DBConnection.createConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT studentyear, yearConstraint, showdivmul FROM calculator where studentYear=" + i);
            while (rs.next()) {
                cp.setYear(rs.getInt("studentYear"));
                cp.setConstraints(rs.getInt("yearConstraint"));
                cp.setShowdivmul(rs.getBoolean("showdivmul"));
            }
            return cp;

        } catch (SQLException e) {

        }
        return null;

    }
    
    public ArrayList<Integer> getYears() throws SQLException {
        ArrayList<Integer> studentyear = new ArrayList<>();

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DBConnection.createConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT studentyear FROM calculator");

            while (rs.next()) {
                int year = rs.getInt("studentyear");
                studentyear.add(year);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return studentyear;
    }

    public ArrayList<calculatorProcess> getCalculatorProcesses() throws SQLException {
        ArrayList<calculatorProcess> calculatorProcesses = new ArrayList<>();

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DBConnection.createConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT studentyear, yearConstraint,showdivmul FROM calculator");

            while (rs.next()) {
                int year = rs.getInt("studentyear");
                int constraints = rs.getInt("yearConstraint");
                Boolean showdivmul = rs.getBoolean("showdivmul");

                calculatorProcess cp = new calculatorProcess(year, constraints,showdivmul);
                calculatorProcesses.add(cp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return calculatorProcesses;
    }
}
