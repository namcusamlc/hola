/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.BaseModel;

/**
 *
 * @author sonnt
 * @param <T>
 */
public abstract class BaseDAO<T extends BaseModel> {
   protected Connection connection;
   public BaseDAO()
   {
       try {
           String url = "jdbc:sqlserver://localhost:1433;databaseName=SE1206_Project";
           String username = "sa";
           String password = "123456";
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           connection = DriverManager.getConnection(url,username,password);
       } catch (ClassNotFoundException | SQLException ex) {
           Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
   
   public abstract ArrayList<T> getAll();
   public abstract T get(int id);
   
}
