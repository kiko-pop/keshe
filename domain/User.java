package domain;
/**
 * 用户基本描述类
 * @author 张文成
 * @version 1.0 2020/7.4
 * @param uname 用户账号名
 * @param password 用户密码
 */
public class User {
  private String uname;
  private String password;
  public User() {
	super();
	// TODO 自动生成的构造函数存根
  }
public String getUname() {
	return uname;
}
public void setUname(String uname) {
	this.uname = uname;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

  

}
