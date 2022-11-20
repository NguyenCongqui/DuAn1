/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View.form.giaodich;

import DomainModel.ChiTietHoaDonBan;
import DomainModel.ChiTietSach;
import DomainModel.HoaDonBanHang;
import DomainModel.KhachHang;
import DomainModel.Voucher;
import Service.Impl.ChiTietHoaDonImpl;
import Service.Impl.HoaDonBanHangImpl;
import Service.Impl.ChiTietSachImpl;
import Service.Impl.KhachHangIMpl;
import Service.Impl.VoucherImpl;
import Services.ChiTietHoaDonService;
import Services.ChiTietSachService;
import Services.HoaDonBanHangService;
import Services.KhachHangService;
import Services.VoucherService;
import ViewModel.BanHangViewModel;
import ViewModel.MatHangViewModel;
import java.lang.reflect.Array;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class ViewBanHang extends javax.swing.JPanel {

    DefaultTableModel tbl_model = new DefaultTableModel();
    DefaultTableModel tbl_model1 = new DefaultTableModel();
    ChiTietSachService chitietsachService = new ChiTietSachImpl();
    List<BanHangViewModel> ListBanHangViewModel = new ArrayList<>();
    List<ChiTietHoaDonBan> ListChiTietHoaDonBan = new ArrayList<>();
    List<Voucher> ListVoucher = new ArrayList<>();
    List<KhachHang> listKhachHang = new ArrayList<>();
    KhachHangService KhachHangService = new KhachHangIMpl();
    VoucherService voucherService = new VoucherImpl();
    HoaDonBanHangService hoadonbanhangservice = new HoaDonBanHangImpl();
    ChiTietHoaDonService chitiethoadonservice = new ChiTietHoaDonImpl();
    
    
    public ViewBanHang() {
        initComponents();
        tbl_model = (DefaultTableModel) tbl1.getModel();
        ListBanHangViewModel = chitietsachService.getlistBanHang();
        fillComboxVoucher();
        fillComboxKhachHang();
        filldata01();
        chk_Voucher.setSelected(false);
        cbo_MaGiamGia.setVisible(false);
        txt_TongTien.setEnabled(false);
        
    }
    Locale lc = new Locale("vn", "VN");
    NumberFormat nf = NumberFormat.getInstance(lc);
    public void filldata01(){
        tbl_model.setRowCount(0);
        for (BanHangViewModel bh : ListBanHangViewModel) {
            tbl_model.addRow(new Object[]{
                bh.getId(),bh.getMaSach(),bh.getTenSach(),bh.getTheLoai(),bh.getNgonNgu(),bh.getTacGia(),bh.getNXB(),nf.format(bh.getDonGia()) + " đ",bh.getSoLuongTon()
              
            });
        }
    }
    public void fillComboxVoucher() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbo_MaGiamGia.getModel();
        cbo_MaGiamGia.removeAllItems();
       ListVoucher = voucherService.getListVouchers();
        for (Voucher v : ListVoucher) {
            model.addElement(v);
        }
    }
    public void fillComboxKhachHang() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbo_KhachHang.getModel();
        cbo_KhachHang.removeAllItems();
       listKhachHang = KhachHangService.getlistKhachHang();
        for (KhachHang kh : listKhachHang) {
            model.addElement(kh);
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
    public void fillTable(){
        
        if (txt_SlgBan.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(this,"số lượng không đc để trống");
            return;
        } else {
            int index = tbl1.getSelectedRow();
            if (index == -1) {
                JOptionPane.showMessageDialog(this,"Bạn chưa chọn mặt hàng nào cả");
                return;
            }else if (Integer.parseInt(txt_SlgBan.getText()) > (int) tbl1.getValueAt(index, 8)) {
                JOptionPane.showMessageDialog(this,"bạn ơi số lượng bán phải lớn hơn số lượng tronng kho");
                return;
                
            } else {
                int id = (int) tbl1.getValueAt(index, 0);
                String MaSach = (String) tbl1.getValueAt(index, 1);
                String TenSach = (String) tbl1.getValueAt(index, 2);
                String TenTheLoai = (String) tbl1.getValueAt(index, 3);
                String TenNgonNgu = (String) tbl1.getValueAt(index, 4);
                String TenTacGia = (String) tbl1.getValueAt(index, 5);
                String TenNhaXuatBan = (String) tbl1.getValueAt(index, 6);
                float DonGia = Float.parseFloat(fomartFloat((String)tbl1.getValueAt(tbl1.getSelectedRow(), 7)));
                int SoLuongTBan = Integer.parseInt(txt_SlgBan.getText());
                
                tbl_model1 =  (DefaultTableModel) tbl2.getModel();
                tbl_model1.addRow(new Object[]{
                    id,MaSach,TenSach,TenTheLoai,TenNgonNgu,TenTacGia,TenNhaXuatBan,nf.format(DonGia)+" đ" , SoLuongTBan
                });
                ChiTietHoaDonBan hd = new ChiTietHoaDonBan();
                hd.setDonGia(DonGia);
                hd.setIdChiTietSach(id);
                hd.setSoLuong(SoLuongTBan);
                ListChiTietHoaDonBan.add(hd);
                tbl1.clearSelection();
                txt_SlgBan.setText("");
                int i = ((int)tbl1.getValueAt(index, 8)) - SoLuongTBan;
                tbl1.setValueAt(i, index, 8);
                System.out.println(i);
                
                
            }
{
                
            }
        }
    }
    public float TotalBuy() {
        float GiaBan = 0;
        int index = tbl2.getRowCount();
        for (int i = 0; i < index; i++) {
            GiaBan += Float.parseFloat(fomartFloat((String) tbl2.getValueAt(i, 7))) * (int) tbl2.getValueAt(i, 8);
        }
        return GiaBan;
    }
     public float MaVoucher() {
         Voucher v = (Voucher) cbo_MaGiamGia.getSelectedItem();
        float voucher = v.getGiamgia();
        return (int) TotalBuy() - (TotalBuy() * (float) (voucher / 100));
    }
      public void delete() {
          DefaultTableModel model = (DefaultTableModel) tbl2.getModel();
        int index = tbl1.getSelectedRow();
        int index2 = tbl2.getSelectedRow();


        if (tbl2.getSelectedRowCount() == 1) {
            for (int i = 0; i < tbl1.getRowCount(); i++) {
                if (tbl1.getValueAt(i, 0).equals(tbl2.getValueAt(index2, 0))) {
                    int ii = (int) tbl1.getValueAt(i, 8) + (int) tbl2.getValueAt(index2, 8);
                    tbl1.setValueAt(ii, i, 8);
                    System.out.println("okooooo" + ii);
                }
            }
            for (int j = 0; j < ListChiTietHoaDonBan.size(); j++) {
                if (ListChiTietHoaDonBan.get(j).getIDHoaDonBan() == (int) tbl2.getValueAt(index2, 0)) {
                   model.removeRow(tbl2.getSelectedRow());
                    ListChiTietHoaDonBan.remove(ListChiTietHoaDonBan.get(j));
                    return;
                }
            }
//            model.setRowCount(0);
//            ListChiTietHoaDonBan.clear();
//                filldata01();
        }

    }
     public HoaDonBanHang getHoaDon() {
        HoaDonBanHang hd = new HoaDonBanHang();
       // Calendar calendar = Calendar.getInstance();
        hd.setTrangThai(true);
        hd.setTrangThaiHoaDon(true);
        hd.setTrangThaiTraTien(true);
        hd.setGhichu(txtMoTa.getText());
        hd.setTongTien(TotalBuy());      
        hd.setTienKhachDua(Float.parseFloat(txt_TienKhachDua.getText()));
    //  hd.setTienTraLai(Float.valueOf(txt_TienKhachDua.getText()) - Float.valueOf(MaVoucher()));
       hd.setTienTraLai(Float.parseFloat(fomartFloat(txt_TienThua.getText())));     
          KhachHang kh = (KhachHang) cbo_KhachHang.getSelectedItem();
        hd.setIdKhachHang(kh.getIdKhachHang());
        hd.setTenKhachHang(kh.getHoTen());
        if (!chk_Voucher.isSelected()) {
           hd.setIDVoucher(null);
        } else {
            Voucher v = (Voucher) cbo_MaGiamGia.getSelectedItem();
            hd.setIDVoucher(v.getIDVoucher());
        }
         
        hd.setIdUsers(1);
        return hd;
    }
      public void insertBanHang(){
           int index = tbl2.getRowCount();
        if (index <= 0) {
            JOptionPane.showMessageDialog(this," bạn chưa thanh toán sản phẩm nào ");
                    
             return;
        } else {
            if (txt_TienKhachDua.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Bạn chưa nhập tiền khách đưa kìa");
                return;
            }  else if (Float.valueOf(txt_TienKhachDua.getText()) - Float.valueOf(TotalBuy()) < 0) {
                JOptionPane.showMessageDialog(this,"bạn ơi nhập lại số tiền khách đưa đi ạ");
                return;
            } else {
                HoaDonBanHang hdbh = getHoaDon();
                JOptionPane.showMessageDialog(this,hoadonbanhangservice.insert(hdbh));
                
                int index1 = tbl2.getRowCount();
                for (int i = 0; i < ListChiTietHoaDonBan.size(); i++) {
                    ChiTietHoaDonBan cthd = ListChiTietHoaDonBan.get(i);
                    System.out.println(cthd.getSoLuong());
                   JOptionPane.showMessageDialog(this,chitiethoadonservice.insert(cthd));
                    JOptionPane.showMessageDialog(this, chitietsachService.updateSoLuongTon(cthd.getSoLuong(),cthd.getIdChiTietSach()));
                  
                }
                hdbh.setTongTien(TotalBuy());
                
               
            
                if (chk_Voucher.isSelected()) {
                    Voucher v1 =  (Voucher) cbo_MaGiamGia.getSelectedItem();
                   // ListVoucher = voucherService.updateSoLuongTon( v1.getIDVoucher());
                    
                }
                DefaultTableModel model = (DefaultTableModel) tbl2.getModel();
                model.setRowCount(0);
                ListChiTietHoaDonBan.clear();
                ListBanHangViewModel = chitietsachService.getlistBanHang();
                filldata01();
            }
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
        jLabel2 = new javax.swing.JLabel();
        txt_Search = new View.form.TextField();
        btn_Search = new View.form.MyButton();
        txt_SlgBan = new View.form.TextField();
        btn_LuuTam = new View.form.MyButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl1 = new View.form.TableColumn();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl2 = new View.form.TableColumn();
        btn_Xoa = new View.form.MyButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        cbo_KhachHang = new View.form.Combobox();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtMoTa = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        txt_TongTien = new View.form.TextField();
        chk_Voucher = new javax.swing.JCheckBox();
        txt_Voucher = new View.form.TextField();
        txt_TienKhachDua = new View.form.TextField();
        txt_TienThua = new View.form.TextField();
        btn_BanHang = new View.form.MyButton();
        myButton1 = new View.form.MyButton();
        cbo_MaGiamGia = new View.form.Combobox();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Ban Hang");

        txt_Search.setLabelText("Tim theo ten hoac ma");

        btn_Search.setText("Tìm Kiếm");
        btn_Search.setRadius(20);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(txt_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addComponent(btn_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_Search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(btn_Search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        txt_SlgBan.setLabelText("So luong ban");
        txt_SlgBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_SlgBanActionPerformed(evt);
            }
        });

        btn_LuuTam.setText("Lưu Tạm");
        btn_LuuTam.setRadius(20);
        btn_LuuTam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LuuTamActionPerformed(evt);
            }
        });

        tbl1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Ma San Pham", "Ten San Pham", "The Loai", "Ngon Ngu", "Tac Gia", "NXB", "Don Gia", "Số Lượng Tồn"
            }
        ));
        jScrollPane1.setViewportView(tbl1);

        tbl2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Ma San Pham", "Ten San Pham", "The Loai", "Ngon Ngu", "Tac Gia", "NXB", "Don Gia", "So Luong Ban"
            }
        ));
        jScrollPane2.setViewportView(tbl2);

        btn_Xoa.setText("Xóa");
        btn_Xoa.setRadius(20);
        btn_Xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XoaActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 414, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 461, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thanh Toán", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 10))); // NOI18N

        cbo_KhachHang.setLabeText("Khach hang");

        txtMoTa.setColumns(20);
        txtMoTa.setRows(5);
        jScrollPane3.setViewportView(txtMoTa);

        jLabel3.setText("Mô tả");

        txt_TongTien.setLabelText("Tong Tien");

        chk_Voucher.setText("Áp mã voucher ?");
        chk_Voucher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_VoucherActionPerformed(evt);
            }
        });

        txt_Voucher.setLabelText("Ma giam gia");
        txt_Voucher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_VoucherActionPerformed(evt);
            }
        });

        txt_TienKhachDua.setLabelText("Tien Khach Dua");
        txt_TienKhachDua.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_TienKhachDuaFocusGained(evt);
            }
        });
        txt_TienKhachDua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_TienKhachDuaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_TienKhachDuaKeyReleased(evt);
            }
        });

        txt_TienThua.setLabelText("Tien Thua");

        btn_BanHang.setText("Thanh Toán");
        btn_BanHang.setRadius(20);
        btn_BanHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BanHangActionPerformed(evt);
            }
        });

        myButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon/icons8_barcode_reader_32.png"))); // NOI18N
        myButton1.setBorderColor(new java.awt.Color(0, 0, 0));
        myButton1.setRadius(20);

        cbo_MaGiamGia.setLabeText("Mã Giảm Giá");
        cbo_MaGiamGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_MaGiamGiaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbo_KhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(chk_Voucher)
                                    .addGap(86, 86, 86))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(cbo_MaGiamGia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(34, 34, 34)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(txt_Voucher, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)))
                        .addComponent(myButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(159, 159, 159))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_BanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_TongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_TienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_TienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(cbo_KhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(chk_Voucher)
                        .addGap(18, 18, 18)
                        .addComponent(cbo_MaGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(myButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_Voucher, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(txt_TongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_TienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_TienThua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_BanHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 955, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txt_SlgBan, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addComponent(btn_LuuTam, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_Xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)))
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(363, 363, 363))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(783, 783, 783)))
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btn_LuuTam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btn_Xoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(txt_SlgBan, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1328, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_SlgBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_SlgBanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_SlgBanActionPerformed

    private void btn_LuuTamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LuuTamActionPerformed
        // TODO add your handling code here:
        
        fillTable();
        if (chk_Voucher.isSelected()) {
            txt_TongTien.setText(nf.format(MaVoucher()) + " đ");
            if (cbo_MaGiamGia.getSelectedItem()== null) {
                return;
            } else {
                cbo_MaGiamGia.setSelectedIndex(0);
                if (txt_TienKhachDua.getText().isEmpty()) {
                    return;
                }else{
                    txt_TienThua.setText(nf.format(Float.valueOf(txt_TienKhachDua.getText()) - Float.valueOf(MaVoucher())));
                }
            }
        } else {
            txt_TongTien.setText(nf.format(TotalBuy()) + " đ");
            if (txt_TienKhachDua.getText().isEmpty()) {
                return;
                
            }else{
                txt_TienThua.setText(nf.format(Float.valueOf(txt_TienKhachDua.getText()) - Float.valueOf(TotalBuy())));
            }
        }
        
    }//GEN-LAST:event_btn_LuuTamActionPerformed

    private void txt_VoucherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_VoucherActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_VoucherActionPerformed

    private void cbo_MaGiamGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_MaGiamGiaActionPerformed
        // TODO add your handling code here:
        txt_TongTien.setText(nf.format(MaVoucher())+ " đ");
    }//GEN-LAST:event_cbo_MaGiamGiaActionPerformed

    private void chk_VoucherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_VoucherActionPerformed
        // TODO add your handling code here:
        if (chk_Voucher.isSelected()) {
            cbo_MaGiamGia.setVisible(true);
            if (cbo_MaGiamGia.getSelectedItem() == null) {
                return;
            } else {
                cbo_MaGiamGia.setSelectedIndex(0);
                if (txt_TienKhachDua.getText().isEmpty()) {
                    return;
                } else {
                    txt_TienThua.setText(nf.format(Float.valueOf(txt_TienKhachDua.getText()) - Float.valueOf(MaVoucher())));
                }
            }
        } else {
            cbo_MaGiamGia.setVisible(false);
            txt_TienThua.setText(nf.format(Float.valueOf(txt_TienKhachDua.getText()) - Float.valueOf(TotalBuy())));
            txt_TongTien.setText(nf.format(TotalBuy()) + " đ");
        }
    }//GEN-LAST:event_chk_VoucherActionPerformed

    private void txt_TienKhachDuaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_TienKhachDuaFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_TienKhachDuaFocusGained

    private void txt_TienKhachDuaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_TienKhachDuaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_TienKhachDuaKeyPressed

    private void txt_TienKhachDuaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_TienKhachDuaKeyReleased
        // TODO add your handling code here:
        if (txt_TienKhachDua.getText().isEmpty()) {
            txt_TienThua.setText("");
            return;
        } else {
            if (chk_Voucher.isSelected()) {
                txt_TienThua.setText(nf.format(Float.valueOf(txt_TienKhachDua.getText()) - Float.valueOf(MaVoucher())) );
            } else {
                txt_TienThua.setText(nf.format(Float.valueOf(txt_TienKhachDua.getText()) - Float.valueOf(TotalBuy())) );
            }
        }
    }//GEN-LAST:event_txt_TienKhachDuaKeyReleased

    private void btn_XoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XoaActionPerformed
        // TODO add your handling code here:
        delete();
        if (chk_Voucher.isSelected()) {
            txt_TongTien.setText(nf.format(MaVoucher()) + " đ");
            if (cbo_MaGiamGia.getSelectedItem() == null) {
                return;
            } else {
                if (txt_TienKhachDua.getText().isEmpty()) {
                    return;
                } else {

                    txt_TienThua.setText(nf.format(Float.valueOf(txt_TienKhachDua.getText()) - Float.valueOf(MaVoucher())) );
                }
            }
        } else {
            if (txt_TienKhachDua.getText().isEmpty()) {
                return;
            } else {

                txt_TienThua.setText(nf.format(Float.valueOf(txt_TienKhachDua.getText()) - Float.valueOf(TotalBuy())) );
            }
            txt_TongTien.setText(nf.format(TotalBuy()) + " đ");
        }
    }//GEN-LAST:event_btn_XoaActionPerformed

    private void btn_BanHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BanHangActionPerformed
        // TODO add your handling code here:
        insertBanHang();
         
        
    }//GEN-LAST:event_btn_BanHangActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private View.form.MyButton btn_BanHang;
    private View.form.MyButton btn_LuuTam;
    private View.form.MyButton btn_Search;
    private View.form.MyButton btn_Xoa;
    private View.form.Combobox cbo_KhachHang;
    private View.form.Combobox cbo_MaGiamGia;
    private javax.swing.JCheckBox chk_Voucher;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private View.form.MyButton myButton1;
    private View.form.TableColumn tbl1;
    private View.form.TableColumn tbl2;
    private javax.swing.JTextArea txtMoTa;
    private View.form.TextField txt_Search;
    private View.form.TextField txt_SlgBan;
    private View.form.TextField txt_TienKhachDua;
    private View.form.TextField txt_TienThua;
    private View.form.TextField txt_TongTien;
    private View.form.TextField txt_Voucher;
    // End of variables declaration//GEN-END:variables
}
