/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Utilities.DBConnection;
import ViewModel.CTHDNhapSpViewModel;
import ViewModel.HDNhapSPViewModel;
import ViewModel.NhapHangViewModel;
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
public class NhapHangRepository {

    DBConnection db;
    ResultSet rs = null;
    Statement st = null;
    PreparedStatement pst = null;
    List<NhapHangViewModel> listNHV = null;
    List<HDNhapSPViewModel> listHDNhap = null;

    public List<NhapHangViewModel> getAll() {

        String sql = "   SELECT c.IdCTSach,s.TenSach,l.TenTheLoai,x.TenNXB,n.TenNgonNGu,T.TenTacGia,C.SoLuongTon,C.GiaBan \n"
                + "  FROM dbo.ChiTietSach C\n"
                + "  INNER JOIN dbo.NgonNgu N ON N.IdNgonNgu = C.IdNgonNgu\n"
                + "  INNER JOIN dbo.NXB X ON X.IdNXB = C.IdNXB\n"
                + "  INNER JOIN dbo.TacGia T ON T.IdTacGia = C.IdTacGia\n"
                + "  INNER JOIN dbo.Sach S ON S.IdSach = C.IdSach\n"
                + "  INNER JOIN dbo.TheLoai L ON L.IdTheLoai = S.Idtheloai\n"
                + "  ORDER BY C.IdCTSach DESC";
        try {
            st = db.getConnection().createStatement();
            rs = st.executeQuery(sql);
            listNHV = new ArrayList<>();
            while (rs.next()) {
                listNHV.add(new NhapHangViewModel(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getFloat(8)));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(NCCRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listNHV;
    }

    public List<NhapHangViewModel> searchTenSach(String temp) {
        String sql = "SELECT c.IdCTSach,s.TenSach,l.TenTheLoai,x.TenNXB,n.TenNgonNGu,T.TenTacGia,C.SoLuongTon,C.GiaBan \n"
                + "FROM dbo.ChiTietSach C\n"
                + "INNER JOIN dbo.NgonNgu N ON N.IdNgonNgu = C.IdNgonNgu\n"
                + "INNER JOIN dbo.NXB X ON X.IdNXB = C.IdNXB\n"
                + "INNER JOIN dbo.TacGia T ON T.IdTacGia = C.IdTacGia\n"
                + "INNER JOIN dbo.Sach S ON S.IdSach = C.IdSach\n"
                + "INNER JOIN dbo.TheLoai L ON L.IdTheLoai = S.Idtheloai where S.TenSach LIKE '%" + temp + "%' order by S.TenSach asc";
        try {
            st = db.getConnection().createStatement();
            rs = st.executeQuery(sql);
            listNHV = new ArrayList<>();
            while (rs.next()) {
                listNHV.add(new NhapHangViewModel(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getFloat(8)));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(NCCRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listNHV;
    }

    public String insertHDN(HDNhapSPViewModel hdnspvm) {

        try {
            String sql = "  INSERT INTO [dbo].[HoaDonNhapSanPham]\n"
                    + "           ([IDNhaCungCap]\n"
                    + "           ,[IDUsers]\n"
                    + "           ,[TINHTRANGTRATIEN]\n"
                    + "           ,[MoTa]"
                    + ",[NGAYTAODON])\n"
                    + "     VALUES\n"
                    + "           (?,?,?,?,GETDATE())";
            pst = db.getConnection().prepareStatement(sql);
            pst.setInt(1, hdnspvm.getIDNhaCungCap());
            pst.setInt(2, hdnspvm.getIDUsers());
            pst.setBoolean(3, hdnspvm.getTINHTRANGTRATIEN());
            pst.setString(4, hdnspvm.getMoTa());
            //  pst.setString(5, hdnspvm.getNGAYTAODON());

            pst.executeUpdate();
            return "Them thanh cong";
        } catch (SQLException ex) {
            Logger.getLogger(NCCRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Them khong thanh cong";
    }

    public String insertHDCT(CTHDNhapSpViewModel cthdnsvm) {

        try {
            String sql = "INSERT INTO [dbo].[ChiTietHoaDonNhapSanPham]([IDHoaDonNhapSanPham],[IDChiTietSach],[SoLuong],[priceImport])VALUES \n"
                    + "((SELECT TOP 1 IDHoaDonNhapSanPham FROM dbo.HoaDonNhapSanPham ORDER BY IDHoaDonNhapSanPham DESC),?,?,?)";
            pst = db.getConnection().prepareStatement(sql);
            // pst.setInt(1, cthdnsvm.getIDHoaDonNhapSanPham());
            pst.setInt(1, cthdnsvm.getIDChiTietSach());
            pst.setInt(2, cthdnsvm.getSoLuong());
            pst.setFloat(3, cthdnsvm.getPrice());

            pst.executeUpdate();
            return "Them thanh cong";
        } catch (SQLException ex) {
            Logger.getLogger(NCCRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Them khong thanh cong";
    }

    public String updateCTSP(Integer slg, Float giaNhap, Integer id) {
        //  NhapHangViewModel nhvm = new NhapHangViewModel();

        String update = "UPDATE dbo.ChiTietSach SET SoLuongTon = SoLuongTon + ? , GiaNhap = (SELECT TOP 1 priceImport FROM dbo.ChiTietHoaDonNhapSanPham ORDER BY priceImport DESC) WHERE IdCTSach = ?";

        try {
            pst = db.getConnection().prepareStatement(update);
            pst.setInt(1, slg);
            //   pst.setFloat(2, nhvm.getGianhap());
            pst.setInt(2, id);

            pst.executeUpdate();
            return "sua thanh cong";
        } catch (SQLException e) {

        }
        return "sua khong thanh cong";
    }

    public NhapHangViewModel searchID(int id) {
        String sql = " SELECT c.IdCTSach,s.TenSach,l.TenTheLoai,x.TenNXB,n.TenNgonNGu,T.TenTacGia,C.SoLuongTon,C.GiaBan \n"
                + "FROM dbo.ChiTietSach C\n"
                + "INNER JOIN dbo.NgonNgu N ON N.IdNgonNgu = C.IdNgonNgu\n"
                + "INNER JOIN dbo.NXB X ON X.IdNXB = C.IdNXB\n"
                + "INNER JOIN dbo.TacGia T ON T.IdTacGia = C.IdTacGia\n"
                + "INNER JOIN dbo.Sach S ON S.IdSach = C.IdSach\n"
                + "INNER JOIN dbo.TheLoai L ON L.IdTheLoai = S.Idtheloai where c.IdCTSach = ?";
        try {
            pst = db.getConnection().prepareStatement(sql);
            pst.setObject(1, id);
            rs = pst.executeQuery();
            listNHV = new ArrayList<>();

            while (rs.next()) {
//                listNHV.add(new NhapHangViewModel(
//                        rs.getInt(1),
//                        rs.getString(2),
//                        rs.getString(3),
//                        rs.getString(4),
//                        rs.getString(5),
//                        rs.getString(6),
//                        rs.getInt(7),
//                        rs.getFloat(8)));
                NhapHangViewModel p = new NhapHangViewModel();
                p.setIdchitietsach(rs.getInt(1));
                p.setTenSach(rs.getString(2));
                p.setTenTheLoai(rs.getString(3));
                p.setTenNxb(rs.getString(4));
                p.setTenNgonNgu(rs.getString(5));
                p.setTenTacGia(rs.getString(6));
                p.setGia(rs.getFloat(8));
                p.setSoluong(rs.getInt(7));

                return p;
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(NCCRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public List<HDNhapSPViewModel> getAllHDNhap() {
//        String sql ="SELECT N.IDHoaDonNhapSanPham , N.NGAYTAODON , U.HoTen, C.TenNhaCungCap , N.MoTa\n" +
//"FROM dbo.HoaDonNhapSanPham N \n" +
//"JOIN dbo.Users U ON U.IdUsers = N.IDUsers\n" +
//"JOIN dbo.NhaCungCap C ON C.IdNhaCungCap = N.IDNhaCungCap ORDER BY N.IDHoaDonNhapSanPham DESC";
//         try {
//            st = db.getConnection().createStatement();
//            rs = st.executeQuery(sql);
//            listHDNhap = new ArrayList<>();
//            while (rs.next()) {
//               HDNhapSPViewModel i = new HDNhapSPViewModel();
//                i.setIDHoaDonNhapSanPham(rs.getInt(1));
//                i.setNGAYTAODON(rs.getString(2));
//                i.setTenUser(rs.getString(3));
//                i.setTenNCC(rs.getString(4));
//                i.setMoTa(rs.getString("MoTa"));
//                
//                listHDNhap.add(i);
//            }
//            rs.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(NCCRepository.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return listHDNhap;

        String sql = "SELECT N.IDHoaDonNhapSanPham , N.NGAYTAODON , U.HoTen, C.TenNhaCungCap ,C.SODIENTHOAI, N.MoTa\n"
                + "FROM dbo.HoaDonNhapSanPham N \n"
                + "JOIN dbo.Users U ON U.IdUsers = N.IDUsers\n"
                + "JOIN dbo.NhaCungCap C ON C.IdNhaCungCap = N.IDNhaCungCap \n"
                + "ORDER BY N.IDHoaDonNhapSanPham DESC";
        try {
            st = db.getConnection().createStatement();
            rs = st.executeQuery(sql);
            listHDNhap = new ArrayList<>();
            while (rs.next()) {
                HDNhapSPViewModel i = new HDNhapSPViewModel();
                i.setIDHoaDonNhapSanPham(rs.getInt("IDHoaDonNhapSanPham"));
                i.setNGAYTAODON(rs.getString("NGAYTAODON"));
                i.setTenUser(rs.getString("HoTen"));
                i.setSdtNCC(rs.getString("SODIENTHOAI"));
                i.setTenNCC(rs.getString("TenNhaCungCap"));
                i.setMoTa(rs.getString("MoTa"));

                listHDNhap.add(i);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(NCCRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listHDNhap;
    }

    public Float TongTien(Integer idHDN) {
        String sql = "SELECT  IDHoaDonNhapSanPham, SUM(SoLuong * priceImport) as \"totalCash\" FROM dbo.ChiTietHoaDonNhapSanPham \n"
                + "GROUP BY IDHoaDonNhapSanPham \n"
                + "HAVING IDHoaDonNhapSanPham = ?";
        try {
            pst = db.getConnection().prepareStatement(sql, idHDN);
            rs = pst.executeQuery();
            while (rs.next()) {
                return rs.getFloat("totalCash");
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
