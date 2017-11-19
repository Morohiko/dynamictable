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

public class DAO {

    private DAO(){
        try {
            InitialContext ic = new InitialContext();
            DataSource dataSource = (DataSource) ic.lookup("jdbc/users");
            Connection connection = dataSource.getConnection();
            statement = connection.createStatement();
            addMetaData();
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private ResultSet resultSet = null;
    private Statement statement = null;

    private static DAO instance;

    public static DAO getInstance(){
        if (instance == null) {
            instance = new DAO();
        }
        return instance;
    }

    private List<String> columnName = new ArrayList<String>();
    private List<String> columnType = new ArrayList<String>();
    private List<String> columnValue = new ArrayList<String>();
    private int columnCount;
    private void addMetaData(){
        try {
            resultSet = statement.executeQuery("SELECT * FROM users.users;");
            System.out.println("getcolumncoutn = " + resultSet.getMetaData().getColumnCount());
            columnCount = resultSet.getMetaData().getColumnCount();
            for (int j = 1; j <= columnCount; j++) {
                columnName.add(resultSet.getMetaData().getColumnName(j));
                columnType.add(resultSet.getMetaData().getColumnTypeName(j));
            }
            Model.columnName = columnName;
            Model.columnType = columnType;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    Model getAllPerson(){
        Model model = new Model();
        try {
            resultSet = statement.executeQuery("SELECT * FROM users.users;");
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

//    void insertToDB(Model model){
//        String name = model.getName();
//        int age = person.getAge();
//        try {
//            statement.executeUpdate("INSERT INTO users.users (name, age) VALUES ('"+name+"', "+age+");");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
}
