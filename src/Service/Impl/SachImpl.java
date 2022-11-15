/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import DomainModel.Sach;
import Repository.SachRepository;
import Services.SachService;
import Services.SachService;
import ViewModel.SachViewModel;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class SachImpl implements SachService {

    private SachRepository rp = new SachRepository();

    @Override
    public List<SachViewModel> getAll() {
        return rp.getAll();
    }

    @Override
    public String inert(Sach s) {
        boolean them = rp.them(s);
        if(them){
            return "them sach thanh cong";
        }
        return "them sach that bai";
    }

    @Override
    public List<Sach> getAllSach() {
        return rp.getAllSach();
    }

}
