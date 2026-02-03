

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");	
		PrintWriter out=response.getWriter();
		String uname=request.getParameter("username");
		String pass=request.getParameter("password");
		
		try {
			
			Connection con=JdbcConnector.makeConnect();
			
			String sql="insert into regi(uname,pass) values(?,?)";
			
			PreparedStatement ps =con.prepareStatement(sql);
			ps.setString(1, uname);
			ps.setString(2, pass);
			
			int res=ps.executeUpdate();
			if (res!=0)
			{
				out.println("<script>"
						+ "alert('Registered Successfull');"
						+"window.location.href='Login.html';"
						+ "</script>"
						
						);
			}
			else{
				out.println("<script>"
						+ "alert('Registered Failed');"
						+ "</script>"
						
						);
			}
			
			
			
		}catch (Exception e) {
			System.out.println(e);
		}
		
		
	}

}
