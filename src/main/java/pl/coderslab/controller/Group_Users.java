package pl.coderslab.controller;

import pl.coderslab.dao.UserDao;
import pl.coderslab.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Group_Users" , urlPatterns = "/Group/Users")
public class Group_Users extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String usersGroup = request.getParameter("groupId");
        UserDao userDao = new UserDao();
        List<User> userList = userDao.loadAll(usersGroup);



        request.setAttribute("userList", userList);
        getServletContext().getRequestDispatcher("/WEB-INF/group_users.jsp").forward(request,response);
    }
}
