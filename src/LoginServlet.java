

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.Cookies;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	      response.setContentType("text/html");
	      PrintWriter p = response.getWriter();
	      
	      request.getRequestDispatcher("link.html").include(request, response); 
	      
	      String name = request.getParameter("uname");
	      String pass = request.getParameter("upass");
	      
	     
	      
	      if(pass.equals("admin"))
	      {
	    	 p.print("You are successfully logged in <br>");
	    	 p.print("Welcome "+name );
	    	 
	    	Cookie c1 = new Cookie("uname", name);
	    	response.addCookie(c1);
	    	
	      }

	      else
	      {
	    	  p.print("sorry, username or password error!");
	    	  
	    	  request.getRequestDispatcher("login.html").include(request, response);
	      }
	
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
