package edu.nuist.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
	
	private static String url="jdbc:mysql://localhost/infotree"; 			//数据库地址
	private static String userName="root"; 								// 用户名    
	private static String password="123456"; 								// 密码
	private static Connection con=null;
	
	public DBConn() throws SQLException{
	        try {
	        		Class.forName("com.mysql.jdbc.Driver").newInstance(); 	//装载驱动程序
	        		con=DriverManager.getConnection(url+"?"+"user="+userName+"&password="+password); //创建连接
        	 } catch (Exception e) {
    	System.out.println(e);
    }	
	}	
		public Connection getConn(){
			return con;
		}
}