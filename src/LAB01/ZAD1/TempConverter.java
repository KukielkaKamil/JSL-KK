package LAB01.ZAD1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TempConverter extends JFrame {
    private JTextField textField;
    private JButton convertButton;
    private JButton closeButton;
    private JPanel Main_Panel;
    private JLabel Result;
    private double temperature;

    public static void main(String[] Args) {
        TempConverter converter = new TempConverter();
        converter.setVisible(true);

    }


    public TempConverter() {
        super("Temp Converter");
        this.setContentPane(this.Main_Panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    temperature = Double.parseDouble(textField.getText()) * 9 / 5 + 32;
                } catch (NumberFormatException err) {
                    JOptionPane.showMessageDialog(null, "Please enter a number!");
                }
                Result.setText("Temperature in Fahrenheit: " + temperature + " F");

            }
        });
    }
}
