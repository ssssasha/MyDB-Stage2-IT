import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UIFrame extends JFrame {

    public static void main(String[] args)
    {
        JFrame frame = new JFrame();// створити фрейм
        frame.setTitle("My Database");
        frame.setBounds(300, 90, 900, 600);
        //frame.setSize(600, 500);         // задаємо ширину і висоту фрейму
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // задаємо дії при закритті фрейму
        frame.setVisible(true); 		// показати фрейм на екрані (зробити видимим)
        //JPanel panel = new JPanel();            // створюємо панель
        //frame.add(panel);// додаємо панель у фрейм
        //Container container = frame.getContentPane();
        frame.setLayout(null);

        JLabel title = new JLabel("My Database");
        title.setFont(new Font("Arial", Font.PLAIN, 20));
        title.setSize(300, 20);
        title.setLocation(400, 30);
        title.setVisible(true);
        frame.add(title);

        //create database
        JLabel name = new JLabel("Database name");
        name.setFont(new Font("Arial", Font.PLAIN, 20));
        name.setSize(200, 20);
        name.setLocation(100, 100);
        frame.add(name);

        JTextField dbname = new JTextField();
        dbname.setFont(new Font("Arial", Font.PLAIN, 15));
        dbname.setSize(150, 20);
        dbname.setLocation(250, 100);
        frame.add(dbname);

        JButton createDbBtn = new JButton("Create Database");
        createDbBtn.setFont(new Font("Arial", Font.PLAIN, 15));
        createDbBtn.setSize(300, 20);
        createDbBtn.setLocation(100, 150);
        EventListener button1Action = new EventListener(1, dbname.getText());
        createDbBtn.addActionListener(button1Action);
        frame.add(createDbBtn);

        //create table
        JLabel tableName = new JLabel("Table name");
        tableName.setVisible(true);
        tableName.setFont(new Font("Arial", Font.PLAIN, 20));
        tableName.setSize(300, 20);
        tableName.setLocation(100, 200);
        frame.add(tableName);

        JTextField tableNameField = new JTextField();
        tableNameField.setVisible(true);
        tableNameField.setFont(new Font("Arial", Font.PLAIN, 15));
        tableNameField.setSize(190, 20);
        tableNameField.setLocation(210, 200);
        frame.add(tableNameField);

        JButton createTableBtn = new JButton("Create Table");
        createTableBtn.setFont(new Font("Arial", Font.PLAIN, 15));
        createTableBtn.setSize(300, 20);
        createTableBtn.setLocation(100, 250);
        EventListener button2Action = new EventListener(2);
        createTableBtn.addActionListener(button2Action);
        frame.add(createTableBtn);

        //find tables difference
        JLabel difTitle = new JLabel("Find tables diffence");
        difTitle.setVisible(true);
        difTitle.setFont(new Font("Arial", Font.PLAIN, 20));
        difTitle.setSize(350, 20);
        difTitle.setLocation(150, 300);
        frame.add(difTitle);

        JLabel difTableName1 = new JLabel("Table 1");
        difTableName1.setVisible(true);
        difTableName1.setFont(new Font("Arial", Font.PLAIN, 20));
        difTableName1.setSize(300, 20);
        difTableName1.setLocation(100, 350);
        frame.add(difTableName1);

        JTextField difTableNameField1 = new JTextField();
        difTableNameField1.setVisible(true);
        difTableNameField1.setFont(new Font("Arial", Font.PLAIN, 15));
        difTableNameField1.setSize(190, 20);
        difTableNameField1.setLocation(210, 350);
        frame.add(difTableNameField1);

        JLabel difTableName2 = new JLabel("Table 2");
        difTableName2.setVisible(true);
        difTableName2.setFont(new Font("Arial", Font.PLAIN, 20));
        difTableName2.setSize(300, 20);
        difTableName2.setLocation(100, 400);
        frame.add(difTableName2);

        JTextField difTableNameField2 = new JTextField();
        difTableNameField2.setVisible(true);
        difTableNameField2.setFont(new Font("Arial", Font.PLAIN, 15));
        difTableNameField2.setSize(190, 20);
        difTableNameField2.setLocation(210, 400);
        frame.add(difTableNameField2);

        JButton findDifBtn = new JButton("Find difference");
        findDifBtn.setFont(new Font("Arial", Font.PLAIN, 15));
        findDifBtn.setSize(300, 20);
        findDifBtn.setLocation(100, 450);
        EventListener button3Action = new EventListener(3);
        findDifBtn.addActionListener(button3Action);
        frame.add(findDifBtn);


    }

}
