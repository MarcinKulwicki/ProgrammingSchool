package pl.coderslab.controller.administration;

import pl.coderslab.dao.TaskDao;
import pl.coderslab.dao.UserDao;
import pl.coderslab.dao.UserGroupDao;
import pl.coderslab.model.Task;
import pl.coderslab.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "DeleteGroup", urlPatterns = "/deleteGroup")
public class DeleteGroup extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try{
            String groupId = request.getParameter("id");

            //delete All User
            UserDao userDao = new UserDao();
            List<User> userList = userDao.loadAll(groupId);
            Iterator<User> itU = userList.iterator();
            while (itU.hasNext()){
                User user = itU.next();

                //delete All Task User
                TaskDao taskDao = new TaskDao();
                List<Task> taskList = taskDao.loadAll(user.getId());
                Iterator<Task> it = taskList.iterator();
                while (it.hasNext()){
                    Task task = it.next();
                    taskDao.delete(task.getId());
                }

                userDao.delete(user.getId());
            }

            //delete group
            UserGroupDao userGroupDao = new UserGroupDao();
            userGroupDao.delete(Integer.parseInt(groupId));
        }catch (Exception e){
            System.out.println("Error in deleteGroup, probably it is not a number or not in table");
            System.out.println(e.getMessage());
        }
        getServletContext().getRequestDispatcher("/WEB-INF/administration/deleteGroup.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/administration/deleteGroup.jsp").forward(request,response);
    }
}
