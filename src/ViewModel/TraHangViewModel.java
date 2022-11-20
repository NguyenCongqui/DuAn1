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
    private int maBanHang;
    private String maSach;
    private String tenKh;
    private String tenSach;
    private int soLuong;
    private String SDT;
    private float donGia;

    public TraHangViewModel() {
    }

    public TraHangViewModel(int maBanHang, String maSach, String tenKh, String tenSach, int soLuong, String SDT, float donGia) {
        this.maBanHang = maBanHang;
        this.maSach = maSach;
        this.tenKh = tenKh;
        this.tenSach = tenSach;
        this.soLuong = soLuong;
        this.SDT = SDT;
        this.donGia = donGia;
    }

    public int getMaBanHang() {
        return maBanHang;
    }

    public void setMaBanHang(int maBanHang) {
        this.maBanHang = maBanHang;
    }

    

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
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
