/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModel.Sach;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface SachService {
    List<Sach> getlist();
    String inert(Sach s);
}
