package LAB01.ZAD2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumGuesser extends JFrame {
    private JPanel Main_Panel;
    private JTextField GuessField;
    private JButton guessButton;
    private JButton goBackButton;
    private JLabel Hint;
    private JLabel Title;

    public NumGuesser(int level, int number){
        super("NumGuesser");
        this.setContentPane(this.Main_Panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Title.setText("I have chosen one number from 1-"+level+". Guess what it is?");
        this.pack();
        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int guess;
                try {
                    guess=Integer.parseInt(GuessField.getText());

                    if(guess<number){
                        Hint.setText("That number is too small");
                        Hint.setForeground(Color.RED);
                    }else if(guess>number){
                        Hint.setText("That number is too high");
                        Hint.setForeground(Color.BLUE);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "You have guessed the number");
                        Menu menu = new Menu();
                        menu.setVisible(true);
                        dispose();
                    }
                }catch(NumberFormatException err){
                    JOptionPane.showMessageDialog(null, "Please enter a number!");
                }

            }
        });
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu menu = new Menu();
                menu.setVisible(true);
                dispose();
            }
        });
    }
}
