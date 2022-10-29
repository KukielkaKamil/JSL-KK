package LAB02.ZAD1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasswdChecker extends JFrame {
    private JPanel MainPanel;
    private JButton OKButton;
    private JPasswordField enterPassword;
    private JPasswordField confirmPassword;

    public static void main(String[] args){
        PasswdChecker window = new PasswdChecker();
        window.setVisible(true);
    }


    public PasswdChecker(){
        super("Password Checker");
        this.setContentPane(this.MainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300,200);
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String enter = new String(enterPassword.getPassword());
                String confirm = new String(confirmPassword.getPassword());
                if(!enter.equals(confirm)){
                    JOptionPane.showMessageDialog(null,"Passwords are not matched!");
                }else{
                    if(enter.equals("codejava")){
                        JOptionPane.showMessageDialog(null,"Congratulations! You entered correct password.");
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Wrong password!");
                    }
                }
            }
        });
    }
}
