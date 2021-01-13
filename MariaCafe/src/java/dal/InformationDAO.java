/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Information;

/**
 *
 * @author hoaktse05446
 */
public class InformationDAO extends DataConfig {

    public Information getInfo() throws Exception {
        Connection connection = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        Information info = null;
        String query = "SELECT [itemContent]\n"
                + "      ,[address]\n"
                + "      ,[phone]\n"
                + "      ,[message]\n"
                + "      ,[author]\n"
                + "  FROM [Information]";
        try {
            connection = getConnection();
            pre = connection.prepareStatement(query);
            rs = pre.executeQuery();
            while (rs.next()) {
                info = new Information();
                info.setContent(rs.getString("itemContent"));
                info.setAddress(rs.getString("address"));
                info.setPhone(rs.getString("phone"));
                info.setMessage(rs.getString("message"));
                info.setAuthor(rs.getString("author"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            close(connection, pre, rs);
        }
        return info;
    }

}
