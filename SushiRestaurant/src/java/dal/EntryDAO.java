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
import model.Category;
import model.Entry;

/**
 *
 * @author hoaktse05446
 */
public class EntryDAO extends DataConfig {

    public Entry getBanner() throws Exception {
        Connection connection = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        Entry entry = null;
        try {
            String query = "SELECT [id]\n"
                    + "      ,c.[categoryId]\n"
                    + "      ,c.categoryName\n"
                    + "      ,[title]\n"
                    + "      ,[imagePath]\n"
                    + "      ,[itemContent]\n"
                    + "      ,[price]\n"
                    + "      ,[shortContent]\n"
                    + "  FROM [Entry] as e INNER JOIN Category as c \n"
                    + "  ON e.categoryId = c.categoryId\n"
                    + "  WHERE c.categoryName = 'banner'";
            connection = getConnection();
            pre = connection.prepareStatement(query);
            rs = pre.executeQuery();
            if (rs.next()) {
                entry = new Entry();
                entry.setId(rs.getInt("id"));
                Category category = new Category();
                category.setId(rs.getInt("categoryId"));
                category.setName(rs.getString("categoryName"));
                entry.setCategory(category);
                entry.setTitle(rs.getString("title"));
                entry.setImagePath(rs.getString("imagePath"));
                entry.setContent(rs.getString("itemContent"));
                entry.setPrice(rs.getFloat("price"));
                entry.setIndex(1);
                entry.setShortContent(rs.getString("shortContent"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            close(connection, pre, rs);
        }
        return entry;
    }

    public Entry getProduct(int id) throws Exception {
        Connection connection = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        Entry entry = null;
        try {
            String query = "SELECT [id]\n"
                    + "      ,c.[categoryId]\n"
                    + "      ,c.categoryName\n"
                    + "      ,[title]\n"
                    + "      ,[imagePath]\n"
                    + "      ,[itemContent]\n"
                    + "      ,[price]\n"
                    + "      ,[shortContent]\n"
                    + "  FROM [Entry] as e INNER JOIN Category as c \n"
                    + "  ON e.categoryId = c.categoryId\n"
                    + "  WHERE id = ?\n";
            connection = getConnection();
            pre = connection.prepareStatement(query);
            pre.setInt(1, id);
            rs = pre.executeQuery();
            if (rs.next()) {
                entry = new Entry();
                entry.setId(rs.getInt("id"));
                Category category = new Category();
                category.setId(rs.getInt("categoryId"));
                category.setName(rs.getString("categoryName"));
                entry.setCategory(category);
                entry.setTitle(rs.getString("title"));
                entry.setImagePath(rs.getString("imagePath"));
                entry.setContent(rs.getString("itemContent"));
                entry.setPrice(rs.getFloat("price"));
                entry.setIndex(1);
                entry.setShortContent(rs.getString("shortContent"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            close(connection, pre, rs);
        }
        return entry;
    }

    public ArrayList<Entry> getProducts(int pageSize, int pageIndex) throws Exception {
        Connection connection = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        int startIndex = (pageIndex - 1) * pageSize + 1;
        int endIndex = pageIndex * pageSize;
        ArrayList<Entry> list = new ArrayList<>();
        String query = "SELECT [id]\n"
                + "      ,tblEntry.[categoryId]\n"
                + "      ,c.categoryName\n"
                + "      ,[title]\n"
                + "      ,[imagePath]\n"
                + "      ,[itemContent]\n"
                + "      ,[price]\n"
                + "      ,[shortContent]\n"
                + "      ,MyRowNumber\n"
                + "  FROM \n"
                + "  (SELECT ROW_NUMBER() OVER (ORDER BY id asc) as MyRowNumber, * FROM Entry\n"
                + "  WHERE categoryId = 2) as tblEntry\n"
                + "  INNER JOIN Category as c\n"
                + "  ON c.categoryId = tblEntry.categoryId\n"
                + "  WHERE MyRowNumber BETWEEN ? AND ?";
        try {
            connection = getConnection();
            pre = connection.prepareStatement(query);
            pre.setInt(1, startIndex);
            pre.setInt(2, endIndex);
            rs = pre.executeQuery();
            while (rs.next()) {
                Entry entry = new Entry();
                entry.setId(rs.getInt("id"));
                Category category = new Category();
                category.setId(rs.getInt("categoryId"));
                category.setName(rs.getString("categoryName"));
                entry.setCategory(category);
                entry.setTitle(rs.getString("title"));
                entry.setImagePath(rs.getString("imagePath"));
                entry.setContent(rs.getString("itemContent"));
                entry.setPrice(rs.getFloat("price"));
                entry.setIndex(rs.getInt("MyRowNumber"));
                entry.setShortContent(rs.getString("shortContent"));
                list.add(entry);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            close(connection, pre, rs);
        }
        return list;
    }

    public ArrayList<Entry> getMenus(int pageSize, int pageIndex) throws Exception {
        Connection connection = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        int startIndex = (pageIndex - 1) * pageSize + 1;
        int endIndex = pageIndex * pageSize;
        ArrayList<Entry> list = new ArrayList<>();
        String query = "SELECT [id]\n"
                + "      ,tblEntry.[categoryId]\n"
                + "      ,c.categoryName\n"
                + "      ,[title]\n"
                + "      ,[imagePath]\n"
                + "      ,[itemContent]\n"
                + "      ,[price]\n"
                + "      ,[shortContent]\n"
                + "      ,MyRowNumber\n"
                + "  FROM \n"
                + "  (SELECT ROW_NUMBER() OVER (ORDER BY id asc) as MyRowNumber, * FROM Entry\n"
                + "  WHERE categoryId = 3) as tblEntry\n"
                + "  INNER JOIN Category as c\n"
                + "  ON c.categoryId = tblEntry.categoryId\n"
                + "  WHERE MyRowNumber BETWEEN ? AND ?";
        try {
            connection = getConnection();
            pre = connection.prepareStatement(query);
            pre.setInt(1, startIndex);
            pre.setInt(2, endIndex);
            rs = pre.executeQuery();
            while (rs.next()) {
                Entry entry = new Entry();
                entry.setId(rs.getInt("id"));
                Category category = new Category();
                category.setId(rs.getInt("categoryId"));
                category.setName(rs.getString("categoryName"));
                entry.setCategory(category);
                entry.setTitle(rs.getString("title"));
                entry.setImagePath(rs.getString("imagePath"));
                entry.setContent(rs.getString("itemContent"));
                entry.setPrice(rs.getFloat("price"));
                entry.setIndex(rs.getInt("MyRowNumber"));
                entry.setShortContent(rs.getString("shortContent"));
                list.add(entry);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            close(connection, pre, rs);
        }
        return list;
    }

    public int getTotalProducts() throws Exception {
        Connection connection = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        String query = "SELECT COUNT(*) as Total\n"
                + "FROM Entry\n"
                + "WHERE categoryId = 2";
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

    public int getTotalMenus() throws Exception {
        Connection connection = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        String query = "SELECT COUNT(*) as Total\n"
                + "FROM Entry\n"
                + "WHERE categoryId = 3";
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

}
