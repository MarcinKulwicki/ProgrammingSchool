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
import java.time.LocalDateTime;

@WebServlet(name = "EditTask", urlPatterns = "/editTask")
public class EditTask extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            int userId = Integer.parseInt(request.getParameter("userId"));
            int taskId = Integer.parseInt(request.getParameter("taskId"));
            String taskName = request.getParameter("taskName");
            String taskAnswer = request.getParameter("taskAnswer");
            String date = LocalDateTime.now().toString().split("T")[0];

            TaskDao taskDao = new TaskDao();
            Task task = new Task(id,userId, taskId, taskName, taskAnswer, date);
            taskDao.editTask(task);


        } catch (Exception e) {
            System.out.println("Error in EditTask Servlet");
            request.setAttribute("information", "Incorrect data");
            getServletContext().getRequestDispatcher("/WEB-INF/administration/editTask.jsp").forward(request, response);
        }
        getServletContext().getRequestDispatcher("/WEB-INF/administration/editTask.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int taskId = 1;
        //Sprawdza po id
        try {
            taskId = Integer.parseInt(request.getParameter("id"));
            TaskDao taskDao = new TaskDao();
            Task task = taskDao.loadById(taskId);
            request.setAttribute("task",task);
        }catch (Exception e){
            System.out.println("Cannot convert editUser to Integer");
        }

        getServletContext().getRequestDispatcher("/WEB-INF/administration/editTask.jsp").forward(request,response);
    }
}
