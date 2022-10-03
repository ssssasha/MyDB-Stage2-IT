import java.time.LocalTime;
import java.util.List;

public class Database {
    private String databaseName;
    private List<Table> tables;

    public Database() {
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
}

