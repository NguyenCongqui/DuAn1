/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModel.TheLoai;
import Utilities.DBConnection;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import net.miginfocom.layout.AC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author quanh
 */
public class TheLoaiRepository {
    public List<TheLoai> getAll(){
        String query = "select * from TheLoai";
        List<TheLoai> lisTl= new ArrayList<>();
        try(Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query)){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                 TheLoai tl = new TheLoai(rs.getInt(1), rs.getString(2), rs.getBoolean(3));
                 lisTl.add(tl);
            }
            return lisTl; 
        }catch(Exception e){
            e.printStackTrace(System.out);
        }
        return null;
    }
    public boolean insert(TheLoai tl){
        String query ="INSERT INTO [dbo].[TheLoai]\n" +
"           ([TenTheLoai]\n" +
"           ,[TrangThai])\n" +
"     VALUES\n" +
"           (?,?)";
        int check = 0;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, tl.getTenTheLoai());
            ps.setObject(2, tl.isTrangThai());
            
            check = ps.executeUpdate();
            

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
    
}
