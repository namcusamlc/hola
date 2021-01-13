/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        Information info = new Information();
        String query = "SELECT [title]\n"
                + "      ,[itemContent]\n"
                + "      ,[message]\n"
                + "      ,[author]\n"
                + "  FROM [Information]";
        try {
            connection = getConnection();
            pre = connection.prepareStatement(query);
            rs = pre.executeQuery();
            if (rs.next()) {
                info.setTitle(rs.getString("title"));
                info.setContent(rs.getString("itemContent"));
                info.setMessages(rs.getString("message"));
                info.setAuthor(rs.getString("author"));
            }
        } catch (SQLException ex) {
        } finally {
            close(connection, pre, rs);
        }
        return info;
    }
}
