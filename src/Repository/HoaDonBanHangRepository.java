
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModel.HoaDonBanHang;
import Utilities.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
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
"		 (\n" +
"		     IdKhachHang,\n" +
"		     IdUsers,\n" +
"		     IdVoucher,\n" +
"		     TENKhachHang,\n" +
"		     statusPay,\n" +
"		     statusInvoice,\n" +
"		     TongTien,\n" +
"		     TienKhachDua,\n" +
"		     TienTraLai,\n" +
"		     TrangThai,\n" +
"		     GhiChu,\n" +
"		     ngayTao,\n" +
"		     NGAYTHANHTOAN\n" +
"		 )\n" +
"		 VALUES(?,?,?,?,?,?,?,?,?,?,?,GETDATE(),GETDATE())";
      
        try {
            pst = db.getConnection().prepareStatement(insert);
            pst.setInt(1, hdbh.getIdKhachHang());
            pst.setInt(2, hdbh.getIdUsers());
            pst.setObject(3, hdbh.getIDVoucher());
            pst.setString(4, hdbh.getTenKhachHang());
            pst.setBoolean(5, hdbh.isTrangThaiTraTien());
            pst.setBoolean(6, hdbh.isTrangThaiHoaDon());
            pst.setFloat(7, hdbh.getTongTien());
            pst.setFloat(8, hdbh.getTienKhachDua());
            pst.setFloat(9, hdbh.getTienTraLai());
            pst.setBoolean(10, hdbh.isTrangThai());
            pst.setString(11, hdbh.getGhichu());
            pst.executeUpdate();
            return "them thanh cong";
        } catch (Exception e) {
            
        }
        return "Them khong thanh cong";
    }
}
