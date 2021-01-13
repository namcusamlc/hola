/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Menu;

/**
 *
 * @author hoaktse05446
 */
public class MenuDAO extends DataConfig {

    public ArrayList<Menu> getMenu(int pageSize, int pageIndex) throws Exception {
        Connection connection = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        int startIndex = (pageIndex - 1) * pageSize + 1;
        int endIndex = pageIndex * pageSize;
        ArrayList<Menu> list = new ArrayList<>();
        String query = "SELECT [id]\n"
                + "      ,[title]\n"
                + "      ,[imagePath]\n"
                + "      ,[itemContent]\n"
                + "      ,[shortContent]\n"
                + "      ,[price]\n"
                + "      ,[date]\n"
                + "  FROM \n"
                + "  (SELECT ROW_NUMBER() OVER (ORDER BY date desc) as MyRowNumber, * FROM Menu) tblMenu\n"
                + "  WHERE MyRowNumber BETWEEN ? AND ?";

        try {
            connection = getConnection();
            pre = connection.prepareStatement(query);
            pre.setInt(1, startIndex);
            pre.setInt(2, endIndex);
            rs = pre.executeQuery();
            while (rs.next()) {
                Menu menu = new Menu();
                menu.setId(rs.getInt("id"));
                menu.setTitle(rs.getString("title"));
                menu.setImagePath(rs.getString("imagePath"));
                menu.setContent(rs.getString("itemContent"));
                menu.setShortContent(rs.getString("shortContent"));
                menu.setPrice(rs.getFloat("price"));
                menu.setPublishedDate(rs.getDate("date"));
                list.add(menu);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            close(connection, pre, rs);
        }
        return list;
    }

    public int getTotal() throws Exception {
        Connection connection = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        String query = "SELECT COUNT(*) as Total \n"
                + "FROM Menu";
        try {
            connection = getConnection();
            pre = connection.prepareStatement(query);
            rs = pre.executeQuery();
            while (rs.next()) {
                return rs.getInt("Total");
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            close(connection, pre, rs);
        }
        return 0;
    }

    public Menu getMenu(int id) throws Exception {
        Connection connection = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        Menu menu = null;
        String query = "SELECT [id]\n"
                + "      ,[title]\n"
                + "      ,[imagePath]\n"
                + "      ,[itemContent]\n"
                + "      ,[shortContent]\n"
                + "      ,[price]\n"
                + "      ,[date]\n"
                + "  FROM [Menu]\n"
                + "  WHERE id = ?";
        try {
            connection = getConnection();
            pre = connection.prepareStatement(query);
            pre.setInt(1, id);
            rs = pre.executeQuery();
            if (rs.next()) {
                menu = new Menu();
                menu.setId(rs.getInt("id"));
                menu.setTitle(rs.getString("title"));
                menu.setImagePath(rs.getString("imagePath"));
                menu.setContent(rs.getString("itemContent"));
                menu.setShortContent(rs.getString("shortContent"));
                menu.setPrice(rs.getFloat("price"));
                menu.setPublishedDate(rs.getDate("date"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            close(connection, pre, rs);
        }
        return menu;
    }
}
