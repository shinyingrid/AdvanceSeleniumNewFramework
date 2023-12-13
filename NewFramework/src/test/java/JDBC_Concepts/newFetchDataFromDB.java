package JDBC_Concepts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.cj.jdbc.Driver;

public class newFetchDataFromDB {

	public static void main(String[] args) throws Throwable
	{
		Driver driverref=new Driver();
		
		DriverManager.registerDriver(driverref);
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1","root","root");
		
		Statement state = conn.createStatement();
		
		String query = "select*from test1";
		
		ResultSet result = state.executeQuery(query);
		
		while(result.next())
		{
			System.out.println(result.getString(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4));
		}
		
		conn.close();
		
		

	}

}

