/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModel.ChiTietSach;
import DomainModel.NhaXuatBan;
import Utilities.DBConnection;
import ViewModel.MatHang01;
import ViewModel.MatHangViewModel;
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
public class ChiTietSachRepository {

    DBConnection db;
    ResultSet rs = null;
    Statement st = null;
    PreparedStatement pst = null;
    List<ChiTietSach> ListChiTietSach = null;
    List<MatHang01> ListMatHang = null;
    List<NhapHangViewModel> listNHV = null;
    List<MatHangViewModel> listMatHangViewModel = null;
 
    public ChiTietSachRepository() {
    }

    public List<MatHangViewModel> getListchitietsp() {
        String select = "  SELECT IdCTSach, MaSach,TenSach,GiaBan,TenNgonNGu,TenTacGia,TenNXB,SoLuongTon \n"
                + "  FROM dbo.ChiTietSach INNER JOIN dbo.Sach ON Sach.IdSach = ChiTietSach.IdSach \n"
                + "  INNER JOIN dbo.NgonNgu ON NgonNgu.IdNgonNgu = ChiTietSach.IdNgonNgu 	\n"
                + "  INNER JOIN dbo.TacGia ON TacGia.IdTacGia = ChiTietSach.IdTacGia \n"
                + "  INNER JOIN dbo.NXB ON NXB.IdNXB = ChiTietSach.IdNXB";
        listMatHangViewModel = new ArrayList<>();
        try {
            st = db.getConnection().createStatement();
            rs = st.executeQuery(select);
            while (rs.next()) {
                listMatHangViewModel.add(new MatHangViewModel(rs.getInt(1), rs.getInt(8), rs.getFloat(4), rs.getString(2), rs.getString(3), rs.getString(5), rs.getString(6), rs.getString(7)));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietSachRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listMatHangViewModel;
    }

    public String insert(MatHangViewModel cts) {
        String insert = "INSERT INTO dbo.ChiTietSach\n"
                + "				(\n"
                + "				    IdSach,\n"
                + "				    IdNgonNgu,\n"
                + "				    IdTacGia,\n"
                + "				    IdNXB,\n"
                + "				    SoLuongTon,\n"
                + "				    GiaBan,\n"
                + "				    CreatedAt,\n"             
                + "				)\n"
                + "				VALUES(?,?,?,?,?,?,GETDATE())";
        try {
            pst = db.getConnection().prepareStatement(insert);
            pst.setInt(1, cts.getIdsach());
            pst.setInt(2, cts.getIdNgonNgu());
            pst.setInt(3, cts.getIdTacGia());
            pst.setInt(4, cts.getIsNXB());
            pst.setInt(5, cts.getSoluongton());
            pst.setFloat(6, cts.getGiaban());
            pst.executeUpdate();
            return "them thanh cong";
        } catch (Exception e) {

        }
        return "Them khong thanh cong";
    }

    public String update(MatHangViewModel cts) {
        String update = "UPDATE dbo.ChiTietSach SET IdSach = ?,IdNgonNgu = ?,IdTacGia = ?,IdNXB = ?,GiaBan = ? WHERE IdCTSach = ?";
        try {
            pst = db.getConnection().prepareStatement(update);

            pst.setInt(1, cts.getIdsach());
            pst.setInt(2, cts.getIdNgonNgu());
            pst.setInt(3, cts.getIdTacGia());
            pst.setInt(4, cts.getIsNXB());
            pst.setFloat(5, cts.getGiaban());
            pst.setInt(6, cts.getIdchitietsach());
            pst.executeUpdate();
            return "sua thanh cong";
        } catch (Exception e) {

        }
        return "sua khong thanh cong";
    }

    public List<MatHang01> getListConHang() {
        String select = "SELECT MaSach,TenSach,GiaBan,TenNgonNGu,TenTacGia,TenNXB,SoLuongTon FROM dbo.ChiTietSach INNER JOIN dbo.Sach ON Sach.IdSach = ChiTietSach.IdSach INNER JOIN dbo.NgonNgu ON NgonNgu.IdNgonNgu = ChiTietSach.IdNgonNgu \n"
                + "	INNER JOIN dbo.TacGia ON TacGia.IdTacGia = ChiTietSach.IdTacGia\n"
                + "	INNER JOIN dbo.NXB ON NXB.IdNXB = ChiTietSach.IdNXB\n"
                + "	WHERE SoLuongTon >0";
        ListMatHang = new ArrayList<>();
        try {
            st = db.getConnection().createStatement();
            rs = st.executeQuery(select);
            while (rs.next()) {
                ListMatHang.add(new MatHang01(rs.getString(1), rs.getString(2), rs.getFloat(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7)));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietSachRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ListMatHang;
    }

    public List<MatHang01> getListHetHang() {
        String select = "SELECT MaSach,TenSach,GiaBan,TenNgonNGu,TenTacGia,TenNXB,SoLuongTon FROM dbo.ChiTietSach INNER JOIN dbo.Sach ON Sach.IdSach = ChiTietSach.IdSach INNER JOIN dbo.NgonNgu ON NgonNgu.IdNgonNgu = ChiTietSach.IdNgonNgu \n"
                + "	INNER JOIN dbo.TacGia ON TacGia.IdTacGia = ChiTietSach.IdTacGia\n"
                + "	INNER JOIN dbo.NXB ON NXB.IdNXB = ChiTietSach.IdNXB\n"
                + "	WHERE SoLuongTon <=0";
        ListMatHang = new ArrayList<>();
        try {
            st = db.getConnection().createStatement();
            rs = st.executeQuery(select);
            while (rs.next()) {
                ListMatHang.add(new MatHang01(rs.getString(1), rs.getString(2), rs.getFloat(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7)));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietSachRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ListMatHang;
    }

    public List<MatHang01> getListDangKinhDoanh() {
        String select = "SELECT MaSach,TenSach,GiaBan,TenNgonNGu,TenTacGia,TenNXB,SoLuongTon FROM dbo.ChiTietSach INNER JOIN dbo.Sach ON Sach.IdSach = ChiTietSach.IdSach INNER JOIN dbo.NgonNgu ON NgonNgu.IdNgonNgu = ChiTietSach.IdNgonNgu \n"
                + "	INNER JOIN dbo.TacGia ON TacGia.IdTacGia = ChiTietSach.IdTacGia\n"
                + "	INNER JOIN dbo.NXB ON NXB.IdNXB = ChiTietSach.IdNXB\n"
                + "	WHERE TrangThai = 1";
        ListMatHang = new ArrayList<>();
        try {
            st = db.getConnection().createStatement();
            rs = st.executeQuery(select);
            while (rs.next()) {
                ListMatHang.add(new MatHang01(rs.getString(1), rs.getString(2), rs.getFloat(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7)));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietSachRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ListMatHang;
    }

    public List<MatHang01> getListNgungKinhDoanh() {
        String select = "SELECT MaSach,TenSach,GiaBan,TenNgonNGu,TenTacGia,TenNXB,SoLuongTon FROM dbo.ChiTietSach INNER JOIN dbo.Sach ON Sach.IdSach = ChiTietSach.IdSach INNER JOIN dbo.NgonNgu ON NgonNgu.IdNgonNgu = ChiTietSach.IdNgonNgu \n"
                + "	INNER JOIN dbo.TacGia ON TacGia.IdTacGia = ChiTietSach.IdTacGia\n"
                + "	INNER JOIN dbo.NXB ON NXB.IdNXB = ChiTietSach.IdNXB\n"
                + "	WHERE TrangThai = 0";
        ListMatHang = new ArrayList<>();
        try {
            st = db.getConnection().createStatement();
            rs = st.executeQuery(select);
            while (rs.next()) {
                ListMatHang.add(new MatHang01(rs.getString(1), rs.getString(2), rs.getFloat(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7)));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietSachRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ListMatHang;
    }

    public List<MatHang01> getListThapToiCao() {
        String select = "SELECT MaSach,TenSach,GiaBan,TenNgonNGu,TenTacGia,TenNXB,SoLuongTon FROM dbo.ChiTietSach INNER JOIN dbo.Sach ON Sach.IdSach = ChiTietSach.IdSach INNER JOIN dbo.NgonNgu ON NgonNgu.IdNgonNgu = ChiTietSach.IdNgonNgu \n"
                + "	INNER JOIN dbo.TacGia ON TacGia.IdTacGia = ChiTietSach.IdTacGia\n"
                + "	INNER JOIN dbo.NXB ON NXB.IdNXB = ChiTietSach.IdNXB\n"
                + "	ORDER BY GiaBan ASC";
        ListMatHang = new ArrayList<>();
        try {
            st = db.getConnection().createStatement();
            rs = st.executeQuery(select);
            while (rs.next()) {
                ListMatHang.add(new MatHang01(rs.getString(1), rs.getString(2), rs.getFloat(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7)));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietSachRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ListMatHang;
    }

    public List<MatHang01> getListTuCaoToiThap() {
        String select = "SELECT MaSach,TenSach,GiaBan,TenNgonNGu,TenTacGia,TenNXB,SoLuongTon FROM dbo.ChiTietSach INNER JOIN dbo.Sach ON Sach.IdSach = ChiTietSach.IdSach INNER JOIN dbo.NgonNgu ON NgonNgu.IdNgonNgu = ChiTietSach.IdNgonNgu \n"
                + "	INNER JOIN dbo.TacGia ON TacGia.IdTacGia = ChiTietSach.IdTacGia\n"
                + "	INNER JOIN dbo.NXB ON NXB.IdNXB = ChiTietSach.IdNXB\n"
                + "	ORDER BY GiaBan DESC";
        ListMatHang = new ArrayList<>();
        try {
            st = db.getConnection().createStatement();
            rs = st.executeQuery(select);
            while (rs.next()) {
                ListMatHang.add(new MatHang01(rs.getString(1), rs.getString(2), rs.getFloat(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7)));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietSachRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ListMatHang;
    }

    public List<NhapHangViewModel> getAll() {

        String sql = "   SELECT c.IdCTSach,s.TenSach,l.TenTheLoai,x.TenNXB,n.TenNgonNGu,T.TenTacGia,C.SoLuongTon,C.GiaBan \n" +
"  FROM dbo.ChiTietSach C\n" +
"  INNER JOIN dbo.NgonNgu N ON N.IdNgonNgu = C.IdNgonNgu\n" +
"  INNER JOIN dbo.NXB X ON X.IdNXB = C.IdNXB\n" +
"  INNER JOIN dbo.TacGia T ON T.IdTacGia = C.IdTacGia\n" +
"  INNER JOIN dbo.Sach S ON S.IdSach = C.IdSach\n" +
"  INNER JOIN dbo.TheLoai L ON L.IdTheLoai = S.Idtheloai\n" +
"  ORDER BY C.IdCTSach DESC";
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
}
