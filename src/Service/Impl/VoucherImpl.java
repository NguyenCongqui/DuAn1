/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import DomainModel.Voucher;
import Repository.VoucherRepository;
import Services.VoucherService;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class VoucherImpl implements VoucherService{
    VoucherRepository rep = new VoucherRepository();
    @Override
    public List<Voucher> getListVouchers() {
        return rep.getLisVoucher();
    }

    @Override
    public String updateSoLuongTon(Integer idVoucher) {
        return rep.updateSoLuongTon(idVoucher);
    }
    
}