package data;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Model {
    public List<String> columnName;
    private List<List<String>> columnValue;
    private int columnCount;


    public List<String> columnType;

    public List<String> getColumnType() {
        return columnType;
    }

    public void setColumnType(List<String> columnType) {
        this.columnType = columnType;
    }

    public List<String> getColumnName() {
        return columnName;
    }

    public void setColumnName(List<String> columnName) {
        this.columnName = columnName;
    }

    public List<List<String>> getColumnValue() {
        return columnValue;
    }

    Model(){
        columnValue = new ArrayList<List<String>>();
    }

    public List<List<String>> getAllTableValue(){
        return columnValue;
    }
    public List getColumnValue(int id) {
        return columnValue.get(id);
    }

    public void setColumnValue(List <String>columnValue1) {
        this.columnValue.add(columnValue1);
    }

    public int getColumnCount() {
        return columnCount;
    }

    public void setColumnCount(int columnCount) {
        this.columnCount = columnCount;
    }

}
