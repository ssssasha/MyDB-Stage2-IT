import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class MainTest {

    @Test
    public void testDataBaseCreation(){
        Database db1 = Database.crateDatabase("DB1");
        Assert.assertTrue(db1.getDatabaseName().equalsIgnoreCase("db1"));
    }

    @Test
    public void testTableCreation(){
        Database db1 = Database.crateDatabase("DB1");
        Table table1 = db1.CreateTable(new Table("Table1"));
        Table table2 = db1.CreateTable(new Table("Table2"));
        Assert.assertTrue(db1.getTables().size() ==2);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(db1.getTables().contains(table1));
        softAssert.assertTrue(db1.getTables().contains(table2));
        softAssert.assertEquals(table1.getTableName(), "Table1");
        softAssert.assertEquals(table2.getTableName(), "Table2");
        softAssert.assertAll();
    }

    @Test
    public void testTableDeleting(){
        Database db1 = Database.crateDatabase("DB1");
        Table table1 = db1.CreateTable(new Table("Table1"));
        Table table2 = db1.CreateTable(new Table("Table2"));
        db1.DeleteTable(table2.getTableName());
        Assert.assertTrue(db1.getTables().size() == 1);
        Assert.assertFalse(db1.getTables().contains(table2));
    }

    @Test
    public void testFindingTablesDifference() throws Exception {
        Database db1 = Database.crateDatabase("DB1");
        Table table1 = db1.CreateTable(new Table("Table1"));
        Column col1 = table1.AddColumn("Column1", DataType.INTEGER);
        Column col2 = table1.AddColumn("Column2", DataType.STRING);
        Row row1 = table1.AddRow();
        row1.setTable(table1);
        row1.setValue("Column1", 123);
        row1.setValue("Column2", "Hello");
        Row row2 = table1.AddRow();
        row2.setTable(table1);
        row2.setValue("Column1", 456);
        row2.setValue("Column2", "world");
        Row row3 = table1.AddRow();
        row3.setTable(table1);
        row3.setValue("Column1", 789);
        row3.setValue("Column2", "www");
        Table table2 = db1.CreateTable(new Table("Table2"));
        table2.AddColumn("Column1", DataType.INTEGER);
        table2.AddColumn("Column2", DataType.STRING);
        Row r1 = table2.AddRow();
        r1.setTable(table2);
        r1.setValue("Column1", 123);
        r1.setValue("Column2", "Hello");
        Row r2 = table2.AddRow();
        r2.setTable(table2);
        r2.setValue("Column1", 456);
        r2.setValue("Column2", "world");
        List<Row> resultList = db1.FindTableDifference(table1,table2);
        Assert.assertTrue(resultList.size() == 1);
        Assert.assertEquals(resultList.get(0).getValue(col1.getColumnName()),789);
        Assert.assertEquals(resultList.get(0).getValue(col2.getColumnName()),"www");
    }


}
