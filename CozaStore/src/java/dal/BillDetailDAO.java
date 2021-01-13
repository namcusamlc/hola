/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import model.BillDetail;

public class BillDetailDAO extends BaseDAO<BillDetail> {

    public void insertBillDetail(BillDetail bd) throws SQLException {
        String sql = "INSERT INTO [BillDetail]\n"
                + "           ([idBill]\n"
                + "           ,[productID]\n"
                + "           ,[price]\n"
                + "           ,[quantity])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)";
        PreparedStatement ps = connection.prepareCall(sql);
        ps.setInt(1, bd.getBillID());
        ps.setInt(2, bd.getProductID());
        ps.setFloat(3, bd.getPrice());
        ps.setInt(4, bd.getQuantity());
        ps.executeUpdate();
    }

    @Override
    public ArrayList<BillDetail> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BillDetail get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
