/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;


import Utilities.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class TrangChuRepository {
    DBConnection db;
    ResultSet rs = null;
    Statement st = null;
    PreparedStatement pst = null;
    //List<Ng> ListNgonNgu = null;

    public TrangChuRepository() {
    }
    
    
     public  int getTongDoanhTHu(){
        String select="SELECT IIF(CAST(SUM(totalReturn) AS INT ) is NULL , CAST(SUM(dbo.CTHoaDonBan.DonGia * dbo.CTHoaDonBan.SoLuong) AS INT), \n" +
"              (CAST(SUM(dbo.CTHoaDonBan.DonGia * dbo.CTHoaDonBan.SoLuong) - SUM(totalReturn) AS INT)))\n" +
"                            revenue FROM dbo.CTHoaDonBan JOIN dbo.HoaDonBan ON HoaDonBan.IdHoaDonBan = CTHoaDonBan.IdHoaDonBan\n" +
"                           LEFT JOIN dbo.HoaDonTraHang ON HoaDonTraHang.IDHoaDonBanHang = HoaDonBan.IdHoaDonBan WHERE \n" +
"                           YEAR(dbo.HoaDonBan.ngayTao) = YEAR(GETDATE()) AND\n" +
"                          MONTH(dbo.HoaDonBan.ngayTao) = MONTH(GETDATE()) AND DAY(dbo.HoaDonBan.ngayTao) = DAY(GETDATE())";
        try {
            st = db.getConnection().createStatement();
            rs = st.executeQuery(select);
            while (rs.next()) {
                return rs.getInt("TongDoanhThu");
            }
        } catch (Exception e) {
        }
        return 0;
    }
      public  int getTongKhachHang(){
        String select="SELECT COUNT(IdKhachHang) TongKhachHang FROM dbo.KhachHang";
        try {
            st = db.getConnection().createStatement();
            rs = st.executeQuery(select);
            while (rs.next()) {
                return rs.getInt("TongKhachHang");
            }
        } catch (Exception e) {
        }
        return 0;
    }
      public  int getTongSanPham(){
        String select="SELECT SUM(SoLuong) soluong FROM dbo.HoaDonBan JOIN dbo.CTHoaDonBan ON CTHoaDonBan.IdHoaDonBan = HoaDonBan.IdHoaDonBan\n" +
"              WHERE YEAR(ngayTao) = YEAR(GETDATE()) AND MONTH(ngayTao) = MONTH(GETDATE()) AND DAY(ngayTao) = DAY(GETDATE())";
        try {
            st = db.getConnection().createStatement();
            rs = st.executeQuery(select);
            while (rs.next()) {
                return rs.getInt("soluong");
            }
        } catch (Exception e) {
        }
        return 0;
    }
      public  int getTongTonKho(){
        String select="SELECT SUM(SoLuongTon) soluongton FROM dbo.ChiTietSach";
        try {
            st = db.getConnection().createStatement();
            rs = st.executeQuery(select);
            while (rs.next()) {
                return rs.getInt("soluongton");
            }
        } catch (Exception e) {
        }
        return 0;
    }
}
