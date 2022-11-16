/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import DomainModel.ChiTietSach;
import Repository.ChiTietSachRepository;
import Services.ChiTietSachService;
import ViewModel.MatHang01;
import ViewModel.MatHangViewModel;
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
    public List<MatHang01> getlist() {
        return rep.getListchitietsp();
    }

    @Override
    public String insert(MatHangViewModel cts) {
       return rep.insert(cts);
    }

    @Override
    public List<MatHang01> getlistConHang() {
        return rep.getListConHang();
    }

    @Override
    public List<MatHang01> getlistHetHang() {
        return rep.getListHetHang();
    }

    @Override
    public List<MatHang01> getlistThapToiCao() {
        return rep.getListThapToiCao();
    }

    @Override
    public List<MatHang01> getlistCaoToiThap() {
        return rep.getListTuCaoToiThap();
    }

    @Override
    public List<MatHang01> getlistDangKinhDoanh() {
       return rep.getListDangKinhDoanh();
    }

    @Override
    public List<MatHang01> getlistNgungKinhDoanh() {
       return rep.getListNgungKinhDoanh();
    }

    

   
}