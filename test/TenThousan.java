package test;

import dao.AdminDao;
import domain.Admin;
import domain.User;

public class TenThousan {
	public static void main(String[] args) {
		
	AdminDao ad=new AdminDao();
	String uname="z";
	String password="w";
    for(int i=0;i<10000;i++) {
    	Admin admin=new Admin();
    	admin.setUname(uname+i);
    	admin.setPassword(password+i);
    	ad.insert(admin);
    }
	}
}
