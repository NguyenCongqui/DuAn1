/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModel.ChiTietSach;
import DomainModel.NhaXuatBan;
import Utilities.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class ChiTietSachRepository {
    DBConnection db;
    ResultSet rs = null;
    Statement st = null;
    PreparedStatement pst = null;
    List<ChiTietSach> ListChiTietSach = null;

    public ChiTietSachRepository() {
    }
    
    public String insert (ChiTietSach cts){
        String insert = "INSERT INTO dbo.ChiTietSach\n" +
"				(\n" +
"				    IdSach,\n" +
"				    IdNgonNgu,\n" +
"				    IdTacGia,\n" +
"				    IdNXB,\n" +
"				    MoTa,\n" +
"				    SoLuongTon,\n" +
"				    GiaNhap,\n" +
"				    GiaBan,\n" +
"				    CreatedAt,\n" +
"				    UpdateAt\n" +
"				)\n" +
"				VALUES(?,?,?,?,?,?,?,?,GETDATE(),GETDATE())";
        try {
            pst = db.getConnection().prepareStatement(insert);
            pst.setInt(1, cts.getIdSach());
            pst.setInt(2, cts.getIdNgonNgu());
            pst.setInt(3, cts.getIdTacGIa());
            pst.setInt(4, cts.getIdNXB());
            pst.setString(5, cts.getMota());
            pst.setInt(6, cts.getSoluong());
            pst.setFloat(7, cts.getGiaNhap());
            pst.setFloat(8, cts.getGiaBan());           
            pst.executeUpdate();
            return "them thanh cong";
        } catch (Exception e) {
            
        }
        return "Them khong thanh cong";
    }
}
