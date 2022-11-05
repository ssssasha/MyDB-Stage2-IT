import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class UIFrame extends JFrame {
    private static Database db;
    private static List<Table> tables = new ArrayList<>();
    public static JTextField dbname;
    public static List<Row> differences;
    public static JTextArea resArea;

    public static void main(String[] args)
    {
        JFrame frame = new JFrame();// створити фрейм
        frame.setTitle("My Database");
        frame.setBounds(300, 90, 900, 600);
        //frame.setSize(600, 500);         // задаємо ширину і висоту фрейму
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // задаємо дії при закритті фрейму
        //frame.setVisible(true); 		// показати фрейм на екрані (зробити видимим)
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

        dbname = new JTextField();
        dbname.setFont(new Font("Arial", Font.PLAIN, 15));
        dbname.setSize(150, 20);
        dbname.setLocation(250, 100);
        frame.add(dbname);

        JButton createDbBtn = new JButton("Create Database");
        createDbBtn.setFont(new Font("Arial", Font.PLAIN, 15));
        createDbBtn.setSize(300, 20);
        createDbBtn.setLocation(100, 150);
        //Database db = Database.crateDatabase(UIFrame.dbname.getText());
        //EventListener button1Action = new EventListener(1, db);
        //createDbBtn.addActionListener(button1Action);
        frame.add(createDbBtn);
        createDbBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               db =  Database.crateDatabase(UIFrame.dbname.getText());
            }
        });
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
        //EventListener button2Action = new EventListener(2, db, tableNameField);
        //createTableBtn.addActionListener(button2Action);
        frame.add(createTableBtn);
        createTableBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tables.add(db.CreateTable(new Table(tableNameField.getText())));
                for(Table t: tables)
                    resArea.setText(t.getTableName()+"\n");
                JFrame tableFrame = new JFrame();// створити фрейм
                tableFrame.setTitle("Table creation");
                tableFrame.setBounds(300, 90, 400, 400);
                tableFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                tableFrame.setLayout(null);

                JButton addColBtn = new JButton("Add Column");
                addColBtn.setFont(new Font("Arial", Font.PLAIN, 15));
                addColBtn.setSize(150, 20);
                addColBtn.setLocation(120, 100);
                tableFrame.add(addColBtn);
                addColBtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        addColumn(tableNameField.getText());
                    }
                });
                JButton addRowBtn = new JButton("Add Row");
                addRowBtn.setFont(new Font("Arial", Font.PLAIN, 15));
                addRowBtn.setSize(150, 20);
                addRowBtn.setLocation(120, 200);
                tableFrame.add(addRowBtn);
                addRowBtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        addRow(tableNameField.getText());
                    }
                });
                tableFrame.setVisible(true);
            }
        });


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
        frame.add(findDifBtn);
        findDifBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Table table1 = null;
                Table table2 = null;
                for(Table table:tables){
                    if(table.getTableName().equalsIgnoreCase(difTableNameField1.getText())){
                        table1 = table;
                    }
                    if(table.getTableName().equalsIgnoreCase(difTableNameField2.getText())){
                        table2 = table;
                    }
                }
//                for(Table table:tables){
//                    if(table.getTableName().equalsIgnoreCase(difTableNameField2.getText())){
//                        table2 = table;
//                    }
//                }
                try {
                    differences = db.FindTableDifference(table1, table2);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                String s1 = "Table: Result table" + "\n" + table1.getColumns().get(0) + " " + table1.getColumns().get(1)
                        + " " +  table1.getColumns().get(2) +"\n";
                String s2= "";
                for(Row res : differences){
                     s2 = s2 + "  " + res.getValues()[0] + "       " + res.getValues()[1] + "        " + res.getValues()[2] + "\n";
                }
                resArea.setText(s1+s2);
            }
        });

        JButton saveDbBtn = new JButton("Save database");
        saveDbBtn.setFont(new Font("Arial", Font.PLAIN, 15));
        saveDbBtn.setSize(150, 20);
        saveDbBtn.setLocation(100, 500);
        frame.add(saveDbBtn);

        JButton showDbBtn = new JButton("Show database");
        showDbBtn.setFont(new Font("Arial", Font.PLAIN, 15));
        showDbBtn.setSize(150, 20);
        showDbBtn.setLocation(250, 500);
        showDbBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resArea.setText(showTable1(tables.get(0)) + "\n" + showTable2(tables.get(1)));
            }
        });

        frame.add(showDbBtn);


        resArea = new JTextArea();
        resArea.setFont(new Font("Arial", Font.PLAIN, 15));
        resArea.setSize(300, 400);
        resArea.setLocation(500, 100);
        resArea.setLineWrap(true);
        resArea.setEditable(false);
        frame.add(resArea);

        frame.setVisible(true);
    }

    public static void addColumn(String curTableName){
        for(Table table : tables){
            if(table.getTableName().equals(curTableName)){
                JFrame f = new JFrame();// створити фрейм
                f.setTitle("Adding columns");
                f.setBounds(300, 90, 500, 400);
                f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                f.setLayout(null);

                JLabel columnName = new JLabel("Column name");
                columnName.setFont(new Font("Arial", Font.PLAIN, 18));
                columnName.setSize(200, 20);
                columnName.setLocation(100, 100);
                f.add(columnName);

                JTextField colNameField = new JTextField();
                colNameField.setFont(new Font("Arial", Font.PLAIN, 15));
                colNameField.setSize(190, 20);
                colNameField.setLocation(260, 100);
                f.add(colNameField);

                JLabel colType = new JLabel("Column type");
                colType.setFont(new Font("Arial", Font.PLAIN, 18));
                colType.setSize(200, 20);
                colType.setLocation(100, 200);
                f.add(colType);

                String dataTypes[] = {"Integer", "Real", "Char", "String", "$Invl"};
                JComboBox colTypeBox = new JComboBox(dataTypes);
                colTypeBox.setFont(new Font("Arial", Font.PLAIN, 15));
                colTypeBox.setSize(100, 20);
                colTypeBox.setLocation(260, 200);
                f.add(colTypeBox);

                JButton addColumn = new JButton("Add column");
                addColumn.setFont(new Font("Arial", Font.PLAIN, 15));
                addColumn.setSize(200, 20);
                addColumn.setLocation(150, 250);
                //EventListener button6Action = new EventListener(6, colNameField);
                //addColumn.addActionListener(button6Action);
                f.add(addColumn);
                f.setVisible(true);
                addColumn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        if ((String) colTypeBox.getSelectedItem() == "Integer") {
                            try {
                                table.AddColumn(colNameField.getText(), DataType.INTEGER);
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }
                        if ((String) colTypeBox.getSelectedItem() == "Real") {
                            try {
                                table.AddColumn(colNameField.getText(), DataType.REAL);
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }
                        if ((String) colTypeBox.getSelectedItem() == "Char") {
                            try {
                                table.AddColumn(colNameField.getText(), DataType.CHAR);
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }
                        if ((String) colTypeBox.getSelectedItem() == "String") {
                            try {
                                table.AddColumn(colNameField.getText(), DataType.STRING);
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }
                        if ((String) colTypeBox.getSelectedItem() == "$Invl") {
                            try {
                                table.AddColumn(colNameField.getText(), DataType.$INVL);
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }
                        String def = "";
                        colNameField.setText(def);

                        if(table.getColumns().size()==3){
                            resArea.setText(tables.get(0).getColumns().get(0).getColumnName()+"\n" + tables.get(0).getColumns().get(1).getColumnName()+"\n" +
                                    tables.get(0).getColumns().get(2).getColumnName()+"\n");
                        }
                    }
                });
            }
        }
    }

    public static void addRow(String curTableName) {
        for (Table table : tables) {
            if (table.getTableName().equals(curTableName)) {
               Row row =  table.AddRow();
               row.setTable(table);
               for(int i=0; i<table.getColumns().size(); i++){
                   //String columnName = table.getColumns().get(i).getColumnName();
                   if(table.getColumns().get(i).getDataType()==(DataType.INTEGER)) {
                       String columnName = table.getColumns().get(i).getColumnName();
                       JFrame fr = new JFrame();// створити фрейм
                       fr.setTitle("Adding rows");
                       fr.setBounds(300, 90, 500, 400);
                       fr.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                       fr.setLayout(null);

                       JLabel rowValue = new JLabel("Row integer value");
                       rowValue.setFont(new Font("Arial", Font.PLAIN, 18));
                       rowValue.setSize(230, 20);
                       rowValue.setLocation(100, 100);
                       fr.add(rowValue);

                       JTextField rowValueField = new JTextField();
                       rowValueField.setFont(new Font("Arial", Font.PLAIN, 15));
                       rowValueField.setSize(190, 20);
                       rowValueField.setLocation(250, 100);
                       fr.add(rowValueField);

                       JButton setValue = new JButton("Set value");
                       setValue.setFont(new Font("Arial", Font.PLAIN, 15));
                       setValue.setSize(200, 20);
                       setValue.setLocation(150, 250);
                       fr.add(setValue);
                       setValue.addActionListener(new ActionListener() {
                           @Override
                           public void actionPerformed(ActionEvent e) {
                               try {
                                   row.setValue(columnName, rowValueField.getText());
                               } catch (Exception ex) {
                                   ex.printStackTrace();
                               }
                           }
                       });
                       fr.setVisible(true);
                   }

                   if(table.getColumns().get(i).getDataType()==DataType.REAL) {
                       String columnName = table.getColumns().get(i).getColumnName();
                       JFrame fr = new JFrame();// створити фрейм
                       fr.setTitle("Adding rows");
                       fr.setBounds(300, 90, 500, 400);
                       fr.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                       fr.setLayout(null);

                       JLabel rowValue = new JLabel("Row real value");
                       rowValue.setFont(new Font("Arial", Font.PLAIN, 18));
                       rowValue.setSize(230, 20);
                       rowValue.setLocation(100, 100);
                       fr.add(rowValue);

                       JTextField rowValueField = new JTextField();
                       rowValueField.setFont(new Font("Arial", Font.PLAIN, 15));
                       rowValueField.setSize(190, 20);
                       rowValueField.setLocation(250, 100);
                       fr.add(rowValueField);

                       JButton setValue = new JButton("Set value");
                       setValue.setFont(new Font("Arial", Font.PLAIN, 15));
                       setValue.setSize(200, 20);
                       setValue.setLocation(150, 250);
                       fr.add(setValue);
                       fr.setVisible(true);
                       setValue.addActionListener(new ActionListener() {
                           @Override
                           public void actionPerformed(ActionEvent e) {
                               try {
                                   row.setValue(columnName, rowValueField.getText());
                               } catch (Exception ex) {
                                   ex.printStackTrace();
                               }
                           }
                       });
                   }

                   if(table.getColumns().get(i).getDataType()==DataType.CHAR) {
                       String columnName = table.getColumns().get(i).getColumnName();
                       JFrame fr = new JFrame();// створити фрейм
                       fr.setTitle("Adding rows");
                       fr.setBounds(300, 90, 500, 400);
                       fr.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                       fr.setLayout(null);

                       JLabel rowValue = new JLabel("Row char value");
                       rowValue.setFont(new Font("Arial", Font.PLAIN, 18));
                       rowValue.setSize(230, 20);
                       rowValue.setLocation(100, 100);
                       fr.add(rowValue);

                       JTextField rowValueField = new JTextField();
                       rowValueField.setFont(new Font("Arial", Font.PLAIN, 15));
                       rowValueField.setSize(190, 20);
                       rowValueField.setLocation(250, 100);
                       fr.add(rowValueField);

                       JButton setValue = new JButton("Set value");
                       setValue.setFont(new Font("Arial", Font.PLAIN, 15));
                       setValue.setSize(200, 20);
                       setValue.setLocation(150, 250);
                       fr.add(setValue);
                       fr.setVisible(true);
                       setValue.addActionListener(new ActionListener() {
                           @Override
                           public void actionPerformed(ActionEvent e) {
                               try {
                                   row.setValue(columnName, rowValueField.getText());
                               } catch (Exception ex) {
                                   ex.printStackTrace();
                               }
                           }
                       });
                   }

                   if(table.getColumns().get(i).getDataType()==DataType.STRING) {
                       String columnName = table.getColumns().get(i).getColumnName();

                       JFrame fr = new JFrame();// створити фрейм
                       fr.setTitle("Adding rows");
                       fr.setBounds(300, 90, 500, 400);
                       fr.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                       fr.setLayout(null);

                       JLabel rowValue = new JLabel("Row string value");
                       rowValue.setFont(new Font("Arial", Font.PLAIN, 18));
                       rowValue.setSize(230, 20);
                       rowValue.setLocation(100, 100);
                       fr.add(rowValue);

                       JTextField rowValueField = new JTextField();
                       rowValueField.setFont(new Font("Arial", Font.PLAIN, 15));
                       rowValueField.setSize(190, 20);
                       rowValueField.setLocation(250, 100);
                       fr.add(rowValueField);

                       JButton setValue = new JButton("Set value");
                       setValue.setFont(new Font("Arial", Font.PLAIN, 15));
                       setValue.setSize(200, 20);
                       setValue.setLocation(150, 250);
                       fr.add(setValue);
                       fr.setVisible(true);
                       setValue.addActionListener(new ActionListener() {
                           @Override
                           public void actionPerformed(ActionEvent e) {
                               try {
                                   row.setValue(columnName, rowValueField.getText());
                               } catch (Exception ex) {
                                   ex.printStackTrace();
                               }
                           }
                       });
                   }

                   if(table.getColumns().get(i).getDataType()==DataType.$INVL) {
                       String columnName = table.getColumns().get(i).getColumnName();
                       JFrame fr = new JFrame();// створити фрейм
                       fr.setTitle("Adding rows");
                       fr.setBounds(300, 90, 500, 500);
                       fr.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                       fr.setLayout(null);

                       JLabel rowValue = new JLabel("Min value");
                       rowValue.setFont(new Font("Arial", Font.PLAIN, 18));
                       rowValue.setSize(200, 20);
                       rowValue.setLocation(100, 100);
                       fr.add(rowValue);

                       JTextField rowValueField = new JTextField();
                       rowValueField.setFont(new Font("Arial", Font.PLAIN, 15));
                       rowValueField.setSize(190, 20);
                       rowValueField.setLocation(210, 100);
                       fr.add(rowValueField);

                       JLabel row2Value = new JLabel("Max value");
                       row2Value.setFont(new Font("Arial", Font.PLAIN, 18));
                       row2Value.setSize(200, 20);
                       row2Value.setLocation(100, 200);
                       fr.add(row2Value);

                       JTextField row2ValueField = new JTextField();
                       row2ValueField.setFont(new Font("Arial", Font.PLAIN, 15));
                       row2ValueField.setSize(190, 20);
                       row2ValueField.setLocation(210, 200);
                       fr.add(row2ValueField);

                       JButton setValue = new JButton("Set value");
                       setValue.setFont(new Font("Arial", Font.PLAIN, 15));
                       setValue.setSize(200, 20);
                       setValue.setLocation(150, 250);
                       fr.add(setValue);
                       setValue.addActionListener(new ActionListener() {
                           @Override
                           public void actionPerformed(ActionEvent e) {
                               try {
                                   row.setValue(columnName, Double.parseDouble(rowValueField.getText()), Double.parseDouble(row2ValueField.getText()));
                               } catch (Exception ex) {
                                   ex.printStackTrace();
                               }
                           }
                       });
                       fr.setVisible(true);
                   }
               }
            }
        }
    }

    public static String showTable1(Table table){
        return ("Tables: " + " " + table.getTableName() + "\n" + table.getColumns().get(0).getColumnName() + " "
                + table.getColumns().get(1).getColumnName() + " " +  table.getColumns().get(2).getColumnName()
                + "\n " + table.getRows().get(0).getValues()[0]+ "       " + table.getRows().get(0).getValues()[1] + "        " + table.getRows().get(0).getValues()[2] + "\n "
                + table.getRows().get(1).getValues()[0] + "        " + table.getRows().get(1).getValues()[1] + "        " + table.getRows().get(1).getValues()[2]+ "\n "
                + table.getRows().get(2).getValues()[0] + "        " + table.getRows().get(2).getValues()[1] + "        " + table.getRows().get(2).getValues()[2]);
    }

    public static String showTable2(Table table){
        return("Tables: " + " " + table.getTableName() + "\n" + table.getColumns().get(0).getColumnName() + " "
                + table.getColumns().get(1).getColumnName() + " " +  table.getColumns().get(2).getColumnName()
                + "\n " + table.getRows().get(0).getValues()[0]+ "       " + table.getRows().get(0).getValues()[1] + "        " + table.getRows().get(0).getValues()[2] + "\n "
                + table.getRows().get(1).getValues()[0] + "       " + table.getRows().get(1).getValues()[1] + "        " + table.getRows().get(1).getValues()[2]);
    }
}
