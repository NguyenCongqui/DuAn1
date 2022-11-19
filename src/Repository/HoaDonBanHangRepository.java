
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModel.HoaDonBanHang;
import DomainModel.NgonNgu;
import Utilities.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class HoaDonBanHangRepository {
     DBConnection db;
    ResultSet rs = null;
    Statement st = null;
    PreparedStatement pst = null;
    List<HoaDonBanHang> ListHoaDon = null;

    public HoaDonBanHangRepository() {
    }
    
     public String insert (HoaDonBanHang hdbh){
        String insert = "INSERT INTO dbo.HoaDonBan\n" +
"					 (\n" +
"					     IdKhachHang,\n" +
"					     IdVoucher,\n" +
"					     TENKHACHHANG,\n" +
"					     statusPay,\n" +
"					     statusInvoice,\n" +
"					     TongTien,\n" +
"					     TienKhachDua,\n" +
"					     TienTraLai,\n" +
"					     TrangThai,\n" +
"						 ngayTao,\n" +
"					     NGAYTHANHTOAN,\n" +
"					 )\n" +
"					 VALUES(?,?,?,?,?,?,?,?,?, GETDATE(), GETDATE())";
        try {
            pst = db.getConnection().prepareStatement(insert);
            pst.setInt(1, hdbh.getIDHoaDonBan());
            pst.setInt(2, hdbh.getIDVoucher());
            pst.setString(3, hdbh.getTenKhachHang());
            pst.setBoolean(4, hdbh.isTrangThaiTraTien());
            pst.setBoolean(5, hdbh.isTrangThaiHoaDon());
            pst.setFloat(6, hdbh.getTongTien());
            pst.setFloat(7, hdbh.getTienKhachDua());
            pst.setFloat(8, hdbh.getTienTraLai());
            pst.setBoolean(9, hdbh.isTrangThai());
            pst.executeUpdate();
            return "them thanh cong";
        } catch (Exception e) {
            
        }
        return "Them khong thanh cong";
    }
}
