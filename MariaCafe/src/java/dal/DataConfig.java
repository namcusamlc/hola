/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author hoaktse05446
 */
public class DataConfig {

    private static Connection conn = null;
    private static String connectionURL = "";
    private static String user = "";
    private static String pass = "";
    private static String imagePath = "";
    private static int pageGap;
    private static int pageSize;
    private static String sqldriverclass = "";

    public static void initConfig() {
        try {
            InitialContext initialContext = new InitialContext();
            Context environmentContext = (Context) initialContext.lookup("java:/comp/env");
            connectionURL = (String) environmentContext.lookup("myConnectionURL");
            sqldriverclass = (String) environmentContext.lookup("sqldriverclass");
            user = (String) environmentContext.lookup("databaseUser");
            pass = (String) environmentContext.lookup("databasePass");
            imagePath = (String) environmentContext.lookup("imagePath");
            pageGap = (int) environmentContext.lookup("pageGap");
            pageSize = (int) environmentContext.lookup("pageSize");
            System.out.println("hjgjh");
        } catch (NamingException ex) {
            Logger.getLogger(DataConfig.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getConnection() {
        initConfig();
        try {
            Class.forName(sqldriverclass);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataConfig.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Connect successfully.");
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(connectionURL, user, pass);
        } catch (SQLException ex) {
            Logger.getLogger(DataConfig.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }

    public void close(Connection conn, PreparedStatement pre, ResultSet rs) {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }

            if (pre != null && !pre.isClosed()) {
                pre.close();
            }

            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataConfig.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String getImagePath() {
        return imagePath;
    }

    public static void setImagePath(String imagePath) {
        DataConfig.imagePath = imagePath;
    }

    public static int getPageGap() {
        return pageGap;
    }

    public static void setPageGap(int pageGap) {
        DataConfig.pageGap = pageGap;
    }

    public static int getPageSize() {
        return pageSize;
    }

    public static void setPageSize(int pageSize) {
        DataConfig.pageSize = pageSize;
    }

}
