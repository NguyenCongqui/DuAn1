/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModel.TaiKhoan;
import DomainModel.Users;
import Utilities.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class NhanVienRepository {
DBConnection db;
    ResultSet rs = null;
    Statement st = null;
    PreparedStatement pst = null;
    List<Users> ListUsers = null;
    Users users = null;
    public NhanVienRepository() {
    }
    
        
    public boolean them(Users us) {
        String query = "INSERT INTO dbo.Users\n" +
"            (\n" +
"                HoTen,\n" +
"                NgaySinh,\n" +
"                GioiTinh,\n" +
"                DiaChi,\n" +
"                Sdt,\n" +
"                Email,\n" +
"                Luong,\n" +
"                Role,\n" +
"                TrangThai,\n" +
"                CCCD\n" +
"            )\n" +
"            VALUES(?,?,?,?,?,?,?,?,?,?)";
        int check = 0;
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {

            ps.setObject(1, us.getHoten());
            ps.setObject(2, us.getNgaysinh());
            ps.setObject(3, us.isGioitinh());
            ps.setObject(4, us.getDiaChi());
            ps.setObject(5, us.getSoDienThoai());
            ps.setObject(6, us.getEmail());
            ps.setObject(7, us.getLuong());
            ps.setObject(8, us.isRole());
            ps.setObject(9, us.isTrangThai());
            ps.setObject(10, us.getCCCD());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
    
    public List<Users> getListnhanvien() {
        String select = "SELECT * FROM dbo.Users WHERE TrangThai =1 ORDER BY IdUsers DESC";
        ListUsers = new ArrayList<>();
        try {
            st = db.getConnection().createStatement();
            rs = st.executeQuery(select);
            while (rs.next()) {
                ListUsers.add(new Users(rs.getInt(1),rs.getString(2),rs.getDate(3), rs.getBoolean(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getFloat(8), rs.getBoolean(9), rs.getBoolean(10),rs.getString(11)));
            }
            rs.close();
        } catch (Exception e) {
        }
        return ListUsers;
    }
     public List<Users> getListnhanvienKhonglam() {
        String select = "SELECT * FROM dbo.Users WHERE TrangThai =0 ORDER BY IdUsers DESC";
        ListUsers = new ArrayList<>();
        try {
            st = db.getConnection().createStatement();
            rs = st.executeQuery(select);
            while (rs.next()) {
                ListUsers.add(new Users(rs.getInt(1),rs.getString(2),rs.getDate(3), rs.getBoolean(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getFloat(8), rs.getBoolean(9), rs.getBoolean(10),rs.getString(1)));
            }
            rs.close();
        } catch (Exception e) {
        }
        return ListUsers;
    }
    public String insertTaiKhoan (TaiKhoan tk){
        String insert = "INSERT INTO dbo.TaiKhoan\n" +
"(\n" +
"    IdUsers,\n" +
"    UserName,\n" +
"    MatKhau\n" +
")\n" +
"VALUES\n" +
"(  (SELECT TOP 1 IdUsers FROM dbo.Users ORDER BY IdUsers DESC),?,?) ";
      
        try {
            pst = db.getConnection().prepareStatement(insert);
            pst.setString(1, tk.getName());
            pst.setString(2, tk.getMatKhau());
            pst.executeUpdate();
            return "them thanh cong";
        } catch (Exception e) {
            
        }
        return "Them khong thanh cong";
    }
    public String Delete (int t) {
        String update = "UPDATE dbo.Users SET TrangThai = 0 WHERE IdUsers =?";
        try {
            pst = db.getConnection().prepareStatement(update);

            pst.setInt(1, t);
           
            pst.executeUpdate();
            return "Xoa thanh cong";
        } catch (Exception e) {

        }
        return "Xoa khong thanh cong";
    }
    	  
public String updataNhanVien (Users us) {
        String update = "UPDATE dbo.Users SET HoTen = ?,NgaySinh = ?,GioiTinh = ?,DiaChi = ?,Sdt = ?,Email = ?, Luong = ?,Role = ?,TrangThai =? ,CCCD = ? WHERE IdUsers = ?";
        try {
            pst = db.getConnection().prepareStatement(update);

            pst.setObject(1, us.getHoten());
            pst.setObject(2, us.getNgaysinh());
            pst.setObject(3, us.isGioitinh());
            pst.setObject(4, us.getDiaChi());
            pst.setObject(5, us.getSoDienThoai());
            pst.setObject(6, us.getEmail());
            pst.setObject(7, us.getLuong());
            pst.setObject(8, us.isRole());
            pst.setObject(9, us.isTrangThai());
            pst.setObject(10, us.getCCCD());
            pst.setInt(11, us.getIdusers());
           
            pst.executeUpdate();
            return "Sua Nhan Vien thanh cong";
        } catch (Exception e) {

        }
        return "Sua khong thanh cong";
    }
}
