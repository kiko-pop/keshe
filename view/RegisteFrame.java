package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.AdminDao;
import dao.UserDao;
import domain.Admin;
import domain.User;
import service.UserDaoSevice;
import util.UiUtil;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JPasswordField;
import java.awt.Toolkit;
import javax.swing.JRadioButton;
/**
 * 用户注册界面类
 * @author 张文成
 * @version 1.0 2020/7.4
 * 例如：RegisteFrame rf=new RegisteFrame();
 *              rf.setVisible(true);
 * @see java.awt.BorderLayout;
 * @see java.awt.EventQueue;
 * @see avax.swing.JFrame;
 * ...              
 */
public class RegisteFrame extends JFrame {

	private JPanel contentPane;
	private JTextField jtfUname;
	private JPasswordField jpfPassword;




	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisteFrame frame = new RegisteFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}



	/**
	 * Create the frame.
	 */

	public RegisteFrame() {
		initialize();
		init();	
	}
	private void init() {
		// TODO 自动生成的方法存根
		//设置背景图片
				
					// TODO 自动生成的方法存根
					 ImageIcon icon = new ImageIcon("src\\pic\\2.jpg"); 

						// 将图片放入label中
						JLabel label2 = new JLabel(icon);

						// 设置label的大小
						label2.setBounds(0, 0, 600, 500);		
						
						// 获取窗口的第二层，将label放入
						getLayeredPane().add(label2, new Integer(Integer.MIN_VALUE));
						JPanel panel = new JPanel();
						panel.setForeground(Color.BLACK);
						// 获取frame的顶层容器,并设置为透明
						JPanel j = (JPanel) getContentPane();
						j.setOpaque(false);
						// 必须设置为透明的。否则看不到图片
						panel.setOpaque(false);
						getContentPane().add(panel, BorderLayout.NORTH);
						panel.setLayout(new BorderLayout(0, 0));						
						UiUtil.setFrameCenter(this);//界面居中
						setResizable(false);
									
	}

	private void initialize() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegisteFrame.class.getResource("/pic/头像.jpg")));
		setTitle("注册界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,587, 451);
		setResizable(false);//不允许改变窗口大小

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("请输入个人信息");
		label.setFont(new Font("华文行楷", Font.PLAIN, 30));
		
		JLabel label_1 = new JLabel("账号");
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		JButton button = new JButton("重置");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 jtfUname.setText("");
			     jpfPassword.setText("");
			}
		});
		
		JButton button_1 = new JButton("注册普通用户");
		button_1.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent e) {
				
				//获取用户名和密码
				String uname=jtfUname.getText().trim();
				String password=jpfPassword.getText().trim();
				//用正则表达式做数据校验
				   String unameRegex = "\\w{1,8}";
			        String passwordRegex ="\\w{1,8}";

			        if (!(uname.matches(unameRegex))) {
			            JOptionPane.showMessageDialog(null, "用户名错误（1-5个任意字母）");
			            jtfUname.setText("");
			            jtfUname.requestFocus();
			            return;
			        }

			        if (!(password.matches(passwordRegex))) {
			        	JOptionPane.showMessageDialog(null, "密码错误（1-8个任意字母）");
			            jpfPassword.setText("");
			            jpfPassword.requestFocus();
			            return;
			        }

			        //封装用户对象
			        User user = new User();
			        user.setUname(uname);
			        user.setPassword(password);

			        // 调用用户操作的功能进行注册
			        boolean id=false;
			        UserDao ud = new UserDaoSevice();
			        boolean flag=ud.regist(uname,password,id);
                    if(!flag) {
                    	 // 提示注册成功
    			        JOptionPane.showMessageDialog(null,"用户注册成功");
                    }else {
                    	JOptionPane.showMessageDialog(null,"此用户已存在");
                    }
                    AdminDao ad=new AdminDao();
    				Admin admin=new Admin();
    				admin.setUname(uname);
    				admin.setPassword(password);
    				ad.insert(admin);
			        goLoginFrame();
			}

			private void goLoginFrame() {
				// TODO 自动生成的方法存根
//				LoginFrame lf=new LoginFrame();
//				new LoginFrame().setVisible(true);//注册界面出现
				dispose();//释放注册界面屏幕资源
			}	
		});
		JButton btnvip = new JButton("注册VIP用户");
		btnvip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {					
					//获取用户名和密码
					String uname=jtfUname.getText().trim();
					String password=jpfPassword.getText().trim();
					//用正则表达式做数据校验
					   String unameRegex = "\\w{1,8}";
				        String passwordRegex ="\\w{1,8}";

				        if (!(uname.matches(unameRegex))) {
				            JOptionPane.showMessageDialog(null, "VIP用户名错误（1-5个任意字母）");
				            jtfUname.setText("");
				            jtfUname.requestFocus();
				            return;
				        }

				        if (!(password.matches(passwordRegex))) {
				        	JOptionPane.showMessageDialog(null, "密码错误（1-8个任意字母）");
				            jpfPassword.setText("");
				            jpfPassword.requestFocus();
				            return;
				        }

				        //封装用户对象
				        User user = new User();
				        user.setUname(uname);
				        user.setPassword(password);

				        // 调用用户操作的功能进行注册
				        boolean id=true;
				        UserDao ud = new UserDaoSevice();
				        boolean flag=ud.regist(uname,password,id);
	                    if(!flag) {
	                    	 // 提示注册成功
	    			        JOptionPane.showMessageDialog(null,"VIP用户注册成功");
	                    }else {
	                    	JOptionPane.showMessageDialog(null,"此用户已存在");
	                    }
	                    AdminDao ad=new AdminDao();
	    				Admin admin=new Admin();
	    				admin.setUname(uname);
	    				admin.setPassword(password);
	    				ad.insertVIP(admin);
				        goLoginFrame();
				}

				private void goLoginFrame() {
					// TODO 自动生成的方法存根
//					LoginFrame lf=new LoginFrame();
//					new LoginFrame().setVisible(true);//注册界面出现
					dispose();//释放注册界面屏幕资源
				}	
				
			
		});
		
		jtfUname = new JTextField();
		jtfUname.setFont(new Font("华文隶书", Font.BOLD, 18));
		jtfUname.setColumns(10);
		
		JButton button_2 = new JButton("取消");
		
		JLabel label_2 = new JLabel("密码");
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		jpfPassword = new JPasswordField();
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				LoginFrame lf=new LoginFrame();
//				lf.setVisible(true);
				dispose();
			}
		});
		


		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(54)
							.addComponent(button)
							.addGap(31)
							.addComponent(button_2)
							.addPreferredGap(ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
							.addComponent(button_1)
							.addGap(22))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(114)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(label_2)
								.addComponent(label_1))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(jpfPassword, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
								.addComponent(jtfUname, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE))))
					.addGap(5)
					.addComponent(btnvip)
					.addGap(58))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(158, Short.MAX_VALUE)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE)
					.addGap(145))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(36)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(jtfUname, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1))
					.addGap(45)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label_2)
						.addComponent(jpfPassword, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addGap(70)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_1)
						.addComponent(btnvip)
						.addComponent(button_2)
						.addComponent(button))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		
	}
}
