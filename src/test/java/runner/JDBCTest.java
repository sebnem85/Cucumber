package runner;

import utilities.Configuration;
import utilities.JDBCUtils;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCTest {

    //JDBC=> Java Database Connectivity : It is a dependency.
    // to coneect to database with my framework

    public static void main(String[] args) throws IOException, SQLException {
        // There are going to be three class to make a connection to our database
        // first we need to add JDBC(driver) dependency to our POM.xml file (and reimport them)
        // if we need these things ask devops team they will provide them. in order to connect the database
        // and add under the dependencies and then go pom.xml click and click maven and then reimport
        // Connection
        // Statement
        // ResultSet

        Connection connection = DriverManager.getConnection(     // to make connection to our database we create connection class
                Configuration.getProperties("dbHostname"),  // hostname comes from our SQL database click right and go to properties and copy the hostname
                Configuration.getProperties("dbUsername"),
                Configuration.getProperties("dbPassword"));  // unhandle exception should be handle with method level

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); // we create statement with statement class

        ResultSet resultSet = statement.executeQuery("Select*from employees");
        // we set our result. resultset is an object so it will call all the data
        // we have to run our query so execute the query work this purpose. we provide the query as String
        // once we executed the query. it will store all the data that is coming from table. when we run the query we it will return data.
        // it will be stored this resultSet

        resultSet.next(); //it will go row one
        resultSet.next(); // it will go row two
        resultSet.next();
        String myFirstData = resultSet.getString("FIRST_NAME"); //101 employee_id  // to read data from resultSet
        System.out.println(myFirstData);
        resultSet.next();

        System.out.println(resultSet.getObject("FIRST_NAME"));
        resultSet.next();

        System.out.println(resultSet.getObject("employee_ID"));
        System.out.println(resultSet.getRow());

        ResultSetMetaData rsMetadata = resultSet.getMetaData();
        // metaData provides structure of the data table

        System.out.println("=======================");
        System.out.println(rsMetadata.getColumnCount());
        System.out.println(rsMetadata.getColumnName(5));
        System.out.println(rsMetadata.getColumnType(5));
        System.out.println(rsMetadata.getColumnClassName(1)); //--> it shows string type of data

        List<Map<String, Object>> listOfMaps = new ArrayList<>();

        while (resultSet.next()) {

            Map<String, Object> row = new HashMap<>();

            for (int i = 1; i < rsMetadata.getColumnCount(); i++) {
                row.put(rsMetadata.getColumnName(i), resultSet.getObject(rsMetadata.getColumnName(i)));

            }
            listOfMaps.add(row);


        }

        for (int i = 0; i < listOfMaps.size(); i++) {
            for (String key : listOfMaps.get(i).keySet()) {
                System.out.println(listOfMaps.get(i).get(key));
            }
        }

        JDBCUtils.establishConnection(); // this is establishing the database


    }
}

//  to be connected to database we need to apply url,username,password
/*
 * We stored data from UI
 * We stored the data from Database
 * Then we asserted
 * I have to create customer on my application and validate that it is created in database   */
/*

You signed up with customer information
and how delete that data from database
My last step in my scenarios is deleting mock data that I created

 */