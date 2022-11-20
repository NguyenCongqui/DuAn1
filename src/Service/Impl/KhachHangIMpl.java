/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import DomainModel.KhachHang;
import Repository.KhachHangRepository;
import Services.KhachHangService;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class KhachHangIMpl implements KhachHangService {

    KhachHangRepository rep = new KhachHangRepository();

    public KhachHangIMpl() {
    }

    @Override
    public List<KhachHang> getlistKhachHang() {
        return rep.getListKhachHang();
    }

    @Override
    public String them(KhachHang kh) {
        boolean t = rep.them(kh);
        if (t) {
            return "them thanh cong";
        }
        return "them that bai";
    }
}
