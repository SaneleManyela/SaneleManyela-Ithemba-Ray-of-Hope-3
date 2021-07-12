/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ithembarayofhope;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
/**
 *
 * @author Sanele
 */
public class SQLExecutingMethods {
    public Connection mDatabaseConnection() {
        String strDBConnectionString = "jdbc:mysql://localhost:3306/burial_society_database";
        String strDBUser = "root";
        String strDBPassword = "password";
        
        try {
            return DriverManager.getConnection(strDBConnectionString, strDBUser, strDBPassword);
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }
    
    public String[] mFetchUserDetails(String strQuery) {
        
        java.sql.Connection conMySQLConnectionString = mDatabaseConnection();
        Statement stStatement;
        ResultSet rs;
        try {
            stStatement = conMySQLConnectionString.createStatement();
            rs = stStatement.executeQuery(strQuery);
            ResultSetMetaData rsmt = rs.getMetaData();
            String[] arr = new String[rsmt.getColumnCount() + 1];
            while(rs.next()) {
                for(int i = 1; i < arr.length; i++) {
                    arr[i] = String.valueOf(rs.getString(i));
                }
            }
            
            String[] arrDetails = mRemoveEmptyElements(arr).toArray(new String[mRemoveEmptyElements(arr).size()]);
            
            stStatement.close();
            rs.close();
            conMySQLConnectionString.close();
            return arrDetails;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }
    
    private List<String> mRemoveEmptyElements(String[] arr) {
        List<String> values = new ArrayList<>();
        try{
            for(String element: arr) {
                if(element != null){
                    values.add(element);
                }
            }
        } catch(NullPointerException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return values;
    }
    
    public boolean mCheckIfItemsExistInTable(String strQuery)
    {   boolean boolRecordExists = false;      
        try
        {
            java.sql.Connection conMySQLConnectionString = mDatabaseConnection();
            Statement myStatement = conMySQLConnectionString.createStatement();
            
            ResultSet rs = myStatement.executeQuery(strQuery);;
            boolRecordExists = rs.next();
            myStatement.close();
            rs.close();
            conMySQLConnectionString.close();
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        return boolRecordExists;
    }
    
    public String mCreateUser(String strQuery)
    {        
        try
        {
            java.sql.Connection conMySQLConnectionString = mDatabaseConnection();
            try (Statement myStatement = conMySQLConnectionString.createStatement()) {
                myStatement.executeUpdate(strQuery);
                myStatement.close();
                conMySQLConnectionString.close();
            }
            return "Created";
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        return "";
    }
    
    public String mUpdateUser(String strQuery)
    {
        try
        {
            java.sql.Connection conMySQLConnectionString = mDatabaseConnection();
            Statement myStatement = conMySQLConnectionString.createStatement();
            
            myStatement.executeUpdate(strQuery);
            myStatement.close(); 
            conMySQLConnectionString.close();
            return "Updated";
        }
        catch(SQLException e)
        {
           
            JOptionPane.showMessageDialog(null, e);
        }
        return "";
    }
    
    public String mDeleteUser(String strQuery)
    {
        try {
            
            java.sql.Connection conMySQLConnectionString = mDatabaseConnection();
            Statement myStatement = conMySQLConnectionString.prepareStatement(strQuery);
            myStatement.execute(strQuery);
            myStatement.close();
            conMySQLConnectionString.close();
            return "Deleted";
        }
        catch(SQLException e)
        {
                JOptionPane.showMessageDialog(null, e);
        }
        return "";
    }
    
    public void mLoadName(String strQuery, JComboBox cbo) {
        java.sql.Connection conMySQLConnectionString = mDatabaseConnection();
        Statement stStatement;
        ResultSet rs;
        
        try {
            stStatement = conMySQLConnectionString.createStatement();
            
            stStatement.execute(strQuery);
            rs = stStatement.getResultSet();
            while (rs.next()) {
                if(strQuery.contains(",")) {
                    cbo.addItem(rs.getString(1)+" "+rs.getString(2));
                } 
                else {
                    cbo.addItem(rs.getString(1));
                }
            }
            stStatement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }
    
    public String mTableField(String strQuery) {
        java.sql.Connection conMySQLConnectionString = mDatabaseConnection();
        try(Statement stStatement = mDatabaseConnection().prepareStatement(strQuery)) {
            ResultSet rs = stStatement.executeQuery(strQuery);
            
            while(rs.next()) {
                return rs.getString(1);
            }
            conMySQLConnectionString.close();
            stStatement.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return "";
    }
}
