package com.granovskiy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainServlet extends HttpServlet {
    //  It starts working with doGet method
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);   //  calling processRequest method
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name;
        // if requested URI equals "/servlet/login" and if the method is GET, String name = "login"
        if (req.getRequestURI().equals("/servlet/login") && req.getMethod().equals("GET")) {
            name = "login";
        // if requested URI equals "/servlet/login" and if the method is POST
        } else if(req.getRequestURI().equals("/servlet/login") && req.getMethod().equals("POST")) {
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            req.setAttribute("username", username);
            name = "welcome";
        } else {
            name = "404";
        }
        /* using format, file address is formed.  File address and String name are sent further with dispatcher
          going to: /WEB-INF/views/login.jsp file   */
        req.getRequestDispatcher(String.format("/WEB-INF/views/%s.jsp", name)).forward(req, resp);
        /*  the first time it sends you to login page
          the second time it sends you to welcome page or to 404 page  */
    }
}
