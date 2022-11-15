/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;



/**
 *
 * @author ADMIN
 */

public class TaiKhoan {
    
    private int id;
    
    
    private String name;
    
    
    private String matKhau;
    
   

    public TaiKhoan() {
    }

    public TaiKhoan(int id, String name, String matKhau, TaiKhoan taiKhoan) {
        this.id = id;
        this.name = name;
        this.matKhau = matKhau;
       // this.taiKhoan = taiKhoan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    
    
}
