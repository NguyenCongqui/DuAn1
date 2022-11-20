/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Utilities.DBConnection;
import ViewModel.TraHangViewModel;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
/**
 *
 * @author quanh
 */
public class HoaDonTraHangRepository {
    public List<TraHangViewModel> getAll() throws SQLException{
        String query = "SELECT dbo.HoaDonTraHang.IDHoaDonTraHang, dbo.HoaDonBan.IdHoaDonBan, dbo.KhachHang.Hoten, dbo.Sach.TenSach, dbo.chitietHoaDonTraHang.SoLuong, dbo.KhachHang.Sdt, dbo.CTHoaDonBan.SoLuong AS Expr1\n" +
"FROM     dbo.chitietHoaDonTraHang INNER JOIN\n" +
"                  dbo.ChiTietSach ON dbo.chitietHoaDonTraHang.IDChiTietSach = dbo.ChiTietSach.IdCTSach INNER JOIN\n" +
"                  dbo.CTHoaDonBan ON dbo.ChiTietSach.IdCTSach = dbo.CTHoaDonBan.IdCTSach INNER JOIN\n" +
"                  dbo.HoaDonBan ON dbo.CTHoaDonBan.IdHoaDonBan = dbo.HoaDonBan.IdHoaDonBan INNER JOIN\n" +
"                  dbo.HoaDonTraHang ON dbo.chitietHoaDonTraHang.IDHoaDonTraHang = dbo.HoaDonTraHang.IDHoaDonTraHang AND dbo.HoaDonBan.IdHoaDonBan = dbo.HoaDonTraHang.IDHoaDonBanHang INNER JOIN\n" +
"                  dbo.KhachHang ON dbo.HoaDonBan.IdKhachHang = dbo.KhachHang.IdKhachHang AND dbo.HoaDonTraHang.IDKhachHang = dbo.KhachHang.IdKhachHang INNER JOIN\n" +
"                  dbo.Sach ON dbo.ChiTietSach.IdSach = dbo.Sach.IdSach";
        List<TraHangViewModel> listTh = new ArrayList<>();
        try(Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query)){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
               TraHangViewModel th = new TraHangViewModel(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getFloat(7));
               listTh.add(th);
            }
            return listTh;
        }
    catch(Exception e){
        e.printStackTrace(System.out);
    }
        return null;
    }
}
