package dao;

import domain.User;

/**
 * 这是针对用户进行操作的接口
 * @author 张文成
 * @version 1.0 2020/7.4
 */
public interface UserDao {
    /**
     * 用户登录功能
     * @param uname 用户名
     * @param password 密码
     * @param id判断是普通用户还是vip用户
     * @return 返回登录是否成功
     */
	public abstract boolean login(String uname,String password,boolean id);
	/**
	 * 用户注册功能
	 * @param uname 用户名
     * @param password 密码
     * @param id判断是普通用户还是vip用户
	 * @param user 要注册的用户信息
	 */
	public abstract boolean regist(String uname,String password,boolean id);
	/**
	 * 用户修改密码
	 * @param uname 用户名
     * @param newpassword 新密码
     * @return 返回修改是否成功
	 */

	public abstract boolean change(String uname,String password,String newpassword,boolean id);
	/**
	 * 用户销户功能
	 * @param uname 用户名
     * @param password 密码
     * @param id判断是普通用户还是vip用户
     * @return 返回销户是否成功
	 */
	public abstract boolean delete(String uname,String password,boolean id);
	/**
	 * 判断是否为VIP用户功能
	 * @param uname 用户名
     * @return 返回是否是VIP
	 */
	public abstract boolean identity(String uname);
}
