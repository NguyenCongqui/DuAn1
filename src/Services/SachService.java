/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModel.Sach;
import ViewModel.SachViewModel;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface SachService {
    List<SachViewModel> getlist();
    String inert(Sach s);
}
