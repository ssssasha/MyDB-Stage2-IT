import java.util.List;

public class Row {
    private Object[] values;
    private Table table;

    public Row() {
    }

    public Row(Table table, Object[] values){
        this.table = table;
        this.values = values;
    }

    public Object[] getValues() {
        return this.values;
    }

    public void setValues(Object[] values) {
        this.values = values;
    }

    public Table getTable() {
        return this.table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public Object GetValue(String columnName)
    {
        Table table = new Table();
        Column column  = table.GetColumn(columnName);
        int index = table.getColumns().indexOf(column);
        return values[index];
    }

    public void SetValue(String columnName, Object value) throws Exception {
        Table table = new Table();
        Column column = table.GetColumn(columnName);
        int index = table.getColumns().indexOf(column);
        DataType dataType = column.getDataType();
        switch (dataType) {
            case INTEGER:
                values[index] =  (Integer) value;
                break;
            case REAL:
                values[index] = (double) value;
                break;
            case STRING:
                values[index] = (String) value;
                break;
            case CHAR:
                values[index] = (char) value;
                break;
            case $INVL:
                var invl = (double) value;
                values[index] = invl;
                if ((invl < column.getMinInvl()) || (invl > column.getMaxInvl()))
                    throw new Exception("Not in type range");
                break;
            default:
                throw new Exception("Wrong type");
        }

    }
}
