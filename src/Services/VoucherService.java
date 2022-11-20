/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModel.Voucher;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface VoucherService {
    List<Voucher> getListVouchers();
    String updateSoLuongTon(Integer idVoucher);
}
