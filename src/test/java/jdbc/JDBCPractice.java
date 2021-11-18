package jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class JDBCPractice {
    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager.getConnection(
                "jdbc:oracle:thin:@vel.crttyzc4agsb.us-east-2.rds.amazonaws.com:1521/ORCL",
                "Velyhora",
                "vd1335667"
        );
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("select * from employees");
        resultSet.next();  // returns boolean -> true if there is next row, false if there is no rows after
        // returns the entire row

        System.out.println( resultSet.getString("first_name"));
        resultSet.last();// it will go to the last row

        System.out.println(resultSet.getString("last_name"));
       // resultSet.first(); // it will go to the first row

        System.out.println(resultSet.getString(5));

        resultSet.beforeFirst(); // it will go to column names

        resultSet.next();
        System.out.println(resultSet.getRow());
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        //METADATA --> Information about the column , rows etc. in your table
        // It is a set of data that describes and gives information about other data
        System.out.println(resultSetMetaData.getColumnCount());
        for (int i = 1; i <=resultSetMetaData.getColumnCount(); i++) {
            System.out.println(resultSetMetaData.getColumnName(i));
        }
        List<Map<String, Object>> employees = new ArrayList<>();
        while (resultSet.next()){
            Map <String, Object> employee = new LinkedHashMap<>();
            for (int i = 1; i <=resultSetMetaData.getColumnCount(); i++) {
                employee.put(resultSetMetaData.getColumnName(i),resultSet.getObject(i));
            }
            employees.add(employee);
        }
        System.out.println(employees.size());
        System.out.println(employees.get(0).get("FIRST_NAME"));

    }
}
