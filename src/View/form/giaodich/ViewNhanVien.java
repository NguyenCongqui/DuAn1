/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View.form.giaodich;

import DomainModel.Users;
import Service.Impl.NhanVienImpl;
import Service.Impl.UsersImpl;
import Services.NhanVienService;
import Services.UsersService;
import View.login.Auth;
import View.login.XDate;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class ViewNhanVien extends javax.swing.JPanel {

    private DefaultTableModel tblModel;
    private List<Users> us = new ArrayList<>();
    private UsersService usersService = new UsersImpl();
    ViewThemNhanVienFrame nhanvien = new ViewThemNhanVienFrame();
    NhanVienService nhanvienservice = new NhanVienImpl();
    ViewThemNhanVienFrame thenhanvien01 = new ViewThemNhanVienFrame();
    ViewThemNhanVienFrame thenhanvienUpdate;

    public ViewNhanVien() {
        initComponents();
        tblModel = (DefaultTableModel) tbl_nhanvien.getModel();
        us = nhanvienservice.ListgetNhanVien();
        showData();
//        if (webcam == null) {
//            return;
//        }
//        webcam.close();
        
    }
    Locale lc = new Locale("vn", "VN");
    NumberFormat nf = NumberFormat.getInstance(lc);
    

    public void showData() {
        tblModel.setRowCount(0);
        for (Users us : us) {
            Object[] row = new Object[]{us.getIdusers(),
                us.getCCCD(),
                us.getHoten(),
                us.isRole() == true ? "Quản Lý" : "Nhân Viên",
                us.isGioitinh() == true ? "Nam" : "Nu",
                us.getNgaysinh(), 
                us.getDiaChi(),
                us.getSoDienThoai(),
                us.getEmail(),
                us.getLuong()};
            tblModel.addRow(row);
        }
    }
    
    public void showDataKhongLam() {
        tblModel.setRowCount(0);
        List<Users>  list = nhanvienservice.ListgetNhanVienKhongLam();
       for (Users us : list) {
            Object[] row = new Object[]{us.getIdusers(),
                us.getCCCD(),
                us.getHoten(),
                us.isRole() == true ? "Quản Lý" : "Nhân Viên",
                us.isGioitinh() == true ? "Nam" : "Nu",
                us.getNgaysinh(), 
                us.getDiaChi(),
                us.getSoDienThoai(),
                us.getEmail(),
                nf.format(us.getLuong()) + " đ"};
            tblModel.addRow(row);
        }
    }
  
    public void delete() {
        int index = tbl_nhanvien.getSelectedRow();
        int idUser = (int) tbl_nhanvien.getValueAt(index, 0);
        if (idUser == Auth.user.getIdusers()) {
            JOptionPane.showMessageDialog(this,"Bạn không thể xoá được bạn ???");
            return;
        } 
           JOptionPane.showMessageDialog(this, nhanvienservice.XoaNhanVien(idUser));
           us = nhanvienservice.ListgetNhanVien();
            showData();
           
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_tim = new View.form.TextField();
        btn_tim = new View.form.MyButton();
        cbo_tinhtrang = new View.form.Combobox();
        btn_themnhanvien = new View.form.MyButton();
        btn_xoanhanvien = new View.form.MyButton();
        btn_xuat = new View.form.MyButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_nhanvien = new View.form.TableColumn();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Nhân Viên");

        txt_tim.setLabelText("Tìm theo tên hoặc mã");
        txt_tim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_timActionPerformed(evt);
            }
        });

        btn_tim.setText("Tìm");
        btn_tim.setRadius(20);

        cbo_tinhtrang.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Đang Làm Việc", "Nghỉ Làm" }));
        cbo_tinhtrang.setLabeText("Tình Trạng ");
        cbo_tinhtrang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_tinhtrangActionPerformed(evt);
            }
        });

        btn_themnhanvien.setText("Thêm Nhân Viên");
        btn_themnhanvien.setRadius(20);
        btn_themnhanvien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themnhanvienActionPerformed(evt);
            }
        });

        btn_xoanhanvien.setText("Xóa Nhân Viên");
        btn_xoanhanvien.setRadius(20);
        btn_xoanhanvien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoanhanvienActionPerformed(evt);
            }
        });

        btn_xuat.setText("Xuất");
        btn_xuat.setRadius(20);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(txt_tim, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btn_tim, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(cbo_tinhtrang, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addComponent(btn_themnhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(btn_xoanhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btn_xuat, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_tim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_tim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbo_tinhtrang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_themnhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_xoanhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_xuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        tbl_nhanvien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Căn Cước Công Dân", "Họ Tên", "Chức Vụ", "giới Tính", "Ngày Sinh", "Địa Chỉ", "Số Điện Thoại", "email", "lương"
            }
        ));
        tbl_nhanvien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_nhanvienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_nhanvien);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1166, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_themnhanvienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themnhanvienActionPerformed
        // TODO add your handling code here:
        nhanvien.setVisible(true);

    }//GEN-LAST:event_btn_themnhanvienActionPerformed

    private void txt_timActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_timActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_timActionPerformed

    private void btn_xoanhanvienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoanhanvienActionPerformed
        // TODO add your handling code here:\
        delete();
    }//GEN-LAST:event_btn_xoanhanvienActionPerformed

    private void tbl_nhanvienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_nhanvienMouseClicked
        // TODO add your handling code here:
        // if (evt.getClickCount() == 2) {
            int index = tbl_nhanvien.getSelectedRow();
            int idUser = (int) tbl_nhanvien.getValueAt(index, 0);
            String CCCD = tbl_nhanvien.getValueAt(index, 1).toString();
            String Hoten = tbl_nhanvien.getValueAt(index, 2).toString();
            String ChucVu = tbl_nhanvien.getValueAt(index, 3).toString();
            String GioiTinh = tbl_nhanvien.getValueAt(index, 4).toString();
            String NgaySinh = tbl_nhanvien.getValueAt(index, 5).toString();
            String DiaChi = tbl_nhanvien.getValueAt(index, 6).toString();
            String SoDienThoai = tbl_nhanvien.getValueAt(index, 7).toString();
            String email = tbl_nhanvien.getValueAt(index, 8).toString();
            String Luong = tbl_nhanvien.getValueAt(index, 9).toString();
            thenhanvienUpdate = new ViewThemNhanVienFrame(CCCD,Hoten,ChucVu,GioiTinh,NgaySinh,DiaChi,SoDienThoai,email,Luong,idUser,cbo_tinhtrang.getSelectedIndex());
            thenhanvienUpdate.setVisible(true);
        //}

        if (thenhanvienUpdate == null) {
            return;
        } else {
            thenhanvienUpdate.addEvenUpdate(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    thenhanvienUpdate.update();
//                    MsgBox.alert(this, "Update thành công");
                    cbo_tinhtrang.setSelectedIndex(0);
                    showData();
                }
            }
                    
                
            );

        }
    }//GEN-LAST:event_tbl_nhanvienMouseClicked

    private void cbo_tinhtrangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_tinhtrangActionPerformed
        // TODO add your handling code here:
        if (cbo_tinhtrang.getSelectedIndex() == 0) {
            showData();
        } else {
            showDataKhongLam();
        }
    }//GEN-LAST:event_cbo_tinhtrangActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private View.form.MyButton btn_themnhanvien;
    private View.form.MyButton btn_tim;
    private View.form.MyButton btn_xoanhanvien;
    private View.form.MyButton btn_xuat;
    private View.form.Combobox cbo_tinhtrang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private View.form.TableColumn tbl_nhanvien;
    private View.form.TextField txt_tim;
    // End of variables declaration//GEN-END:variables
}
