import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class Row {
    private Object[] values;
    private Table table;
    private double minInvl ;
    private double maxInvl;

    public Row() {
    }

    public Row(Object[] values){
        this.values = values;
    }

    public Row(double minInvl, double maxInvl) {
        this.minInvl = minInvl;
        this.maxInvl = maxInvl;
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

    public double getMinInvl() {
        return this.minInvl;
    }

    public void setMinInvl(double minInvl) {
        this.minInvl = minInvl;
    }

    public double getMaxInvl() {
        return this.maxInvl;
    }

    public void setMaxInvl(double patient) {
        this.maxInvl = maxInvl;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public Object getValue(String columnName)
    {
        Column column  = table.GetColumn(columnName);
        int index = table.getColumns().indexOf(column);
        return values[index];
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
//            case $INVL:
//                values[index] = (double) value;
//                var invl = (double) value;
//                values[index] = invl;
//                if ((invl < column.getMinInvl()) || (invl > column.getMaxInvl()))
//                    throw new Exception("Not in type range");
//                break;
        }
    }
    public void setValue(String name, double min, double max) throws Exception {
        Column column = table.GetColumn(name);
        int index = table.getColumns().indexOf(column);
        DataType dataType = column.getDataType();
        switch (dataType) {
            case $INVL:
                if(min>max){
                    throw new Exception("Incorrect minimum value");
                }
                MoneyType moneyType = new MoneyType(min, max);
                values[index] = moneyType;
                break;
            default:
                throw new Exception("Wrong type");
        }
    }
    @Override
    public String toString() {
       // return  values[0] + "     " + values[1];
        return  values[0] + "     " + values[1] + "      " + values[2];
//        return "  " + values[1] + "       " + NumberFormat.getCurrencyInstance(new Locale("en", "US"))
//                .format(values[2]);
    }

    @Override
    public boolean equals(Object obj) {
        Row r = (Row) obj;
        for(int i = 0; i< values.length; i++){
            if(!this.values[i].toString().equals(r.getValues()[i].toString())){
                return false;
            }
        }
        return true;
    }
}
