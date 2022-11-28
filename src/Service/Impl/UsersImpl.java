/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import DomainModel.Users;
import Repository.UserRepositoty;
import Services.UsersService;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class UsersImpl implements UsersService{
    UserRepositoty rep = new UserRepositoty();

    public UsersImpl() {
    }

    @Override
    public Users getUsers(int k) {
        return rep.getLisUsers(k);
    }

   

   

    

    
}
