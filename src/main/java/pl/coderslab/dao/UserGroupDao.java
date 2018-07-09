package pl.coderslab.dao;

import pl.coderslab.model.UserGroup;
import pl.coderslab.services.DBService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserGroupDao {
    private String database = "school";

    public int getId(){

        try(Connection conn = DBService.connect(this.database)){
            PreparedStatement prep = conn.prepareStatement("SELECT * FROM user_group;");
            ResultSet rs = prep.executeQuery();
            return DBService.numberOfRows(rs);

        }catch (SQLException e){
            System.out.println("Error Connection to database getID() from UserGroupDao");
        }

        return 0;
    }


    public void addUserGroup(UserGroup userGroup){

        String query = "Insert into user_group Values (?,?)";

        List<String> queryParams = new ArrayList<>();
        queryParams.add(String.valueOf(userGroup.getId()));
        queryParams.add(userGroup.getName());

        DBService.executeUpdate(this.database, query , queryParams);
    }

    public UserGroup loadById(int id){

        String query = "SELECT * FROM user_group WHERE id="+id;
        UserGroup userGroup;
        try(ResultSet rs = DBService.executeQuery(DBService.connect(this.database), query)){

            while (rs.next()) {


                userGroup = (new UserGroup(
                        rs.getInt("id"),
                        rs.getString("name") )
                );

                return userGroup;
            }
        }catch (SQLException e){
            System.out.println("Error in loadById in UserGroupDao");
        }
        return userGroup = null;
    }


    public List<UserGroup> loadAll(){

        List<UserGroup> userGroupList = new ArrayList<>();

        String query = "SELECT * FROM user_group";

        try(ResultSet rs = DBService.executeQuery(DBService.connect(this.database), query)){

            while (rs.next()) {

                userGroupList.add(new UserGroup(
                        rs.getInt("id"),
                        rs.getString("name") )
                );

            }
        }catch (SQLException e){
            System.out.println("Error in loadAll in UserGroupDao");
        }

        System.out.println("");

        return userGroupList;
    }

    public void editUserGroup(UserGroup userGroup){

        String query = "UPDATE user_group SET name=? WHERE id=?";

        List<String> queryParams = new ArrayList<>();

        queryParams.add(userGroup.getName());
        queryParams.add( String.valueOf(userGroup.getId()) );

        DBService.executeUpdate(this.database, query, queryParams);
    }

    public void delete(int id){

        String query = "DELETE FROM user_group WHERE id="+id;

        try {
            DBService.executeUpdate(this.database, query);
        }catch (Exception e){
            System.out.println("No element in tab (UserGroup->delete)");
        }

    }
}
