/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Customer;

public class CustomerDAO extends BaseDAO<Customer> {

    @Override
    public ArrayList<Customer> getAll() {
        ArrayList<Customer> customers = new ArrayList<>();
        try {
            String sql = "SELECT [CustomerID]\n"
                    + "      ,[Username]\n"
                    + "      ,[Password]\n"
                    + "  FROM [Customer]";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Customer c = new Customer();
                c.setId(rs.getInt("CustomerID"));
                c.setName(rs.getString("Username"));
                c.setPassword(rs.getString("Password"));
                customers.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return customers;
    }

    @Override
    public Customer get(int id) {
        try {
            String sql = "SELECT [CustomerID]\n"
                    + "      ,[Username]\n"
                    + "      ,[Password]\n"
                    + "  FROM [Customer]\n"
                    + "  WHERE [CustomerID] = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Customer c = new Customer();
                c.setId(rs.getInt("CustomerID"));
                c.setName(rs.getString("Username"));
                c.setPassword(rs.getString("Password"));
                return c;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Customer get(String username, String password){
        try {
            String sql = "SELECT [CustomerID]\n"
                    + "      ,[Username]\n"
                    + "      ,[Password]\n"
                    + "  FROM [Customer]\n"
                    + "  WHERE [Username] = ?\n"
                    + "  AND [Password] = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username.trim());
            statement.setString(2, password);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Customer c = new Customer();
                c.setId(rs.getInt("CustomerID"));
                c.setName(rs.getString("Username"));
                c.setPassword(rs.getString("Password"));
                return c;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
