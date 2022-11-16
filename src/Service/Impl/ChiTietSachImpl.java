/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import DomainModel.ChiTietSach;
import Repository.ChiTietSachRepository;
import Services.ChiTietSachService;
import ViewModel.MatHang01;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class ChiTietSachImpl implements ChiTietSachService{
    ChiTietSachRepository rep = new ChiTietSachRepository();
    
    public ChiTietSachImpl() {
    }

    @Override
    public String insert(ChiTietSach cts) {
        return rep.insert(cts);
    }

    @Override
    public List<MatHang01> getlist() {
        return rep.getListchitietsp();
    }

   
}
