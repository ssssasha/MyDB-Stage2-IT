import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class EventListener implements ActionListener {
    private JFrame frame;
    private JLabel name;
    private Container container;
    private JLabel title;
    private JTextField tname;
    private JLabel mno;
    private JButton addColumn;

    private int buttonNumber;
    private String dbName;

    public EventListener(int number) {
        buttonNumber = number;
    }

    public EventListener(int number, String name) {
        buttonNumber = number;
        dbName= name;
    }

    @Override // не обов'язково, вказуємо, що ми перевизначаємо метод actionPerformed
    public void actionPerformed(ActionEvent event) {
        // Виводимо повідомлення у діалоговому вікні, яку кнопку натиснуто
//        if (buttonNumber == 1) JOptionPane.showMessageDialog(new JFrame(), "Ви натиснули кнопку 1");
//        else JOptionPane.showMessageDialog(new JFrame(), "Ви натиснули кнопку 2");
        if(buttonNumber == 1){
            Database db1 = Database.crateDatabase(dbName);
//            frame = new JFrame();// створити фрейм
//            frame.setTitle("Database creation");
//            frame.setBounds(300, 90, 900, 600);
//            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            frame.setVisible(true);
//            container = frame.getContentPane();
//            container.setLayout(null);
//
//
//            title = new JLabel("Database creation");
//            title.setFont(new Font("Arial", Font.PLAIN, 30));
//            title.setSize(300, 30);
//            title.setLocation(200, 30);
//            title.setVisible(true);
//            container.add(title);
//
//            name = new JLabel("Database name");
//            name.setFont(new Font("Arial", Font.PLAIN, 20));
//            name.setSize(100, 20);
//            name.setLocation(100, 100);
//            container.add(name);
//
//            tname = new JTextField();
//            tname.setFont(new Font("Arial", Font.PLAIN, 15));
//            tname.setSize(190, 20);
//            tname.setLocation(200, 100);
//            container.add(tname);
//
//            addColumn = new JButton("Add column");
//            addColumn.setFont(new Font("Arial", Font.PLAIN, 15));
//            addColumn.setSize(300, 20);
//            addColumn.setLocation(150, 250);
//            EventListener button2Action = new EventListener(2);
//            addColumn.addActionListener(button2Action);
//            container.add(addColumn);
        }
        if(buttonNumber==2){

        }
    }

}
