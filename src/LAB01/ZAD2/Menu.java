package LAB01.ZAD2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Menu extends JFrame {
    private JPanel Menu_Panel;
    private JButton Button1;
    private JButton Button2;
    private JButton Button3;

    public Menu(){
        super("NumGuesser Menu");
        this.setContentPane(this.Menu_Panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        Random rand = new Random();
        Button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int n = rand.nextInt(10);
                dispose();
                NumGuesser game = new NumGuesser(10,n);
                game.setVisible(true);
            }
        });
        Button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int n = rand.nextInt(100);
                dispose();
                NumGuesser game = new NumGuesser(100,n);
                game.setVisible(true);

            }
        });
        Button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int n = rand.nextInt(1000);
                dispose();
                NumGuesser game = new NumGuesser(1000,n);
                game.setVisible(true);
            }
        });
    }

}
