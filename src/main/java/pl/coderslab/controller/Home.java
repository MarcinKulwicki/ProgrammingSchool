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

@WebServlet(name = "Home", urlPatterns = "")
public class Home extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        TaskDao taskDao = new TaskDao();
        List<Task> taskList = taskDao.loadAll("SELECT * FROM task order by task_data DESC limit 10;");
        System.out.println("");


        request.setAttribute("taskList", taskList);
        getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request,response);
    }
}
