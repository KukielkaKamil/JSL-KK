package LAB05.ZAD1;

import datechooser.beans.DateChooserCombo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class AddTask extends JFrame {
    private JTextField titleTextField;
    private JButton saveButton;
    private JComboBox priorityBox;
    private JPanel mainPanel;
    private JLabel header;
    private DateChooserCombo dateChooser;
    private JTextArea descriptionTextArea;

    private String operation;
    private static Task curTask;

    public AddTask(boolean edit) {
        super("Task");
        operation = (edit) ? "Edit" : "Add";
        this.setTitle(operation + " task");
        header.setText(operation + " task");
        this.setContentPane(this.mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 400);
        if(edit){
            titleTextField.setText(curTask.getTitle());
            descriptionTextArea.setText(curTask.getDescription());
            if(curTask.getPriority().equals("Low")) {
                priorityBox.setSelectedIndex(0);
            }
            else{
                priorityBox.setSelectedIndex(1);
            }
            SimpleDateFormat formater = new SimpleDateFormat("dd.mm.yyyy");
            Date date = formater.parse(curTask.getExpDate(),new ParsePosition(0));
            Calendar caldate = Calendar.getInstance();
            caldate.setTime(date);
            dateChooser.setSelectedDate(caldate);


            System.out.println(dateChooser.setText(curTask.getExpDate()));
        }

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                if(edit){
                    curTask.setTitle(titleTextField.getText());
                    curTask.setDescription(descriptionTextArea.getText());
                    curTask.setPriority(priorityBox.getSelectedItem().toString());
                    curTask.setExpDate(dateChooser.getText());
                    Kanban.getToDoListModel().set(Kanban.getCurIndex(),curTask);
                }
                else{
                    String title = titleTextField.getText();
                    String description = descriptionTextArea.getText();
                    String priority = priorityBox.getSelectedItem().toString();
                    System.out.println(priority);
                    String date = dateChooser.getText();
                    System.out.println(dateChooser.getText());
                    Kanban.getToDoListModel().addElement(new Task(title, description, priority, date));
                }


                dispose();
                Kanban kanban = new Kanban();
                kanban.setVisible(true);
            }
        });
    }

    public static void setCurTask(Task task) {
        curTask = task;
    }
}
