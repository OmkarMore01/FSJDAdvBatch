

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		String name=request.getParameter("uname");
		String pass=request.getParameter("pass");
		PrintWriter out=response.getWriter();
		out.println("uname ="+name +" and pass=="+pass);
	
		if(name.equals("admin") && pass.equals("admin123")) {
		out.println("<script>alert('Login Successfull');</script>");
		HttpSession session=request.getSession(true);
		session.setAttribute("uname", name);
		session.setAttribute("pass", pass);
		session.setMaxInactiveInterval(60);
		out.println("<a href='SecondServlet'>Second Page</a>");
		}
		else {
			out.println("<script>"
					+ "alert('Login Failed');"
					+ "window.location.href='Hidden.html';"
					+ "</script>");
		}
	}

}
