package DateNgayThangNam;

public final class Months extends javax.swing.JPanel {

    private Event event;
    private int m;

    public Months() {
        initComponents();
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
        button5 = new DateNgayThangNam.Button();
        button4 = new DateNgayThangNam.Button();
        button6 = new DateNgayThangNam.Button();
        button7 = new DateNgayThangNam.Button();
        button8 = new DateNgayThangNam.Button();
        button9 = new DateNgayThangNam.Button();
        button10 = new DateNgayThangNam.Button();
        button11 = new DateNgayThangNam.Button();
        button12 = new DateNgayThangNam.Button();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.GridLayout(4, 4));

        button1.setText("Tháng 1");
        add(button1);

        button2.setText("Tháng 2");
        add(button2);

        button3.setText("Tháng 3");
        add(button3);

        button5.setText("Tháng 4");
        add(button5);

        button4.setText("Tháng 5");
        add(button4);

        button6.setText("Tháng 6");
        add(button6);

        button7.setText("Tháng 7");
        add(button7);

        button8.setText("Tháng 8");
        add(button8);

        button9.setText("Tháng 9");
        add(button9);

        button10.setText("Tháng 10");
        add(button10);

        button11.setText("Tháng 11");
        add(button11);

        button12.setText("Tháng 12");
        add(button12);
    }// </editor-fold>//GEN-END:initComponents

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
        addEvent();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private DateNgayThangNam.Button button1;
    private DateNgayThangNam.Button button10;
    private DateNgayThangNam.Button button11;
    private DateNgayThangNam.Button button12;
    private DateNgayThangNam.Button button2;
    private DateNgayThangNam.Button button3;
    private DateNgayThangNam.Button button4;
    private DateNgayThangNam.Button button5;
    private DateNgayThangNam.Button button6;
    private DateNgayThangNam.Button button7;
    private DateNgayThangNam.Button button8;
    private DateNgayThangNam.Button button9;
    // End of variables declaration//GEN-END:variables

}
