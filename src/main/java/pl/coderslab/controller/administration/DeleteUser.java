package pl.coderslab.controller.administration;

import pl.coderslab.dao.TaskDao;
import pl.coderslab.dao.UserDao;
import pl.coderslab.model.Task;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "DeleteUser", urlPatterns = "/deleteUser")
public class DeleteUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try{
            int userId = Integer.parseInt(request.getParameter("id"));

            //delete All Task User
            TaskDao taskDao = new TaskDao();
            List<Task> taskList = taskDao.loadAll(userId);
            Iterator<Task> it = taskList.iterator();
            while (it.hasNext()){
                Task task = it.next();
                taskDao.delete(task.getId());
            }
            //delete User
            UserDao userDao = new UserDao();
            userDao.delete(userId);
        }catch (Exception e){
            System.out.println("Error in deleteUser, probably it is not a number or not in table");
            System.out.println(e.getMessage());
        }
        getServletContext().getRequestDispatcher("/WEB-INF/administration/deleteUser.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/administration/deleteUser.jsp").forward(request,response);
    }
}
