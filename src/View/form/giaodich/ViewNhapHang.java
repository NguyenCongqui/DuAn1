/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View.form.giaodich;

import DomainModel.NCC;
import DomainModel.Users;
import Service.Impl.ChiTietSachImpl;
import Service.Impl.NCCServiceImpl;
import Service.Impl.NhapHangImpl;
import Services.ChiTietSachService;
import Services.NCCService;
import Services.NhapHangService;
import View.login.Auth;
import ViewModel.CTHDNhapSpViewModel;
import ViewModel.HDNhapSPViewModel;
import ViewModel.NhapHangViewModel;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class ViewNhapHang extends javax.swing.JPanel {
    //  Locale lc = new Locale("nv", "VN");
    // NumberFormat formatter = NumberFormat.getIntegerInstance(lc);

    DefaultTableModel tableModel;
    DefaultComboBoxModel dcbm;
    List<NCC> list1;
    NCCService service1;
    List<CTHDNhapSpViewModel> list = new ArrayList<>();
    NhapHangService NHservice;
    List<NhapHangViewModel> list2;
    Users user = new Users();

    //list lưu những hóa đơn chi tiết
    /**
     * Creates new form NhapHang
     */
    public ViewNhapHang() {
        initComponents();
        dcbm = (DefaultComboBoxModel) cbo_NCC.getModel();
        service1 = new NCCServiceImpl();
        list1 = service1.getAll();
        for (NCC ncc : list1) {
            dcbm.addElement(ncc);
        }
        btn_LuuTam.setEnabled(false);
        btn_XoaTam.setEnabled(false);
        NHservice = new NhapHangImpl();
        fillTable();
    }

    public void fillTable() {
        DefaultTableModel model = (DefaultTableModel) tbl1.getModel();
        model.setRowCount(0);
        list2 = NHservice.getAll();//CTS
        for (NhapHangViewModel p : list2) {
            model.addRow(new Object[]{
                p.getIdchitietsach(),
                p.getMaSach(),
                p.getTenSach(),
                p.getTenTheLoai(),
                p.getTenNxb(),
                p.getTenNgonNgu(),
                p.getTenTacGia(),
                p.getSoluong(),
                p.getGia() + " đ"
            });
        }
    }

    private boolean validatFrom() {
        if (txt_SLgNhap.getText().isEmpty() || txt_Gia.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không duoc de trong");
            return false;
        } else {
            try {
                Integer.parseInt(txt_SLgNhap.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "So luong nhap ko phai so");
                return false;
            }
        }
        {
            try {
                Integer.parseInt(txt_SLgNhap.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Gia tien ko phai so");
                return false;
            }
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_Search = new View.form.TextField();
        lbl_Search = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl1 = new View.form.TableColumn();
        jPanel3 = new javax.swing.JPanel();
        txt_SLgNhap = new View.form.TextField();
        txt_Gia = new View.form.TextField();
        btn_LuuTam = new View.form.MyButton();
        btn_XoaTam = new View.form.MyButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl2 = new View.form.TableColumn();
        cbo_NCC = new View.form.Combobox();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txt_GhiChu = new javax.swing.JTextArea();
        btn_NhapHang = new View.form.MyButton();
        lblSlgNhap = new javax.swing.JLabel();
        lblGiaNhap = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText(" Nhập Hàng");

        txt_Search.setLabelText("Tìm theo tên san pham");
        txt_Search.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_SearchCaretUpdate(evt);
            }
        });
        txt_Search.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_SearchFocusGained(evt);
            }
        });
        txt_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_SearchActionPerformed(evt);
            }
        });

        lbl_Search.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(189, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addComponent(txt_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_Search, javax.swing.GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin sách", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 10))); // NOI18N

        tbl1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id SP", "Ma SP", "Ten SP", "The Loai", "NXB", "Ngon Ngu", "Tac Gia", "Slg trong kho", "Gia Ban"
            }
        ));
        tbl1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nhập Hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 10))); // NOI18N

        txt_SLgNhap.setLabelText("Số Lượng Nhập");
        txt_SLgNhap.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_SLgNhapFocusGained(evt);
            }
        });
        txt_SLgNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_SLgNhapActionPerformed(evt);
            }
        });

        txt_Gia.setLabelText("Giá Nhập");
        txt_Gia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_GiaFocusGained(evt);
            }
        });
        txt_Gia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_GiaKeyReleased(evt);
            }
        });

        btn_LuuTam.setText("Luu Tam");
        btn_LuuTam.setRadius(20);
        btn_LuuTam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LuuTamActionPerformed(evt);
            }
        });

        btn_XoaTam.setText("Xoa Tam");
        btn_XoaTam.setRadius(20);
        btn_XoaTam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XoaTamActionPerformed(evt);
            }
        });

        tbl2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id SP", "Ma SP", "Ten SP", "The Loai", "NXB", "Ngon Ngu", "Tac Gia", "Slg Nhap", "Gia Nhap"
            }
        ));
        tbl2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl2);

        cbo_NCC.setLabeText("Nhà Cung Cấp");

        jLabel2.setText("Ghi Chú");

        txt_GhiChu.setColumns(20);
        txt_GhiChu.setRows(5);
        jScrollPane3.setViewportView(txt_GhiChu);

        btn_NhapHang.setText("Nhap Hang");
        btn_NhapHang.setRadius(20);
        btn_NhapHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_NhapHangActionPerformed(evt);
            }
        });

        lblSlgNhap.setForeground(new java.awt.Color(255, 0, 0));
        lblSlgNhap.setText(" ");
        lblSlgNhap.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        lblGiaNhap.setForeground(new java.awt.Color(255, 0, 0));
        lblGiaNhap.setText(" ");
        lblGiaNhap.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 861, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblSlgNhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_SLgNhap, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_Gia, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                            .addComponent(lblGiaNhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(btn_LuuTam, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btn_XoaTam, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(cbo_NCC, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(btn_NhapHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(cbo_NCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(btn_NhapHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_SLgNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_Gia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_LuuTam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_XoaTam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblGiaNhap))
                            .addComponent(lblSlgNhap, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1191, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1203, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 713, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_SLgNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_SLgNhapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_SLgNhapActionPerformed

    private void btn_LuuTamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LuuTamActionPerformed
        // TODO add your handling code here:
        if (validatFrom()) {
            int row = tbl1.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Bạn chưa chọn mặt hàng nào");
            } else {//lay dlieu tu bang 1
                int id = Integer.parseInt(tbl1.getValueAt(row, 0).toString());
                 String maSp = (String) tbl1.getValueAt(row, 1);
                String tenSP = (String) tbl1.getValueAt(row, 2);
                String theLoai = (String) tbl1.getValueAt(row, 3);
                String NXB = (String) tbl1.getValueAt(row, 4);
                String ngonNgu = (String) tbl1.getValueAt(row, 5);
                String tacGia = (String) tbl1.getValueAt(row, 6);
                int sLg = Integer.parseInt(txt_SLgNhap.getText());
                Float giaNhap = Float.parseFloat(txt_Gia.getText());

                //do dlieu vao bang 2
                DefaultTableModel tableModel1 = (DefaultTableModel) tbl2.getModel();
                tableModel1.addRow(new Object[]{id,maSp, tenSP, theLoai, NXB, ngonNgu, tacGia, sLg, giaNhap});
                CTHDNhapSpViewModel nhvm = new CTHDNhapSpViewModel();
                nhvm.setPrice(giaNhap);
                nhvm.setIDChiTietSach(id);
                nhvm.setSoLuong(sLg);
                //add vào list
                list.add(nhvm);
                //clear form
                tbl1.clearSelection();//Bỏ chọn tất cả các cột và hàng trước đó đã được chọn.
                txt_Gia.setText("");
                txt_SLgNhap.setText("");
            }
        }
    }//GEN-LAST:event_btn_LuuTamActionPerformed

    private void btn_XoaTamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XoaTamActionPerformed
        // TODO add your handling code here:

        int row = tbl2.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) tbl2.getModel();
        int id = (int) tbl2.getValueAt(row, 0);
        model.removeRow(row);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getIDChiTietSach() == id) {
                list.remove(list.get(i));
                JOptionPane.showMessageDialog(this, "Xóa thành công !");
                btn_XoaTam.setEnabled(false);
                return;
            }
        }
    }//GEN-LAST:event_btn_XoaTamActionPerformed

    private void tbl1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl1MouseClicked
        // TODO add your handling code here:
        btn_LuuTam.setEnabled(true);
    }//GEN-LAST:event_tbl1MouseClicked

    private void tbl2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl2MouseClicked
        // TODO add your handling code here:
        btn_XoaTam.setEnabled(true);
    }//GEN-LAST:event_tbl2MouseClicked

    private void txt_SLgNhapFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_SLgNhapFocusGained
        // TODO add your handling code here:
        lblSlgNhap.setVisible(false);
    }//GEN-LAST:event_txt_SLgNhapFocusGained

    private void txt_GiaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_GiaFocusGained
        // TODO add your handling code here:
        lblGiaNhap.setVisible(false);
    }//GEN-LAST:event_txt_GiaFocusGained
    public HDNhapSPViewModel themDl() {
        // SimpleDateFormat sdf = new SimpleDateFormat();
        HDNhapSPViewModel hdnspvm = new HDNhapSPViewModel();
        // Calendar calendar = Calendar.getInstance();
        //  hdnspvm.setNGAYTAODON(sdf.format( calendar.getTime()));
        hdnspvm.setTINHTRANGTRATIEN(false);
        hdnspvm.setIDUsers(Auth.user.getIdusers());
        hdnspvm.setMoTa(txt_GhiChu.getText());
        NCC ncc = (NCC) cbo_NCC.getSelectedItem();
        hdnspvm.setIDNhaCungCap(ncc.getIdNCC());
        return hdnspvm;

    }
       private boolean validatFrom1() {
        if (txt_GhiChu.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không de trong ghi chu !");
            return false;
        } 
        return true;
       }
    private void btn_NhapHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_NhapHangActionPerformed
        // TODO add your handling code here:
        int count = tbl2.getRowCount();
        if (count <= 0) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhap sản phẩm nào");
        } else {
            if(validatFrom1()){
            HDNhapSPViewModel hdnspvm = themDl();
            NHservice.insertHDN(hdnspvm);
            //  JOptionPane.showMessageDialog(this,  NHservice.insertHDN(hdnspvm));
            // lặp list để insert từng hóa đơn chi tiết vào db
            for (int i = 0; i < list.size(); i++) {
                CTHDNhapSpViewModel de = list.get(i);
                // them dlieu vao hdctiet
                System.out.println(de.getSoLuong());
                System.out.println(de.getPrice());
                NHservice.insertHDCT(de);
                //   JOptionPane.showMessageDialog(this,  NHservice.insertHDCT(de) );

                // hàm cập nhập số lượng tồn kho trong bảng sản phẩm chi tiết
                NHservice.updateCTSP(de.getSoLuong(), de.getPrice(), de.getIDChiTietSach());
                //   JOptionPane.showMessageDialog(this,  NHservice.updateCTSP(de.getSoLuong(),de.getPrice(), de.getIDChiTietSach()) );
                //NHservice.updateCTSP(de.getSoLuong(),de.getPrice(), de.getDetailsInvoice());
            }
            
            JOptionPane.showMessageDialog(this, "Thêm " + list.size() + " mặt hàng vào hóa đơn thành công");
            
            DefaultTableModel model = (DefaultTableModel) tbl2.getModel();
            model.setRowCount(0);
            list.clear();
            fillTable();
            }
        }
        btn_XoaTam.setEnabled(false);

    }//GEN-LAST:event_btn_NhapHangActionPerformed
    public void TimTheoTen() {
        String temp = txt_Search.getText();
        list2 = NHservice.searchTenSach(temp);
        tableModel = (DefaultTableModel) tbl1.getModel();
        tableModel.setRowCount(0);
        if (list2.isEmpty()) {
            lbl_Search.setText("Không tìm thay san pham : " + temp);
          return;
        }
        for (NhapHangViewModel p : list2) {
            tableModel.addRow(new Object[]{
                p.getIdchitietsach(),
                p.getMaSach(),
                p.getTenSach(),
                p.getTenTheLoai(),
                p.getTenNxb(),
                p.getTenNgonNgu(),
                p.getTenTacGia(),
                p.getSoluong(),
                p.getGia() + " đ"
            });
        }
    }
// public void TimTheoID() {
//        int id = Integer.valueOf(txt_Search.getText());
//        NhapHangViewModel p = NHservice.searchID(id);
//        tableModel = (DefaultTableModel) tbl1.getModel();
//        tableModel.setRowCount(0);
//        if (p == null) {
//            lbl_Search.setText("Không tìm thay id : " + id);
//           return;
//        }
//            tableModel.addRow(new Object[]{
//                p.getIdchitietsach(),
//                p.getTenSach(),
//                p.getTenTheLoai(),
//                p.getTenNxb(),
//                p.getTenNgonNgu(),
//                p.getTenTacGia(),
//                p.getSoluong(),
//                p.getGia() + " đ"
//            });
//       
//    }
    private void txt_SearchCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_SearchCaretUpdate
        // TODO add your handling code here:
//         try {
//           TimTheoTen();   
//        } catch (Exception e) {
            TimTheoTen();
        //}

    }//GEN-LAST:event_txt_SearchCaretUpdate
public String deleteLastKey(String str) {
        if (str.charAt(str.length() - 1) == 'đ') {
            str = str.replace(str.substring(str.length() - 1), "");
            return str;
        } else {
            return str;
        }
    }
    
    public String fomartFloat(String txt) {
        String pattern = deleteLastKey(txt);
        return pattern = pattern.replaceAll(",", "");
    }
    private void txt_GiaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_GiaKeyReleased
        // TODO add your handling code here:
           if (txt_Gia.getText().trim().isEmpty()) {
            lblGiaNhap.setText("");
            return;
        }
        if (Float.parseFloat(txt_Gia.getText()) > Float.parseFloat(fomartFloat(tbl1.getValueAt(tbl1.getSelectedRow(), 8).toString()))) {
            lblGiaNhap.setVisible(true);
            lblGiaNhap.setText("Giá nhập nhỏ hơn giá bán");
            System.out.println(Float.parseFloat(fomartFloat(tbl1.getValueAt(tbl1.getSelectedRow(), 8).toString())));
        } else {
            
            lblGiaNhap.setText("");
        }
    }//GEN-LAST:event_txt_GiaKeyReleased

    private void txt_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_SearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_SearchActionPerformed

    private void txt_SearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_SearchFocusGained
        // TODO add your handling code here:
         
    }//GEN-LAST:event_txt_SearchFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private View.form.MyButton btn_LuuTam;
    private View.form.MyButton btn_NhapHang;
    private View.form.MyButton btn_XoaTam;
    private View.form.Combobox cbo_NCC;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblGiaNhap;
    private javax.swing.JLabel lblSlgNhap;
    private javax.swing.JLabel lbl_Search;
    private View.form.TableColumn tbl1;
    private View.form.TableColumn tbl2;
    private javax.swing.JTextArea txt_GhiChu;
    private View.form.TextField txt_Gia;
    private View.form.TextField txt_SLgNhap;
    private View.form.TextField txt_Search;
    // End of variables declaration//GEN-END:variables
}
