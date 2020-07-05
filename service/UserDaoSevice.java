package service;


import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.FileWriter;
import java.io.FileReader;
import dao.UserDao;
import domain.User;
/**
 * 这是用户操作的具体实现类
 * @author 张文成
 * @version 1.0 2020/7.4
 */
public class UserDaoSevice implements UserDao {
	//定义文件
	private static File file=new File("E:\\Java\\GUI1\\user.txt");
	private static File vipfile=new File("E:\\Java\\GUI1\\vip.txt");
	//类加载的时候就创建文件
	static {
		try {
			file.createNewFile();
			vipfile.createNewFile();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	/**
	 * 通过用户名称返回的值判断用户身份的方法
	 * 例如：UserDao ud = new UserDaoImpl();
	 *		        boolean id=ud.identity(uname);
	 *@param uname 用户名称
	 *@return flag 判断是否是VIP
	 *@see java.io.File;
     *@see java.io.IOException;
     *@see java.io.RandomAccessFile;
     *@see java.io.FileWriter;
     *@see java.io.FileReader;
     *@see dao.UserDao;
     *@see domain.User;
	 */
	@Override
	public boolean identity(String uname) {
		boolean flag=false;
		try {
			RandomAccessFile raf=new RandomAccessFile(vipfile,"rw");
			String name="";//原文档里拆分出来要被检查的名字
			//String password2="";//原文档里拆分出来要被检查的密码
			String record;//拼接后的字符串
			String newUname=uname;//用户登录界面输入的账号
			//String newPassword=password;//用户登录界面输入的密码
			int index;
			while(raf.getFilePointer()<raf.length()) {
				record=raf.readLine();
            	index = record.indexOf("=");
            	name=record.substring(0,index);
            	//password2=record.substring(index+1,record.length());
            	if(name.equals(newUname)) {
            		flag=true;
         			break;
            	}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				//raf.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return flag;	
		}

	/**
	 * 用户登录的方法
	 * 例如：UserDao ud = new UserDaoImpl();
	 *		        ud.login(uname,password,id);
	 *@param uname 用户名称
	 *@param password 用户密码
	 *@param id 判断是不是VIP
	 *@return flag 判断是否登录成功
	 *@see java.io.File;
     *@see java.io.IOException;
     *@see java.io.RandomAccessFile;
     *@see java.io.FileWriter;
     *@see java.io.FileReader;
     *@see dao.UserDao;
     *@see domain.User;
	 */
	@Override
	public boolean login(String uname, String password,boolean id) {
		boolean flag=false;
		if(id) {
			try {
				RandomAccessFile raf=new RandomAccessFile(vipfile,"rw");
				String name="";//原文档里拆分出来要被检查的名字
				String password2="";//原文档里拆分出来要被检查的密码
				String record;//拼接后的字符串
				String newUname=uname;//用户登录界面输入的账号
				String newPassword=password;//用户登录界面输入的密码
				int index;
				while(raf.getFilePointer()<raf.length()) {
					record=raf.readLine();
	            	index = record.indexOf("=");
	            	name=record.substring(0,index);
	            	password2=record.substring(index+1,record.length());
	            	if(name.equals(newUname)&&password2.equals(newPassword)) {
	            		flag=true;
	         			break;
	            	}
				}

			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					//raf.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return flag;	
		}else {
			try {
				RandomAccessFile raf=new RandomAccessFile(file,"rw");
				String name="";//原文档里拆分出来要被检查的名字
				String password2="";//原文档里拆分出来要被检查的密码
				String record;//拼接后的字符串
				String newUname=uname;//用户登录界面输入的账号
				String newPassword=password;//用户登录界面输入的密码
				int index;
				while(raf.getFilePointer()<raf.length()) {
					record=raf.readLine();
	            	index = record.indexOf("=");
	            	name=record.substring(0,index);
	            	password2=record.substring(index+1,record.length());
	            	if(name.equals(newUname)&&password2.equals(newPassword)) {
	            		flag=true;
	         			break;
	            	}
				}

			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					//raf.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return flag;	
		}
		
	}

	/**
	 * 用户注册新增方法
	 * 例如：UserDao ud = new UserDaoImpl();
	 *		        ud.regist(uname,password,id);
	 *@param uname 用户名称
	 *@param password 用户密码
	 *@param id 判断是不是VIP
	 *@return flag 判断是否注册成功
	 *@see java.io.File;
     *@see java.io.IOException;
     *@see java.io.RandomAccessFile;
     *@see java.io.FileWriter;
     *@see java.io.FileReader; 
     *@see dao.UserDao;
     *@see domain.User;
	 */
	@Override
	public boolean regist(String uname,String password,boolean id) {	    
		boolean flag=false;
		if(id) {
			try {
		    	RandomAccessFile raf=new RandomAccessFile(vipfile,"rw");
		    	String newUname=uname;//想注册的名字
		    	String record;//拼接后的字符串
		    	int index;
		    	String name="";//原文档里拆分出来要被检查的名字	
	            while(raf.getFilePointer()<raf.length()) {
	            	record=raf.readLine();
	            	index=record.indexOf("=");
	            	name=record.substring(0,index);
	            	if(name.equals(newUname)) {//查到就退出
	            		flag=true;
	            		break;
	            	}
	            }
	           
	            if(!flag) {//不存在就新增
	            	record=newUname+"="+password;
	            	raf.writeBytes(record);
	            	raf.writeBytes(System.lineSeparator());//换行
	            }else {
	            	raf.close();
	            }

		    }catch (Exception e) {
				e.printStackTrace();
		}
			return flag;
		}else {
			try {
		    	RandomAccessFile raf=new RandomAccessFile(file,"rw");
		    	String newUname=uname;//想注册的名字
		    	String record;//拼接后的字符串
		    	int index;
		    	String name="";//原文档里拆分出来要被检查的名字	
	            while(raf.getFilePointer()<raf.length()) {
	            	record=raf.readLine();
	            	index=record.indexOf("=");
	            	name=record.substring(0,index);
	            	if(name.equals(newUname)) {//查到就退出
	            		flag=true;
	            		break;
	            	}
	            }
	           
	            if(!flag) {//不存在就新增
	            	record=newUname+"="+password;
	            	raf.writeBytes(record);
	            	raf.writeBytes(System.lineSeparator());//换行
	            }else {
	            	raf.close();
	            }

		    }catch (Exception e) {
				e.printStackTrace();
		}
			return flag;
		}
		
	}	
	/**
	 * 修改用户密码的方法
	 * 例如：UserDao ud = new UserDaoImpl();
	 *		        ud.change(uname,password,newpassword,id);
	 *@param uname 用户名称
	 *@param password 用户密码
	 *@param newpassword 新的用户密码
	 *@param id 判断是不是VIP
     *@return flag 判断是否修改成功
	 *@see java.io.File;
     *@see java.io.IOException;
     *@see java.io.RandomAccessFile;
     *@see java.io.FileWriter;
     *@see java.io.FileReader;
     *@see dao.UserDao;
     *@see domain.User;
	 */
	public boolean change(String uname,String password,String newpassword,boolean id) {
		boolean flag=false;
		if(id) {
			try {
		    	RandomAccessFile raf=new RandomAccessFile(vipfile,"rw");
		    	String record;//拼接后的字符串
		    	int index;
		    	String name="";//原文档里拆分出来要被检查的名字
		    	String password2="";//原文档里拆分出来要被检查的密码
	            while(raf.getFilePointer()<raf.length()) {
	            	record=raf.readLine();
	            	index=record.indexOf("=");
	            	name=record.substring(0,index);
	            	password2=record.substring(index+1,record.length());
	            	if(name.equals(uname)&&password2.equals(password)) {
	            		flag=true;//存在这个想要修改密码的账号
	            		break;
	            	}
	            }
	           
	            if(flag) {//存在就改密码
	            	File tmpFile=new File("temp.txt");
	            	RandomAccessFile tmpraf=new RandomAccessFile(tmpFile,"rw");
	            	raf.seek(0);
	            	while(raf.getFilePointer()<raf.length()) {
	            		record=raf.readLine();
	            		index=record.indexOf("=");
	            		name=record.substring(0,index);
	            		if(name.equals(uname)) {//按名字匹配被修改的人
	            			record=name+"="+newpassword;//被修改后的账号信息
	            		}
	            		tmpraf.writeBytes(record);
	            		tmpraf.writeBytes(System.lineSeparator());//换行
	            	}//临时文件包含了新信息
	            	raf.seek(0);
	            	tmpraf.seek(0);
	            	while(tmpraf.getFilePointer()<tmpraf.length()) {
	            		raf.writeBytes(tmpraf.readLine());//一行一行复制
	            		raf.writeBytes(System.lineSeparator());//换行
	            	}
	            	raf.setLength(tmpraf.length());
	            	raf.close();
	            	tmpraf.close();
	            	tmpFile.delete();//删除临时文件
	            }else {
	            	raf.close();
	            }
		    }catch (Exception e) {
				e.printStackTrace();
				}
			return flag;
		}else {
			try {
		    	RandomAccessFile raf=new RandomAccessFile(file,"rw");
		    	String record;//拼接后的字符串
		    	int index;
		    	String name="";//原文档里拆分出来要被检查的名字
		    	String password2="";//原文档里拆分出来要被检查的密码
	            while(raf.getFilePointer()<raf.length()) {
	            	record=raf.readLine();
	            	index=record.indexOf("=");
	            	name=record.substring(0,index);
	            	password2=record.substring(index+1,record.length());
	            	if(name.equals(uname)&&password2.equals(password)) {
	            		flag=true;//存在这个想要修改密码的账号
	            		break;
	            	}
	            }
	           
	            if(flag) {//存在就改密码
	            	File tmpFile=new File("temp.txt");
	            	RandomAccessFile tmpraf=new RandomAccessFile(tmpFile,"rw");
	            	raf.seek(0);
	            	while(raf.getFilePointer()<raf.length()) {
	            		record=raf.readLine();
	            		index=record.indexOf("=");
	            		name=record.substring(0,index);
	            		if(name.equals(uname)) {//按名字匹配被修改的人
	            			record=name+"="+newpassword;//被修改后的账号信息
	            		}
	            		tmpraf.writeBytes(record);
	            		tmpraf.writeBytes(System.lineSeparator());//换行
	            	}//临时文件包含了新信息
	            	raf.seek(0);
	            	tmpraf.seek(0);
	            	while(tmpraf.getFilePointer()<tmpraf.length()) {
	            		raf.writeBytes(tmpraf.readLine());//一行一行复制
	            		raf.writeBytes(System.lineSeparator());//换行
	            	}
	            	raf.setLength(tmpraf.length());
	            	raf.close();
	            	tmpraf.close();
	            	tmpFile.delete();//删除临时文件
	            }else {
	            	raf.close();
	            }
		    }catch (Exception e) {
				e.printStackTrace();
				}
			return flag;
		}
		
   }

	//销户
	/**
	 * 注销用户方法
	 * 例如：UserDao ud = new UserDaoImpl();
	 *		        ud.delete(uname,password,id);
	 *@param uname 用户名称
	 *@param password 用户密码
	 *@param id 判断是不是VIP
	 *@return flag 判断是否销户成功
	 *@see java.io.File;
     *@see java.io.IOException;
     *@see java.io.RandomAccessFile;
     *@see java.io.FileWriter;
     *@see java.io.FileReader;
     *@see dao.UserDao;
     *@see domain.User;
	 */
	@Override
	public boolean delete(String uname, String password,boolean id) {
		// TODO 自动生成的方法存根
		boolean flag=false;
		if(id) {
			try {
		    	RandomAccessFile raf=new RandomAccessFile(vipfile,"rw");
		    	String record;//拼接后的字符串
		    	int index;
		    	String name="";//原文档里拆分出来要被检查的名字
		    	String password2="";//原文档里拆分出来要被检查的密码
	            while(raf.getFilePointer()<raf.length()) {
	            	record=raf.readLine();
	            	index=record.indexOf("=");
	            	name=record.substring(0,index);
	            	password2=record.substring(index+1,record.length());
	            	if(name.equals(uname)&&password2.equals(password)) {
	            		flag=true;//存在这个想要销户的账号
	            		break;
	            	}
	            }
	           
	            if(flag) {//存在就销户
	            	File tmpFile=new File("temp.txt");
	            	RandomAccessFile tmpraf=new RandomAccessFile(tmpFile,"rw");
	            	raf.seek(0);
	            	while(raf.getFilePointer()<raf.length()) {
	            		record=raf.readLine();
	            		index=record.indexOf("=");
	            		name=record.substring(0,index);
	            		if(name.equals(uname)) {//按名字匹配被修改的人
	            			continue;//找到要销户的名字就不存进临时文件
	            		}
	            		tmpraf.writeBytes(record);
	            		tmpraf.writeBytes(System.lineSeparator());//换行
	            	}//临时文件包含了新信息
	            	raf.seek(0);
	            	tmpraf.seek(0);
	            	while(tmpraf.getFilePointer()<tmpraf.length()) {
	            		raf.writeBytes(tmpraf.readLine());//一行一行复制
	            		raf.writeBytes(System.lineSeparator());//换行
	            	}
	            	raf.setLength(tmpraf.length());
	            	raf.close();
	            	tmpraf.close();
	            	tmpFile.delete();//删除临时文件
	            }else {
	            	raf.close();
	            }
		    }catch (Exception e) {
				e.printStackTrace();
				}
			return flag;
		}else {
			try {
		    	RandomAccessFile raf=new RandomAccessFile(file,"rw");
		    	String record;//拼接后的字符串
		    	int index;
		    	String name="";//原文档里拆分出来要被检查的名字
		    	String password2="";//原文档里拆分出来要被检查的密码
	            while(raf.getFilePointer()<raf.length()) {
	            	record=raf.readLine();
	            	index=record.indexOf("=");
	            	name=record.substring(0,index);
	            	password2=record.substring(index+1,record.length());
	            	if(name.equals(uname)&&password2.equals(password)) {
	            		flag=true;//存在这个想要销户的账号
	            		break;
	            	}
	            }
	           
	            if(flag) {//存在就销户
	            	File tmpFile=new File("temp.txt");
	            	RandomAccessFile tmpraf=new RandomAccessFile(tmpFile,"rw");
	            	raf.seek(0);
	            	while(raf.getFilePointer()<raf.length()) {
	            		record=raf.readLine();
	            		index=record.indexOf("=");
	            		name=record.substring(0,index);
	            		if(name.equals(uname)) {//按名字匹配被修改的人
	            			continue;//找到要销户的名字就不存进临时文件
	            		}
	            		tmpraf.writeBytes(record);
	            		tmpraf.writeBytes(System.lineSeparator());//换行
	            	}//临时文件包含了新信息
	            	raf.seek(0);
	            	tmpraf.seek(0);
	            	while(tmpraf.getFilePointer()<tmpraf.length()) {
	            		raf.writeBytes(tmpraf.readLine());//一行一行复制
	            		raf.writeBytes(System.lineSeparator());//换行
	            	}
	            	raf.setLength(tmpraf.length());
	            	raf.close();
	            	tmpraf.close();
	            	tmpFile.delete();//删除临时文件
	            }else {
	            	raf.close();
	            }
		    }catch (Exception e) {
				e.printStackTrace();
				}
			return flag;
		}
		}	
}
