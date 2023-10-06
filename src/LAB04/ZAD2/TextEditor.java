package LAB04.ZAD2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextEditor extends JFrame {
    private JComboBox comboBox1;
    private JEditorPane editorPane1;
    private JButton boldButton;
    private JButton smallFontButton;
    private JButton italicButton;
    private JButton bigFontButton;
    private JPanel mainPanel;

    boolean isBold, isItalic =false;
    int fontSize;
    String defaultFont;

    public TextEditor(){
        super("Text Editor");
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300,400);
        //editorPane1.setBackground(Color.GRAY);
        fontSize=editorPane1.getFont().getSize();
        defaultFont= editorPane1.getFont().getFontName();
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = comboBox1.getSelectedIndex();
                String color = comboBox1.getItemAt(index).toString();

                switch (color){
                    case "Czarny":
                        editorPane1.setForeground(Color.BLACK);
                        break;
                    case "Zielony":
                        editorPane1.setForeground(Color.GREEN);
                        break;
                    case "Niebieski":
                        editorPane1.setForeground(Color.BLUE);
                        break;
                    case "Żółty":
                        editorPane1.setForeground(Color.YELLOW);
                        break;
                    case "Szary":
                        editorPane1.setForeground(Color.DARK_GRAY);
                        break;
                    case "Fioletowy":
                        editorPane1.setForeground(new Color(125, 0,255));
                        break;

                }
            }
        });
        boldButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isBold){
                    editorPane1.setFont(new Font(defaultFont,Font.PLAIN,fontSize));
                }else{
                    editorPane1.setFont(new Font(defaultFont,Font.BOLD,fontSize));
                    isItalic=false;
                }
                isBold=!isBold;
            }
        });
        italicButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isItalic){
                    editorPane1.setFont(new Font(defaultFont,Font.PLAIN,fontSize));
                }else{
                    editorPane1.setFont(new Font(defaultFont,Font.ITALIC,fontSize));
                    isBold=false;
                }
                isItalic=!isItalic;
            }
        });
        smallFontButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fontSize-=2;
                editorPane1.setFont(new Font(defaultFont,editorPane1.getFont().getStyle(),fontSize));
            }
        });
        bigFontButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fontSize+=2;
                editorPane1.setFont(new Font(defaultFont,editorPane1.getFont().getStyle(),fontSize));
            }
        });
    }

    public static void main(String[] args){
        TextEditor app = new TextEditor();
        app.setVisible(true);
    }
}
