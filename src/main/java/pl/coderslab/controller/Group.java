package pl.coderslab.controller;

import pl.coderslab.dao.UserGroupDao;
import pl.coderslab.model.UserGroup;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Group", urlPatterns = "/Group")
public class Group extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserGroupDao userGroupDao = new UserGroupDao();
        List<UserGroup> userGroupList = userGroupDao.loadAll();
        request.setAttribute("userGroupList", userGroupList);
        getServletContext().getRequestDispatcher("/WEB-INF/group.jsp").forward(request,response);
    }
}
