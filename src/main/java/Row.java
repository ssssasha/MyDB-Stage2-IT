import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class Row {
    private Object[] values;
    private Table table;

    public Row() {
    }

    public Row(Object[] values){
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

    public Integer getValue(String columnName)
    {
        Column column  = table.GetColumn(columnName);
        int index = table.getColumns().indexOf(column);
        return (Integer)values[index];
    }

    public void setValue(String columnName, Object value) throws Exception {
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
    @Override
    public String toString() {
        return  values[0] + "     " + values[1] + "       " + values[2] + "      " + NumberFormat.getCurrencyInstance(new Locale("en", "US"))
                .format(values[3]);
//        return "  " + values[1] + "       " + NumberFormat.getCurrencyInstance(new Locale("en", "US"))
//                .format(values[2]);
    }
}
