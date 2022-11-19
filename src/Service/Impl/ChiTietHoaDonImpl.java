/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import DomainModel.ChiTietHoaDonBan;
import Repository.ChiTietHoaDonRepository;
import Services.ChiTietHoaDonService;

/**
 *
 * @author ADMIN
 */
public class ChiTietHoaDonImpl implements ChiTietHoaDonService{
    ChiTietHoaDonRepository rep = new ChiTietHoaDonRepository();
    
    @Override
    public String insert(ChiTietHoaDonBan cthd) {
        return rep.insert(cthd);
    }
    
}
