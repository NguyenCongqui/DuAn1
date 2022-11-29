/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import ViewModel.TraHangViewModel;
import java.util.List;

/**
 *
 * @author quanh
 */
public interface HoaDonTraHangService {
    List<TraHangViewModel> getAll();
    List<TraHangViewModel> searchID(int id);
}
