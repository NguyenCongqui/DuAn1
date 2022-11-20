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
    public List<TraHangViewModel> getAll(){
        String query = "SELECT dbo.HoaDonBan.IdHoaDonBan, dbo.Sach.MaSach, dbo.KhachHang.Hoten, dbo.Sach.TenSach, dbo.CTHoaDonBan.SoLuong, dbo.KhachHang.Sdt, dbo.CTHoaDonBan.DonGia\n" +
"FROM     dbo.HoaDonBan INNER JOIN\n" +
"                  dbo.CTHoaDonBan ON dbo.HoaDonBan.IdHoaDonBan = dbo.CTHoaDonBan.IdHoaDonBan INNER JOIN\n" +
"                  dbo.HoaDonTraHang ON dbo.HoaDonBan.IdHoaDonBan = dbo.HoaDonTraHang.IDHoaDonBanHang INNER JOIN\n" +
"                  dbo.chitietHoaDonTraHang ON dbo.HoaDonTraHang.IDHoaDonTraHang = dbo.chitietHoaDonTraHang.IDHoaDonTraHang INNER JOIN\n" +
"                  dbo.KhachHang ON dbo.HoaDonBan.IdKhachHang = dbo.KhachHang.IdKhachHang AND dbo.HoaDonTraHang.IDKhachHang = dbo.KhachHang.IdKhachHang CROSS JOIN\n" +
"                  dbo.Sach";
        List<TraHangViewModel> listTh = new ArrayList<>();
        try(Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query)){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
               TraHangViewModel th = new TraHangViewModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getFloat(7));
               listTh.add(th);
            }
            return listTh;
        }
    catch(Exception e){
        e.printStackTrace(System.out);
    }
        return null;
    }
    public List<TraHangViewModel> searchTen(String temp){
        String query = "SELECT dbo.HoaDonBan.IdHoaDonBan, dbo.Sach.MaSach, dbo.KhachHang.Hoten, dbo.Sach.TenSach, dbo.CTHoaDonBan.SoLuong, dbo.KhachHang.Sdt, dbo.CTHoaDonBan.DonGia\n" +
"FROM     dbo.HoaDonBan INNER JOIN\n" +
"                  dbo.CTHoaDonBan ON dbo.HoaDonBan.IdHoaDonBan = dbo.CTHoaDonBan.IdHoaDonBan INNER JOIN\n" +
"                  dbo.HoaDonTraHang ON dbo.HoaDonBan.IdHoaDonBan = dbo.HoaDonTraHang.IDHoaDonBanHang INNER JOIN\n" +
"                  dbo.chitietHoaDonTraHang ON dbo.HoaDonTraHang.IDHoaDonTraHang = dbo.chitietHoaDonTraHang.IDHoaDonTraHang INNER JOIN\n" +
"                  dbo.KhachHang ON dbo.HoaDonBan.IdKhachHang = dbo.KhachHang.IdKhachHang AND dbo.HoaDonTraHang.IDKhachHang = dbo.KhachHang.IdKhachHang CROSS JOIN\n" +
"                  dbo.Sach where Sach.MaSach LIKE '%"+temp+"%' order by Sach.MaSach asc";
        List<TraHangViewModel> listTHV = new ArrayList<>();
        try(Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query)){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
               TraHangViewModel th = new TraHangViewModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getFloat(7));
               listTHV.add(th);
            }
            return listTHV;
        }
    catch(Exception e){
        e.printStackTrace(System.out);
    }
        return null;
    }
  
}
