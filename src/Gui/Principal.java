package Gui;


import Objects.Constants;
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
    private JButton predictButton;
    private JTextField hourTextField;
    private JTextField minutesTextField;
    private JLabel licensePlateLabel;
    private JLabel yearLabel;
    private JLabel monthLabel;
    private JLabel dayLabel;
    private JLabel hourLabel;
    private JLabel minutesLabel;
    private JPanel timeSeparatorLabel;
    private JTextArea responseTextArea;


    public Principal(String title) {
        super(title);
        setTextOnCenter();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        predictButton.addActionListener(e -> {
            if (validateFields()) {
                Predictor p = new Predictor(licensePlateTextField.getText(), getConcatenatedDate(),
                        stringToInteger(hourTextField.getText()), stringToInteger(minutesTextField.getText()));
                responseTextArea.setText(p.getAvailability());
            }
        });
        yearTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                validateFieldType(evt, Constants.YEAR_LENGTH, yearTextField);
            }
        });
        monthTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                validateFieldType(e, Constants.MONTH_LENGTH, monthTextField);
            }
        });
        dayTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                validateFieldType(e, Constants.DAY_LENGTH, dayTextField);
            }
        });
        hourTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                validateFieldType(e, Constants.HOUR_LENGTH, hourTextField);
            }
        });
        minutesTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                validateFieldType(e, Constants.MINUTES_LENGTH, minutesTextField);
            }
        });
        licensePlateTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                validateFieldType(e, Constants.PLATE_NUMBER_LENGTH, licensePlateTextField);
            }
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

    private void validateFieldType(KeyEvent evt, Integer length, JTextField field) {
        if (field.getText().length() == length) {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
            evt.consume();
            Constants.showMessage(Constants.MAX_LENGTH);
        } else if (field != licensePlateTextField) {
            validateOnlyNumbers(evt);
        }
    }

    public void validateOnlyNumbers(KeyEvent evt) {
        int k = evt.getKeyChar();
        if (((k >= 48) && (k <= 57))) {

        } else if ((k == 8) || (k == 127)) {

        } else {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
            evt.consume();
            Constants.showMessage(Constants.ONLY_NUMBERS);
        }
    }

    private Boolean validateFields() {
        return validatePlateNumber() && validateYear() && validateMonth() && validateDay()
                && validateHour() && validateMinutes();
    }

    private Boolean validatePlateNumber() {
        String text = licensePlateTextField.getText();
        if (validateEmptyFields(text, Constants.PLATE_TYPE)) {
            text = text.replace('-', '0');
            licensePlateTextField.setText(text);
            for (int i = 0; i < text.length(); i++) {
                char c = text.charAt(i);
                if (i <= 2 && !(Character.isLetter(c))) {
                    Constants.showMessage(Constants.PLATE_NOT_VALID);
                    return false;
                } else if ((Character.isLetter(c)) && i > 2) {
                    Constants.showMessage(Constants.PLATE_NOT_VALID);
                    return false;
                }
            }
        }else {
            return false;
        }
        return true;
    }

    private Boolean validateYear() {
        String text = yearTextField.getText();
        if (validateEmptyFields(text, Constants.YEAR_TYPE)) {
            try {
                Integer year = stringToInteger(text);
                if (year <= 2010) {
                    Constants.showMessage(Constants.DOESNT_EXIST);
                    return false;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                Constants.showMessage(Constants.YEAR_NOT_VALID);
                return false;
            }
        }else {
            return false;
        }
        return true;
    }

    private Boolean validateMonth() {
        String text = monthTextField.getText();
        if (validateEmptyFields(text, Constants.MONTH_TYPE)) {
            try {
                Integer month = stringToInteger(text);
                if (month == 0 || month > 12) {
                    Constants.showMessage(Constants.MONTH_NOT_VALID);
                    return false;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                Constants.showMessage(Constants.MONTH_NOT_VALID);
                return false;
            }
        }else {
            return false;
        }
        return true;
    }

    private Boolean validateDay() {
        String text = dayTextField.getText();
        if (validateEmptyFields(text, Constants.DAY_TYPE)) {
            try {
                Integer day = stringToInteger(text);
                if (day == 0 || day > 31) {
                    Constants.showMessage(Constants.DAY_NOT_VALID);
                    return false;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                Constants.showMessage(Constants.DAY_NOT_VALID);
                return false;
            }
        }else {
            return false;
        }
        return true;
    }

    private Boolean validateHour() {
        String text = hourTextField.getText();
        if (validateEmptyFields(text, Constants.HOUR_TYPE)) {
            try {
                Integer hour = stringToInteger(text);
                if (hour == 0 || hour > 24) {
                    Constants.showMessage(Constants.HOUR_NOT_VALID);
                    return false;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                Constants.showMessage(Constants.HOUR_NOT_VALID);
                return false;
            }
        }else {
            return false;
        }
        return true;
    }

    private Boolean validateMinutes() {
        String text = minutesTextField.getText();
        if (validateEmptyFields(text, Constants.MINUTES_TYPE)) {
            try {
                Integer minute = stringToInteger(text);
                if (minute > 60) {
                    Constants.showMessage(Constants.MINUTES_NOT_VALID);
                    return false;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                Constants.showMessage(Constants.MINUTES_NOT_VALID);
                return false;
            }
        }else {
            return false;
        }
        return true;
    }


    private Boolean validateEmptyFields(String field, String type) {
        if (field.isEmpty()) {
            JOptionPane.showMessageDialog(null, Constants.REQUIRED_FIELD + type);
            return false;
        } else {
            return true;
        }
    }

    private void setTextOnCenter(){
        licensePlateTextField.setHorizontalAlignment(SwingConstants.CENTER);
        yearTextField.setHorizontalAlignment(SwingConstants.CENTER);
        monthTextField.setHorizontalAlignment(SwingConstants.CENTER);
        dayTextField.setHorizontalAlignment(SwingConstants.CENTER);
        hourTextField.setHorizontalAlignment(SwingConstants.CENTER);
        minutesTextField.setHorizontalAlignment(SwingConstants.CENTER);
        responseTextArea.setEditable(false);
    }
}
