package pl.coderslab.controller.administration;

import pl.coderslab.controller.Group;
import pl.coderslab.dao.UserGroupDao;
import pl.coderslab.model.UserGroup;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AddGroup", urlPatterns = "/addGroup")
public class AddGroup extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String groupName = request.getParameter("groupName");

            UserGroupDao userGroupDao = new UserGroupDao();
            UserGroup group = new UserGroup(userGroupDao.getId() + 1, groupName);
            userGroupDao.addUserGroup(group);


            response.getWriter().append("Dodano do bazy");

        } catch (Exception e) {


            request.setAttribute("information", "Incorrect data");
            getServletContext().getRequestDispatcher("/WEB-INF/administration/addGroup.jsp").forward(request, response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        getServletContext().getRequestDispatcher("/WEB-INF/administration/addGroup.jsp").forward(request, response);
    }
}
