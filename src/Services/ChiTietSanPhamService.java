/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModel.ChiTietSach;
import ViewModel.MatHang01;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface ChiTietSachService {
    List<MatHang01> getlist ();
    String insert(ChiTietSach cts);
}
