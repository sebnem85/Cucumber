package utilities;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCUtils {
    //   we need static methods
    //   establishConnection()  ==>> we automatically connect the data
    //   runSQLQuery(String query) ==>>  this query will run the query and return the list of Maps
    //   closeDatabase()
    //   countRows(String query) ==>> will return int

    private static Connection connection; // we make it private because of the privacy
    private static Statement statement;
    private static ResultSet resultSet;

    // This method establishing a connections with Oracle SQL Database
    public static void establishConnection() throws IOException, SQLException {
         connection = DriverManager.getConnection(
                Configuration.getProperties("dbHostname"),
                Configuration.getProperties("dbUsername"),
                Configuration.getProperties("dbPassword"));

        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);



    }

    /**
     *
     * @param query
     * @return
     * @throws SQLException
     */

    public static List<Map<String,Object>> runSQLQuery(String query) throws SQLException{
        resultSet =statement.executeQuery(query);
        ResultSetMetaData rsMetadata = resultSet.getMetaData();

        List<Map<String,Object>>listOfMaps = new ArrayList<>(); // how many column we have \

        int columnCount=rsMetadata.getColumnCount();

        while (resultSet.next()){  //-> it shows next row  it will to very first row

            Map<String,Object> row = new HashMap<>();

               for(int i=1; i<=columnCount;i++ ){// sql table starts from 1

                   String columnName= rsMetadata.getColumnName(i);
                   Object columnValue = resultSet.getObject(columnName);
                   row.put(columnName,columnValue);
               }

                listOfMaps.add(row);
        }

        return listOfMaps;
    }

    /**
     * This method will execute query and return number of rows.
     * @param query
     * @return
     * @throws SQLException
     */

    public static int countRows(String query) throws  SQLException{

        resultSet = statement.executeQuery(query);
        resultSet.last();
        return resultSet.getRow();
    }

    /**
     * This method will close Database connection, stratement, and resultset
     * @throws SQLException
     */

    public static void closeConnection() throws SQLException{

        if(connection!=null){
        connection.close();
        }

        if(statement!=null){
            statement.close();
        }

        if(resultSet!=null){
            resultSet.close();
        }
    }

}
