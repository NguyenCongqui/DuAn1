/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author ADMIN
 */

public class HDNhapSanPham  {

  
    private int IDHOADONNHAPSANPHAM;
    private int IDNHACUNGCAP;
    private int IDUsers;
    private Date NGAYTAODON;
    private int TINHTRANGTRATIEN;
    private String MOTA;

   
    public HDNhapSanPham() {
    }

    public HDNhapSanPham(int IDHOADONNHAPSANPHAM, int IDNHACUNGCAP, int IDUsers, Date NGAYTAODON, int TINHTRANGTRATIEN, String MOTA, NCC ncc) {
        this.IDHOADONNHAPSANPHAM = IDHOADONNHAPSANPHAM;
        this.IDNHACUNGCAP = IDNHACUNGCAP;
        this.IDUsers = IDUsers;
        this.NGAYTAODON = NGAYTAODON;
        this.TINHTRANGTRATIEN = TINHTRANGTRATIEN;
        this.MOTA = MOTA;
       // this.ncc = ncc;
    }

    public int getIDHOADONNHAPSANPHAM() {
        return IDHOADONNHAPSANPHAM;
    }

    public void setIDHOADONNHAPSANPHAM(int IDHOADONNHAPSANPHAM) {
        this.IDHOADONNHAPSANPHAM = IDHOADONNHAPSANPHAM;
    }

    public int getIDNHACUNGCAP() {
        return IDNHACUNGCAP;
    }

    public void setIDNHACUNGCAP(int IDNHACUNGCAP) {
        this.IDNHACUNGCAP = IDNHACUNGCAP;
    }

    public int getIDUsers() {
        return IDUsers;
    }

    public void setIDUsers(int IDUsers) {
        this.IDUsers = IDUsers;
    }

    public Date getNGAYTAODON() {
        return NGAYTAODON;
    }

    public void setNGAYTAODON(Date NGAYTAODON) {
        this.NGAYTAODON = NGAYTAODON;
    }

    public int getTINHTRANGTRATIEN() {
        return TINHTRANGTRATIEN;
    }

    public void setTINHTRANGTRATIEN(int TINHTRANGTRATIEN) {
        this.TINHTRANGTRATIEN = TINHTRANGTRATIEN;
    }

    public String getMOTA() {
        return MOTA;
    }

    public void setMOTA(String MOTA) {
        this.MOTA = MOTA;
    }

  

}
