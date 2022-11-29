/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View.form.giaodich;

import Service.Impl.HoaDonBanHangImpl;
import Service.Impl.HoaDonTraHangImpl;
import Services.HoaDonTraHangService;
import View.login.txtField;
import ViewModel.NhapHangViewModel;
import ViewModel.TraHangViewModel;
import com.fpt.entity.CTHDTra;
import com.fpt.utils.MsgBox;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ACER
 */
public class ViewTraHang extends javax.swing.JPanel {

    private DefaultTableModel tblModel = new DefaultTableModel();
    private DefaultTableModel tblModelList = new DefaultTableModel();
    private List<TraHangViewModel> listTraHang = new ArrayList<>();
    private List<TraHangViewModel> list = new ArrayList<>();
    
    private HoaDonTraHangService svTraHang = new HoaDonTraHangImpl();

    /**
     * Creates new form TraHang
     */
    public ViewTraHang() {
        initComponents();
//        tblModel = (DefaultTableModel) tbl_thongtinhoadon.getModel();
        svTraHang = (HoaDonTraHangService) new HoaDonTraHangImpl();
        listTraHang = svTraHang.getAll();
//        fillTable();
        showData();
    }

    public void showData() {
        DefaultTableModel model = (DefaultTableModel) tbl_thongtinhoadon.getModel();
        model.setRowCount(0);
        List<TraHangViewModel> list = svTraHang.getAll();
        for (TraHangViewModel p : list) {
            model.addRow(new Object[]{
                p.getIDMaHoaDon(),
                p.getIDSach(),
                p.getTenSach(),
                p.getSoLuong(),
                p.getTenNXB(),
                p.getTenNN(),
                p.getTenTG(),
                p.getDonGia() + " đ",
                p.getTenKh(),});
        }
    }

    public void TimTheoID() {
        if (txt_timkiemhoadon.getText().isEmpty()) {
            return ;
        }
    lbl_thongBao.setVisible(true);
       DefaultTableModel tableModel = (DefaultTableModel) tbl_thongtinhoadon.getModel();
        tableModel.setRowCount(0);
        int id = Integer.valueOf(txt_timkiemhoadon.getText());
        List<TraHangViewModel> p = svTraHang.searchID(id);
        if (p == null) {
            //lbl_Search.setVisible(true);
            lbl_thongBao.setText("Không có hoa don : " + id);
            return;
        }
        for (TraHangViewModel i : p) {
            tableModel.addRow(new Object[]{
            i.getIDMaHoaDon(),
            i.getIDSach(),
            i.getTenSach(),
            i.getSoLuong(),
            i.getTenNXB(),
            i.getTenNN(),
            i.getTenTG(),
            i.getDonGia(),
            i.getTenKh(),
        });
            txt_khachhang.setText(i.getTenKh());
            txt_mahoadon.setText(String.valueOf(i.getIDMaHoaDon()));
        }
        lbl_thongBao.setText("");
    }
    
    Locale lc = new Locale("nv", "VN");
    NumberFormat nf = NumberFormat.getInstance(lc);
    
    float priceTotal;
    public float TotalBuy() {
        float price = 0;
        int index = tbl_danhsachsanpham.getRowCount();
        for (int i = 0; i < index; i++) {
            price += (int) tbl_danhsachsanpham.getValueAt(i, 2) * (float) tbl_danhsachsanpham.getValueAt(i, 6);
        }
        return price;
    }
    public void insertTraHang() {
        try {
            boolean flag = false;
            int quatity = Integer.valueOf(MsgBox.prompt(this, "Nhập số lượng cần hoàn trả"));
            int row = tbl_thongtinhoadon.getSelectedRow();
            int idMaHD = (int) tbl_thongtinhoadon.getValueAt(row, 0);
            int idSach = (int) tbl_thongtinhoadon.getValueAt(row, 1);
            String tenSach = (String) tbl_thongtinhoadon.getValueAt(row, 2);
            int soLuong = (int) tbl_thongtinhoadon.getValueAt(row, 3);
            String tenNXB = (String) tbl_thongtinhoadon.getValueAt(row, 4);
            String tenNN = (String) tbl_thongtinhoadon.getValueAt(row, 5);
            String tenTG = (String) tbl_thongtinhoadon.getValueAt(row, 6);
            float donGia = (float) tbl_thongtinhoadon.getValueAt(row, 7);
            String tenKh = (String) tbl_thongtinhoadon.getValueAt(row, 8);

            if (quatity > (int) tbl_thongtinhoadon.getValueAt(row, 3) || quatity < 0) {
                MsgBox.warring(this, "Số lượng trả hàng không hợp lệ!!!");
            } else {
                tblModel = (DefaultTableModel) tbl_danhsachsanpham.getModel();
                tblModel.addRow(new Object[]{
                    idSach, tenSach, quatity, tenNXB, tenNN, tenTG, donGia
                });
                int i = ((int) tbl_thongtinhoadon.getValueAt(row, 3)) - quatity;
                tbl_thongtinhoadon.setValueAt(i, row, 3);
                txt_tienhoantra.setText(nf.format(TotalBuy()) + " đ");
                priceTotal = TotalBuy();
                TraHangViewModel dir = new TraHangViewModel();
                dir.setDonGia(donGia);
                dir.setIDSach(idSach);
                dir.setSoLuong(soLuong);
                list.add(dir);
                 tbl_thongtinhoadon.clearSelection();
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Chưa chọn số lượng hoàn trả ???");
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
        jLabel2 = new javax.swing.JLabel();
        txt_timkiemhoadon = new View.form.TextField();
        lbl_thongBao = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_thongtinhoadon = new View.form.TableColumn();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_danhsachsanpham = new View.form.TableColumn();
        jPanel4 = new javax.swing.JPanel();
        txt_khachhang = new View.form.TextField();
        txt_mahoadon = new View.form.TextField();
        txt_ghichu = new View.form.TextField();
        txt_tienhoantra = new View.form.TextField();
        btn_trahang = new View.form.MyButton();
        btn_xoa = new View.form.MyButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Trả Hàng");

        jLabel2.setText("Tìm Kiếm :");

        txt_timkiemhoadon.setLabelText("Tìm kiếm hóa đơn");
        txt_timkiemhoadon.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_timkiemhoadonCaretUpdate(evt);
            }
        });
        txt_timkiemhoadon.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_timkiemhoadonFocusGained(evt);
            }
        });
        txt_timkiemhoadon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_timkiemhoadonActionPerformed(evt);
            }
        });
        txt_timkiemhoadon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_timkiemhoadonKeyReleased(evt);
            }
        });

        lbl_thongBao.setText("jLabel3");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(jLabel2)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_timkiemhoadon, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_thongBao, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(txt_timkiemhoadon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lbl_thongBao)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 10))); // NOI18N

        tbl_thongtinhoadon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Ban Hang", "ID Sach", "Tên sách", "Số lượng", "TenNXB", "TenNN", "TenTG", "Đơn giá", "HoTen"
            }
        ));
        tbl_thongtinhoadon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_thongtinhoadonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_thongtinhoadon);
        if (tbl_thongtinhoadon.getColumnModel().getColumnCount() > 0) {
            tbl_thongtinhoadon.getColumnModel().getColumn(2).setResizable(false);
            tbl_thongtinhoadon.getColumnModel().getColumn(4).setResizable(false);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 10))); // NOI18N

        tbl_danhsachsanpham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Sach", "Ten Sach", "So Luong", "tenNXB", "tenNN", "tenTG", "Don gia"
            }
        ));
        jScrollPane2.setViewportView(tbl_danhsachsanpham);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        txt_khachhang.setLabelText("Khách Hàng");

        txt_mahoadon.setLabelText("Mã Hóa Đơn");

        txt_ghichu.setLabelText("Ghi Chú");

        txt_tienhoantra.setLabelText("Tiền Hoàn Trả");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_khachhang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_mahoadon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_ghichu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_tienhoantra, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_khachhang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_mahoadon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_ghichu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(txt_tienhoantra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_trahang.setText("Trả Hàng");
        btn_trahang.setRadius(20);

        btn_xoa.setText("Xóa");
        btn_xoa.setRadius(20);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(12, 12, 12)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(btn_trahang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(127, 127, 127))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_trahang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(133, 133, 133))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_timkiemhoadonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_timkiemhoadonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_timkiemhoadonActionPerformed

    private void txt_timkiemhoadonCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_timkiemhoadonCaretUpdate
        TimTheoID();
    }//GEN-LAST:event_txt_timkiemhoadonCaretUpdate

    private void txt_timkiemhoadonFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_timkiemhoadonFocusGained
        lbl_thongBao.setText("");
    }//GEN-LAST:event_txt_timkiemhoadonFocusGained

    private void txt_timkiemhoadonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_timkiemhoadonKeyReleased
        TimTheoID();
    }//GEN-LAST:event_txt_timkiemhoadonKeyReleased

    private void tbl_thongtinhoadonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_thongtinhoadonMouseClicked
        insertTraHang();
    }//GEN-LAST:event_tbl_thongtinhoadonMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private View.form.MyButton btn_trahang;
    private View.form.MyButton btn_xoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_thongBao;
    private View.form.TableColumn tbl_danhsachsanpham;
    private View.form.TableColumn tbl_thongtinhoadon;
    private View.form.TextField txt_ghichu;
    private View.form.TextField txt_khachhang;
    private View.form.TextField txt_mahoadon;
    private View.form.TextField txt_tienhoantra;
    private View.form.TextField txt_timkiemhoadon;
    // End of variables declaration//GEN-END:variables
}
