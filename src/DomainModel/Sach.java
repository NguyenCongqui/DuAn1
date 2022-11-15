
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

import Utilities.DBConnection;
import ViewModel.SachViewModel;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class Sach {

    private int IdSach;
    private int IdNhaCungCap, idTheLoai;
    private String MaSach;
    private String TenSach;
    private boolean TrangThai;

    public List<Sach> getAll() {
        String query = "select * from sach";
        List<Sach> listSach = new ArrayList<>();
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Sach s = new Sach(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(3), rs.getString(4), rs.getBoolean(5));
                listSach.add(s);
            }
            return listSach;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public Sach() {
    }

    public Sach(int IdSach, int IdNhaCungCap, int idTheLoai, String MaSach, String TenSach, boolean TrangThai) {
        this.IdSach = IdSach;
        this.IdNhaCungCap = IdNhaCungCap;
        this.idTheLoai = idTheLoai;
        this.MaSach = MaSach;
        this.TenSach = TenSach;
        this.TrangThai = TrangThai;
    }
    
    public Sach(int IdSach, int IdNhaCungCap, int idTheLoai, String MaSach, String TenSach, boolean TrangThai, TheLoai theloai) {
        this.IdSach = IdSach;
        this.IdNhaCungCap = IdNhaCungCap;
        this.idTheLoai = idTheLoai;
        this.MaSach = MaSach;
        this.TenSach = TenSach;
        this.TrangThai = TrangThai;
    }

    public int getIdTheLoai() {
        return idTheLoai;
    }

    public void setIdTheLoai(int idTheLoai) {
        this.idTheLoai = idTheLoai;
    }

    public int getIdSach() {
        return IdSach;
    }

    public void setIdSach(int IdSach) {
        this.IdSach = IdSach;
    }

    public int getIdNhaCungCap() {
        return IdNhaCungCap;
    }

    public void setIdNhaCungCap(int IdNhaCungCap) {
        this.IdNhaCungCap = IdNhaCungCap;
    }

    public String getMaSach() {
        return MaSach;
    }

    public void setMaSach(String MaSach) {
        this.MaSach = MaSach;
    }

    public String getTenSach() {
        return TenSach;
    }

    public void setTenSach(String TenSach) {
        this.TenSach = TenSach;
    }

    public boolean isTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(boolean TrangThai) {
        this.TrangThai = TrangThai;
    }

    @Override
    public String toString() {
        return TenSach;
    }

}
