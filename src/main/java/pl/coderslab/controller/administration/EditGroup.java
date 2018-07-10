package pl.coderslab.controller.administration;

import pl.coderslab.dao.UserGroupDao;
import pl.coderslab.model.UserGroup;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditGroup" ,urlPatterns = "/editGroup")
public class EditGroup extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String groupName = request.getParameter("name");
            String groupId = request.getParameter("id");

            UserGroupDao userGroupDao = new UserGroupDao();
            UserGroup group = new UserGroup(Integer.parseInt(groupId), groupName);
            userGroupDao.editUserGroup(group);

        } catch (Exception e) {
            System.out.println("Error in EditGroup Servlet");
            request.setAttribute("information", "Incorrect data");
            getServletContext().getRequestDispatcher("/WEB-INF/administration/editGroup.jsp").forward(request, response);
        }
        getServletContext().getRequestDispatcher("/WEB-INF/administration/editGroup.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int userGroupId = 1;
        //Sprawdza po id
        try {
            userGroupId = Integer.parseInt(request.getParameter("id"));
            UserGroupDao userGroupDao = new UserGroupDao();
            UserGroup userGroup = userGroupDao.loadById(userGroupId);
            request.setAttribute("userGroup",userGroup);
        }catch (Exception e){
            System.out.println("Cannot convert editUserGroup to Integer");
        }

        getServletContext().getRequestDispatcher("/WEB-INF/administration/editGroup.jsp").forward(request,response);
    }
}
