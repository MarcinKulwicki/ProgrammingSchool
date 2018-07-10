package pl.coderslab.controller.administration;

import pl.coderslab.dao.UserDao;
import pl.coderslab.dao.UserGroupDao;
import pl.coderslab.model.User;
import pl.coderslab.model.UserGroup;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditUser", urlPatterns = "/editUser")
public class EditUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String id = request.getParameter("id");
            String userGroupId = request.getParameter("userGroupId");
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            String gitLogin = request.getParameter("gitLogin");
            String email = request.getParameter("email");

            UserDao userDao = new UserDao();
            User user = new User(Integer.parseInt(id),Integer.parseInt(userGroupId), name, surname, gitLogin,email);
            userDao.editUser(user);


        } catch (Exception e) {
            System.out.println("Error in EditUser Servlet");
            request.setAttribute("information", "Incorrect data");
            getServletContext().getRequestDispatcher("/WEB-INF/administration/editUser.jsp").forward(request, response);
        }
        getServletContext().getRequestDispatcher("/WEB-INF/administration/editUser.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int userId = 1;
        //Sprawdza po id
        try {
            userId = Integer.parseInt(request.getParameter("id"));
            UserDao userDao = new UserDao();
            User user = userDao.loadById(userId);
            request.setAttribute("user",user);
        }catch (Exception e){
            System.out.println("Cannot convert editUser to Integer");
        }

        getServletContext().getRequestDispatcher("/WEB-INF/administration/editUser.jsp").forward(request,response);
    }
}
