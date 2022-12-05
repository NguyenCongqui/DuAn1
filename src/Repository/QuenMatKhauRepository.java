/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModel.NCC;
import Utilities.DBConnection;
import ViewModel.NhanVienViewModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class QuenMatKhauRepository {
    DBConnection dbConnection;
   Connection con = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    List<NhanVienViewModel> list = null;

    public List<NhanVienViewModel> getAll() {
        String sql = "SELECT TaiKhoan.IdUsers,IdTaiKhoan,CCCD\n" +
",HoTen,Sdt,DiaChi,Email,UserName,MatKhau,\n" +
"GioiTinh,Role,TrangThai,NgaySinh,Luong \n" +
"FROM dbo.TaiKhoan INNER JOIN dbo.Users \n" +
"ON Users.IdUsers = TaiKhoan.IdUsers ORDER BY \n" +
"TaiKhoan.IdUsers DESC";
        try {
           // pst = db.getConnection().prepareStatement(sql);
            con = dbConnection.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            list = new ArrayList<>();

            while (rs.next()) {
                list.add(new NhanVienViewModel(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getBoolean(10), rs.getBoolean(11), rs.getBoolean(12), rs.getDate(13),rs.getFloat(14)));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(NCCRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
