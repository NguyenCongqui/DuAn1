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

    public List<TraHangViewModel> getAll() {
        String query = "SELECT I.IdHoaDonBan,P.IdSach,P.TenSach,E.SoLuong,S.TenNXB,M.TenNgonNGu,A.TenTacGia, E.DonGia,C.Hoten\n"
                + "                FROM dbo.CTHoaDonBan E\n"
                + "                JOIN dbo.HoaDonBan I ON I.IdHoaDonBan = E.IdHoaDonBan\n"
                + "                JOIN dbo.KhachHang C ON C.IdKhachHang = I.IdKhachHang\n"
                + "                JOIN dbo.ChiTietSach D ON D.IdCTSach = E.IdCTSach\n"
                + "                JOIN dbo.Sach P ON P.IdSach = D.IdSach\n"
                + "                JOIN dbo.NXB S ON S.IdNXB = D.IdNXB\n"
                + "                JOIN dbo.NgonNgu M ON M.IdNgonNgu = D.IdNgonNgu\n"
                + "                JOIN dbo.TacGia A ON A.IdTacGia = D.IdTacGia";
        List<TraHangViewModel> listTh = new ArrayList<>();
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TraHangViewModel th = new TraHangViewModel(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getFloat(8), rs.getString(9));
                listTh.add(th);
            }
            return listTh;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<TraHangViewModel> searchId(int id) {
        String query = "SELECT I.IdHoaDonBan,P.IdSach,P.TenSach,E.SoLuong,S.TenNXB,M.TenNgonNGu,A.TenTacGia, E.DonGia,C.Hoten\n"
                + "                FROM dbo.CTHoaDonBan E\n"
                + "                JOIN dbo.HoaDonBan I ON I.IdHoaDonBan = E.IdHoaDonBan\n"
                + "                JOIN dbo.KhachHang C ON C.IdKhachHang = I.IdKhachHang\n"
                + "                JOIN dbo.ChiTietSach D ON D.IdCTSach = E.IdCTSach\n"
                + "                JOIN dbo.Sach P ON P.IdSach = D.IdSach\n"
                + "                JOIN dbo.NXB S ON S.IdNXB = D.IdNXB\n"
                + "                JOIN dbo.NgonNgu M ON M.IdNgonNgu = D.IdNgonNgu\n"
                + "                JOIN dbo.TacGia A ON A.IdTacGia = D.IdTacGia\n"
                + "               WHERE E.IdHoaDonBan = ?";
        List<TraHangViewModel> listSearch = new ArrayList<>();
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                TraHangViewModel th = new TraHangViewModel(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getFloat(8), rs.getString(9));
                listSearch.add(th);
            }
            return listSearch;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

}
