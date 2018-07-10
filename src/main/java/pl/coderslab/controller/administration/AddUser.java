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

@WebServlet(name = "AddUser", urlPatterns = "/addUser")
public class AddUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String userGroupId = request.getParameter("userGroupId");
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            String gitLogin = request.getParameter("gitLogin");
            String email = request.getParameter("email");


            UserDao userDao = new UserDao();
            User user = new User(userDao.getId()+1,Integer.parseInt(userGroupId), name, surname, gitLogin,email);
            userDao.addUser(user);


            response.getWriter().append("Added to base");

        } catch (Exception e) {


            request.setAttribute("information", "Incorrect data");
            getServletContext().getRequestDispatcher("/WEB-INF/administration/addUser.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        getServletContext().getRequestDispatcher("/WEB-INF/administration/addUser.jsp").forward(request,response);
    }
}
