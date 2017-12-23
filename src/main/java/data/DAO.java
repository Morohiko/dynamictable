package data;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

class DAO {
    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    private String tableName = "users.users";
    private DAO(){
        try {
            InitialContext ic = new InitialContext();
            DataSource dataSource = (DataSource) ic.lookup("jdbc/users");
            Connection connection = dataSource.getConnection();
            statement = connection.createStatement();
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private ResultSet resultSet = null;
    private Statement statement = null;

    private static DAO instance;

    static DAO getInstance(){
        if (instance == null) {
            instance = new DAO();
        }
        return instance;
    }

    private List<String> columnName = new ArrayList<String>();
    private List<String> columnType = new ArrayList<String>();
    private List<String> columnValue = new ArrayList<String>();
    private int columnCount;
    private Model model;

    private void addMetaData(){
        columnName = new ArrayList<String>();
        columnType = new ArrayList<String>();
        columnValue = new ArrayList<String>();
        try {
            resultSet = statement.executeQuery("SELECT * FROM " + tableName + ";");
            columnCount = resultSet.getMetaData().getColumnCount();
            for (int j = 1; j <= columnCount; j++) {
                columnName.add(resultSet.getMetaData().getColumnName(j));
                columnType.add(resultSet.getMetaData().getColumnTypeName(j));
            }
            model = new Model();
            model.setColumnName(columnName);
            model.setColumnType(columnType);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    Model getAllPerson(){
        addMetaData();
        try {
            resultSet = statement.executeQuery("SELECT * FROM " + tableName + ";");
            model.setColumnCount(columnCount);
            while (resultSet.next()) {
                for (String name:columnName) {
                    System.out.println("columnName = " + name);
                    columnValue.add(resultSet.getString(name));
                }
                model.setColumnValue(columnValue);
                columnValue = new ArrayList<String>();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return model;
    }
}
