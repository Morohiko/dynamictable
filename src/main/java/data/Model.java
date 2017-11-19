package data;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Model {
    public static List<String> columnType;
    @JsonProperty("columnName")
    public static List<String> columnName;
    @JsonProperty("columnValue")
    private List<List<String>> columnValue;
    @JsonProperty("columnCount")
    private int columnCount;
//    static Model getModel(){
//        return this.clone();
//    }
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
