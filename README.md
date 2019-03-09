# webapp-without-frameworks-GET-POST-methods

MainServlet code

1. Method doGet works.  
    - It calls method processRequest and passes arguments req and resp to it.
    
2. Method processRequest works.
    - String name is created.
    - If requested URI equals "/servlet/login" and if the method is GET, name = "login" (that's what happens).
    - The result of work of processRequest method is that name got its string value (name = "login").
    
3. req.getRequestDispatcher(String.format("/WEB-INF/views/%s.jsp", name)).forward(req, resp);
    - Using String.format, file address is formed.
    - The getRequestDispatcher() method gets the generated string as the argument.
    - The getRequestDispatcher() method returns the object of RequestDispatcher.
    - It forwards a request from a servlet to another resource: JSP file (or servlet, or HTML file) on the server.
    
4. JSP file: login.jsp.
    - Generates an html page with a form.
    - When the form is filled and sent, POST request is sent to the server (method = "post" is used in the form).
    
5. In MainServlet.java the method doPost is called: doPost(HttpServletRequest req, HttpServletResponse resp).
    - It calls method processRequest and passes arguments req and resp to it.
    
6. Method processRequest works.
    - String name is created.
    - If requested URI equals "/servlet/login" and if the method is POST, name = "login" (that's what happens).
    - The result of work of processRequest method is that name got its string value (name = "login").
