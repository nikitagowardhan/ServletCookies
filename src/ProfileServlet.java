

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");  
        PrintWriter p=response.getWriter(); 
        
          
        request.getRequestDispatcher("link.html").include(request, response); 
        
        Cookie c[]= request.getCookies();
        if(c!=null){
        String name = c[0].getValue();
        
        if(!name.equals("")||name!=null){  
            p.print("<br><b>Welcome to Profile</b>");  
            p.print("<br>Welcome, "+name);  
        }  
        }
        else{  
            p.print("Please login first<br>");  
            request.getRequestDispatcher("login.html").include(request, response);  
        }  

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
