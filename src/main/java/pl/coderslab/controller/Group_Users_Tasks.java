package pl.coderslab.controller;

import pl.coderslab.dao.TaskDao;
import pl.coderslab.model.Task;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Group_Users_Tasks", urlPatterns = "/Group/Users/Task")
public class Group_Users_Tasks extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        try {
            int userId = Integer.parseInt(request.getParameter("task"));

            TaskDao taskDao = new TaskDao();
            List<Task> taskList = taskDao.loadAll(userId);

            request.setAttribute("taskList", taskList);
            getServletContext().getRequestDispatcher("/WEB-INF/group_users_tasks.jsp").forward(request,response);

        }catch (Exception e){
            System.out.println("In group user task setvlet cannot convert to int");
        }


        getServletContext().getRequestDispatcher("/WEB-INF/group_users_tasks.jsp").forward(request,response);
    }
}
