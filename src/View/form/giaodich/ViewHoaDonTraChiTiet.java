/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View.form.giaodich;

import Service.Impl.HoaDonTraHangImpl;
import Services.HoaDonTraHangService;
import ViewModel.CTHDNhapSpViewModel;
import ViewModel.CTHDTraHangViewModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author quanh
 */
public class ViewHoaDonTraChiTiet extends javax.swing.JPanel {
    
    DefaultTableModel model;
     int row;
     int id;
private DefaultTableModel tblMOdel = new DefaultTableModel();
private List<CTHDTraHangViewModel> list = new ArrayList<>();
private HoaDonTraHangService svTraHang = new HoaDonTraHangImpl();
 
    /**
     * Creates new form ViewHoaDonTraChiTiet
     */
    public ViewHoaDonTraChiTiet(int id,String totalMoney, DefaultTableModel model, int row) {
        initComponents();
        this.model = model;
        this.row = row;
        this.id = id;
        
        fillTable(id);
    }
    public void fillTable(int id) {
        DefaultTableModel model = (DefaultTableModel) tableColumn1.getModel();
        model.setRowCount(0);
        list = svTraHang.SearchTKID(id);
        for (CTHDTraHangViewModel d : list) {
            model.addRow(new Object[]{
                d.getIdHDChiTiet(),
                d.getTenSach(),
                d.getTenKhach(),
                d.getTenNN(),
                d.getTenNXB(),
                d.getTenTG(),
                d.getSoLuong(),
                d.getTongTien()+ " đ"
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

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableColumn1 = new View.form.TableColumn();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 51));
        jLabel1.setText("CHI TIET HOA DON TRA HANG");

        tableColumn1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID CTTH", "TenSach", "Ten Khach", "Ten NN", "Ten NXB", "Ten TG", "So Luong", "Tong Tien"
            }
        ));
        jScrollPane1.setViewportView(tableColumn1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private View.form.TableColumn tableColumn1;
    // End of variables declaration//GEN-END:variables
}