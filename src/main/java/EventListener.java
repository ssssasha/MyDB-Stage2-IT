import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class EventListener implements ActionListener {
    private int buttonNumber;
    private JTextField name;
    private Database db;
    private String min;
    private String max;

    public EventListener(){

    }
    public EventListener(int number, Database db) {
        buttonNumber = number;
        this.db = db;
    }

    public EventListener(int number, Database db, JTextField name) {
        buttonNumber = number;
        this.db = db;
        this.name= name;
    }

    public int getButtonNumber() {
        return buttonNumber;
    }

//
//    public EventListener(int number, JTextField name, String min, String max) {
//        buttonNumber = number;
//        this.name= name;
//        this.min = min;
//        this.max = max;
//    }

    @Override // не обов'язково, вказуємо, що ми перевизначаємо метод actionPerformed
    public void actionPerformed(ActionEvent event) {
        // Виводимо повідомлення у діалоговому вікні, яку кнопку натиснуто
//        if (buttonNumber == 1) JOptionPane.showMessageDialog(new JFrame(), "Ви натиснули кнопку 1");
//        else JOptionPane.showMessageDialog(new JFrame(), "Ви натиснули кнопку 2");
//        if(buttonNumber == 1){
//            db = Database.crateDatabase(UIFrame.dbname.getText());
//        }
        if(buttonNumber==2){
            String tableName=name.getText();
            Table table1 = db.CreateTable(new Table(tableName));
            JFrame f = new JFrame();// створити фрейм
            f.setTitle("Database creation");
            f.setBounds(300, 90, 900, 600);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setLayout(null);

            JLabel columnName = new JLabel("Column name");
            columnName.setFont(new Font("Arial", Font.PLAIN, 20));
            columnName.setSize(100, 20);
            columnName.setLocation(100, 100);
            f.add(columnName);

            JTextField colNameField = new JTextField();
            colNameField.setFont(new Font("Arial", Font.PLAIN, 15));
            colNameField.setSize(190, 20);
            colNameField.setLocation(200, 100);
            f.add(colNameField);

            JLabel colType = new JLabel("Column type");
            colType.setFont(new Font("Arial", Font.PLAIN, 20));
            colType.setSize(100, 20);
            colType.setLocation(100, 100);
            f.add(columnName);

            String dataTypes[] = {"Integer", "Real", "Char", "String", "$Invl"};
            JComboBox colTypeBox = new JComboBox(dataTypes);
            colTypeBox.setFont(new Font("Arial", Font.PLAIN, 15));
            colTypeBox.setSize(50, 20);
            colTypeBox.setLocation(200, 250);
            f.add(colTypeBox);
            if((String)colTypeBox.getSelectedItem()=="$Invl"){
                JFrame newF = new JFrame();// створити фрейм
                newF.setTitle("$Invl type parameters");
                newF.setBounds(300, 90, 400, 400);
                newF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                newF.setLayout(null);

                JLabel minVal = new JLabel("Min Value");
                minVal.setFont(new Font("Arial", Font.PLAIN, 20));
                minVal.setSize(100, 20);
                minVal.setLocation(100, 100);
                f.add(minVal);

                JTextField minField = new JTextField();
                minField.setFont(new Font("Arial", Font.PLAIN, 15));
                minField.setSize(190, 20);
                minField.setLocation(200, 100);
                minField.add(minField);

                JLabel maxVal = new JLabel("Max Value");
                maxVal.setFont(new Font("Arial", Font.PLAIN, 20));
                maxVal.setSize(100, 20);
                maxVal.setLocation(100, 100);
                f.add(maxVal);

                JTextField maxField = new JTextField();
                maxField.setFont(new Font("Arial", Font.PLAIN, 15));
                maxField.setSize(190, 20);
                maxField.setLocation(200, 100);
                maxField.add(maxField);

                JButton addColumn = new JButton("Add column");
                addColumn.setFont(new Font("Arial", Font.PLAIN, 15));
                addColumn.setSize(300, 20);
                addColumn.setLocation(150, 250);
                //EventListener button6Action = new EventListener(6, colNameField, minField.getText(), maxField.getText());
                //addColumn.addActionListener(button6Action);
                f.add(addColumn);
            }
            else{
                JButton addColumn = new JButton("Add column");
                addColumn.setFont(new Font("Arial", Font.PLAIN, 15));
                addColumn.setSize(300, 20);
                addColumn.setLocation(150, 250);
                //EventListener button6Action = new EventListener(6, colNameField);
                //addColumn.addActionListener(button6Action);
                f.add(addColumn);
            }
        }
    }

}
