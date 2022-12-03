/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

/**
 *
 * @author ADMIN
 */
public class CTDoiSPViewModel {
  
    private int idCTDoiHD, idCTHDDoi;
    private int idCTSach;
    private int soLuong;
    private float gia;

    private String tenSach;
    private String tenNXB;
    private String tenTacGia;
    private String tenNgonNgu;

    public CTDoiSPViewModel() {
    }

    public CTDoiSPViewModel(int idCTDoiHD, int idCTHDDoi, int idCTSach, int soLuong, float gia, String tenSach, String tenNXB, String tenTacGia, String tenNgonNgu) {
        this.idCTDoiHD = idCTDoiHD;
        this.idCTHDDoi = idCTHDDoi;
        this.idCTSach = idCTSach;
        this.soLuong = soLuong;
        this.gia = gia;
        this.tenSach = tenSach;
        this.tenNXB = tenNXB;
        this.tenTacGia = tenTacGia;
        this.tenNgonNgu = tenNgonNgu;
    }

    public int getIdCTDoiHD() {
        return idCTDoiHD;
    }

    public void setIdCTDoiHD(int idCTDoiHD) {
        this.idCTDoiHD = idCTDoiHD;
    }

    public int getIdCTHDDoi() {
        return idCTHDDoi;
    }

    public void setIdCTHDDoi(int idCTHDDoi) {
        this.idCTHDDoi = idCTHDDoi;
    }

    public int getIdCTSach() {
        return idCTSach;
    }

    public void setIdCTSach(int idCTSach) {
        this.idCTSach = idCTSach;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTenNXB() {
        return tenNXB;
    }

    public void setTenNXB(String tenNXB) {
        this.tenNXB = tenNXB;
    }

    public String getTenTacGia() {
        return tenTacGia;
    }

    public void setTenTacGia(String tenTacGia) {
        this.tenTacGia = tenTacGia;
    }

    public String getTenNgonNgu() {
        return tenNgonNgu;
    }

    public void setTenNgonNgu(String tenNgonNgu) {
        this.tenNgonNgu = tenNgonNgu;
    }
    
    
}
