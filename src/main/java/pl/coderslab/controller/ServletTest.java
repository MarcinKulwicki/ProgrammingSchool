package pl.coderslab.controller;

import pl.coderslab.services.DBService;
import pl.coderslab.services.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(name = "ServletTest" , urlPatterns = "/test")
public class ServletTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



//            String sql = "INSERT INTO users (username) VALUES ('Edi');";
//            String databaseName = "school";
//
//        DBService.executeUpdate(databaseName, sql);


        getServletContext().getRequestDispatcher("/WEB-INF/trap.jsp").forward(request,response);



//            PreparedStatement preStmt =
//                    conn.prepareStatement("SELECT * FROM users WHERE user_name = ?");
//            preStmt.setString(1, userName);



    }
}
