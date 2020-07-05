package test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * 测试数据库是否连接成功的类
 * @author 张文成
 * @version 1.0 2020/7.4
 */
public class jdbc {
	public static void main(String[] args) {
		String driverName = "com.mysql.cj.jdbc.Driver";
		String dbURL = "jdbc:mysql://127.0.0.1:3306/user?characterEncoding=utf8&useUnicode=true&useSSL=false&serverTimezone=UTC";
		String userName = "root";
		String userPwd = "15697463503z";
		Connection Conn=null;
		Statement statement=null;
		ResultSet rs =null;
		
		try { 
			Class.forName(driverName); 
			System.out.println("加载驱动成功！");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("加载驱动失败！");
		}
		try {
			Conn = DriverManager.getConnection(dbURL, userName, userPwd);
			System.out.println("连接数据库成功！");
			//创建一个对象将SQL语句发送到SQL 			
			statement = Conn.createStatement(); 			
			//sql语句 			
			String sql = "select * from 所有用户"; 			
			// ResultSet类，用来存放获取的结果集 
			rs = statement.executeQuery(sql);
			while(rs.next()) {
				System.out.println(rs.getString("uname"));
				System.out.println(rs.getString("password"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.print("SQL Server连接失败！");
		}finally {
			try {
				rs.close();
				Conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}