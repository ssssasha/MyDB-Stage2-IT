import java.util.List;
import java.util.stream.Collectors;

public class Table {
    private String tableName;
    private List<Column> columns;
    private List<Row> rows ;

    public Table() {
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
        Row row = new Row(new Table(),new Object[columns.size()]);
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
}
