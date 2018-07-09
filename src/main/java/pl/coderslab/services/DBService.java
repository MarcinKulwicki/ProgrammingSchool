package pl.coderslab.services;

import java.sql.*;
import java.util.List;

public class DBService {

    public static Connection connect(String database) throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch(Exception e){
            System.out.println(e.getMessage());
        };

        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/" + database +"?useUnicode=true" +
                        "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false",
                "root",
                "coderslab");
    }



    public static int numberOfRows(ResultSet rs) throws SQLException{
        int rowCount = 0;
        if (rs.last()) {
            rowCount = rs.getRow();
            rs.beforeFirst(); // not rs.first() because the rs.next() below will move on, missing the first element
        }
        return rowCount;

    }

    public static ResultSet executeSelectQuery(String database, String query) {
        ResultSet result = null;
        try( Connection conn = connect(database) ) {
            PreparedStatement prep = conn.prepareStatement(query);
            result=prep.executeQuery();
        }catch(SQLException e){
            System.out.println(e);
        }
        return result;
    }

    public static ResultSet executeSelectQuery(String database, String query, List<String> params) {
        ResultSet result = null;
        try( Connection conn = connect(database) ) {
            PreparedStatement prep = conn.prepareStatement(query);

            int paramNumber=1;
            for(String param : params) {
                prep.setString(paramNumber, param);
                paramNumber++;
            }

            result=prep.executeQuery();
        }catch(SQLException e){
            System.out.println(e);
        }
        return result;
    }

    //TODO :: CREATE METHOD FOR INSERT QUERY RETURNING CREATED ID

    public static int executeUpdateReturnId(String database, String query, List<String> params){
        Integer id=null;
        try(Connection con = connect(database)){

            String generatedColumns[] = {"ID"};
            PreparedStatement prep = con.prepareStatement(query,generatedColumns);
            for (int i=0; i<params.size(); i++) {
                prep.setString(i+1, params.get(i));
            }
            prep.executeUpdate();
            ResultSet rs = prep.getGeneratedKeys();
            if (rs.next())  id = rs.getInt(1);
        }catch (SQLException e){
            System.out.println(e);
        }
        return id;
    }

    public static int executeUpdateReturnId(String database, String query){
        Integer id=null;
        try(Connection con = connect(database)){

            String generatedColumns[] = {"ID"};
            PreparedStatement prep = con.prepareStatement(query,generatedColumns);

            prep.executeUpdate();
            ResultSet rs = prep.getGeneratedKeys();
            if (rs.next())  id = rs.getInt(1);
        }catch (SQLException e){
            System.out.println(e);
        }
        return id;
    }

    public static void executeUpdate(String database, String query){
        try(Connection con = connect(database)){
            PreparedStatement prep = con.prepareStatement(query);

            prep.executeUpdate();
        }catch (SQLException e){
            System.out.println(e);
        }
    }
    //prepared statement
    public static void executeUpdate(String database, String query, List<String> params){
        try(Connection con = connect(database)){
            PreparedStatement prep = con.prepareStatement(query);

            for (int i=0; i<params.size(); i++) {
                prep.setString(i+1, params.get(i));
            }

            prep.executeUpdate();
        }catch (SQLException e){
            System.out.println(e);
        }
    }

    public static void executeUpdate(String database, String query, String param){
        try(Connection con = connect(database)){
            PreparedStatement prep = con.prepareStatement(query);
            prep.setString(1, param);

            prep.executeUpdate();
        }catch (SQLException e){
            System.out.println(e);
        }
    }

    public static ResultSet executeQuery(Connection conn, String query){

        ResultSet result = null;
        try{
            result = conn.createStatement().executeQuery(query);

        }catch (SQLException e){

        }
        return result;
    }

}
