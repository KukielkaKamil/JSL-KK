package LAB03.ZAD1;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;


public class Contacts extends JFrame {
    private JList contactsList;
    private JTextField nameField;
    private JTextField emailField;
    private JTextField phoneField;
    private JTextField addressField;
    private JPanel mainPanel;
    private JTextField dateField;
    private JButton saveNewButton;
    private JButton saveExistingButton;
    private JLabel ageLabel;

    private static ArrayList<Person> contacts = new ArrayList<>();
    private static DefaultListModel<String> list = new DefaultListModel<>();

    public static void main(String[] args){
        Contacts app = new Contacts();
        app.setVisible(true);
        initList();
    }

    public Contacts(){
       super("App");
       this.setContentPane(mainPanel);
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setSize(450,400);
       contactsList.setModel(list);
        saveNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addContact();
            }
        });
        contactsList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                try {
                    int index = contactsList.getSelectedIndex();
                    nameField.setText(contacts.get(index).getName());
                    emailField.setText(contacts.get(index).getEmail());
                    phoneField.setText(Integer.toString(contacts.get(index).getNumber()));
                    addressField.setText(contacts.get(index).getAdress());
                    dateField.setText(contacts.get(index).getDateofbirth().toString());
                    ageLabel.setText(Integer.toString(Period.between(contacts.get(index).getDateofbirth(), LocalDate.now()).getYears()) + " years");
                    saveExistingButton.setEnabled(true);
                }catch (IndexOutOfBoundsException indexException){
                    clearFrom();
                }
            }
        });
        saveExistingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(nameField.getText().equals("")) throw new EmptyStringException();
                    if(emailField.getText().equals("")) throw new EmptyStringException();
                    if(addressField.getText().equals("")) throw new EmptyStringException();
                    int index = contactsList.getSelectedIndex();
                    contacts.get(index).setName(nameField.getText());
                    contacts.get(index).setEmail(emailField.getText());
                    contacts.get(index).setNumber(Integer.parseInt(phoneField.getText()));
                    contacts.get(index).setAdress(addressField.getText());
                    contacts.get(index).setDateofbirth(LocalDate.parse(dateField.getText()));
                    list.set(index,nameField.getText());
                    contactsList.setModel(list);
                    ageLabel.setText("0 years");

                }catch (DateTimeParseException dateExeption){
                    JOptionPane.showMessageDialog(null,"Podaj datę w formacie YYYY-MM-DD");
                }catch (EmptyStringException emptyString){
                    JOptionPane.showMessageDialog(null,"Uzupełnij wszystkie pola");
                }catch (NumberFormatException wrongNumber){
                    JOptionPane.showMessageDialog(null,"Uzupełnij wszystkie pola");
                }
            }
        });
    }

    public void addContact(){
        try {
            if(nameField.getText().equals("")) throw new EmptyStringException();
            if(emailField.getText().equals("")) throw new EmptyStringException();
            if(addressField.getText().equals("")) throw new EmptyStringException();

            contacts.add(new Person(
                    nameField.getText(),
                    emailField.getText(),
                    Integer.parseInt(phoneField.getText()),
                    addressField.getText(),
                    LocalDate.parse(dateField.getText())
            ));
            list.addElement(nameField.getText());
            contactsList.setModel(list);
            clearFrom();
            saveExistingButton.setEnabled(false);
            ageLabel.setText("0 years");
        }catch (DateTimeParseException dateExeption){
            JOptionPane.showMessageDialog(null,"Podaj datę w formacie YYYY-MM-DD");
        }catch (EmptyStringException emptyString){
            JOptionPane.showMessageDialog(null,"Uzupełnij wszystkie pola");
        }catch (NumberFormatException wrongNumber){
            JOptionPane.showMessageDialog(null,"Uzupełnij wszystkie pola");
        }


    }
    public static void initList(){
        Person start1 = new Person("Jan Kowalski", "tak@wp.pl", 123456789, "Warszawa", LocalDate.parse("2001-11-13"));
        Person start2 = new Person("Janusz Kowalski", "tak@wp.pl", 123456789, "Warszawa", LocalDate.parse("2001-10-23"));
        Person start3 = new Person("Robert Kowalski", "tak@wp.pl", 123456789, "Warszawa", LocalDate.parse("2001-11-14"));
        Person start4 = new Person("Adam Kowalski", "tak@wp.pl", 123456789, "Warszawa", LocalDate.parse("2001-12-10"));
        contacts.add(start1);
        contacts.add(start2);
        contacts.add(start3);
        contacts.add(start4);
        list.addElement(start1.getName());
        list.addElement(start2.getName());
        list.addElement(start3.getName());
        list.addElement(start4.getName());

    }

    public void clearFrom(){
        nameField.setText("");
        emailField.setText("");
        phoneField.setText("");
        addressField.setText("");
        dateField.setText("");

    }

}
