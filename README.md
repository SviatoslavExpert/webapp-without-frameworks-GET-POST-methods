# webapp-without-frameworks-GET-POST-methods

MainServlet code

Part I

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
    - Generates an html page with a form. Login page opens for user.
    
Part II
    
1.  When the form is filled and sent, POST request is sent to the server (method = "post" is used in the form).
    
2. In MainServlet.java the method doPost is called: doPost(HttpServletRequest req, HttpServletResponse resp).
    - It calls method processRequest and passes arguments req and resp to it.
    
3. Method processRequest works.
    - String name is created.
    - If requested URI equals "/servlet/login" and if the method is POST (that's what they are).
    - String username is declared and gets the parameter (value) corresponding to username (key) which is taken from the POST request.
    - String password is declared and gets the parameter (value) corresponding to password (key) which is taken from the POST request. 
       (Method getParameter is a built-in method.  
       .getParameter(String var1) gets value from request using key (string) and returns a string.)
    - req.setAttribute("username", username);
      setAttribute(String, Object) method Stores an attribute in this request. Attributes are reset. 
      Now request contains "username" (string which is key) and username (object which is value).
      (username which is stored in the request will be used in welcome.jsp file. username value will be displayed to the user.)
    - String name get value "welcome" (for navigation).
    
4. req.getRequestDispatcher(String.format("/WEB-INF/views/%s.jsp", name)).forward(req, resp);
    - Using String.format, file address is formed.
    - The getRequestDispatcher() method gets the generated string as the argument.
    - The getRequestDispatcher() method returns the object of RequestDispatcher.
    - It forwards a request from a servlet to another resource: JSP file (or servlet, or HTML file) on the server.
    
5. JSP file: welcome.jsp.
    - Generates an html page with a greeting. Welcome page opens for user.
    
    
    Notes:
    
    java.lang.String getParameter(java.lang.String name)
    Returns the value of a request parameter as a String, or null if the parameter does not exist. 
    Request parameters are extra information sent with the request. 
    For HTTP servlets, parameters are contained in the query string or posted form data.
    https://docs.oracle.com/javaee/6/api/javax/servlet/ServletRequest.html#getParameter(java.lang.String)
    
    method:  void setAttribute(java.lang.String name,java.lang.Object o)
    Stores an attribute in this request. Attributes are reset between requests. This method is most often used in conjunction 
    with  RequestDispatcher.
    https://docs.oracle.com/javaee/6/api/javax/servlet/ServletRequest.html
    
    
RequestDispatcher in Servlet

The RequestDispatcher interface provides the facility of dispatching the request
to another resource it may be html, servlet or jsp.

This interface can also be used to include the content of another resource also.
It is one of the ways of servlet collaboration.

There are two methods defined in the RequestDispatcher interface:

public void forward(ServletRequest request,ServletResponse response)throws ServletException,
java.io.IOException:
Forwards a request from a servlet to another resource (servlet, JSP file, or HTML file) on the server.

public void include(ServletRequest request,ServletResponse response)throws ServletException,
java.io.IOException:
Includes the content of a resource (servlet, JSP page, or HTML file) in the response.
   
