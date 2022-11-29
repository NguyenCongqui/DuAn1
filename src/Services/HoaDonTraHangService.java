/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import ViewModel.CTHDTraHangViewModel;
import ViewModel.HDBanViewModel;
import ViewModel.HDTraHangViewModel;
import ViewModel.TraHangViewModel;
import java.util.List;

/**
 *
 * @author quanh
 */
public interface HoaDonTraHangService {
    List<TraHangViewModel> getAll();
    List<HDTraHangViewModel> getAllTra();
    List<TraHangViewModel> searchID(int id);
    String insert(HDTraHangViewModel hdthvm);
    Float TongTien(Float idHDT);
    List<CTHDTraHangViewModel> getAllTRaCT();
    List<CTHDTraHangViewModel> SearchTKID(int id);
}
