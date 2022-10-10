import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        Database db1 = Database.crateDatabase("DB1");
        Table table1 = db1.CreateTable(new Table("Table1"));
        table1.AddColumn("Column1", DataType.INTEGER);
        table1.AddColumn("Column2", DataType.STRING);
        table1.AddColumn("Column3", DataType.$INVL);

        Row row1 = table1.AddRow();
        row1.setTable(table1);
        row1.setValue("Column1", 123);
        row1.setValue("Column2", "Hello");
        row1.setValue("Column3", 20.0, 20000.0);
        Row row2 = table1.AddRow();
        row2.setTable(table1);
        row2.setValue("Column1", 456);
        row2.setValue("Column2", "world");
        row2.setValue("Column3", 5.0,5500.0);
        Row row3 = table1.AddRow();
        row3.setTable(table1);
        row3.setValue("Column1", 789);
        row3.setValue("Column2", "www");
        row3.setValue("Column3", 2.0,200000.0);
        //table1.DeleteRow(row2);
        //table1.DeleteColumn("Column1");
        //System.out.println(table1.GetColumn(col1.getColumnName()));
        //System.out.println(table1);

        Table table2 = db1.CreateTable(new Table("Table2"));
        table2.AddColumn("Column1", DataType.INTEGER);
        table2.AddColumn("Column2", DataType.STRING);
        table2.AddColumn("Column3", DataType.$INVL);
        Row r1 = table2.AddRow();
        r1.setTable(table2);
        r1.setValue("Column1", 123);
        r1.setValue("Column2", "Hello");
        r1.setValue("Column3",20.0, 20000.0);
        Row r2 = table2.AddRow();
        r2.setTable(table2);
        r2.setValue("Column1", 456);
        r2.setValue("Column2", "world");
        r2.setValue("Column3",5.0, 5500.0);
        //System.out.println(table2);
        //System.out.println(db1);
        db1.printDB(table1, table2);
        List<Row> differences = db1.FindTableDifference(table1, table2);
        table1.printResultTable(table1, differences);
        //Database.saveDatabase(db1, "C:\\Users\\User\\IdeaProjects\\MyDBProgram\\database1.txt");
    }
}
