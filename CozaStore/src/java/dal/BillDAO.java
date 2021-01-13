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
import model.Bill;

public class BillDAO extends BaseDAO<Bill> {

    public void insertBill(Bill bill) throws SQLException {
        String sql = "INSERT INTO [Bill]\n"
                + "           ([id]\n"
                + "           ,[customerID]\n"
                + "           ,[total]\n"
                + "           ,[payment]\n"
                + "           ,[date]\n"
                + "           ,[address])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,GETDATE()\n"
                + "           ,?)";
        PreparedStatement ps = connection.prepareCall(sql);
        ps.setInt(1, bill.getId());
        ps.setInt(2, bill.getCustomerID());
        ps.setFloat(3, bill.getTotal());
        ps.setString(4, bill.getPayment());
        ps.setString(5, bill.getAddress());
        ps.executeUpdate();
    }

    @Override
    public ArrayList<Bill> getAll() {
        ArrayList<Bill> bills = new ArrayList<>();
        try {
            String sql = "SELECT [id]\n"
                    + "      ,[customerID]\n"
                    + "      ,[total]\n"
                    + "      ,[payment]\n"
                    + "      ,[address]\n"
                    + "      ,[date]\n"
                    + "  FROM [Bill]";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            ResultSet rs = prepareStatement.executeQuery();
            while (rs.next()) {
                Bill bill = new Bill();
                bill.setId(rs.getInt("id"));
                bill.setCustomerID(rs.getInt("customerID"));
                bill.setDate(rs.getDate("date"));
                bill.setPayment(rs.getString("payment"));
                bill.setAddress(rs.getString("address"));
                bill.setTotal(rs.getFloat("total"));
                bills.add(bill);
            }
        } catch (Exception e) {
        }
        return bills;
    }

    @Override
    public Bill get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
