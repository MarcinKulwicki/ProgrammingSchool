package pl.coderslab.controller.administration;

import pl.coderslab.dao.TaskDao;
import pl.coderslab.dao.UserDao;
import pl.coderslab.model.Task;
import pl.coderslab.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddTask" , urlPatterns = "/addTask")
public class AddTask extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String userId = request.getParameter("userId");
            String taskId = request.getParameter("taskId");
            String taskName = request.getParameter("taskName");
            String taskAnswer = request.getParameter("taskAnswer");

            TaskDao taskDao = new TaskDao();
            Task task = new Task(taskDao.getId()+1, Integer.parseInt(userId) , Integer.parseInt(taskId), taskName , taskAnswer);
            taskDao.addTask(task);


            response.getWriter().append("Added to base");

        } catch (Exception e) {
            System.out.println("Error in addTask");
            request.setAttribute("information", "Incorrect data");
            getServletContext().getRequestDispatcher("/WEB-INF/administration/addTask.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/WEB-INF/administration/addTask.jsp").forward(request,response);
    }
}
