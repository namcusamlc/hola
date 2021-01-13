/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Contact;

/**
 *
 * @author hoaktse05446
 */
public class ContactDAO extends DataConfig {

    public Contact getContact() throws Exception {
        Connection connection = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        Contact contact = null;
        String query = "SELECT [address]\n"
                + "      ,[tel]\n"
                + "      ,[email]\n"
                + "      ,[working]\n"
                + "      ,[map]\n"
                + "  FROM [Contact]";
        try {
            connection = getConnection();
            pre = connection.prepareStatement(query);
            rs = pre.executeQuery();
            while (rs.next()) {
                contact = new Contact();
                contact.setAddress(rs.getString("address"));
                contact.setTel(rs.getString("tel"));
                contact.setEmail(rs.getString("email"));
                contact.setWorkingHour(rs.getString("working"));
                contact.setMapPath(rs.getString("map"));
            }
        } catch (Exception e) {
            throw e;
        }finally{
            close(connection, pre, rs);
        }
        return contact;
    }
}
