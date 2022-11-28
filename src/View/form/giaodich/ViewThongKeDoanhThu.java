/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View.form.giaodich;

import Repository.DoanhThuRepository;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ACER
 */
public class ViewThongKeDoanhThu extends javax.swing.JPanel {

    DefaultTableModel tbl_model = new DefaultTableModel();
    DoanhThuRepository rep = new DoanhThuRepository();
    public ViewThongKeDoanhThu() {
        initComponents();
        fillYear();
         rdo_bieudoduong.setSelected(true);
        for (int i = 0; i < tbl_thongkedoanhthu.getRowCount(); i++) {
            tbl_thongkedoanhthu.setValueAt(nf.format(tbl_thongkedoanhthu.getValueAt(i, 2)) + " đ", i, 2);
            tbl_thongkedoanhthu.setValueAt(nf.format(tbl_thongkedoanhthu.getValueAt(i, 3)) + " đ", i, 3);
            tbl_thongkedoanhthu.setValueAt(nf.format(tbl_thongkedoanhthu.getValueAt(i, 4)) + " đ", i, 4);
            tbl_thongkedoanhthu.setValueAt(nf.format(tbl_thongkedoanhthu.getValueAt(i, 5)) + " đ", i, 5);
        }
        
    }
       Locale lc = new Locale("nv", "VN");
    NumberFormat nf = NumberFormat.getInstance(lc);
    public void fillYear() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbo_nam.getModel();
        model.removeAllElements();
        List<Integer> list = rep.selectYears();
        for (Integer i : list) {
            model.addElement(i);
        }
    }
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
      public void fillTable() throws Exception {
        DefaultTableModel model = (DefaultTableModel) tbl_thongkedoanhthu.getModel();
        model.setRowCount(0);
        int year = (int) cbo_nam.getSelectedItem();
        List<Object[]> list = rep.getSalesStatisticalRevenue(year);
        for (Object[] o : list) {
            model.addRow(o);
        }
        for (int i = 0; i < tbl_thongkedoanhthu.getRowCount(); i++) {
            int moneyImport = rep.getSelectImport((int) tbl_thongkedoanhthu.getValueAt(i, 0), (int) cbo_nam.getSelectedItem());
            int moneyReturn = (int) tbl_thongkedoanhthu.getValueAt(i, 3);
            tbl_thongkedoanhthu.setValueAt(moneyReturn, i, 3);
            tbl_thongkedoanhthu.setValueAt(moneyImport, i, 4);
            tbl_thongkedoanhthu.setValueAt((int) tbl_thongkedoanhthu.getValueAt(i, 2) - (moneyImport + moneyReturn), i, 5);
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
        jLabel1 = new javax.swing.JLabel();
        btn_xuat = new View.form.MyButton();
        jPanel2 = new javax.swing.JPanel();
        rdo_bieudoduong = new javax.swing.JRadioButton();
        rbt_bieudocot = new javax.swing.JRadioButton();
        btn_bieudo = new View.form.MyButton();
        cbo_nam = new View.form.Combobox();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_thongkedoanhthu = new View.form.TableColumn();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Thống Kê Doanh Thu ");

        btn_xuat.setText("Xuất");
        btn_xuat.setRadius(20);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(405, 405, 405)
                .addComponent(btn_xuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(btn_xuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        rdo_bieudoduong.setText("Biểu Đồ Đường");
        rdo_bieudoduong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdo_bieudoduongActionPerformed(evt);
            }
        });

        rbt_bieudocot.setText("Biểu Đồ Cột");

        btn_bieudo.setText("Biểu đồ");
        btn_bieudo.setRadius(20);

        cbo_nam.setLabeText("Năm");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbt_bieudocot)
                            .addComponent(rdo_bieudoduong)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(btn_bieudo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cbo_nam, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(cbo_nam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rdo_bieudoduong)
                .addGap(26, 26, 26)
                .addComponent(rbt_bieudocot)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 202, Short.MAX_VALUE)
                .addComponent(btn_bieudo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83))
        );

        tbl_thongkedoanhthu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tháng ", "Sản Phẩm Bán ", "Tổng giá bán", "Tổng Giá Chi", "Tổng Nhập Hàng", "Lợi Nhuận "
            }
        ));
        jScrollPane1.setViewportView(tbl_thongkedoanhthu);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 936, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(33, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void rdo_bieudoduongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdo_bieudoduongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdo_bieudoduongActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private View.form.MyButton btn_bieudo;
    private View.form.MyButton btn_xuat;
    private View.form.Combobox cbo_nam;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbt_bieudocot;
    private javax.swing.JRadioButton rdo_bieudoduong;
    private View.form.TableColumn tbl_thongkedoanhthu;
    // End of variables declaration//GEN-END:variables
}
