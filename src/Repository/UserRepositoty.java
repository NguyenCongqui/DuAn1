/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModel.Users;
import Utilities.DBConnection;
import Utilities.jdbcHelper;
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
public class UserRepositoty {

    DBConnection db;
    ResultSet rs = null;
    Statement st = null;
    PreparedStatement pst = null;
    List<Users> ListUsers = null;
    Users users = null;

    public UserRepositoty() {

    }

    public List<Users> getListnhanvien() {
        String select = "SELECT [IdUsers]\n"
                + "      ,[HoTen]\n"
                + "      ,[NgaySinh]\n"
                + "      ,[GioiTinh]\n"
                + "      ,[DiaChi]\n"
                + "      ,[Sdt]\n"
                + "      ,[Email]\n"
                + "      ,[Luong]\n"
                + "      ,[Role]\n"
                + "      ,[TrangThai]\n"
                + "  FROM [dbo].[Users] order by IdUsers desc";
        ListUsers = new ArrayList<>();
        try {
            st = db.getConnection().createStatement();
            rs = st.executeQuery(select);
            while (rs.next()) {
                ListUsers.add(new Users(rs.getInt(1),rs.getString(2),rs.getDate(3), rs.getBoolean(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getFloat(8), rs.getBoolean(9), rs.getBoolean(10)));
            }
            rs.close();
        } catch (Exception e) {
        }
        return ListUsers;
    }

    public Users getLisUsers(int iduser) {
        String select = "SELECT * FROM dbo.Users WHERE IdUsers = '" + iduser + "'";

        try {

            st = db.getConnection().createStatement();
            rs = st.executeQuery(select);
            // ListUsers= new ArrayList<>();
            while (rs.next()) {
                users = new Users(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getBoolean(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getFloat(8), rs.getBoolean(9), rs.getBoolean(10));
            }
            rs.close();
        } catch (Exception e) {
        }

        return users;
    }

    public boolean them(Users us) {
        String query = "INSERT INTO [dbo].[Users]\n"
                + "           ([HoTen]\n"
                + "           ,[NgaySinh]\n"
                + "           ,[GioiTinh]\n"
                + "           ,[DiaChi]\n"
                + "           ,[Sdt]\n"
                + "           ,[Email]\n"
                + "           ,[Luong]\n"
                + "           ,[Role]\n"
                + "           ,[TrangThai])\n"
                + "     VALUES\n"
                + "           (?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

}
