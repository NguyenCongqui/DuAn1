
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import DomainModel.TheLoai;
import Repository.TheLoaiRepository;
//import Repository.TheLoaiRepository;
import Services.TheLoaiServie;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class TheLoaiImpl implements TheLoaiServie{
private TheLoaiRepository rp = new TheLoaiRepository();
    @Override
    public List<TheLoai> getlistTheLoai() {
        return rp.getAll();
    }

    @Override
    public String inerts(TheLoai tl) {
        boolean themTl = rp.insert(tl);
        if(themTl){
            return "them thanh cong";
        }
        return "them that bai";
    }

    
}
