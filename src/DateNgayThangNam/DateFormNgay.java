/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package DateNgayThangNam;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JButton;


/**
 *
 * @author ADMIN
 */
public class DateFormNgay extends javax.swing.JPanel {

   private Event event;
    private final int MONTH;
    private final int YEAR;
    private final int DAY;
    private int m;
    private int y;
    private int selectDay = 0;
    private int startDate;
    private int max_of_month;
    public DateFormNgay() {
        initComponents();
         SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
         Date date = new Date();
        String toDay = df.format(date);
        DAY = Integer.valueOf(toDay.split("-")[0]);
        MONTH = Integer.valueOf(toDay.split("-")[1]);
        YEAR = Integer.valueOf(toDay.split("-")[2]);
         
    }
    public void showDate(int month, int year, SelectedDate select) {
        m = month;
        y = year;
        // selectDay = 0;
        Calendar cd = Calendar.getInstance();
        cd.set(year, month - 1, 1);
        int start = cd.get(Calendar.DAY_OF_WEEK);
        max_of_month = cd.getActualMaximum(Calendar.DAY_OF_MONTH);
        if (start == 1) {
            start += 7;
        }
        clear();
        start += 5;
        startDate = start;
        for (int i = 1; i <= max_of_month; i++) {
            Button cmd = (Button) getComponent(start);
            cmd.setColorSelected(getForeground());
            cmd.setText(i + "");
            if (i == DAY && month == MONTH && year == YEAR) {
                cmd.setBackground(new Color(224, 214, 229));
            } else {
                cmd.setBackground(Color.WHITE);
            }
            if (i == select.getNgay() && month == select.getThang() && year == select.getNam()) {
                cmd.setBackground(getForeground());
                cmd.setForeground(new Color(255, 255, 255));
            }
            start++;
        }
    }
    private void clear() {
        for (int i = 7; i < getComponentCount(); i++) {
            ((JButton) getComponent(i)).setText("");
        }
    }
    public void clearSelected() {
        for (int i = 7; i < getComponentCount(); i++) {
            JButton cmd = (JButton) getComponent(i);
            if (MONTH == m && y == YEAR && !cmd.getText().equals("") && Integer.valueOf(cmd.getText()) == DAY) {
                cmd.setBackground(new Color(224, 214, 229));
                cmd.setForeground(new java.awt.Color(75, 75, 75));
            } else {
                cmd.setBackground(Color.WHITE);
                cmd.setForeground(new java.awt.Color(75, 75, 75));
            }
        }
        selectDay = 0;
    }

    private void addEvent() {
        for (int i = 7; i < getComponentCount(); i++) {
            ((Button) getComponent(i)).setEvent(event);
        }
    }

    public void setSelected(int index) {
        selectDay = index;
    }
     public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
        addEvent();
    }
    public void next() {
        if (selectDay == max_of_month) {
            selectDay = 0;
        }
        JButton cmd = (JButton) getComponent(startDate - 1 + selectDay + 1);
        String n = cmd.getText();
        if (!n.equals("") && Integer.valueOf(n) <= max_of_month) {
            selectDay++;
            event.execute(null, selectDay);
            cmd.setBackground(new Color(206, 110, 245));
        }
    }

    public void back() {
        if (selectDay <= 1) {
            selectDay = max_of_month + 1;
        }
        JButton cmd = (JButton) getComponent(startDate - 1 + selectDay - 1);
        String n = cmd.getText();
        if (!n.equals("") && cmd.getName() != null) {
            selectDay--;
            event.execute(null, selectDay);
            cmd.setBackground(new Color(206, 110, 245));
        }
    }

    public void up() {
        JButton cmd = (JButton) getComponent(startDate - 1 + selectDay - 7);
        String n = cmd.getText();
        if (!n.equals("") && cmd.getName() != null) {
            selectDay -= 7;
            event.execute(null, selectDay);
            cmd.setBackground(new Color(206, 110, 245));
        }
    }

    public void down() {
        if (getComponents().length > startDate - 1 + selectDay + 7) {
            JButton cmd = (JButton) getComponent(startDate - 1 + selectDay + 7);
            String n = cmd.getText();
            if (!n.equals("") && cmd.getName() != null) {
                selectDay += 7;
                event.execute(null, selectDay);
                cmd.setBackground(new Color(206, 110, 245));
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
        btn_Thu2 = new DateNgayThangNam.Button();
        btn_thu3 = new DateNgayThangNam.Button();
        btn_thu4 = new DateNgayThangNam.Button();
        btn_thu5 = new DateNgayThangNam.Button();
        btn_thu6 = new DateNgayThangNam.Button();
        btn_thu7 = new DateNgayThangNam.Button();
        btn_ChuNhat = new DateNgayThangNam.Button();
        button8 = new DateNgayThangNam.Button();
        button9 = new DateNgayThangNam.Button();
        btn_1 = new DateNgayThangNam.Button();
        btn_2 = new DateNgayThangNam.Button();
        btn_3 = new DateNgayThangNam.Button();
        btn_4 = new DateNgayThangNam.Button();
        btn_5 = new DateNgayThangNam.Button();
        btn_6 = new DateNgayThangNam.Button();
        btn_7 = new DateNgayThangNam.Button();
        btn_8 = new DateNgayThangNam.Button();
        btn_9 = new DateNgayThangNam.Button();
        btn_10 = new DateNgayThangNam.Button();
        btn_11 = new DateNgayThangNam.Button();
        btn_12 = new DateNgayThangNam.Button();
        btn_13 = new DateNgayThangNam.Button();
        btn_14 = new DateNgayThangNam.Button();
        btn_15 = new DateNgayThangNam.Button();
        btn_16 = new DateNgayThangNam.Button();
        btn_17 = new DateNgayThangNam.Button();
        btn_18 = new DateNgayThangNam.Button();
        btn_19 = new DateNgayThangNam.Button();
        btn_20 = new DateNgayThangNam.Button();
        btn_21 = new DateNgayThangNam.Button();
        btn_22 = new DateNgayThangNam.Button();
        btn_23 = new DateNgayThangNam.Button();
        btn_24 = new DateNgayThangNam.Button();
        btn_25 = new DateNgayThangNam.Button();
        btn_26 = new DateNgayThangNam.Button();
        btn_27 = new DateNgayThangNam.Button();
        btn_28 = new DateNgayThangNam.Button();
        btn_29 = new DateNgayThangNam.Button();
        btn_30 = new DateNgayThangNam.Button();
        btn_31 = new DateNgayThangNam.Button();
        button41 = new DateNgayThangNam.Button();
        button42 = new DateNgayThangNam.Button();
        button43 = new DateNgayThangNam.Button();
        button44 = new DateNgayThangNam.Button();
        button45 = new DateNgayThangNam.Button();
        button46 = new DateNgayThangNam.Button();
        button47 = new DateNgayThangNam.Button();
        button48 = new DateNgayThangNam.Button();
        button49 = new DateNgayThangNam.Button();

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.GridLayout(7, 7));

        btn_Thu2.setText("Thứ 2");
        jPanel2.add(btn_Thu2);

        btn_thu3.setText("Thứ 3");
        jPanel2.add(btn_thu3);

        btn_thu4.setText("Thứ 4");
        jPanel2.add(btn_thu4);

        btn_thu5.setText("Thứ 5");
        jPanel2.add(btn_thu5);

        btn_thu6.setText("Thứ 6");
        jPanel2.add(btn_thu6);

        btn_thu7.setText("Thứ 7");
        jPanel2.add(btn_thu7);

        btn_ChuNhat.setForeground(new java.awt.Color(255, 51, 102));
        btn_ChuNhat.setText("CN");
        jPanel2.add(btn_ChuNhat);
        jPanel2.add(button8);
        jPanel2.add(button9);

        btn_1.setText("1");
        jPanel2.add(btn_1);

        btn_2.setText("2");
        jPanel2.add(btn_2);

        btn_3.setText("3");
        jPanel2.add(btn_3);

        btn_4.setText("4");
        jPanel2.add(btn_4);

        btn_5.setText("5");
        btn_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_5ActionPerformed(evt);
            }
        });
        jPanel2.add(btn_5);

        btn_6.setText("6");
        btn_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_6ActionPerformed(evt);
            }
        });
        jPanel2.add(btn_6);

        btn_7.setText("7");
        jPanel2.add(btn_7);

        btn_8.setText("8");
        jPanel2.add(btn_8);

        btn_9.setText("9");
        jPanel2.add(btn_9);

        btn_10.setText("10");
        jPanel2.add(btn_10);

        btn_11.setText("11");
        jPanel2.add(btn_11);

        btn_12.setText("12");
        jPanel2.add(btn_12);

        btn_13.setText("13");
        jPanel2.add(btn_13);

        btn_14.setText("14");
        jPanel2.add(btn_14);

        btn_15.setText("15");
        jPanel2.add(btn_15);

        btn_16.setText("16");
        jPanel2.add(btn_16);

        btn_17.setText("17");
        jPanel2.add(btn_17);

        btn_18.setText("18");
        jPanel2.add(btn_18);

        btn_19.setText("19");
        jPanel2.add(btn_19);

        btn_20.setText("20");
        jPanel2.add(btn_20);

        btn_21.setText("21");
        jPanel2.add(btn_21);

        btn_22.setText("22");
        jPanel2.add(btn_22);

        btn_23.setText("23");
        btn_23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_23ActionPerformed(evt);
            }
        });
        jPanel2.add(btn_23);

        btn_24.setText("24");
        jPanel2.add(btn_24);

        btn_25.setText("25");
        jPanel2.add(btn_25);

        btn_26.setText("26");
        jPanel2.add(btn_26);

        btn_27.setText("27");
        jPanel2.add(btn_27);

        btn_28.setText("28");
        jPanel2.add(btn_28);

        btn_29.setText("29");
        jPanel2.add(btn_29);

        btn_30.setText("30");
        btn_30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_30ActionPerformed(evt);
            }
        });
        jPanel2.add(btn_30);

        btn_31.setText("31");
        jPanel2.add(btn_31);
        jPanel2.add(button41);
        jPanel2.add(button42);
        jPanel2.add(button43);
        jPanel2.add(button44);
        jPanel2.add(button45);
        jPanel2.add(button46);
        jPanel2.add(button47);
        jPanel2.add(button48);
        jPanel2.add(button49);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 253, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 235, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 253, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 235, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_5ActionPerformed

    private void btn_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_6ActionPerformed

    private void btn_23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_23ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_23ActionPerformed

    private void btn_30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_30ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_30ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private DateNgayThangNam.Button btn_1;
    private DateNgayThangNam.Button btn_10;
    private DateNgayThangNam.Button btn_11;
    private DateNgayThangNam.Button btn_12;
    private DateNgayThangNam.Button btn_13;
    private DateNgayThangNam.Button btn_14;
    private DateNgayThangNam.Button btn_15;
    private DateNgayThangNam.Button btn_16;
    private DateNgayThangNam.Button btn_17;
    private DateNgayThangNam.Button btn_18;
    private DateNgayThangNam.Button btn_19;
    private DateNgayThangNam.Button btn_2;
    private DateNgayThangNam.Button btn_20;
    private DateNgayThangNam.Button btn_21;
    private DateNgayThangNam.Button btn_22;
    private DateNgayThangNam.Button btn_23;
    private DateNgayThangNam.Button btn_24;
    private DateNgayThangNam.Button btn_25;
    private DateNgayThangNam.Button btn_26;
    private DateNgayThangNam.Button btn_27;
    private DateNgayThangNam.Button btn_28;
    private DateNgayThangNam.Button btn_29;
    private DateNgayThangNam.Button btn_3;
    private DateNgayThangNam.Button btn_30;
    private DateNgayThangNam.Button btn_31;
    private DateNgayThangNam.Button btn_4;
    private DateNgayThangNam.Button btn_5;
    private DateNgayThangNam.Button btn_6;
    private DateNgayThangNam.Button btn_7;
    private DateNgayThangNam.Button btn_8;
    private DateNgayThangNam.Button btn_9;
    private DateNgayThangNam.Button btn_ChuNhat;
    private DateNgayThangNam.Button btn_Thu2;
    private DateNgayThangNam.Button btn_thu3;
    private DateNgayThangNam.Button btn_thu4;
    private DateNgayThangNam.Button btn_thu5;
    private DateNgayThangNam.Button btn_thu6;
    private DateNgayThangNam.Button btn_thu7;
    private DateNgayThangNam.Button button41;
    private DateNgayThangNam.Button button42;
    private DateNgayThangNam.Button button43;
    private DateNgayThangNam.Button button44;
    private DateNgayThangNam.Button button45;
    private DateNgayThangNam.Button button46;
    private DateNgayThangNam.Button button47;
    private DateNgayThangNam.Button button48;
    private DateNgayThangNam.Button button49;
    private DateNgayThangNam.Button button8;
    private DateNgayThangNam.Button button9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
