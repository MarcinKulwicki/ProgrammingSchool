package pl.coderslab.dao;

import pl.coderslab.model.Task;
import pl.coderslab.model.User;
import pl.coderslab.services.DBService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TaskDao {


    private String database = "school";

    public int getId(){

        try(Connection conn = DBService.connect(this.database)){
            PreparedStatement prep = conn.prepareStatement("SELECT * FROM task;");
            ResultSet rs = prep.executeQuery();
            return DBService.numberOfRows(rs);

        }catch (SQLException e){
            System.out.println("Error Connection to database getID() from TaskDao");
        }

        return 0;
    }

    public void addTask(Task task){

        String query = "Insert into task Values (?,?,?,?,?,?)";

        List<String> queryParams = new ArrayList<>();
        queryParams.add(String.valueOf(task.getId()));
        queryParams.add(String.valueOf(task.getUserId()));
        queryParams.add(String.valueOf(task.getTaskId()));
        queryParams.add(task.getTaskName());
        queryParams.add(task.getTaskAnswer());
        queryParams.add(task.getTaskData());

        DBService.executeUpdate(this.database, query , queryParams);
    }

    public Task loadById(int id){

        String query = "SELECT * FROM task WHERE id="+id;
        Task task;
        try(ResultSet rs = DBService.executeQuery(DBService.connect(this.database), query)){

            while (rs.next()) {


                task = (new Task(
                        rs.getInt("id"),
                        rs.getInt("user_id"),
                        rs.getInt("task_id"),
                        rs.getString("task_name"),
                        rs.getString("task_answer") )
                );

                return task;
            }
        }catch (SQLException e){
            System.out.println("Error in loadById in TaskDao");
        }
        return task = null;
    }

    public List<Task> loadAll(){

        List<Task> taskList = new ArrayList<>();

        String query = "SELECT * FROM task";

        try(ResultSet rs = DBService.executeQuery(DBService.connect(this.database), query)){

            while (rs.next()) {

                taskList.add(new Task(
                        rs.getInt("id"),
                        rs.getInt("user_id"),
                        rs.getInt("task_id"),
                        rs.getString("task_name"),
                        rs.getString("task_answer"),
                        rs.getString("task_data"))
                );

            }
        }catch (SQLException e){
            System.out.println("Error in loadAll in TaskDao");
        }

        System.out.println("");

        return taskList;
    }

    public List<Task> loadAll(int userId){

        List<Task> taskList = new ArrayList<>();

        String query = "SELECT * FROM task WHERE user_id="+userId;

        try(ResultSet rs = DBService.executeQuery(DBService.connect(this.database), query)){

            while (rs.next()) {

                taskList.add(new Task(
                        rs.getInt("id"),
                        rs.getInt("user_id"),
                        rs.getInt("task_id"),
                        rs.getString("task_name"),
                        rs.getString("task_answer"),
                        rs.getString("task_data"))
                );

            }
        }catch (SQLException e){
            System.out.println("Error in loadAll in TaskDao");
        }

        System.out.println("");

        return taskList;
    }

    public List<Task> loadAll(String query){

        List<Task> taskList = new ArrayList<>();


        try(ResultSet rs = DBService.executeQuery(DBService.connect(this.database), query)){

            while (rs.next()) {

                taskList.add(new Task(
                        rs.getInt("id"),
                        rs.getInt("user_id"),
                        rs.getInt("task_id"),
                        rs.getString("task_name"),
                        rs.getString("task_answer"),
                        rs.getString("task_data"))
                );

            }
        }catch (SQLException e){
            System.out.println("Error in loadAll in TaskDao");
        }

        System.out.println("");

        return taskList;
    }

    public void editTask(Task task){

        String query = "UPDATE task SET user_id=?,task_id=?,task_name=?,task_answer=?,task_data=? WHERE id=?";

        List<String> queryParams = new ArrayList<>();

        queryParams.add(String.valueOf(task.getUserId()));
        queryParams.add(String.valueOf(task.getTaskId()));
        queryParams.add(task.getTaskName());
        queryParams.add(task.getTaskAnswer());
        queryParams.add(task.getTaskData());
        queryParams.add( String.valueOf(task.getId()));


        DBService.executeUpdate(this.database, query, queryParams);
    }

    public void delete(int id){

        String query = "DELETE FROM task WHERE id="+id;

        try {
            DBService.executeUpdate(this.database, query);
        }catch (Exception e){
            System.out.println("No element in tab (Task->delete)");
        }

    }
}
