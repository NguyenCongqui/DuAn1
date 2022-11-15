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

    public List<SachViewModel> getAll() {
        String query = "select sach.IdSach,sach.TenSach,TheLoai.TenTheLoai,sach.TrangThai \n"
                + "from Sach join TheLoai on sach.Idtheloai = TheLoai.IdTheLoai";
        List<SachViewModel> listSp = new ArrayList<>();
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SachViewModel spViewModel = new SachViewModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4));
                listSp.add(spViewModel);
            }
            return listSp;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    public boolean sua(Sach s){
        String query = "INSERT INTO [dbo].[Sach]\n" +
"           (\n" +
"           [TenSach]\n" +
"           ,[TrangThai])\n" +
"     VALUES\n" +
"           (?,?)";
        int check = 0;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1,s.setTenSach(1));
            ps.setObject(check, s);
            
            }
            return listSp;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    
    }
