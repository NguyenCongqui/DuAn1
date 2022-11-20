/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModel.ChiTietHoaDonBan;
import Utilities.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class ChiTietHoaDonRepository {
    DBConnection db;
    ResultSet rs = null;
    Statement st = null;
    PreparedStatement pst = null;
    List<ChiTietHoaDonBan> ListchitietHoaDon = null;

    public ChiTietHoaDonRepository() {
    }
    
    public String insert (ChiTietHoaDonBan cthd){
        String insert =" INSERT INTO dbo.CTHoaDonBan\n" +
"							 (\n" +
"							     IdHoaDonBan,\n" +
"							     IdCTSach,\n" +
"							     SoLuong,\n" +
"							     DonGia\n" +
"							 )\n" +
"							 VALUES\n" +
"							 (  (SELECT TOP 1 IdHoaDonBan FROM dbo.HoaDonBan ORDER BY IdHoaDonBan DESC),?,?,?)"; 
        try {
            pst = db.getConnection().prepareStatement(insert);
           pst.setInt(1, cthd.getIdChiTietSach());
           pst.setInt(2, cthd.getSoLuong());
           pst.setFloat(3, cthd.getDonGia());
            pst.executeUpdate();
            return "them thanh cong";
        } catch (Exception e) {
            
        }
        return "Them khong thanh cong";
    }
}
