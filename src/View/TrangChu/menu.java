/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View.TrangChu;

import View.login.Auth;
import java.awt.Color;
import java.awt.Component;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author ADMIN
 */
public class menu extends javax.swing.JPanel {

public void addEventShowPopup(EventShowPopupMenu eventShowPopup) {
        this.eventShowPopup = eventShowPopup;
    }
    public void setEventShowPopup(EventShowPopupMenu eventShowPopup) {
        this.eventShowPopup = eventShowPopup;
    }

    public boolean isEnableMenu() {
        return enableMenu;
    }

    public void setEnableMenu(boolean enableMenu) {
        this.enableMenu = enableMenu;
    }

    public boolean isShowMenu() {
        return showMenu;
    }

    public void setShowMenu(boolean showMenu) {
        this.showMenu = showMenu;
    }

    

  public void addEvent(EvenMenuSelected event) {
        this.event = event;
    }
 
 

    
      private final MigLayout layout;
    private EvenMenuSelected event;
    private EventShowPopupMenu eventShowPopup;
    private boolean enableMenu = true;
    private boolean showMenu = true;
    
    public menu() {
        initComponents();
        setOpaque(false);
        sp.getViewport().setOpaque(false);
        sp.setVerticalScrollBar(new ScrollBarCustom());
       layout = new MigLayout("wrap, fillx, insets 0", "[fill]", "[]0[]");        
       Panel1.setLayout(layout);
    }
    private void addMenu(ModelMenu menu) {
        Panel1.add(new MenuItem(menu, getEventMenu(), event, Panel1.getComponentCount()), "h 40!");
    }
     public void initMenuItem() {
         if (Auth.isManager()) {
             addMenu(new ModelMenu(new ImageIcon("src\\icon\\icon\\1.png"), "Trang Ch???"));
          addMenu(new ModelMenu(new ImageIcon("src\\icon\\icon\\12.png"), "Qu???n L?? S??ch", "S??ch", "Chi Ti???t S??ch", "Nh?? Cung C???p"));
          addMenu(new ModelMenu(new ImageIcon("src\\icon\\icon\\4.png"), "Giao D???ch", "Nh???p H??ng", "B??n H??ng", "Tr??? H??ng","?????i H??ng","H??a ????n B??n H??ng","H??a ????n Nh???p H??ng","H??a ????n Tr??? H??ng","H??a ????n ?????i H??ng"));
          addMenu(new ModelMenu(new ImageIcon("src\\icon\\icon\\10.png"), "Kh??ch H??ng", "Danh S??ch Kh??ch H??ng"));
          addMenu(new ModelMenu(new ImageIcon("src\\icon\\icon\\5.png"), "Nh??n Vi??n", "Danh S??ch Nh??n Vi??n"));
          addMenu(new ModelMenu(new ImageIcon("src\\icon\\icon\\3.png"), "Th???ng K???", "Doanh Thu", "Doanh S??? "));
          addMenu(new ModelMenu(new ImageIcon("src\\icon\\icon\\canhan.png"), "C?? Nh??n", "Th??ng Tin C?? Nh??n ", "?????i M???t Kh???u"));
          addMenu(new ModelMenu(new ImageIcon("src\\icon\\icon\\9.png"), "Khuy???n M???i"));
          addMenu(new ModelMenu(new ImageIcon("src\\icon\\icon\\18.png"), "????ng Xu???t"));
         } else {
          addMenu(new ModelMenu(new ImageIcon("src\\icon\\icon\\1.png"), "Trang Ch???"));
          addMenu(new ModelMenu(new ImageIcon("src\\icon\\icon\\12.png"), "Qu???n L?? S??ch", "S??ch", "Chi Ti???t S??ch", "Nh?? Cung C???p"));
          addMenu(new ModelMenu(new ImageIcon("src\\icon\\icon\\4.png"), "Giao D???ch", "B??n H??ng", "Tr??? H??ng","?????i H??ng","H??a ????n B??n H??ng","H??a ????n Nh???p H??ng","H??a ????n Tr??? H??ng","H??a ????n ?????i H??ng"));
          addMenu(new ModelMenu(new ImageIcon("src\\icon\\icon\\10.png"), "Kh??ch H??ng", "Danh S??ch Kh??ch H??ng"));
          addMenu(new ModelMenu(new ImageIcon("src\\icon\\icon\\3.png"), "Th???ng K??", "Doanh Thu", "Doanh S??? "));
          addMenu(new ModelMenu(new ImageIcon("src\\icon\\icon\\canhan.png"), "C?? Nh??n", "Th??ng Tin C?? Nh??n ", "?????i M???t Kh???u"));  
          addMenu(new ModelMenu(new ImageIcon("src\\icon\\icon\\18.png"), "????ng Xu???t"));
         }
          
          
        
    }

    private EvenMenu getEventMenu() {
        return new EvenMenu() {
            @Override
            public boolean menuPressed(Component com, boolean open) {
            if (enableMenu) {
                    if (isShowMenu()) {
                        if (open) {
                            new MenuAnimation(layout, com).openMenu();
                        } else {
                            new MenuAnimation(layout, com).closeMenu();
                        }
                        return true;
                    } else {
                        eventShowPopup.showPopup(com);
                    }
                }
                return false;

            }
            };
        }
public void hideallMenu() {
        for (Component com : Panel1.getComponents()) {
            MenuItem item = (MenuItem) com;
            if (item.isOpen()) {
                new MenuAnimation(layout, com, 500).closeMenu();
                item.setOpen(false);
            }
        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gra = new GradientPaint(0,0,new  Color(153,204,255), getWidth(),0,new Color(51,102,255));
       g2.setPaint(gra);
       g2.fillRect(0,0,getWidth(),getHeight());
        
        
        super.paintComponent(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sp = new javax.swing.JScrollPane();
        Panel1 = new javax.swing.JPanel();
        profile1 = new View.TrangChu.Profile();

        setBackground(new java.awt.Color(255, 255, 255));

        sp.setBorder(null);
        sp.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        Panel1.setToolTipText("");
        Panel1.setOpaque(false);

        javax.swing.GroupLayout Panel1Layout = new javax.swing.GroupLayout(Panel1);
        Panel1.setLayout(Panel1Layout);
        Panel1Layout.setHorizontalGroup(
            Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 513, Short.MAX_VALUE)
        );
        Panel1Layout.setVerticalGroup(
            Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 569, Short.MAX_VALUE)
        );

        sp.setViewportView(Panel1);

        profile1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(profile1, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(profile1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel1;
    private View.TrangChu.Profile profile1;
    private javax.swing.JScrollPane sp;
    // End of variables declaration//GEN-END:variables
}
