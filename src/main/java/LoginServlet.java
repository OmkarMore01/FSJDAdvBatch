

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		boolean isMatch=false;
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		String uname=req.getParameter("uname");
		String pass=req.getParameter("pass");
		try {
		Connection con=JdbcConnector.makeConnect();
		
		String sql="select uname,pass from regi";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		while(rs.next())
		{
			if(uname.equals(rs.getString("uname"))&&pass.equals(rs.getString("pass")))
			{
			isMatch=true;
			}
		}
		
		if(isMatch)
		{
			out.println("<script>"
			        + "alert('Login Successful');"
			        + "window.location.href='index.html';"
			        + "</script>");

		}
		else {
			out.println("<script>"
			        + "alert('Login Failed');"
			        + "window.location.href='Login.html';"
			        + "</script>");

		}
		
		}catch (Exception e) {
			System.out.println(e);
		}
		
		
		
		
	
	
	}

}
