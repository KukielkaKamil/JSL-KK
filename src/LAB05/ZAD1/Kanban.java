package LAB05.ZAD1;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;


public class Kanban extends JFrame {
    private JPanel mainPanel;
    private JButton addNewTaskButton;
    private JList toDoList;
    private JList inProgessList;
    private JList doneList;
    private JTextField textField1;
    private JButton backButton;
    private JButton closeButton;
    private static int curIndex;

    private final static DefaultListModel<Task> toDoListModel = new DefaultListModel<>();
    private final static DefaultListModel<String> inProgressListModel = new DefaultListModel<>();
    private final static DefaultListModel<String> doneListModel = new DefaultListModel<>();

    public void init(){
        toDoList.setModel(toDoListModel);
        inProgessList.setModel(inProgressListModel);
        doneList.setModel(doneListModel);



    }
    public Kanban(){
        super("Kaban");
        this.setContentPane(this.mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,400);
        init();
        addNewTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                AddTask task =new AddTask(false);
                task.setVisible(true);

            }
        });

        toDoList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if ( SwingUtilities.isRightMouseButton(e) )
                {
                    toDoList.setSelectedIndex(toDoList.locationToIndex(e.getPoint()));
                    curIndex = toDoList.getSelectedIndex();
                    JPopupMenu menu = new JPopupMenu();

                    JMenuItem deleteButton = new JMenuItem("Delete");
                    deleteButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            toDoListModel.remove(curIndex);
                        }
                    });

                    JMenuItem editButton = new JMenuItem("Edit");
                    editButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            dispose();
                            AddTask.setCurTask(toDoListModel.getElementAt(curIndex));
                            AddTask task =new AddTask(true);
                            task.setVisible(true);
                        }
                    });

                    menu.add(editButton);
                    menu.add(deleteButton);
                    menu.show(toDoList,e.getX(),e.getY());
                }
            }



        });
        toDoList.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
                toDoList.setToolTipText(toDoListModel.getElementAt(toDoList.locationToIndex(e.getPoint())).getDescription());
            }
        });
    }

    public static void main(String[] args){
        //Początkowe dane
        toDoListModel.addElement(new Task("Kolos Ekonomia","Nauczyć się na kolosa","Low","21.12.2022"));
        toDoListModel.addElement(new Task("Kolos ASD","Nauczyć się na kolosa","High","20.12.2022"));
        toDoListModel.addElement(new Task("Kolos Angielski","Czilera Utopia","Low","20.12.2022"));
        Kanban app = new Kanban();
        app.setVisible(true);

    }

    public static DefaultListModel<Task> getToDoListModel() {
        return toDoListModel;
    }

    public DefaultListModel<String> getInProgressListModel() {
        return inProgressListModel;
    }

    public DefaultListModel<String> getDoneListModel() {
        return doneListModel;
    }
    public static int getCurIndex(){
        return curIndex;
    }
}
