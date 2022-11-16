/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModel.ChiTietSach;
import DomainModel.NhaXuatBan;
import Utilities.DBConnection;
import ViewModel.MatHang01;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    List<MatHang01> ListMatHang =null;

    public ChiTietSachRepository() {
    }
    public List<MatHang01> getListchitietsp (){
        String  select ="SELECT MaSach,TenSach,GiaBan,TenNgonNGu,TenTacGia,TenNXB,SoLuongTon FROM dbo.ChiTietSach INNER JOIN dbo.Sach ON Sach.IdSach = ChiTietSach.IdSach INNER JOIN dbo.NgonNgu ON NgonNgu.IdNgonNgu = ChiTietSach.IdNgonNgu \n" +
"	INNER JOIN dbo.TacGia ON TacGia.IdTacGia = ChiTietSach.IdTacGia\n" +
"	INNER JOIN dbo.NXB ON NXB.IdNXB = ChiTietSach.IdNXB";
        ListMatHang = new ArrayList<>();
        try {
            st=db.getConnection().createStatement();
            rs = st.executeQuery(select);
            while (rs.next()) {                
                ListMatHang.add(new MatHang01(rs.getString(1), rs.getString(2), rs.getFloat(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7)));  
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietSachRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ListMatHang;
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
