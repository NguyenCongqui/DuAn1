/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModel.ChiTietSach;
import Utilities.DBConnection;
import ViewModel.CTHDTraHangViewModel;
import ViewModel.HDTraHangViewModel;
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

    public List<HDTraHangViewModel> getAllTra() {
        String query = "SELECT dbo.HoaDonTraHang.IDHoaDonTraHang, dbo.HoaDonBan.IdHoaDonBan, dbo.HoaDonTraHang.NgayDoiHang, dbo.KhachHang.Hoten, dbo.KhachHang.Sdt, dbo.HoaDonTraHang.totalReturn, dbo.HoaDonTraHang.MoTa\n"
                + "FROM     dbo.HoaDonTraHang INNER JOIN\n"
                + "                  dbo.HoaDonBan ON dbo.HoaDonTraHang.IDHoaDonBanHang = dbo.HoaDonBan.IdHoaDonBan INNER JOIN\n"
                + "                  dbo.KhachHang ON dbo.HoaDonTraHang.IDKhachHang = dbo.KhachHang.IdKhachHang AND dbo.HoaDonBan.IdKhachHang = dbo.KhachHang.IdKhachHang CROSS JOIN\n"
                + "                  dbo.ChiTietHoaDonNhapSanPham";
        List<HDTraHangViewModel> listTra = new ArrayList<>();
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HDTraHangViewModel th = new HDTraHangViewModel(rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getString(4), rs.getInt(5), rs.getFloat(6), rs.getString(7));
                listTra.add(th);
            }
            return listTra;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    public List<CTHDTraHangViewModel> getAllTraChiTiet() {
        String query = "SELECT dbo.chitietHoaDonTraHang.IDchitietHoaDonTraHang, dbo.Sach.TenSach, dbo.KhachHang.Hoten, dbo.NgonNgu.TenNgonNGu, dbo.NXB.TenNXB, dbo.TacGia.TenTacGia, dbo.chitietHoaDonTraHang.SoLuong, \n" +
"                  dbo.HoaDonTraHang.totalReturn\n" +
"FROM     dbo.chitietHoaDonTraHang INNER JOIN\n" +
"                  dbo.ChiTietSach ON dbo.chitietHoaDonTraHang.IDChiTietSach = dbo.ChiTietSach.IdCTSach INNER JOIN\n" +
"                  dbo.HoaDonTraHang ON dbo.chitietHoaDonTraHang.IDHoaDonTraHang = dbo.HoaDonTraHang.IDHoaDonTraHang INNER JOIN\n" +
"                  dbo.HoaDonBan ON dbo.HoaDonTraHang.IDHoaDonBanHang = dbo.HoaDonBan.IdHoaDonBan INNER JOIN\n" +
"                  dbo.KhachHang ON dbo.HoaDonTraHang.IDKhachHang = dbo.KhachHang.IdKhachHang AND dbo.HoaDonBan.IdKhachHang = dbo.KhachHang.IdKhachHang INNER JOIN\n" +
"                  dbo.NgonNgu ON dbo.ChiTietSach.IdNgonNgu = dbo.NgonNgu.IdNgonNgu INNER JOIN\n" +
"                  dbo.NXB ON dbo.ChiTietSach.IdNXB = dbo.NXB.IdNXB INNER JOIN\n" +
"                  dbo.Sach ON dbo.ChiTietSach.IdSach = dbo.Sach.IdSach INNER JOIN\n" +
"                  dbo.TacGia ON dbo.ChiTietSach.IdTacGia = dbo.TacGia.IdTacGia";
        List<CTHDTraHangViewModel> listTra = new ArrayList<>();
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CTHDTraHangViewModel th = new CTHDTraHangViewModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7),  rs.getInt(8));
                listTra.add(th);
            }
            return listTra;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    
    

    public List<TraHangViewModel> searchId(int id) {
        String query = "SELECT I.IdHoaDonBan,P.IdSach,P.TenSach,E.SoLuong,S.TenNXB,M.TenNgonNGu,A.TenTacGia, E.DonGia,C.Hoten\n"
                + "                               FROM dbo.CTHoaDonBan E\n"
                + "                             JOIN dbo.HoaDonBan I ON I.IdHoaDonBan = E.IdHoaDonBan\n"
                + "                              JOIN dbo.KhachHang C ON C.IdKhachHang = I.IdKhachHang\n"
                + "                                JOIN dbo.ChiTietSach D ON D.IdCTSach = E.IdCTSach\n"
                + "                               JOIN dbo.Sach P ON P.IdSach = D.IdSach\n"
                + "                               JOIN dbo.NXB S ON S.IdNXB = D.IdNXB\n"
                + "                                JOIN dbo.NgonNgu M ON M.IdNgonNgu = D.IdNgonNgu\n"
                + "                              JOIN dbo.TacGia A ON A.IdTacGia = D.IdTacGia\n"
                + "                               WHERE E.IdHoaDonBan = ? and E.SoLuong>0";
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

    public boolean insert(HDTraHangViewModel hdnspvm) {
        String sql = " INSERT INTO [dbo].[HoaDonTraHang]\n"
                + "           ([IDKhachHang]\n"
                + "           ,[IDUsers]\n"
                + "           ,[IDHoaDonBanHang]\n"
                + "           ,[MoTa]\n"
                + "           ,[totalReturn]\n"
                + "		   ,[NgayDoiHang])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,getdate())";
        int check = 0;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setObject(1, hdnspvm.getIdKhachHang());
            ps.setObject(2, hdnspvm.getIDUsers());
            ps.setObject(3, hdnspvm.getMaHoaDonBan());
            ps.setObject(4, hdnspvm.getGhiChu());
            ps.setObject(5, hdnspvm.getTongTienHoanTra());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public Float TongTien(Float idHDT) {
        String sql = "SELECT  IDchitietHoaDonTraHang, SUM(SoLuong * GIA ) as totalCash FROM dbo.chitietHoaDonTraHang \n"
                + "                GROUP BY IDchitietHoaDonTraHang \n"
                + "                HAVING IDchitietHoaDonTraHang = ?";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setObject(1, idHDT);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getFloat("totalCash");
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<CTHDTraHangViewModel> selectByIdNhap(int id)  {
        String sql = " SELECT dbo.chitietHoaDonTraHang.IDchitietHoaDonTraHang, dbo.Sach.TenSach, dbo.KhachHang.Hoten, dbo.NgonNgu.TenNgonNGu, dbo.NXB.TenNXB, dbo.TacGia.TenTacGia, dbo.chitietHoaDonTraHang.SoLuong, \n" +
"                  dbo.HoaDonTraHang.totalReturn\n" +
"FROM     dbo.chitietHoaDonTraHang INNER JOIN\n" +
"                  dbo.ChiTietSach ON dbo.chitietHoaDonTraHang.IDChiTietSach = dbo.ChiTietSach.IdCTSach INNER JOIN\n" +
"                  dbo.HoaDonTraHang ON dbo.chitietHoaDonTraHang.IDHoaDonTraHang = dbo.HoaDonTraHang.IDHoaDonTraHang INNER JOIN\n" +
"                  dbo.HoaDonBan ON dbo.HoaDonTraHang.IDHoaDonBanHang = dbo.HoaDonBan.IdHoaDonBan INNER JOIN\n" +
"                  dbo.KhachHang ON dbo.HoaDonTraHang.IDKhachHang = dbo.KhachHang.IdKhachHang AND dbo.HoaDonBan.IdKhachHang = dbo.KhachHang.IdKhachHang INNER JOIN\n" +
"                  dbo.NgonNgu ON dbo.ChiTietSach.IdNgonNgu = dbo.NgonNgu.IdNgonNgu INNER JOIN\n" +
"                  dbo.NXB ON dbo.ChiTietSach.IdNXB = dbo.NXB.IdNXB INNER JOIN\n" +
"                  dbo.Sach ON dbo.ChiTietSach.IdSach = dbo.Sach.IdSach INNER JOIN\n" +
"                  dbo.TacGia ON dbo.ChiTietSach.IdTacGia = dbo.TacGia.IdTacGia where dbo.chitietHoaDonTraHang.IDchitietHoaDonTraHang = ?";
        List<CTHDTraHangViewModel> list = new ArrayList<>();
        try(Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                CTHDTraHangViewModel t = new CTHDTraHangViewModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getInt(8));
                list.add(t);
            }
            return list;
        }catch(SQLException e){
            e.printStackTrace(System.out);
        }
            return null;

}
}

