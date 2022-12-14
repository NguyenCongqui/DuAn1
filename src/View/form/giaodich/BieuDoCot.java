/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View.form.giaodich;

import chartCot.ModelChart;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class BieuDoCot extends javax.swing.JFrame {

    /**
     * Creates new form BieuDoCot
     */
    public BieuDoCot(DefaultTableModel tbl_cot) {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getContentPane().setBackground(new Color(250, 250, 250));
        chart011.addLegend("Tổng giá bán", new Color(135, 189, 245));
        chart011.addLegend("Tổng giá chi", new Color(189, 135, 245));
        chart011.addLegend("Tổng giá Nhập", new Color(245, 189, 135));
        chart011.addLegend("Doanh thu", new Color(139, 229, 222));

        for (int j = 0; j < tbl_cot.getRowCount(); j++) {

            chart011.addData(new ModelChart((int) tbl_cot.getValueAt(j, 0) + "",
                    new double[]{
                        //                        (int) tableShow.getValueAt(j, 1),
                        Float.parseFloat(fomartFloat((String) tbl_cot.getValueAt(j, 2))),
                        Float.parseFloat(fomartFloat((String) tbl_cot.getValueAt(j, 3))),
                        Float.parseFloat(fomartFloat((String) tbl_cot.getValueAt(j, 4))),
                        Float.parseFloat(fomartFloat((String) tbl_cot.getValueAt(j, 5)))

                    }));
        }
        chart011.start();
    }

   public BieuDoCot(DefaultTableModel defaultTableModel, Object object) {
       initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setBackground(new Color(250, 250, 250));
        chart011.addLegend("Sản phẩm", new Color(12, 84, 175));
        for (int j = 0; j < defaultTableModel.getRowCount(); j++) {
            if (j == 10) {
                break;
            }
            chart011.addData(new ModelChart((String) defaultTableModel.getValueAt(j, 1), new double[]{(int) defaultTableModel.getValueAt(j, 2)}));
        }
        chart011.start();
    }

    private BieuDoCot() {
       initComponents();
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



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chart011 = new chartCot.chart01();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(chart011, javax.swing.GroupLayout.PREFERRED_SIZE, 664, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(chart011, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(BieuDoCot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BieuDoCot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BieuDoCot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BieuDoCot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BieuDoCot().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private chartCot.chart01 chart011;
    // End of variables declaration//GEN-END:variables
}
