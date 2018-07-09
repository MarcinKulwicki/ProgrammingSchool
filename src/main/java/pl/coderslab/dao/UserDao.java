package pl.coderslab.dao;

import pl.coderslab.model.User;
import pl.coderslab.services.DBService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    private String database = "school";


    public int getId(){

        try(Connection conn = DBService.connect(this.database)){
            PreparedStatement prep = conn.prepareStatement("SELECT * FROM user;");
            ResultSet rs = prep.executeQuery();
            return DBService.numberOfRows(rs);

        }catch (SQLException e){
            System.out.println("Error Connection to database getID() from UserDao");
        }

        return 0;
    }

    public void addUser(User user){

        String query = "Insert into user Values (?,?,?,?,?,?)";

        List<String> queryParams = new ArrayList<>();
        queryParams.add(String.valueOf(user.getId()));
        queryParams.add(String.valueOf(user.getUserGroupId()));
        queryParams.add(user.getName());
        queryParams.add(user.getSurname());
        queryParams.add(user.getGitLogin());
        queryParams.add(user.getEmail());

        DBService.executeUpdate(this.database, query , queryParams);
    }


    public User loadById(int id){

        String query = "SELECT * FROM user WHERE id="+id;
        User user;
        try(ResultSet rs = DBService.executeQuery(DBService.connect(this.database), query)){

            while (rs.next()) {


                user = (new User(
                        rs.getInt("id"),
                        rs.getInt("user_group_id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("git_login"),
                        rs.getString("email") )
                );

                return user;
            }
        }catch (SQLException e){
            System.out.println("Error in loadById in UserDao");
        }
        return user = null;
    }

    public List<User> loadAll(){

        List<User> userList = new ArrayList<>();

        String query = "SELECT * FROM user";

        try(ResultSet rs = DBService.executeQuery(DBService.connect(this.database), query)){

            while (rs.next()) {

                userList.add(new User(
                        rs.getInt("id"),
                        rs.getInt("user_group_id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("git_login"),
                        rs.getString("email") )
                );

            }
        }catch (SQLException e){
            System.out.println("Error in loadAll in UserDao");
        }

        System.out.println("");

        return userList;
    }


    public void editUser(User user){

        String query = "UPDATE user SET user_group_id=?,name=?,surname=?,git_login=?,email=? WHERE id=?";

        List<String> queryParams = new ArrayList<>();

        queryParams.add(String.valueOf(user.getUserGroupId()));
        queryParams.add(user.getName());
        queryParams.add(user.getSurname());
        queryParams.add(user.getGitLogin());
        queryParams.add(user.getEmail());
        queryParams.add( String.valueOf(user.getId()) );

        DBService.executeUpdate(this.database, query, queryParams);
    }


    public void delete(int id){

        String query = "DELETE FROM user WHERE id="+id;

        try {
            DBService.executeUpdate(this.database, query);
        }catch (Exception e){
            System.out.println("No element in tab (User->delete)");
        }

    }
}
