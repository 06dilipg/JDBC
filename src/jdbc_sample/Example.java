package jdbc_sample;
import java.sql.*;
import java.sql.DriverManager;
public class Example {
static final String JDBC_DRIVER="com.mysql.jdbc.Driver";
static final String DB_URL="jdbc:mysql://localhost/employee";

//DB CRED
static final String USER="root";
static final String PASS="";

public static void main(String[] args){
	Connection conn=null;
	Statement stmt=null;
	try{
		//Step 2:Register JDBC Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		//Step 3:open a connection
		System.out.println("Connecting to DB");
		conn=DriverManager.getConnection(DB_URL,"root","");
		//step 4:Execute a query
		System.out.println("Creating statement");
		stmt=conn.createStatement();
		String sql;
		sql="SELECT * FROM `emp1`";
		ResultSet rs=stmt.executeQuery(sql);
		//Step 5:Extract data from result set
		while(rs.next()){
			//Retrieve by col name
			int id=rs.getInt("id");
			int age=rs.getInt("age");
			String first=rs.getString("first");
			String last=rs.getString("last");
			//Display values
			System.out.println("ID:"+id);
			System.out.println("Age:"+age);
			System.out.println("First:"+first);
			System.out.println("Last:"+last);
		}
		//Step 6:cleanup env
		rs.close();
		stmt.close();
		conn.close();
	}catch(SQLException se){
		//handle jdbc error
		se.printStackTrace();
	}catch(Exception e){
		//handle class.forname
		e.printStackTrace();
	}finally{
		try {
			if(stmt!=null)
			stmt.close();
		}catch(SQLException se2){}
		try {
			if(conn!=null)
			conn.close();
		}catch(SQLException se){}
	}
	System.out.println("The end");
}
}
