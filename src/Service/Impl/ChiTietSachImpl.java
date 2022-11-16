/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import DomainModel.ChiTietSach;
import Repository.ChiTietSachRepository;
import Services.ChiTietSanPhamService;

/**
 *
 * @author ADMIN
 */
public class ChiTietSachImpl implements ChiTietSanPhamService{
    ChiTietSachRepository rep = new ChiTietSachRepository();
    
    public ChiTietSachImpl() {
    }

    @Override
    public String insert(ChiTietSach cts) {
        return rep.insert(cts);
    }
    
}
