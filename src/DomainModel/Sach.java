
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

import java.io.Serializable;


/**
 *
 * @author ADMIN
 */

public class Sach {
    

    private int IdSach;  
    private int IdNhaCungCap;
    private String MaSach;
    private String TenSach;
    private boolean TrangThai;  
    private TheLoai theloai;
 
    public Sach() {
    }

    public Sach(int IdSach, int IdNhaCungCap, String MaSach, String TenSach, boolean TrangThai, TheLoai theloai) {
        this.IdSach = IdSach;
        this.IdNhaCungCap = IdNhaCungCap;
        this.MaSach = MaSach;
        this.TenSach = TenSach;
        this.TrangThai = TrangThai;
        this.theloai = theloai;
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
        return  TenSach ;
    }
    
    
    
}
