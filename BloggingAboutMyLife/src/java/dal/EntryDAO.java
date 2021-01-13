/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import model.Category;
import model.Entry;

/**
 *
 * @author hoaktse05446
 */
public class EntryDAO extends DataConfig {

    public ArrayList<Entry> getLatestEntry() throws Exception {
        Connection connection = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        ArrayList<Entry> entries = new ArrayList<>();
        String query = "SELECT top 3 [id]\n"
                + "      ,Category.[categoryId]\n"
                + "      ,Category.categoryName\n"
                + "      ,[title]\n"
                + "      ,[imagePath]\n"
                + "      ,[logoPath]\n"
                + "      ,[itemContent]\n"
                + "      ,[publishedDate]\n"
                + "  FROM Item INNER JOIN Category \n"
                + "  ON Item.categoryId = Category.categoryId\n"
                + "  ORDER BY publishedDate DESC";
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
                entry.setTitle(rs.getString("title"));
                entry.setImagePath(rs.getString("imagePath"));
                entry.setLogoPath(rs.getString("logoPath"));
                entry.setContent(rs.getString("itemContent"));
                entry.setPublishedDate(rs.getDate("publishedDate"));
                entries.add(entry);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            close(connection, pre, rs);
        }
        return entries;
    }

    public Entry getEntry(int id) throws Exception {
        Connection connection = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        Entry entry = new Entry();
        String query = "SELECT [id]\n"
                + "      ,Category.[categoryId]\n"
                + "      ,Category.[categoryName]\n"
                + "      ,[title]\n"
                + "      ,[imagePath]\n"
                + "      ,[logoPath]\n"
                + "      ,[itemContent]\n"
                + "      ,[publishedDate]\n"
                + "  FROM Item INNER JOIN Category \n"
                + "  ON Item.categoryId = Category.categoryId\n"
                + "  WHERE Item.id = ?";
        try {
            connection = getConnection();
            pre = connection.prepareStatement(query);
            pre.setInt(1, id);
            rs = pre.executeQuery();
            while (rs.next()) {
                entry.setId(rs.getInt("id"));
                Category category = new Category();
                category.setId(rs.getInt("categoryId"));
                category.setName(rs.getString("categoryName"));
                entry.setCategory(category);
                entry.setTitle(rs.getString("title"));
                entry.setImagePath(rs.getString("imagePath"));
                entry.setLogoPath(rs.getString("logoPath"));
                entry.setContent(rs.getString("itemContent"));
                entry.setPublishedDate(rs.getDate("publishedDate"));
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            close(connection, pre, rs);
        }
        return entry;
    }

    public HashMap<String, ArrayList<Entry>> getEntries(int pageSize, int pageIndex) throws Exception {
        Connection connection = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        int startIndex = (pageIndex - 1) * pageSize + 1;
        int endIndex = pageIndex * pageSize;
        HashMap<String, ArrayList<Entry>> map = new HashMap();
        String query = "SELECT [id]\n"
                + "      ,c.[categoryId]\n"
                + "      ,c.categoryName\n"
                + "      ,[title]\n"
                + "      ,[imagePath]\n"
                + "      ,[logoPath]\n"
                + "      ,[itemContent]\n"
                + "      ,[publishedDate]\n"
                + "  FROM \n"
                + "  (SELECT ROW_NUMBER() OVER (ORDER BY publishedDate desc) as MyRowNumber, * FROM Item) tblItem\n"
                + "  INNER JOIN Category as c ON tblItem.categoryId = c.categoryId\n"
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
                entry.setLogoPath(rs.getString("logoPath"));
                entry.setContent(rs.getString("itemContent"));
                entry.setPublishedDate(rs.getDate("publishedDate"));
                Date date = rs.getDate("publishedDate");
                String key = formatDate(date).toUpperCase();
                if (map.containsKey(key)) {
                    map.get(key).add(entry);
                } else {
                    ArrayList<Entry> entries = new ArrayList<>();
                    entries.add(entry);
                    map.put(key, entries);
                }
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            close(connection, pre, rs);
        }
        return map;
    }

    public int getTotal() throws Exception {
        Connection connection = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        String query = "SELECT COUNT(*) as Total \n"
                + "FROM Item";
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

    public String formatDate(Date date) {
        String formattedDate = "";
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("MMMM yyyy");
            formattedDate = formatter.format(date);
        } catch (Exception ex) {
            throw ex;
        }
        return formattedDate;

    }
}
