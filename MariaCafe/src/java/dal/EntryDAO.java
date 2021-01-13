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

    public Entry getIntroduction() throws Exception {
        Connection connection = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        Entry entry = null;
        String query = "SELECT e.[id]\n"
                + "      ,e.categoryId\n"
                + "      ,c.name as 'categoryName'\n"
                + "      ,e.[name]\n"
                + "      ,[imagePath]\n"
                + "      ,[itemContent]\n"
                + "      ,[date]\n"
                + "  FROM [Entry] e INNER JOIN Category c\n"
                + "  ON e.categoryId = c.id\n"
                + "  WHERE c.name like 'introduction'";
        try {
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
                entry.setTitle(rs.getString("name"));
                entry.setImagePath(rs.getString("imagePath"));
                entry.setContent(rs.getString("itemContent"));
                entry.setPublishedDate(rs.getDate("date"));
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            close(connection, pre, rs);
        }
        return entry;
    }

    public ArrayList<Entry> getLatestProduct() throws Exception {
        Connection connection = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        ArrayList<Entry> entries = new ArrayList<>();
        String query = "SELECT top 2 e.[id]\n"
                + "      ,e.categoryId\n"
                + "      ,c.name as 'categoryName'\n"
                + "      ,e.[name]\n"
                + "      ,[imagePath]\n"
                + "      ,[itemContent]\n"
                + "      ,[shortContent]\n"
                + "      ,[date]\n"
                + "  FROM [Entry] e INNER JOIN Category c\n"
                + "  ON e.categoryId = c.id\n"
                + "  WHERE c.name like 'product'\n"
                + "  ORDER BY date DESC";
        try {
            connection = getConnection();
            pre = connection.prepareStatement(query);
            rs = pre.executeQuery();
            while (rs.next()) {
                Entry entry = new Entry();
                entry.setId(rs.getInt("id"));
                Category category = new Category();
                category.setId(rs.getInt("categoryId"));
                category.setName(rs.getString("categoryName"));
                entry.setCategory(category);
                entry.setTitle(rs.getString("name"));
                entry.setImagePath(rs.getString("imagePath"));
                entry.setContent(rs.getString("itemContent"));
                entry.setShortContent(rs.getString("shortContent"));
                entry.setPublishedDate(rs.getDate("date"));
                entries.add(entry);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            close(connection, pre, rs);
        }
        return entries;
    }
    
    
    public Entry getProduct(int id) throws Exception{
        Connection connection = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        Entry entry = null;
        String query = "SELECT e.[id]\n"
                + "      ,e.categoryId\n"
                + "      ,c.name as 'categoryName'\n"
                + "      ,e.[name]\n"
                + "      ,[imagePath]\n"
                + "      ,[itemContent]\n"
                + "      ,[shortContent]\n"
                + "      ,[date]\n"
                + "  FROM [Entry] e INNER JOIN Category c\n"
                + "  ON e.categoryId = c.id\n"
                + "  WHERE e.id = ?";
        try {
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
                entry.setTitle(rs.getString("name"));
                entry.setImagePath(rs.getString("imagePath"));
                entry.setContent(rs.getString("itemContent"));
                entry.setShortContent(rs.getString("shortContent"));
                entry.setPublishedDate(rs.getDate("date"));
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            close(connection, pre, rs);
        }
        return entry;
    }
}
