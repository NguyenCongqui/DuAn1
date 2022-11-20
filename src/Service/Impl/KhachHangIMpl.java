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
public class KhachHangIMpl implements KhachHangService{
    KhachHangRepository rep = new KhachHangRepository();

    public KhachHangIMpl() {
    }
    
    
    @Override
    public List<KhachHang> getlistKhachHang() {
        return rep.getListKhachHang();
    }
    
}
