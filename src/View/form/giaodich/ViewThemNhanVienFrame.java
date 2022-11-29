/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View.form.giaodich;

import DomainModel.TaiKhoan;
import DomainModel.Users;
import Service.Impl.NhanVienImpl;

import Service.Impl.UsersImpl;
import Services.NhanVienService;

import Services.UsersService;
import View.login.XDate;
import java.awt.event.ActionListener;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class ViewThemNhanVienFrame extends javax.swing.JFrame {

    private DefaultTableModel tblModel;
    private List<Users> ListUsers = new ArrayList<>();
   // private UsersService usersService = new UsersImpl();
    NhanVienService nhanVienService =new NhanVienImpl();
    List<TaiKhoan> ListTaiKhoan = new ArrayList<>();

    /**
     * Creates new form ViewThemNhanVienFrame
     */
    public ViewThemNhanVienFrame() {
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
       

    }

    ViewThemNhanVienFrame(String Hoten, String ChucVu, String GioiTinh, String NgaySinh, String DiaChi, String SoDienThoai, String email, String Luong) {
        
    }

    ViewThemNhanVienFrame(String Hoten, String ChucVu, String GioiTinh, String NgaySinh, String DiaChi, String SoDienThoai, String email, String Luong, int idUser, int selectedIndex) {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        btn_them.setEnabled(false);
        btn_them.setVisible(false);

        txt_ten.setText(Hoten);
        txt_ngaysinh.setText(NgaySinh);
        txt_diachi.setText(DiaChi);
        txt_dienthoai.setText(SoDienThoai);
        txt_email.setText(email);
        txt_luong.setText(Luong);
        txt_password.setVisible(false);
        txt_username.setVisible(false);
        txt_diachi.setEditable(false);
        //txt_ngaysinh.setEditable(false);
        //this.NgaySinh.setVisible(false);
        rbt_nam.setEnabled(false);
        rbt_nu.setEnabled(false);
        txt_email.setEditable(false);
        txt_ten.setEditable(false);
        txt_dienthoai.setEditable(false);

        if (GioiTinh.equalsIgnoreCase("Nam")) {
            rbt_nam.setSelected(true);
        } else if (GioiTinh.equalsIgnoreCase("Nữ")) {
            rbt_nu.setSelected(true);
        }
        if (ChucVu.equalsIgnoreCase("Quản lý")) {
            rbt_quanly.setSelected(true);
        } else if (ChucVu.equalsIgnoreCase("Nhân viên")) {
            rbt_nhanvien.setSelected(true);
        }

        if (selectedIndex == 0) {
            rbt_danglamviec.setSelected(true);
        } else {
            rbt_nghilam.setSelected(true);
        }
        //lblIDUser.setText(idUser + "");
    }
    public void addEvenUpdate(ActionListener evt) {
        btn_sua.addActionListener(evt);
    }
    public void update() {
        Users us = new Users();
        us.setHoten(txt_ten.getText());
        us.setDiaChi(txt_diachi.getText());
        us.setEmail(txt_email.getText());
        us.setGioitinh(rbt_nam.isSelected());
        us.setLuong(Float.parseFloat(txt_luong.getText()));
        us.setNgaysinh(XDate.toDate(txt_ngaysinh.getText(), "dd-MM-yyyy"));
        us.setRole(rbt_quanly.isSelected());
        us.setSoDienThoai(txt_dienthoai.getText());
        us.setTrangThai(rbt_danglamviec.isSelected());
        JOptionPane.showMessageDialog(this,nhanVienService.SuaNhanVien(us));
        this.dispose();
    }
    
    

    public void clearForm() {
        txt_ten.setText("");
        txt_dienthoai.setText("");
        txt_email.setText("");
        txt_luong.setText("");
        txt_ngaysinh.setText("");
        txt_diachi.setText("");
        txt_username.setText("");
        txt_password.setText("");
        rbt_danglamviec.setSelected(false);
        rbt_nghilam.setSelected(false);
        rbt_quanly.setSelected(false);
        rbt_nhanvien.setSelected(false);
        rbt_nam.setSelected(false);
        rbt_nu.setSelected(false);
        btn_them.setEnabled(true);
    }

    public Users getGui() {
        Users us = new Users();
        us.setHoten(txt_ten.getText());
        us.setSoDienThoai(txt_dienthoai.getText());
        us.setEmail(txt_email.getText());
        us.setLuong(Float.parseFloat(txt_luong.getText()));
        if (rbt_danglamviec.isSelected() == true) {
            us.setTrangThai(true);
        } else {
            us.setTrangThai(false);
        }
        us.setNgaysinh(XDate.toDate(txt_ngaysinh.getText(), "dd-MM-yyyy"));
        if (rbt_nam.isSelected() == true) {
            us.setGioitinh(true);
        } else {
            us.setGioitinh(false);
        }
        if (rbt_quanly.isSelected() == true) {
            us.setRole(true);
        } else {
            us.setRole(false);
        }
        return us;

    }
    public TaiKhoan GetGuidataTaiKhoan(){
        TaiKhoan tk = new TaiKhoan();
        tk.setName(txt_username.getText());
        tk.setMatKhau(txt_password.getText());
        return tk;
    }
    public boolean checkDate() {
        LocalDate today = LocalDate.now();
        LocalDate date = LocalDate.parse(txt_ngaysinh.getText(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        int years = Period.between(date, today).getYears();
        if (years < 18) {
            JOptionPane.showMessageDialog(this,"Bạn ơi trên 18 mới đc nha");
            System.out.println(years);
            return false;
        }
        System.out.println(years);
        return true;
    }
    public boolean validate01(){
        if (txt_ten.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this,"Bạn ơi Họ và Tên đang trống");
            return false;
        }
        if (txt_diachi.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this,"Bạn ơi Dịa Chỉ đang trống");
            return false;
        }
        if (txt_dienthoai.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this,"Bạn ơi Số Điện Thoại đang trống");
            return false;
        }
        try {
            Integer.parseInt(txt_dienthoai.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Số điện thoại phải là số nha");
            return false;
        }
        if (Integer.parseInt(txt_dienthoai.getText())<10) {
            JOptionPane.showMessageDialog(this,"Bạn ơi số Điện Thoại phải nhỏ hơn 10 số nha");
            return false;
        }
        if (txt_email.getText().isEmpty()) {
             JOptionPane.showMessageDialog(this,"Bạn ơi Email đang trống nha");
            return false;
        }
        if (txt_ngaysinh.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this,"Bạn ơi Ngày Sinh đang trống");
            return false;
        }
        if (txt_password.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this,"Bạn ơi pass đang trống");
            return false;
        }
        if (txt_username.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this,"Bạn ơi users đang trống");
            return false;
        }
        if (txt_luong.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this,"Bạn ơi Lương đang trống");
            return false;
        }
        if (!rbt_nam.isSelected()&& !rbt_nu.isSelected()) {
           JOptionPane.showMessageDialog(this,"Bạn ơi chưa chọn Giới Tính ");
            return false;
        }
        if (!rbt_quanly.isSelected()&& !rbt_nhanvien.isSelected()) {
           JOptionPane.showMessageDialog(this,"Bạn ơi chưa chọn chức Vụ ");
            return false;
        }
        if (!rbt_danglamviec.isSelected()&& !rbt_nghilam.isSelected()) {
           JOptionPane.showMessageDialog(this,"Bạn ơi chưa Chọn Tình Trạng ");
            return false;
        }
        try {
            Float.parseFloat(txt_luong.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Bạn ơi Lương phải là số nha");
            return false;
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        NgaySinh = new com.raven.datechooser.DateChooser();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_ten = new View.form.TextField();
        txt_ngaysinh = new View.form.TextField();
        txt_email = new View.form.TextField();
        txt_dienthoai = new View.form.TextField();
        txt_luong = new View.form.TextField();
        txt_password = new View.form.TextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_diachi = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        rbt_nam = new View.form.RadioButtonCustom();
        rbt_nu = new View.form.RadioButtonCustom();
        txt_username = new View.form.TextField();
        jLabel4 = new javax.swing.JLabel();
        rbt_danglamviec = new View.form.RadioButtonCustom();
        rbt_nghilam = new View.form.RadioButtonCustom();
        jLabel5 = new javax.swing.JLabel();
        rbt_quanly = new View.form.RadioButtonCustom();
        rbt_nhanvien = new View.form.RadioButtonCustom();
        btn_them = new View.form.MyButton();
        btn_sua = new View.form.MyButton();
        btn_lammoi = new View.form.MyButton();
        btn_huy = new View.form.MyButton();

        NgaySinh.setTextRefernce(txt_ngaysinh);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Thêm Nhân Viên");

        txt_ten.setLabelText("Tên");

        txt_ngaysinh.setLabelText("Ngày Sinh");

        txt_email.setLabelText("Email");

        txt_dienthoai.setLabelText("Điện Thoại");

        txt_luong.setLabelText("Lương");

        txt_password.setLabelText("PassWord");

        jLabel2.setText("Địa chỉ");

        txt_diachi.setColumns(20);
        txt_diachi.setRows(5);
        jScrollPane1.setViewportView(txt_diachi);

        jLabel3.setText("Giới Tính ");

        rbt_nam.setBackground(new java.awt.Color(102, 255, 102));
        buttonGroup1.add(rbt_nam);
        rbt_nam.setText("Nam");

        rbt_nu.setBackground(new java.awt.Color(51, 255, 51));
        buttonGroup1.add(rbt_nu);
        rbt_nu.setText("Nữ");

        txt_username.setLabelText("UserName");

        jLabel4.setText("Tình Trạng");

        rbt_danglamviec.setBackground(new java.awt.Color(51, 255, 51));
        buttonGroup2.add(rbt_danglamviec);
        rbt_danglamviec.setText("Đang Làm Việc");

        rbt_nghilam.setBackground(new java.awt.Color(51, 255, 51));
        buttonGroup2.add(rbt_nghilam);
        rbt_nghilam.setText("Nghỉ Làm");

        jLabel5.setText("Chức Vụ");

        rbt_quanly.setBackground(new java.awt.Color(102, 255, 102));
        buttonGroup3.add(rbt_quanly);
        rbt_quanly.setText("Quản Lý ");

        rbt_nhanvien.setBackground(new java.awt.Color(51, 255, 51));
        buttonGroup3.add(rbt_nhanvien);
        rbt_nhanvien.setText("Nhân Viên");

        btn_them.setText("Thêm ");
        btn_them.setRadius(20);
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        btn_sua.setText("Sửa");
        btn_sua.setRadius(20);

        btn_lammoi.setText("Làm Mới");
        btn_lammoi.setRadius(20);
        btn_lammoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lammoiActionPerformed(evt);
            }
        });

        btn_huy.setText("Hủy");
        btn_huy.setRadius(20);
        btn_huy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_huyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addComponent(btn_sua, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txt_ten, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                .addComponent(txt_dienthoai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_email, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_luong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_username, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(rbt_danglamviec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(rbt_nghilam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btn_lammoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addComponent(btn_huy, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(rbt_quanly, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(36, 36, 36)
                                        .addComponent(rbt_nhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_ngaysinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(rbt_nam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(rbt_nu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(131, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_ten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_ngaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(7, 7, 7)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel3)
                        .addGap(9, 9, 9)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbt_nam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rbt_nu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txt_dienthoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(txt_luong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbt_danglamviec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbt_nghilam, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbt_quanly, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbt_nhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_sua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_lammoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_huy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(95, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_huyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_huyActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btn_huyActionPerformed

    private void btn_lammoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lammoiActionPerformed
        // TODO add your handling code here:
        clearForm();
    }//GEN-LAST:event_btn_lammoiActionPerformed

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        // TODO add your handling code here:

        //        String ten = txt_ten.getText();
        //        String dienthoai = txt_dienthoai.getText();
        //        String email = txt_email.getText();
        //        Float luong = Float.parseFloat(txt_luong.getText());
        //        Date ngaysinh = XDate.toDate(txt_ngaysinh.getText(), "dd-MM-yyyy");
        //        boolean gt = rbt_nam.isSelected();
        //        if (gt) {
            //            rbt_nam.setSelected(true);
            //        } else {
            //            rbt_nu.setSelected(true);
            //        }
        //
        //        boolean tt = rbt_danglamviec.isSelected();
        //        if (tt) {
            //            rbt_danglamviec.setSelected(true);
            //        }
        //        rbt_nghilam.setSelected(true);
        //
        //        boolean cv = rbt_quanly.isSelected();
        //        if (cv) {
            //            rbt_quanly.setSelected(true);
            //        } else {
            //            rbt_nhanvien.setSelected(true);
            //        }
        //       Users us= new Users( ten, ngaysinh, gt, email, dienthoai, email, luong, cv, tt);
        if (validate01()) {
            if (checkDate()) {
                JOptionPane.showMessageDialog(this, nhanVienService.themNhanVien(getGui()));
        JOptionPane.showMessageDialog(this,nhanVienService.ThemTaiKhoan(GetGuidataTaiKhoan()));
        clearForm();
            }
             
        }

       
    }//GEN-LAST:event_btn_themActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewThemNhanVienFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewThemNhanVienFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewThemNhanVienFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewThemNhanVienFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewThemNhanVienFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.datechooser.DateChooser NgaySinh;
    private View.form.MyButton btn_huy;
    private View.form.MyButton btn_lammoi;
    private View.form.MyButton btn_sua;
    private View.form.MyButton btn_them;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private View.form.RadioButtonCustom rbt_danglamviec;
    private View.form.RadioButtonCustom rbt_nam;
    private View.form.RadioButtonCustom rbt_nghilam;
    private View.form.RadioButtonCustom rbt_nhanvien;
    private View.form.RadioButtonCustom rbt_nu;
    private View.form.RadioButtonCustom rbt_quanly;
    private javax.swing.JTextArea txt_diachi;
    private View.form.TextField txt_dienthoai;
    private View.form.TextField txt_email;
    private View.form.TextField txt_luong;
    private View.form.TextField txt_ngaysinh;
    private View.form.TextField txt_password;
    private View.form.TextField txt_ten;
    private View.form.TextField txt_username;
    // End of variables declaration//GEN-END:variables
}
