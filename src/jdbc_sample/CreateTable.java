package jdbc_sample;
import java.sql.*;
import java.sql.DriverManager;
public class CreateTable {
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
		System.out.println("Creating table in given DB");
		stmt=conn.createStatement();
		String sql;
		sql="CREATE TABLE REG("
				+ "    id INT NOT NULL"
				+ "    first VARCHAR(255)"
				+ "    last VARCHAR(255)"
				+ "    age INT NOT NULL"
				+ "    PRIMARY KEY(id)"
				+ ");";
		stmt.executeUpdate(sql);
		
		//Step 6:cleanup env
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

