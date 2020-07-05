package test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;

import domain.User;

public class DisplayUser {
	public static void main(String adta[]) {
	try {
		String record;
		String name;
		String password;
		int index;
		ArrayList<User> userList=new ArrayList<User>();
		File file=new File("user.txt");
		if(!file.exists()) {
			file.createNewFile();
		}
		RandomAccessFile raf=new RandomAccessFile(file,"rw");
		boolean found=false;
		//遍历
		while(raf.getFilePointer()<raf.length()) {
			record=raf.readLine();
        	index=record.indexOf("=");
        	name=record.substring(0,index);
        	password=record.substring(index+1,record.length());
        	
        	User user=new User();
        	user.setUname(name);
        	user.setPassword(password);
        	
        	userList.add(user);
        	
		}
		Iterator<User> it=userList.iterator();
		while(it.hasNext()) {//打印数据
			User user=it.next();
			System.out.println("uname:"+user.getUname()+" "+"password:"+user.getPassword());
		}
		
	}
	catch(IOException ioe){
		System.out.println(ioe);
	}
	}
}
