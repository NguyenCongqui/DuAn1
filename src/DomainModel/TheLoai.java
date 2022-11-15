/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author ADMIN
 */

public class TheLoai implements Serializable{
  
   // @Column(name = "id")
    private int IdTheLoai;
    
   // @Column(name = "TenTheLoai",length = 200,nullable = false)
    private String TenTheLoai;
    
    //@Column(name = "trangThai")
    private boolean TrangThai;

    public TheLoai() {
    }

    

    public String getTenTheLoai() {
        return TenTheLoai;
    }

    public void setTenTheLoai(String TenTheLoai) {
        this.TenTheLoai = TenTheLoai;
    }

    public int getIdTheLoai() {
        return IdTheLoai;
    }

    public void setIdTheLoai(int IdTheLoai) {
        this.IdTheLoai = IdTheLoai;
    }

    public boolean isTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(boolean TrangThai) {
        this.TrangThai = TrangThai;
    }

   

    @Override
    public String toString() {
        return  TenTheLoai ;
    }
    
    
    
}
