package JDBC_Concepts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class InsertDataToDB {

	public static void main(String[] args) throws Throwable
	{
		Driver driverRef = new Driver();
		
		DriverManager.registerDriver(driverRef);
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1","root","root");
		
		Statement state = conn.createStatement();
		
		String query = "insert into test1(first_name,last_name,address)values('Ram','Sam','Goa')";
		
		int result = state.executeUpdate(query);
		
		if(result==1)
		{
			System.out.println("Data is updated");
		}
		else
		{
			System.out.println("Data not updated");
		}

	}

}
