package DateNgayThangNam;

import javax.swing.JButton;

public final class Years extends javax.swing.JPanel {

    private Event event;
    private int startYear;

    public Years() {
        initComponents();
    }

    public int showYear(int year) {
        year = calculateYear(year);
        for (int i = 0; i < getComponentCount(); i++) {
            JButton cmd = (JButton) getComponent(i);
            cmd.setText(year + "");
            year++;
        }
        return startYear;
    }

    private int calculateYear(int year) {
        year -= year % 10;
        startYear = year;
        return year;
    }

    private void addEvent() {
        for (int i = 0; i < getComponentCount(); i++) {
            ((Button) getComponent(i)).setEvent(event);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        button1 = new DateNgayThangNam.Button();
        button2 = new DateNgayThangNam.Button();
        button3 = new DateNgayThangNam.Button();
        button4 = new DateNgayThangNam.Button();
        button5 = new DateNgayThangNam.Button();
        button6 = new DateNgayThangNam.Button();
        button7 = new DateNgayThangNam.Button();
        button8 = new DateNgayThangNam.Button();
        button9 = new DateNgayThangNam.Button();
        button10 = new DateNgayThangNam.Button();
        button11 = new DateNgayThangNam.Button();
        button12 = new DateNgayThangNam.Button();
        button13 = new DateNgayThangNam.Button();
        button14 = new DateNgayThangNam.Button();
        button15 = new DateNgayThangNam.Button();
        button16 = new DateNgayThangNam.Button();
        button17 = new DateNgayThangNam.Button();
        button18 = new DateNgayThangNam.Button();
        button19 = new DateNgayThangNam.Button();
        button20 = new DateNgayThangNam.Button();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.GridLayout(5, 4));

        button1.setText("2010");
        add(button1);

        button2.setText("2011");
        add(button2);

        button3.setText("2012");
        add(button3);

        button4.setText("2013");
        add(button4);

        button5.setText("2014");
        add(button5);

        button6.setText("2015");
        add(button6);

        button7.setText("2016");
        add(button7);

        button8.setText("2017");
        add(button8);

        button9.setText("2018");
        add(button9);

        button10.setText("2019");
        add(button10);

        button11.setText("2020");
        add(button11);

        button12.setText("2021");
        add(button12);

        button13.setText("2022");
        add(button13);

        button14.setText("2023");
        add(button14);

        button15.setText("2024");
        add(button15);

        button16.setText("2025");
        add(button16);

        button17.setText("2026");
        add(button17);

        button18.setText("2027");
        add(button18);

        button19.setText("2028");
        add(button19);

        button20.setText("2029");
        add(button20);
    }// </editor-fold>//GEN-END:initComponents

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
        addEvent();
    }

    public int next(int year) {
        showYear(year + 20);
        return startYear;
    }

    public int back(int year) {
        showYear(year - 20);
        return startYear;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private DateNgayThangNam.Button button1;
    private DateNgayThangNam.Button button10;
    private DateNgayThangNam.Button button11;
    private DateNgayThangNam.Button button12;
    private DateNgayThangNam.Button button13;
    private DateNgayThangNam.Button button14;
    private DateNgayThangNam.Button button15;
    private DateNgayThangNam.Button button16;
    private DateNgayThangNam.Button button17;
    private DateNgayThangNam.Button button18;
    private DateNgayThangNam.Button button19;
    private DateNgayThangNam.Button button2;
    private DateNgayThangNam.Button button20;
    private DateNgayThangNam.Button button3;
    private DateNgayThangNam.Button button4;
    private DateNgayThangNam.Button button5;
    private DateNgayThangNam.Button button6;
    private DateNgayThangNam.Button button7;
    private DateNgayThangNam.Button button8;
    private DateNgayThangNam.Button button9;
    // End of variables declaration//GEN-END:variables

}
