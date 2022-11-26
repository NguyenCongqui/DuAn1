/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package DateNgayThangNam;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author ADMIN
 */
public class DateChooser extends javax.swing.JPanel {

    public JTextField getTextRefernce() {
        return textRefernce;
    }

    private JTextField textRefernce;
    private final String MONTH_ENGLISH[] = {"Tháng 1", "Tháng 2", "Tháng 3", "Tháng 4", "Tháng 5", "Tháng 6", "Tháng7", "Tháng 8", "Tháng 9", "Tháng 10", "Tháng 11", "Tháng 12"};
    private String dateFormat = "dd-MM-yyyy";
    private int MONTH = 1;
    private int YEAR = 2022;
    private int DAY = 1;
    private int STATUS = 1;   //  1 is day    2 is month  3 is year
    private int startYear;
    private SelectedDate selectedDate = new SelectedDate();
    public DateChooser() {
        initComponents();
        execute();
    }
    private void execute() {
        setForeground(new Color(204, 93, 93));
        popup.add(this);
        toDay();
        
    }

    public void setTextRefernce(JTextField txt) {
        this.textRefernce = txt;
        this.textRefernce.setEditable(false);
        this.textRefernce.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                if (textRefernce.isEnabled()) {
                    showPopup();
                }
            }
        });
        setText();
    }
    private void setText() {
        if (textRefernce != null) {
            try {
                SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                Date date = df.parse(DAY + "-" + MONTH + "-" + YEAR);
                textRefernce.setText(new SimpleDateFormat(dateFormat).format(date));
            } catch (ParseException e) {
                System.err.println(e);
            }
        }
    }

    private Event getEventDay(DateFormNgay dates) {
        return (MouseEvent evt, int num) -> {
            dates.clearSelected();
            dates.setSelected(num);
            DAY = num;
            selectedDate.setNgay(DAY);
            selectedDate.setThang(MONTH);
            selectedDate.setNam(YEAR);
            setText();
            if (evt != null && evt.getClickCount() == 2 && SwingUtilities.isLeftMouseButton(evt)) {
                popup.setVisible(false);
            }
        };
    }

    private Event getEventMonth() {
        return (MouseEvent evt, int num) -> {
            MONTH = num;
            selectedDate.setNgay(DAY);
            selectedDate.setThang(MONTH);
            selectedDate.setNam(YEAR);
            setText();
            DateFormNgay d = new DateFormNgay();
            d.setForeground(getForeground());
            d.setEvent(getEventDay(d));
            d.showDate(MONTH, YEAR, selectedDate);
            if (slides.slideToDown(d)) {
                cmdMonth.setText(MONTH_ENGLISH[MONTH - 1]);
                cmdYear.setText(YEAR + "");
                STATUS = 1;
            }
        };
    }

    private Event getEventYear() {
        return (MouseEvent evt, int num) -> {
            YEAR = num;
            selectedDate.setNgay(DAY);
            selectedDate.setThang(MONTH);
            selectedDate.setNam(YEAR);
            setText();
            Months d = new Months();
            d.setEvent(getEventMonth());
            if (slides.slideToDown(d)) {
                 cmdMonth.setText(MONTH_ENGLISH[MONTH - 1]);
                cmdYear.setText(YEAR + "");
                STATUS = 2;
            }
        };
    }

    public void toDay() {
        DateFormNgay dates = new DateFormNgay();
        dates.setForeground(getForeground());
        dates.setEvent(getEventDay(dates));
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        String toDay = df.format(date);
        DAY = Integer.valueOf(toDay.split("-")[0]);
        MONTH = Integer.valueOf(toDay.split("-")[1]);
        YEAR = Integer.valueOf(toDay.split("-")[2]);
        selectedDate.setNgay(DAY);
        selectedDate.setThang(MONTH);
        selectedDate.setNam(YEAR);
        dates.showDate(MONTH, YEAR, selectedDate);
        slides.slideNon(dates);
         cmdMonth.setText(MONTH_ENGLISH[MONTH - 1]);
        cmdYear.setText(YEAR + "");
        setText();
    }
    private void setDateNext() {
        DateFormNgay dates = new DateFormNgay();
        dates.setForeground(getForeground());
        dates.setEvent(getEventDay(dates));
        dates.showDate(MONTH, YEAR, selectedDate);
        if (slides.slideToLeft(dates)) {
            cmdMonth.setText(MONTH_ENGLISH[MONTH - 1]);
            cmdYear.setText(YEAR + "");
        }
    }

    private void setDateBack() {
       DateFormNgay dates = new DateFormNgay();
        dates.setForeground(getForeground());
        dates.setEvent(getEventDay(dates));
        dates.showDate(MONTH, YEAR, selectedDate);
        if (slides.slideToRight(dates)) {
            cmdMonth.setText(MONTH_ENGLISH[MONTH - 1]);
            cmdYear.setText(YEAR + "");
        }
    }

    private void setYearNext() {
        Years years = new Years();
        years.setEvent(getEventYear());
        startYear = years.next(startYear);
        slides.slideToLeft(years);
    }

    private void setYearBack() {
        if (startYear >= 1000) {
            Years years = new Years();
            years.setEvent(getEventYear());
            startYear = years.back(startYear);
            slides.slideToLeft(years);
        }
    }

    public void showPopup(Component com, int x, int y) {
        popup.show(com, x, y);
    }

    public void showPopup() {
        popup.show(textRefernce, 0, textRefernce.getHeight());
    }
    private void cmdPreviousActionPerformed(java.awt.event.ActionEvent evt) {                                            
        if (STATUS == 1) {   //  Date
            if (MONTH == 1) {
                MONTH = 12;
                YEAR--;
            } else {
                MONTH--;
            }
            setDateBack();
        } else if (STATUS == 3) {    //  Year
            setYearBack();
        } else {
            if (YEAR >= 1000) {
                YEAR--;
                Months months = new Months();
                months.setEvent(getEventMonth());
                slides.slideToLeft(months);
                cmdYear.setText(YEAR + "");
            }
        }
    }                                           

    private void cmdForwardActionPerformed(java.awt.event.ActionEvent evt) {                                           
        if (STATUS == 1) {   //  Date
            if (MONTH == 12) {
                MONTH = 1;
                YEAR++;
            } else {
                MONTH++;
            }
            setDateNext();
        } else if (STATUS == 3) {    //  Year
            setYearNext();
        } else {
            YEAR++;
            Months months = new Months();
            months.setEvent(getEventMonth());
            slides.slideToLeft(months);
            cmdYear.setText(YEAR + "");
        }
    }                                          

    private void cmdMonthActionPerformed(java.awt.event.ActionEvent evt) {                                         
        if (STATUS != 2) {
            STATUS = 2;
            Months months = new Months();
            months.setEvent(getEventMonth());
            slides.slideToDown(months);
        } else {
           DateFormNgay dates = new DateFormNgay();
            dates.setForeground(getForeground());
            dates.setEvent(getEventDay(dates));
            dates.showDate(MONTH, YEAR, selectedDate);
            slides.slideToDown(dates);
            STATUS = 1;
        }
    }                                        

    private void cmdYearActionPerformed(java.awt.event.ActionEvent evt) {                                        
        if (STATUS != 3) {
            STATUS = 3;
            Years years = new Years();
            years.setEvent(getEventYear());
            startYear = years.showYear(YEAR);
            slides.slideToDown(years);
        } else {
            DateFormNgay dates = new DateFormNgay();
            dates.setForeground(getForeground());
            dates.setEvent(getEventDay(dates));
            dates.showDate(MONTH, YEAR, selectedDate);
            slides.slideToDown(dates);
            STATUS = 1;
        }
    }                                       

    private void cmdPreviousKeyPressed(java.awt.event.KeyEvent evt) {                                       
        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            Component com = slides.getComponent(0);
            if (com instanceof DateFormNgay) {
                DateFormNgay d = (DateFormNgay) com;
                d.up();
            }
        } else if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            Component com = slides.getComponent(0);
            if (com instanceof DateFormNgay) {
                DateFormNgay d = (DateFormNgay) com;
                d.down();
            }
        } else if (evt.getKeyCode() == KeyEvent.VK_LEFT) {
            Component com = slides.getComponent(0);
            if (com instanceof DateFormNgay) {
                DateFormNgay d = (DateFormNgay) com;
                d.back();
            }
        } else if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
            Component com = slides.getComponent(0);
            if (com instanceof DateFormNgay) {
                DateFormNgay d =  (DateFormNgay) com;
                d.next();
            }
        }
    }                                      

    public String getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    public void setSelectedDate(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String d = df.format(date);
        DAY = Integer.valueOf(d.split("-")[0]);
        MONTH = Integer.valueOf(d.split("-")[1]);
        YEAR = Integer.valueOf(d.split("-")[2]);
        selectedDate.setNgay(DAY);
        selectedDate.setThang(MONTH);
        selectedDate.setNam(YEAR);
        DateFormNgay dates = new DateFormNgay();
        dates.setForeground(getForeground());
        dates.setEvent(getEventDay(dates));
        dates.setSelected(DAY);
        dates.showDate(MONTH, YEAR, selectedDate);
        slides.slideNon(dates);
        cmdMonth.setText(MONTH_ENGLISH[MONTH - 1]);
        cmdYear.setText(YEAR + "");
        setText();
        STATUS = 1;
    }
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popup = new javax.swing.JPopupMenu();
        header = new javax.swing.JPanel();
        cmdForward = new DateNgayThangNam.Button();
        MY = new javax.swing.JLayeredPane();
        cmdMonth = new DateNgayThangNam.Button();
        lb = new javax.swing.JLabel();
        cmdYear = new DateNgayThangNam.Button();
        cmdPrevious = new DateNgayThangNam.Button();
        slides = new DateNgayThangNam.Slider();

        header.setBackground(new java.awt.Color(204, 93, 93));

        cmdForward.setBackground(new java.awt.Color(204, 93, 93));
        cmdForward.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DateNgayThangNam/forward.png"))); // NOI18N

        MY.setLayout(new java.awt.FlowLayout());

        cmdMonth.setBackground(new java.awt.Color(204, 93, 93));
        cmdMonth.setForeground(new java.awt.Color(255, 255, 255));
        cmdMonth.setText("Tháng");
        cmdMonth.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        MY.add(cmdMonth);

        lb.setBackground(new java.awt.Color(255, 255, 255));
        lb.setForeground(new java.awt.Color(255, 255, 255));
        lb.setText("-");
        MY.add(lb);

        cmdYear.setBackground(new java.awt.Color(204, 93, 93));
        cmdYear.setForeground(new java.awt.Color(255, 255, 255));
        cmdYear.setText("2020");
        cmdYear.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        MY.add(cmdYear);

        cmdPrevious.setBackground(new java.awt.Color(204, 93, 93));
        cmdPrevious.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DateNgayThangNam/previous.png"))); // NOI18N

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmdPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(MY, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmdForward, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(headerLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cmdPrevious, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(headerLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(MY))
                    .addGroup(headerLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cmdForward, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(184, 184, 184))
        );

        slides.setLayout(new javax.swing.BoxLayout(slides, javax.swing.BoxLayout.LINE_AXIS));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(slides, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(slides, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane MY;
    private DateNgayThangNam.Button cmdForward;
    private DateNgayThangNam.Button cmdMonth;
    private DateNgayThangNam.Button cmdPrevious;
    private DateNgayThangNam.Button cmdYear;
    private javax.swing.JPanel header;
    private javax.swing.JLabel lb;
    private javax.swing.JPopupMenu popup;
    private DateNgayThangNam.Slider slides;
    // End of variables declaration//GEN-END:variables
public SelectedDate getSelectedDate() {
        return selectedDate;
    }

    public void setSelectedDate(SelectedDate selectedDate) {
        this.selectedDate = selectedDate;
        DAY = selectedDate.getNgay();
        MONTH = selectedDate.getThang();
        YEAR = selectedDate.getNam();
        DateFormNgay dates = new DateFormNgay();
        dates.setForeground(getForeground());
        dates.setEvent(getEventDay(dates));
        dates.setSelected(DAY);
        dates.showDate(MONTH, YEAR, selectedDate);
        slides.slideNon(dates);
        cmdMonth.setText(MONTH_ENGLISH[MONTH - 1]);
        cmdYear.setText(YEAR + "");
        setText();
        STATUS = 1;
    }

    @Override
    public void setForeground(Color color) {
        super.setForeground(color);
        if (header != null) {
            header.setBackground(color);
            toDay();
        }
    }
}
