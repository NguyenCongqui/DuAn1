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

    public List<NhapHangViewModel> search(String temp) {
        String sql = "    SELECT c.IdCTSach,s.TenSach,l.TenTheLoai,x.TenNXB,n.TenNgonNGu,T.TenTacGia,C.SoLuongTon,C.GiaBan \n"
                + "FROM dbo.ChiTietSach C\n"
                + "INNER JOIN dbo.NgonNgu N ON N.IdNgonNgu = C.IdNgonNgu\n"
                + "INNER JOIN dbo.NXB X ON X.IdNXB = C.IdNXB\n"
                + "INNER JOIN dbo.TacGia T ON T.IdTacGia = C.IdTacGia\n"
                + "INNER JOIN dbo.Sach S ON S.IdSach = C.IdSach\n"
                + "INNER JOIN dbo.TheLoai L ON L.IdTheLoai = S.Idtheloai where S.TenSach  LIKE '%" + temp + "%' ";
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
    
      public boolean insertHDN(HDNhapSPViewModel hdnspvm) {
           int check = 0;
         try {
            String sql = "INSERT INTO dbo.HoaDonNhapSanPham\n" +
" (\n" +
"     IDNhaCungCap,\n" +
"     TINHTRANGTRATIEN,\n" +
"     MoTa,\n" +
"	NGAYTAODON\n" +
" )\n" +
" VALUES\n" +
" (?,?,?,GETDATE())";
            pst = db.getConnection().prepareStatement(sql);
            pst.setInt(1, hdnspvm.getIDNhaCungCap());
           // pst.setInt(2, hdnspvm.getIDUsers());
            //pst.setString(3, hdnspvm.getNGAYTAODON());
            pst.setBoolean(2, hdnspvm.getTINHTRANGTRATIEN());
            pst.setString(3, hdnspvm.getMoTa());
           
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(NCCRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check > 0;
}
      
         public boolean insertHDCT(CTHDNhapSpViewModel cthdnsvm) {
           int check = 0;
         try {
            String sql = "INSERT INTO [dbo].[ChiTietHoaDonNhapSanPham]([IDHoaDonNhapSanPham],[IDChiTietSach],[SoLuong],[priceImport])VALUES\n" +
"((SELECT TOP 1 IDHoaDonNhapSanPham FROM dbo.HoaDonNhapSanPham ORDER BY IDHoaDonNhapSanPham DESC),?,?,\n" +
"( SELECT TOP 1 GiaNhap FROM dbo.ChiTietSach ORDER BY GiaNhap DESC))";
            pst = db.getConnection().prepareStatement(sql);
           // pst.setInt(1, cthdnsvm.getIDHoaDonNhapSanPham());
            pst.setInt(1, cthdnsvm.getIDChiTietSach());
            pst.setInt(2, cthdnsvm.getSoLuong());
            pst.setFloat(3, cthdnsvm.getPrice());
            
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(NCCRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check > 0;
}
       public String updateCTSP(Integer slg,Float giaNhap ,Integer id){
            NhapHangViewModel nhvm= new NhapHangViewModel();
             String update = "UPDATE dbo.ChiTietSach SET SoLuongTon = SoLuongTon + 3,GiaNhap = ? WHERE IdCTSach = ?";
             
            try {
            pst = db.getConnection().prepareStatement(update);
            pst.setInt(1, nhvm.getSoluong());
            pst.setFloat(2, nhvm.getGianhap());
            pst.setInt(3, nhvm.getIdchitietsach());
            
            pst.executeUpdate();
            return "sua thanh cong";
        } catch (SQLException e) {

        }
        return "sua khong thanh cong";  
       }
         
}
