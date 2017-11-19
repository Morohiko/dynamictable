package data;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class ModelJSON {
    @JsonProperty("columnName")
    private List<String> columnName;
    @JsonProperty("columnValue")
    private List<String> columnValue;
    @JsonProperty("columnCount")
    private int columnCount;

    ModelJSON(){
        columnValue = new ArrayList<String>();
        columnName = new ArrayList<String>();
        columnName.add("Name1");
        columnName.add("Name2");
        columnName.add("Name3");
        columnValue.add("Value1");
        columnValue.add("Value2");
        columnValue.add("Value3");
    }

    public List getColumnName() {
        return columnName;
    }

    public void setColumnName(List columnName) {
        this.columnName = columnName;
    }

    public List getColumnValue() {
        return columnValue;
    }

    public void setColumnValue(List columnValue) {
        this.columnValue = columnValue;
    }

    public int getColumnCount() {
        return columnCount;
    }

    public void setColumnCount(int columnCount) {
        this.columnCount = columnCount;
    }

    @Override
    public String toString() {
        String text = "";
        text +="<tr><td>";
        for (int i = 0; i < columnName.size(); i++) {
            text += columnName.get(i);
        }
        for (int i = 0; i < columnValue.size(); i++) {
            text += columnValue.get(i);
        }
        text +="</tr></td>";
        return text;
    }
}
