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
import model.Category;
import model.Product;

/**
 *
 * @author sonnt
 */
public class ProductDAO extends BaseDAO<Product> {

    @Override
    public ArrayList<Product> getAll() {
        ArrayList<Product> products = new ArrayList<>();
        try {
            String sql = "SELECT [ProductID]\n"
                    + "      ,[ProductName]\n"
                    + "      ,[Price]\n"
                    + "      ,p.[CategoryID]\n"
                    + "	  ,c.[CategoryName]\n"
                    + "      ,[Color]\n"
                    + "      ,[Url]\n"
                    + "  FROM [Product] p\n"
                    + "  INNER JOIN [Category] c ON p.[CategoryID] = c.[CategoryID]";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Category c = new Category();
                c.setId(rs.getInt("CategoryID"));
                c.setName(rs.getString("CategoryName"));
                Product p = new Product();
                p.setId(rs.getInt("ProductID"));
                p.setName(rs.getString("ProductName"));
                p.setPrice(rs.getFloat("Price"));
                p.setCategory(c);
                p.setColor(rs.getString("Color"));
                p.setUrl(rs.getString("Url"));
                products.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }

    @Override
    public Product get(int id) {
        try {
            String sql = "SELECT [ProductID]\n"
                    + "      ,[ProductName]\n"
                    + "      ,[Price]\n"
                    + "      ,p.[CategoryID]\n"
                    + "	  ,c.[CategoryName]\n"
                    + "      ,[Color]\n"
                    + "      ,[Url]\n"
                    + "  FROM [Product] p\n"
                    + "  INNER JOIN [Category] c ON p.[CategoryID] = c.[CategoryID]\n"
                    + "  WHERE p.[ProductID] = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Category c = new Category();
                c.setId(rs.getInt("CategoryID"));
                c.setName(rs.getString("CategoryName"));
                Product p = new Product();
                p.setId(rs.getInt("ProductID"));
                p.setName(rs.getString("ProductName"));
                p.setPrice(rs.getFloat("Price"));
                p.setCategory(c);
                p.setColor(rs.getString("Color"));
                p.setUrl(rs.getString("Url"));
                return p;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Product> getProduct(int CategoryID) {
        ArrayList<Product> products = new ArrayList<>();
        try {
            String sql = "SELECT [ProductID]\n"
                    + "      ,[ProductName]\n"
                    + "      ,[Price]\n"
                    + "      ,p.[CategoryID]\n"
                    + "	  ,c.[CategoryName]\n"
                    + "      ,[Color]\n"
                    + "      ,[Url]\n"
                    + "  FROM [Product] p\n"
                    + "  INNER JOIN [Category] c ON p.[CategoryID] = c.[CategoryID]\n"
                    + "  WHERE p.[CategoryID] = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, CategoryID);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Category c = new Category();
                c.setId(rs.getInt("CategoryID"));
                c.setName(rs.getString("CategoryName"));
                Product p = new Product();
                p.setId(rs.getInt("ProductID"));
                p.setName(rs.getString("ProductName"));
                p.setPrice(rs.getFloat("Price"));
                p.setCategory(c);
                p.setColor(rs.getString("Color"));
                p.setUrl(rs.getString("Url"));
                products.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }

    //select 8 newest product
    public ArrayList<Product> getNew() {
        ArrayList<Product> products = new ArrayList<>();
        try {
            String sql = "SELECT  [ProductID]\n"
                    + "      ,[ProductName]\n"
                    + "      ,[Price]\n"
                    + "      ,P.[CategoryID]\n"
                    + "	  ,C.[CategoryName]\n"
                    + "      ,[Color]\n"
                    + "      ,[Url]\n"
                    + "  FROM (\n"
                    + "	Select top 8 [ProductID]\n"
                    + "      ,[ProductName]\n"
                    + "      ,[Price]\n"
                    + "      ,[CategoryID]\n"
                    + "      ,[Color]\n"
                    + "      ,[Url]\n"
                    + "	  From [Product]\n"
                    + "	  Order by  ProductID desc\n"
                    + "  ) P \n"
                    + "  INNER JOIN Category C ON P.CategoryID = C.CategoryID\n"
                    + "  Order By ProductID";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Category c = new Category();
                c.setId(rs.getInt("CategoryID"));
                c.setName(rs.getString("CategoryName"));
                Product p = new Product();
                p.setId(rs.getInt("ProductID"));
                p.setName(rs.getString("ProductName"));
                p.setPrice(rs.getFloat("Price"));
                p.setCategory(c);
                p.setColor(rs.getString("Color"));
                p.setUrl(rs.getString("Url"));
                products.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }

    public ArrayList<Product> search(String text) {
        ArrayList<Product> products = new ArrayList<>();
        try {
            String sql = "SELECT [ProductID]\n"
                    + "      ,[ProductName]\n"
                    + "      ,[Price]\n"
                    + "      ,P.[CategoryID]\n"
                    + "	  ,C.[CategoryName]\n"
                    + "      ,[Color]\n"
                    + "      ,[Url]\n"
                    + "  FROM [Product] P\n"
                    + "  INNER JOIN [Category] C ON P.[CategoryID] =C.[CategoryID]\n"
                    + "  WHERE [ProductName] like '%'+?+'%'";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, text);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Category c = new Category();
                c.setId(rs.getInt("CategoryID"));
                c.setName(rs.getString("CategoryName"));
                Product p = new Product();
                p.setId(rs.getInt("ProductID"));
                p.setName(rs.getString("ProductName"));
                p.setPrice(rs.getFloat("Price"));
                p.setCategory(c);
                p.setColor(rs.getString("Color"));
                p.setUrl(rs.getString("Url"));
                products.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }
}
