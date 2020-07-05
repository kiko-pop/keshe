package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import domain.Admin;
import domain.User;
/**
 * 这是针对JDBC进行操作的接口
 * @author 张文成
 * @version 1.0 2020/7.4
 */
public class AdminDao {
	//public static void main(String[] args) {
		String driverName = "com.mysql.cj.jdbc.Driver";
		String dbURL = "jdbc:mysql://127.0.0.1:3306/user?characterEncoding=utf8&useUnicode=true&useSSL=false&serverTimezone=UTC";
		String userName = "root";
		String userPwd = "15697463503z";
		
		Connection Conn=null;//数据库链接对象
		//Statement statement=null;//执行sql的对象
		PreparedStatement pstat=null;//语句对象
		PreparedStatement pstat2=null;//语句对象
		/**
	     * 将一行VIP用户数据写入数据库VIP用户表和所有用户表中
	     * @param admin 管理员的类
	     */
		public void insertVIP(Admin admin) {
			String sql="insert into vip用户 values(?,?)";
			String sql2="insert into 所有用户 values(?,?)";
			try {
				Class.forName(driverName); 
				Conn = DriverManager.getConnection(dbURL, userName, userPwd);
				pstat=Conn.prepareStatement(sql);
				pstat.setString(1, admin.getUname());
				pstat.setString(2, admin.getPassword());
				pstat2=Conn.prepareStatement(sql2);
				pstat2.setString(1, admin.getUname());
				pstat2.setString(2, admin.getPassword());
				pstat.executeUpdate();
				pstat2.executeUpdate();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(pstat!=null) {
						pstat.close();
					}
				}catch(SQLException e) {
					e.printStackTrace();
				}try {
					if(Conn!=null) {
						Conn.close();
					}
				}catch(SQLException e) {
					e.printStackTrace();
				}
				}
		}

		/**
	     * 将一行普通用户数据写入数据库普通用户表和所有用户表中
	     * @param admin 管理员的类
	     */
		public void insert(Admin admin) {
			String sql="insert into 普通用户 values(?,?)";
			String sql2="insert into 所有用户 values(?,?)";
			try {
				Class.forName(driverName); 
				Conn = DriverManager.getConnection(dbURL, userName, userPwd);
				pstat=Conn.prepareStatement(sql);
				pstat.setString(1, admin.getUname());
				pstat.setString(2, admin.getPassword());
				pstat2=Conn.prepareStatement(sql2);
				pstat2.setString(1, admin.getUname());
				pstat2.setString(2, admin.getPassword());
				pstat.executeUpdate();
				pstat2.executeUpdate();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(pstat!=null) {
						pstat.close();
					}
				}catch(SQLException e) {
					e.printStackTrace();
				}try {
					if(Conn!=null) {
						Conn.close();
					}
				}catch(SQLException e) {
					e.printStackTrace();
				}
				}
		}
		
		/**
	     * 将一行用户数据写入数据库Line表中
	     * @param num 用户的号码
	     * @param uname 用户的账号名
	     * @param id id用来判断是否是VIP
	     */
		public void insertLine(int num,String uname,int id) {
			String sql="insert into 队列 values(?,?,?)";
			try {
				Class.forName(driverName); 
				Conn = DriverManager.getConnection(dbURL, userName, userPwd);
				pstat=Conn.prepareStatement(sql);
				pstat.setInt(1, num);
				pstat.setString(2, uname);
				pstat.setInt(3, id);
				pstat.executeUpdate();
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(pstat!=null) {
						pstat.close();
					}
				}catch(SQLException e) {
					e.printStackTrace();
				}try {
					if(Conn!=null) {
						Conn.close();
					}
				}catch(SQLException e) {
					e.printStackTrace();
				}
				}
		}
		
		/**
	     * 删除数据库表中的VIP用户信息
	     * @param uname 用户的账号名
	     */
		public int deleteVIP(String uname) {
			int count=0;
			String sql="DELETE FROM vip用户 WHERE UNAME=?";
			try {
				Class.forName(driverName); 
				Conn = DriverManager.getConnection(dbURL, userName, userPwd);
				pstat=Conn.prepareStatement(sql);
				pstat.setString(1, uname);
				count=pstat.executeUpdate();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(pstat!=null) {
						pstat.close();
					}
				}catch(SQLException e) {
					e.printStackTrace();
				}try {
					if(Conn!=null) {
						Conn.close();
					}
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			return count;
		}
		
		/**
	     * 删除数据库表中的普通用户信息
	     * @param uname 用户的账号名
	     */
		public int delete(String uname) {
			int count=0;
			String sql="DELETE FROM 普通用户 WHERE UNAME=?";
			try {
				Class.forName(driverName); 
				Conn = DriverManager.getConnection(dbURL, userName, userPwd);
				pstat=Conn.prepareStatement(sql);
				pstat.setString(1, uname);
				count=pstat.executeUpdate();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(pstat!=null) {
						pstat.close();
					}
				}catch(SQLException e) {
					e.printStackTrace();
				}try {
					if(Conn!=null) {
						Conn.close();
					}
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			return count;
		}
		
		/**
	     * 删除数据库总表中的用户信息
	     * @param uname 用户的账号名
	     */
		public int deleteStat(String uname) {
			int count=0;
			String sql="DELETE FROM 所有用户 WHERE UNAME=?";
			try {
				Class.forName(driverName); 
				Conn = DriverManager.getConnection(dbURL, userName, userPwd);
				pstat=Conn.prepareStatement(sql);
				pstat.setString(1, uname);
				count=pstat.executeUpdate();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(pstat!=null) {
						pstat.close();
					}
				}catch(SQLException e) {
					e.printStackTrace();
				}try {
					if(Conn!=null) {
						Conn.close();
					}
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			return count;
		}
		
		/**
	     * 删除队列里的用户信息
	     * @param num 用户的排队号
	     */
		public void deleteLine(int num) {

			String sql="DELETE FROM 队列 WHERE num=?";
			try {
				Class.forName(driverName); 
				Conn = DriverManager.getConnection(dbURL, userName, userPwd);
				pstat=Conn.prepareStatement(sql);
				pstat.setInt(1, num);
				pstat.executeUpdate();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(pstat!=null) {
						pstat.close();
					}
				}catch(SQLException e) {
					e.printStackTrace();
				}try {
					if(Conn!=null) {
						Conn.close();
					}
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}

		}
		
		/**
	     * 查询队列里第一个人的排队号
	     */
		public int first( ) {
			int count=0;
			String sql="select * from 队列 order by id desc";
			ResultSet rs=null;
			try {
				Class.forName(driverName); 
				Conn = DriverManager.getConnection(dbURL,userName, userPwd);
				pstat=Conn.prepareStatement(sql);
				rs=pstat.executeQuery();
				if(rs.next()) {
					count=rs.getInt("num");
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {//回收资源
				try {
					if(rs!=null) {
						rs.close();
					}
				}catch(SQLException e) {
					e.printStackTrace();
				}try {
					if(pstat!=null) {
						pstat.close();
					}
				}catch(SQLException e) {
					e.printStackTrace();
				}try {
					if(Conn!=null) {
						Conn.close();
					}
				}catch(SQLException e) {
					e.printStackTrace();
				}
				}
			return count;
			
		}
				
		/**
	     * 通过用户名查询用户的信息
	     * @param uname 用户名
	     */
		public Admin selectOne(String uname) {
			Admin admin=null;
			String sql="select uname,password from 所有用户 where uname=?";
			ResultSet rs=null;
			try {
				Class.forName(driverName); 
				Conn = DriverManager.getConnection(dbURL, userName, userPwd);
				pstat=Conn.prepareStatement(sql);
				pstat.setString(1, uname);
				rs=pstat.executeQuery();
				if(rs.next()) {
					admin=new Admin();
					admin.setUname(rs.getString("uname"));
					admin.setPassword(rs.getString("password"));
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {//回收资源
				try {
					if(rs!=null) {
						rs.close();
					}
				}catch(SQLException e) {
					e.printStackTrace();
				}try {
					if(pstat!=null) {
						pstat.close();
					}
				}catch(SQLException e) {
					e.printStackTrace();
				}try {
					if(Conn!=null) {
						Conn.close();
					}
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			return admin;			
		}
		
		/**
	     * 修改VIP用户的密码
	     * @param admin 管理员的类
	     */
		public int updateVIP(Admin admin) {
			int count=0;//记录更改的行数
			String sql="update vip用户 set password=? where uname=?";
			try {
				Class.forName(driverName); 
				Conn = DriverManager.getConnection(dbURL, userName, userPwd);
				pstat=Conn.prepareStatement(sql);			
				pstat.setString(1, admin.getPassword());
				pstat.setString(2, admin.getUname());
				count=pstat.executeUpdate();			
			}catch(Exception e) {
				e.printStackTrace();
			}finally {//回收资源
			try {
					if(pstat!=null) {
						pstat.close();
					}
				}catch(SQLException e) {
					e.printStackTrace();
				}try {
					if(Conn!=null) {
						Conn.close();
					}
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			return count;
			
		}
		/**
	     * 修改普通用户的密码
	     * @param admin 管理员的类
	     */		
        public int update(Admin admin) {
			int count=0;//记录更改的行数
			String sql="update 普通用户 set password=? where uname=?";
			try {
				Class.forName(driverName); 
				Conn = DriverManager.getConnection(dbURL, userName, userPwd);
				pstat=Conn.prepareStatement(sql);			
				pstat.setString(1, admin.getPassword());
				pstat.setString(2, admin.getUname());
				count=pstat.executeUpdate();			
			}catch(Exception e) {
				e.printStackTrace();
			}finally {//回收资源
			try {
					if(pstat!=null) {
						pstat.close();
					}
				}catch(SQLException e) {
					e.printStackTrace();
				}try {
					if(Conn!=null) {
						Conn.close();
					}
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			return count;
			
		}
		
        /**
	     * 修改总表信息
	     * @param admin 管理员的类
	     */	
		public int updateStat(Admin admin) {
			int count=0;//记录更改的行数
			String sql="update 所有用户 set password=? where uname=?";
			try {
				Class.forName(driverName); 
				Conn = DriverManager.getConnection(dbURL, userName, userPwd);
				pstat=Conn.prepareStatement(sql);			
				pstat.setString(1, admin.getPassword());
				pstat.setString(2, admin.getUname());
				count=pstat.executeUpdate();			
			}catch(Exception e) {
				e.printStackTrace();
			}finally {//回收资源
			try {
					if(pstat!=null) {
						pstat.close();
					}
				}catch(SQLException e) {
					e.printStackTrace();
				}try {
					if(Conn!=null) {
						Conn.close();
					}
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			return count;
			
		}
		
	    /**
	     * 查询用户是否存在
	     * @param uname 用户的账号
	     */	
		public boolean refer(String uname) {
			boolean flag=false;
			String sql="SELECT password FROM 所有用户 WHERE uname=?";
			ResultSet rs=null;
			try {
				Class.forName(driverName); 
				Conn = DriverManager.getConnection(dbURL, userName, userPwd);
				pstat=Conn.prepareStatement(sql);			
				pstat.setString(1, uname);
				rs=pstat.executeQuery();
				if(rs.next()) {
					flag=true;//有next就是存在
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {//回收资源
			try {
					if(pstat!=null) {
						pstat.close();
					}
				}catch(SQLException e) {
					e.printStackTrace();
				}try {
					if(Conn!=null) {
						Conn.close();
					}
				}catch(SQLException e) {
					e.printStackTrace();
				}try {
					if(rs!=null) {
						rs.close();
					}
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			return flag;
			
		}
		
		/**
	     * //查询队列有多少人
	     */	
		public int num( ) {
			String sql="select count(uname) from 队列 group by uname";
			ResultSet rs=null;
			int count=1;
			try {
				Class.forName(driverName); 
				Conn = DriverManager.getConnection(dbURL, userName, userPwd);
				pstat=Conn.prepareStatement(sql);
				rs=pstat.executeQuery();
				while(rs.next()) {
					count++;
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {//回收资源
				try {
					if(rs!=null) {
						rs.close();
					}
				}catch(SQLException e) {
					e.printStackTrace();
				}try {
					if(pstat!=null) {
						pstat.close();
					}
				}catch(SQLException e) {
					e.printStackTrace();
				}try {
					if(Conn!=null) {
						Conn.close();
					}
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			return count;			
		}
       	
}
