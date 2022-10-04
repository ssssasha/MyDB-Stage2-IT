import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Table {
    private String tableName;
    private List<Column> columns = new ArrayList<>();
    private List<Row> rows = new ArrayList<>();

    public Table() {
    }

    public Table(String tableName) {
        this.tableName = tableName;
    }

    public String getTableName() {
        return this.tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<Column> getColumns() {
        return this.columns;
    }

    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }

    public List<Row> getRows() {
        return this.rows;
    }

    public void setRows(List<Row> rows) {
        this.rows = rows;
    }

    public Row AddRow()
    {
        Row row = new Row(new Object[columns.size()]);
        rows.add(row);
        return row;
    }

    public void DeleteRow(Row row)
    {
        rows.remove(row);
    }

    public Column AddColumn(String name, DataType type) throws Exception {
        if(rows.size() > 0)
            throw new Exception("Impossible add a new column as table has already had rows in it");
        Column column = new Column(name, type);
        columns.add(column);
        return column;
    }

    public Column AddColumn(String name, DataType type, double min, double max) throws Exception {
        if(rows.size() > 0)
            throw new Exception("Impossible add a new column as table has already had rows in it");
        Column column = new Column(name, type, min, max);
        columns.add(column);
        return column;
    }

    public Column GetColumn(String name)
    {
        Column resultColumn = new Column();
        for(Column col: columns){
            if(col.getColumnName().equals(name)){
                resultColumn = col;
            }
        }
        return resultColumn;
    }

    public void DeleteColumn(String name)
    {
        Column column = GetColumn(name);
        columns.remove(column);
    }

    @Override
    public String toString() {
//        return "Tables: " + " " + tableName + "\n" + columns.get(0) + " " + columns.get(1) + " " +  columns.get(2)
//                + " " + columns.get(3) + "\n " + rows.get(0) + "\n " + rows.get(1) + "\n " + rows.get(2);
        return "Tables: " + " " + tableName + "\n" + columns.get(0) + " " + columns.get(1) + " " +  columns.get(2)
                + " " + columns.get(3) + "\n " + rows.get(0) + "\n " + rows.get(1);
//        return "Tables: " + " " + tableName + "\n" + columns.get(0) + " " + columns.get(1) + " " +  columns.get(2)
//                + "\n " + rows.get(0) + "\n ";
//        return "Tables: " + " " + tableName + "\n" + columns.get(0) + " " + columns.get(1) + " "
//                + "\n " + rows.get(0) + "\n " + rows.get(1);
    }

    public void printTable1(){
        System.out.println("Tables: " + " " + tableName + "\n" + columns.get(0) + " " + columns.get(1) + " " +  columns.get(2)
                + " " + columns.get(3) + "\n " + rows.get(0) + "\n " + rows.get(1) + "\n " + rows.get(2));
    }

    public void printTable2(){
        System.out.println("Tables: " + " " + tableName + "\n" + columns.get(0) + " " + columns.get(1) + " " +  columns.get(2)
                + " " + columns.get(3) + "\n " + rows.get(0) + "\n " + rows.get(1));
    }

    public void printResultTable(Table table, List<Integer> dif){
        System.out.println("Table: " + " " + tableName + "\n" + columns.get(0) + " " + columns.get(1) + " " +  columns.get(2)
                + " " + columns.get(3));
        for(Integer res : dif){
            for(Row r: table.rows){
                if(r.getValue("Id")==res){
                    System.out.println(rows.get(table.rows.indexOf(r))+ "\n");
                }
            }
        }
    }
}
