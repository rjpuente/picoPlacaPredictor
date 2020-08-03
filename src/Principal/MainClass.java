package Principal;

import Gui.Principal;

import javax.swing.*;

public class MainClass {

    public static void main(String[] args) {
        JFrame frame = new Principal("Pico y Placa predictor");
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
