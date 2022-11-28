/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import DomainModel.Users;
import Repository.ThongTinCaNhanRepository;
import Services.ThongTinCaNhanService;

/**
 *
 * @author ADMIN
 */
public class ThongTinCaNhanImpl implements ThongTinCaNhanService{
    ThongTinCaNhanRepository rep = new ThongTinCaNhanRepository();
    @Override
    public Users getlistUsers(Integer id) {
        return rep.getListusers(id);
    }
    
}
