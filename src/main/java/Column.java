import java.time.LocalTime;

public class Column {
    private String columnName;
    private DataType dataType;
    private double minInvl ;
    private double maxInvl;

    public Column() {
    }

    public Column(String columnName, DataType dataType) {
        this.columnName = columnName;
        this.dataType = dataType;
    }

    public Column(String columnName, DataType dataType, double minInvl, double maxInvl) {
        this.columnName = columnName;
        this.dataType = dataType;
        this.minInvl = minInvl;
        this.maxInvl = maxInvl;
    }

    public String getColumnName() {
        return this.columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public DataType getDataType() {
        return this.dataType;
    }

    public void setDataType(DataType dataType) {
        this.dataType = dataType;
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

    @Override
    public String toString() {
        return  " " + columnName;
    }

}
