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
import model.Admin;
import model.Customer;

/**
 *
 * @author HoaPC
 */
public class AdminDAO extends BaseDAO<Admin> {

    @Override
    public ArrayList<Admin> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Admin get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Admin get(String username, String password) {
        try {
            String sql = "SELECT [id]\n"
                    + "      ,[username]\n"
                    + "      ,[password]\n"
                    + "  FROM [Admin]\n"
                    + "  WHERE [username]=? AND [password]=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username.trim());
            statement.setString(2, password);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Admin c = new Admin();
                c.setId(rs.getInt("id"));
                c.setUsername(rs.getString("username"));
                c.setPassword(rs.getString("password"));
                return c;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
