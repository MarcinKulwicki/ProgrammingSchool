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
import java.util.List;

@WebServlet(name = "AllTask" , urlPatterns = "/allTask")
public class AllTask extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        TaskDao taskDao = new TaskDao();
        List<Task> taskList = taskDao.loadAll();
        System.out.println("");


        request.setAttribute("taskList", taskList);
        getServletContext().getRequestDispatcher("/WEB-INF/administration/allTask.jsp").forward(request,response);

    }
}
