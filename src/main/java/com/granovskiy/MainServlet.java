package com.granovskiy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name;
        // if requested URI is equal "/servlet/login" and if the method is GET, String name = "login"
        if (req.getRequestURI().equals("/servlet/login") && req.getMethod().equals("GET")) {
            name = "login";
        } else if(req.getRequestURI().equals("/servlet/login") && req.getMethod().equals("POST")) {
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            req.setAttribute("username", username);
            name = "welcome";
        } else {
            name = "404";
        }
        // using format, file address is formed.  File address and String name are sent further with dispatcher
        //  going to: /WEB-INF/views/login.jsp file
        req.getRequestDispatcher(String.format("/WEB-INF/views/%s.jsp", name)).forward(req, resp);
    }
}
