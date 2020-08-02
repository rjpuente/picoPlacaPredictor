package Gui;

import objetos.Predictor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Menu extends JFrame {
    private JPanel mainPanel;
    private JTextField yearTextField;
    private JLabel yearLabel;
    private JTextField monthTextField;
    private JLabel monthLabel;
    private JTextField dayTextField;
    private JLabel dayLabel;
    private JTextField licensePlatetextField;
    private JLabel placaLabel;
    private JButton predictButton;


    public Menu(String title) {
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
        predictButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Predictor p = new Predictor(licensePlatetextField.getText(), "", "", "");
            }
        });
    }


    public static void main(String[] args) {
        JFrame frame = new Menu("Pico y Placa predictor");
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
