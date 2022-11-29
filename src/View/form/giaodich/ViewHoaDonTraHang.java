/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View.form.giaodich;


import Service.Impl.HoaDonTraHangImpl;
import Services.HoaDonTraHangService;
import ViewModel.HDTraHangViewModel;
import java.lang.reflect.Array;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class ViewHoaDonTraHang extends javax.swing.JPanel {
private DefaultTableModel tblModel = new DefaultTableModel();
private HoaDonTraHangService svTraHang = new HoaDonTraHangImpl();
private List<HDTraHangViewModel> listTra = new ArrayList<>();
    /**
     * Creates new form TraHang
     */
    public ViewHoaDonTraHang() {
        initComponents();
        setOpaque(false);
        fillData();
    }
    public void fillData() {
        tblModel = (DefaultTableModel) tbl_HoaDonTraHang.getModel();
        tblModel.setRowCount(0);
        listTra = svTraHang.getAllTra();
        for (HDTraHangViewModel i : listTra) {
            Float tongTien = svTraHang.TongTien(Float.valueOf(i.getMaHoaDonBan()));
            tblModel.addRow(new Object[]{
                i.getMaHoaDonTra(),
                i.getMaHoaDonBan(),
                i.getThoiGian(),
                i.getKhachHang(),
                i.getSdt(),
                1000 + "đ",
                i.getGhiChu(),
            });
        }
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
        btn_xuat = new View.form.MyButton();
        combobox1 = new View.form.Combobox();
        btn_reset = new View.form.MyButton();
        btn_loc = new View.form.MyButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_HoaDonTraHang = new View.form.TableColumn();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Hóa Đơn Trả Hàng");

        txt_tim.setLabelText("Tìm theo mã hoặc tên");

        btn_tim.setText("Tìm");
        btn_tim.setRadius(20);

        btn_xuat.setText("Xuất");
        btn_xuat.setRadius(20);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(76, 76, 76)
                .addComponent(txt_tim, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(104, 104, 104)
                .addComponent(btn_tim, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(156, 156, 156)
                .addComponent(btn_xuat, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_tim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_tim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_xuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        combobox1.setLabeText("Thời Gian ");

        btn_reset.setText("Reset");
        btn_reset.setRadius(20);

        btn_loc.setText("Lọc");
        btn_loc.setRadius(20);

        tbl_HoaDonTraHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Ma Tra Hang", "Ma Hoa Don", "Thoi Gian", "Khach Hang", "SDT", "Tong Tien Hoan Tra", "Ghi Chu"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_HoaDonTraHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_HoaDonTraHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_HoaDonTraHang);
        if (tbl_HoaDonTraHang.getColumnModel().getColumnCount() > 0) {
            tbl_HoaDonTraHang.getColumnModel().getColumn(0).setResizable(false);
            tbl_HoaDonTraHang.getColumnModel().getColumn(1).setResizable(false);
            tbl_HoaDonTraHang.getColumnModel().getColumn(2).setResizable(false);
            tbl_HoaDonTraHang.getColumnModel().getColumn(3).setResizable(false);
            tbl_HoaDonTraHang.getColumnModel().getColumn(4).setResizable(false);
            tbl_HoaDonTraHang.getColumnModel().getColumn(5).setResizable(false);
            tbl_HoaDonTraHang.getColumnModel().getColumn(6).setResizable(false);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_loc, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(btn_reset, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(combobox1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 932, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(combobox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_loc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_reset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 23, Short.MAX_VALUE))
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

    private void tbl_HoaDonTraHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_HoaDonTraHangMouseClicked
          
            int row = tbl_HoaDonTraHang.getSelectedRow();
            int id = (int) tbl_HoaDonTraHang.getValueAt(row, 0);
            String totalMoney = (String) tbl_HoaDonTraHang.getValueAt(row, 5);
            new ViewHoaDonTraChiTiet(id, totalMoney, (DefaultTableModel) tbl_HoaDonTraHang.getModel(), tbl_HoaDonTraHang.getSelectedRow()).setVisible(true);
        
    }//GEN-LAST:event_tbl_HoaDonTraHangMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private View.form.MyButton btn_loc;
    private View.form.MyButton btn_reset;
    private View.form.MyButton btn_tim;
    private View.form.MyButton btn_xuat;
    private View.form.Combobox combobox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private View.form.TableColumn tbl_HoaDonTraHang;
    private View.form.TextField txt_tim;
    // End of variables declaration//GEN-END:variables
}
