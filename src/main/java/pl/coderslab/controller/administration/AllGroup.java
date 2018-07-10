package pl.coderslab.controller.administration;

import pl.coderslab.dao.TaskDao;
import pl.coderslab.dao.UserGroupDao;
import pl.coderslab.model.UserGroup;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AllGroup" , urlPatterns = "/allGroup")
public class AllGroup extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserGroupDao userGroupDao = new UserGroupDao();
        List<UserGroup> userGroupList = userGroupDao.loadAll();
        System.out.println("");


        request.setAttribute("userGroupList", userGroupList);
        getServletContext().getRequestDispatcher("/WEB-INF/administration/allGroup.jsp").forward(request,response);

    }
}
