package Gui;


import Objects.Predictor;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Principal extends JFrame {

    private JPanel mainPanel;
    private JTextField yearTextField;
    private JTextField monthTextField;
    private JTextField dayTextField;
    private JTextField licensePlateTextField;
    private JLabel yearLabel;
    private JLabel monthLabel;
    private JLabel dayLabel;
    private JLabel licensePlateLabel;
    private JButton predictButton;
    private JTextField hourTextField;
    private JTextField minutesTextField;
    private JLabel hourLabel;
    private JLabel minutesLabel;
    private JPanel timeSeparatorLabel;


    public Principal(String title) {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        yearTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                char c = e.getKeyChar();

                if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE) || yearTextField.getText().length() == 7) {

                    e.consume();

                }
            }
        });
        predictButton.addActionListener(e -> {
            Predictor p = new Predictor(licensePlateTextField.getText(), getConcatenatedDate(),
                    stringToInteger(hourTextField.getText()), stringToInteger(minutesTextField.getText()));
            licensePlateLabel.setText(p.getAvailability());
        });
    }

    private String getConcatenatedDate() {
        return dayTextField.getText() + "/" + monthTextField.getText() + "/" + yearTextField.getText();
    }

    private Integer stringToInteger(String text) {
        int number = 0;
        try {
            number = Integer.parseInt(text);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return number;
    }

    public static void main(String[] args) {
        JFrame frame = new Principal("Pico y Placa predictor");
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
