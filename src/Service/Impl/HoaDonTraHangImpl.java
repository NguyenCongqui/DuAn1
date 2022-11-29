/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import Repository.HoaDonBanHangRepository;
import Repository.HoaDonTraHangRepository;
import Services.HoaDonTraHangService;
import ViewModel.HDBanViewModel;
import ViewModel.HDTraHangViewModel;
import ViewModel.TraHangViewModel;
import java.util.List;

/**
 *
 * @author quanh
 */
public class HoaDonTraHangImpl implements HoaDonTraHangService{
private HoaDonTraHangRepository rp = new HoaDonTraHangRepository();
    @Override
    public List<TraHangViewModel> getAll() {
        return rp.getAll();
    }

    @Override
    public List<TraHangViewModel> searchID(int id) {
        return rp.searchId(id);
    }

    @Override
    public String insert(HDTraHangViewModel hdthvm) {
        boolean in = rp.insert(hdthvm);
        if(in){
            return "them thanh cong";
    }
        return "them that bai";
   
}

    @Override
    public List<HDTraHangViewModel> getAllTra() {
        return rp.getAllTra();
    }

    @Override
    public Float TongTien(Float idHDT) {
        return rp.TongTien(idHDT);
    }
}
