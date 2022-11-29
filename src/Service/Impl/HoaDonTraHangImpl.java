/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import Repository.HoaDonBanHangRepository;
import Repository.HoaDonTraHangRepository;
import Services.HoaDonTraHangService;
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

   

    

    
    
}
