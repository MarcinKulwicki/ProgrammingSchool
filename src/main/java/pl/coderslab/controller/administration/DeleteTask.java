package pl.coderslab.controller.administration;

import pl.coderslab.dao.TaskDao;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteTask" , urlPatterns = "/deleteTask")
public class DeleteTask extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try{
            int taskId = Integer.parseInt(request.getParameter("id"));
            TaskDao taskDao = new TaskDao();
            taskDao.delete(taskId);
        }catch (Exception e){
            System.out.println("Error in deleteTask, problably it is not a number or not in table");
            System.out.println(e.getMessage());
        }
        getServletContext().getRequestDispatcher("/WEB-INF/administration/deleteTask.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/administration/deleteTask.jsp").forward(request,response);
    }
}
