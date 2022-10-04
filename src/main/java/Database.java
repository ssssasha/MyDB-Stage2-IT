import java.io.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Database {
    private String databaseName;
    private List<Table> tables = new ArrayList<>();

    public Database() {
    }

    public Database(String databaseName) {
        this.databaseName = databaseName;
    }

    public String getDatabaseName() {
        return this.databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public List<Table> getTables() {
        return this.tables;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }

    public static Database CrateDatabase(String name){
        Database newDatabase = new Database(name);
        return  newDatabase;
    }

    public static void OpenDatabase(String path) throws IOException, ClassNotFoundException {
        FileInputStream fi = new FileInputStream(path);
        ObjectInputStream oi = new ObjectInputStream(fi);

        // Read objects
        Database db1 = (Database) oi.readObject();

        System.out.println(db1.toString());

        oi.close();
        fi.close();
    }

    public static void saveDatabase(Database dBtoSave, String path) throws IOException {
        FileOutputStream f = new FileOutputStream(new File(path));
        ObjectOutputStream o = new ObjectOutputStream(f);

        try {
            // Write objects to file
            o.writeObject(dBtoSave.toString());
            System.out.println("Done");
            o.close();
            f.close();
        }catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        }
    }
    public Table CreateTable(Table table)
    {
        tables.add(table);
        return table;
    }

    public Table GetTable(String name)
    {
        Table resultTable = new Table();
        for(Table tab: tables){
            if(tab.getTableName().equals(name)){
                resultTable = tab;
            }
        }
        return resultTable;
    }

    public void DeleteTable(String name)
    {
        Table table = GetTable(name);
        tables.remove(table);
    }

    public void FindTableDifference(Table table1, Table table2){
        List<Integer> idList1 = table1.getRows().stream().map(r -> r.getValue("Id")).collect(Collectors.toList());
        List<Integer> idList2 = table2.getRows().stream().map(r -> r.getValue("Table1Id")).collect(Collectors.toList());
        System.out.println(idList1);
        System.out.println(idList2);
        List<Integer> differences = idList1.stream()
                .filter(element -> !idList2.contains(element))
                .collect(Collectors.toList());
        System.out.println(differences);
        table1.printResultTable(table1, differences);
    }

    public String toString() {
        return "Database: " + " " + databaseName + "\n" + tables.get(0) + "\n" + tables.get(1);
    }

    public void printDB(Table table1, Table table2){
        table1.printTable1();
        table2.printTable2();
    }
}

