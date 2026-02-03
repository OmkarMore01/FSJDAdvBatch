import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcConnector {

	public static Connection makeConnect()
	{
		
	try {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/javabatch9";
		String user="root";
		String passw="8284";
		Connection con=DriverManager.getConnection(url,user,passw);
		System.out.println("Connection succesfull");
	return con;
		
		
	}catch (Exception e) {
		System.out.println(e);
	}
	return null;
	
	}
}
