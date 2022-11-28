/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModel.Users;
import Utilities.DBConnection;

import Utilities.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class ThongTinCaNhanRepository {
 DBConnection db;
    ResultSet rs = null;
    Statement st = null;
    PreparedStatement pst = null;
    List<Users> ListNgonNgu = null;
    Users users = null;
    
    public ThongTinCaNhanRepository() {
    }
    public Users getListusers(Integer id) {
        String select01 = "SELECT * FROM dbo.Users WHERE IdUsers = ?";
        
        try {
           pst = db.getConnection().prepareStatement(select01);
           pst.setInt(1, id);
           rs = pst.executeQuery();
          //LisTaiKhoan = new ArrayList<>();
            while (rs.next()) {                
                users =new Users(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getBoolean(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getFloat(8), rs.getBoolean(9), rs.getBoolean(10));
            }
           rs.close();
        } catch (Exception e) {
        }
        
        return users;
    }
  
}
