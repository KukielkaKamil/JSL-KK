package LAB04.ZAD1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListMover extends JFrame {
    private JList list1;
    private JList list2;
    private JButton moveTo2;
    private JButton moveAllTo2;
    private JButton moveTo1;
    private JButton moveAllTo1;
    private JPanel mainPanel;

    private final DefaultListModel<String> listModel1 = new DefaultListModel<>();
    private final DefaultListModel<String> listModel2 = new DefaultListModel<>();

    public ListMover(){
        super("List mover");
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300,400);
        for(int i=0;i<list1.getModel().getSize();i++){
            listModel1.addElement(list1.getModel().getElementAt(i).toString());
        }
        list1.setModel(listModel1);
        for(int i=0;i<list2.getModel().getSize();i++){
            listModel2.addElement(list2.getModel().getElementAt(i).toString());
        }
        list2.setModel(listModel2);
        moveTo2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int index = list1.getSelectedIndex();
                    listModel2.addElement(list1.getSelectedValue().toString());
                    listModel1.remove(index);
                }catch (NullPointerException nullPointer){
                    JOptionPane.showMessageDialog(null,"Wybierz element z listy 1!");
                }
            }
        });
        moveAllTo2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i=0; i<listModel1.getSize();i++){
                    listModel2.addElement(listModel1.getElementAt(i));
                }
                listModel1.clear();
            }
        });
        moveTo1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int index = list2.getSelectedIndex();
                    listModel1.addElement(list2.getSelectedValue().toString());
                    listModel2.remove(index);
                }catch (NullPointerException nullPointer){
                    JOptionPane.showMessageDialog(null,"Wybierz element z listy 2!");
                }
            }
        });
        moveAllTo1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i=0; i<listModel2.getSize();i++){
                    listModel1.addElement(listModel2.getElementAt(i));
                }
                listModel2.clear();
            }
        });
    }

    public static void main(String[] args){
        ListMover app = new ListMover();
        app.setVisible(true);
    }
}
