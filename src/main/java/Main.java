public class Main {
    public static void main(String[] args) throws Exception {
        Database db1 = Database.CrateDatabase("DB1");
        Table table1 = db1.CreateTable(new Table("Table1"));
        Column col1 = table1.AddColumn("Id", DataType.INTEGER);
        table1.AddColumn("Column1", DataType.INTEGER);
        table1.AddColumn("Column2", DataType.CHAR);
        Column col4 =table1.AddColumn("Column3", DataType.$INVL, 10.0, 100000.0);
        Row row1 = table1.AddRow();
        row1.setTable(table1);
        row1.setValue("Id", 1);
        row1.setValue("Column1", 123);
        row1.setValue("Column2", '$');
        row1.setValue("Column3", 200.0);
        Row row2 = table1.AddRow();
        row2.setTable(table1);
        row2.setValue("Id", 2);
        row2.setValue("Column1", 456);
        row2.setValue("Column2", 'a');
        row2.setValue("Column3", 20.0);
        Row row3 = table1.AddRow();
        row3.setTable(table1);
        row3.setValue("Id", 3);
        row3.setValue("Column1", 789);
        row3.setValue("Column2", '@');
        row3.setValue("Column3", 20000.0);
        //table1.DeleteRow(row2);
        //table1.DeleteColumn("Column1");
        //System.out.println(table1.GetColumn(col1.getColumnName()));
        //System.out.println(table1);

        Table table2 = db1.CreateTable(new Table("Table2"));
        table2.AddColumn("Id", DataType.INTEGER);
        table2.AddColumn("Table1Id", DataType.INTEGER);
        table2.AddColumn("Column1", DataType.STRING);
        table2.AddColumn("Column2", DataType.$INVL, 5.0, 500000.0);
        Row r1 = table2.AddRow();
        r1.setTable(table2);
        r1.setValue("Id", 1);
        r1.setValue("Table1Id", 2);
        r1.setValue("Column1", "Hello");
        r1.setValue("Column2", 5.5);
        Row r2 = table2.AddRow();
        r2.setTable(table2);
        r2.setValue("Id", 2);
        r2.setValue("Table1Id", 3);
        r2.setValue("Column1", "World");
        r2.setValue("Column2", 550.0);
        //System.out.println(table2);
        //System.out.println(db1);
        db1.printDB(table1, table2);
        db1.FindTableDifference(table1, table2);
        //Database.saveDatabase(db1, "C:\\Users\\User\\IdeaProjects\\MyDBProgram\\database1.txt");
    }
}
