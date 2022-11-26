/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;


import DomainModel.Voucher;
import Utilities.DBConnection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class VoucherRepository {
    DBConnection db;
    ResultSet rs = null;
    Statement st = null;
    PreparedStatement pst = null;
    List<Voucher> ListVoucher = null;

    public VoucherRepository() {
    }
    public List<Voucher> getLisVoucher() {
        String select = "SELECT * FROM dbo.Voucher";
        ListVoucher = new ArrayList<>();
        try {
            st = db.getConnection().createStatement();
            rs = st.executeQuery(select);
            while (rs.next()) {
                ListVoucher.add(new Voucher(rs.getInt(1),rs.getString(2),rs.getFloat(3),rs.getString(4),rs.getDate(5),rs.getDate(6),rs.getInt(7),rs.getBoolean(8)));
            }
            rs.close();
        } catch (Exception e) {
        }
        
        return ListVoucher;
    }
    public String updateSoLuongTon( Integer idVoucher) {
        String update = "UPDATE dbo.Voucher SET SoLuong = SoLuong - 1 WHERE IdVoucher = ?";
        try {
            pst = db.getConnection().prepareStatement(update);

            pst.setInt(1, idVoucher);           
            pst.executeUpdate();
            return "sua thanh cong";
        } catch (Exception e) {

        }
        return "sua khong thanh cong";
    }
     public String insert (Voucher v){
        String insert = "INSERT INTO dbo.Voucher\n" +
"(\n" +
"    MaGiamGia,\n" +
"    GiamGia,\n" +
"    StartsAt,\n" +
"    EndsAt,\n" +
"    SoLuong,\n" +
"    NgayTao,\n" +
")\n" +
"VALUES(?,?,?,?,?,GETDATE())";
      
        try {
            pst = db.getConnection().prepareStatement(insert);
            pst.setString(1, v.getMaGiamGia());
            pst.setFloat(2, v.getGiamgia());
            pst.setDate(3, (Date) v.getNgayBatDau());
            pst.setDate(4, (Date) v.getNgayKetThuc());
            pst.setInt(5, v.getSoLuong());
           
            
            pst.executeUpdate();
            return "them thanh cong";
        } catch (Exception e) {
            
        }
        return "Them khong thanh cong";
    }
}
