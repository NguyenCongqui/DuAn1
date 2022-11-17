/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModel.Sach;
import Utilities.DBConnection;
import ViewModel.SachViewModel;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author quanh
 */
public class SachRepository {

    public List<Sach> getAllSach() {
        String query = "select * from sach";
        List<Sach> listSach = new ArrayList<>();
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Sach s = new Sach(rs.getInt(1), rs.getString(4), rs.getString(5), rs.getInt(2), rs.getInt(3), rs.getBoolean(6));
                listSach.add(s);
            }
            return listSach;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<SachViewModel> getAll() {
        String query = "SELECT dbo.Sach.IdSach, dbo.Sach.MaSach, dbo.Sach.TenSach, dbo.TheLoai.TenTheLoai, dbo.NhaCungCap.TenNhaCungCap, dbo.Sach.TrangThai\n"
                + "FROM     dbo.NhaCungCap INNER JOIN\n"
                + "                  dbo.Sach ON dbo.NhaCungCap.IdNhaCungCap = dbo.Sach.IdNhaCungCap INNER JOIN\n"
                + "                  dbo.TheLoai ON dbo.Sach.Idtheloai = dbo.TheLoai.IdTheLoai";
        List<SachViewModel> listSp = new ArrayList<>();
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SachViewModel spViewModel = new SachViewModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getBoolean(6));
                listSp.add(spViewModel);
            }
            return listSp;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean update(Sach s, String id) {
        String query = "UPDATE [dbo].[Sach]\n"
                + "   SET \n"
                + "       [MaSach] = ?\n"
                + "      ,[TenSach] = ?\n"
                + "	 ,[Idtheloai] = ?\n"
                + "      ,[IdNhaCungCap] =?\n"
                + "      ,[TrangThai] = ?\n"
                + " WHERE IdSach = ?";
        int check = 0;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, s.getMaSach());
            ps.setObject(2, s.getTenSach());
            ps.setObject(3, s.getIdTheLoai());
            ps.setObject(4, s.getIdNhaCungCap());
            ps.setObject(5, s.isTrangThai());
            ps.setObject(6, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean them(Sach s) {
        String query = "INSERT INTO [dbo].[Sach]\n"
                + "           (\n"
                + "		   [MaSach]\n"
                + "		   ,[TenSach]\n"
                + "           ,[Idtheloai]\n"
                + "		   ,[IdNhaCungCap]\n"
                + "           ,[TrangThai])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?)";
        int check = 0;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {

            ps.setObject(1, s.getMaSach());
            ps.setObject(2, s.getTenSach());
            ps.setObject(3, s.getIdTheLoai());
            ps.setObject(4, s.getIdNhaCungCap());
            ps.setObject(5, s.isTrangThai());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean xoa(String id) {
        int check = 0;
        String sql = "DELETE FROM [dbo].[Sach]\n"
                + "      WHERE IdSach = ?";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
    public Sach selectName(String name) {
        String query = "SELECT IdSach,TenSach FROM dbo.Sach WHERE IdSach = ?";
        List<Sach> listSach = new ArrayList<>();
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Sach s = new Sach(rs.getInt(1), rs.getString(2));
                listSach.add(s);
            }
            return (Sach) listSach;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

}
