/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

/**
 *
 * @author quanh
 */
public class TraHangViewModel {
    private int idTraHang;
    private int idBanHang;
    private String tenKh;
    private String tenSach;
    private int soLuong;
    private String SDT;
    private float donGia;

    public TraHangViewModel() {
    }

    public TraHangViewModel(int idTraHang, int idBanHang, String tenKh, String tenSach, int soLuong, String SDT, float donGia) {
        this.idTraHang = idTraHang;
        this.idBanHang = idBanHang;
        this.tenKh = tenKh;
        this.tenSach = tenSach;
        this.soLuong = soLuong;
        this.SDT = SDT;
        this.donGia = donGia;
    }

    public int getIdTraHang() {
        return idTraHang;
    }

    public void setIdTraHang(int idTraHang) {
        this.idTraHang = idTraHang;
    }

    public int getIdBanHang() {
        return idBanHang;
    }

    public void setIdBanHang(int idBanHang) {
        this.idBanHang = idBanHang;
    }

    public String getTenKh() {
        return tenKh;
    }

    public void setTenKh(String tenKh) {
        this.tenKh = tenKh;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }
    
    
}
