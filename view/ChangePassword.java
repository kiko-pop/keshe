package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.UserDao;
import service.UserDaoSevice;
import util.UiUtil;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPasswordField;
/**
 * 这是修改密码类
 * @author 张文成
 * @version 1.0 2020/7.4
 * 例如：ChangePassword cp=new ChangePassword();
 *              cp.setVisible(true);
 * @see java.awt.BorderLayout;
 * @see java.awt.EventQueue;
 * @see avax.swing.JFrame;
 * ...              
 */
public class ChangePassword extends JFrame {

	private JPanel contentPane;
	private JTextField jtfUname;
	private JPasswordField jpfPassword;
	private JPasswordField jpfNewPassword;
	private JPasswordField jpfOkPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangePassword frame = new ChangePassword();
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
	public ChangePassword() {
		initialize();
		init();
	}

	private void init() {
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
	}

	private void initialize() {
		setTitle("修改密码界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton button = new JButton("确认修改");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//获取用户名和密码
				String uname=jtfUname.getText().trim();
				String password=jpfPassword.getText().trim();
				String newpassword=jpfNewPassword.getText().trim();
				String okpassword=jpfOkPassword.getText().trim();
				//用正则表达式做数据校验
				   String unameRegex = "\\w{1,5}";
			        String passwordRegex = "\\w{1,8}";

			        if (!(uname.matches(unameRegex))) {
			           JOptionPane.showMessageDialog(null, "用户名错误（1-5个字母）");
			            jtfUname.setText("");
			            jtfUname.requestFocus();
			            return;
			        }

			        if (!(password.matches(passwordRegex))) {
			        	JOptionPane.showMessageDialog(null, "密码错误（1-8个任意字母）");
			        	jtfUname.setText("");
			            jpfPassword.requestFocus();
			            return;
			        }
			        if(!(newpassword.equals(okpassword))) {
			        	JOptionPane.showMessageDialog(null, "新密码与确认密码不一致");
			        	jpfNewPassword.setText("");
			        	jpfOkPassword.setText("");
			            jpfNewPassword.requestFocus();
			            return;
                    }
			        UserDao ud = new UserDaoSevice();
			        boolean id=ud.identity(uname);
			        boolean flag = ud.change(uname, password,newpassword,id);  
			        if(flag) {
			        	JOptionPane.showMessageDialog(null,"修改成功！");
			        	if(id) {
			        		VIP vip=new VIP();
			        		vip.setVisible(true);
			        		dispose();
			        	}else {
			        		CustomerFrame cf=new CustomerFrame();
			        		cf.setVisible(true);
			        		dispose();
			        	}

			        }
			        else{
			        	JOptionPane.showMessageDialog(null, "原账号或原密码错误");
			        	jtfUname.setText("");
			        	jpfPassword.setText("");
			        	jpfNewPassword.setText("");
			        	jpfOkPassword.setText("");
			        	return;
			        } 
			}
		});
		
		JButton btnvi = new JButton("重置");
		btnvi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	        	jtfUname.setText("");
	        	jpfPassword.setText("");
	        	jpfOkPassword.setText("");
	            jpfNewPassword.setText("");
	            jtfUname.requestFocus();
				
			}
		});
		
		JLabel label = new JLabel("账号");
		label.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		jtfUname = new JTextField();
		jtfUname.setFont(new Font("华文隶书", Font.BOLD, 18));
		jtfUname.setColumns(10);
		
		JLabel label_1 = new JLabel("原密码");
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		JLabel label_2 = new JLabel("新密码");
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		JLabel label_3 = new JLabel("确认密码");
		label_3.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		jpfPassword = new JPasswordField();
		
		jpfNewPassword = new JPasswordField();
		
		jpfOkPassword = new JPasswordField();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnvi)
							.addGap(112)
							.addComponent(button))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(90)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(label)
								.addComponent(label_1)
								.addComponent(label_2)
								.addComponent(label_3))
							.addGap(53)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(jpfOkPassword, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
								.addComponent(jpfNewPassword, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
								.addComponent(jpfPassword, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
								.addComponent(jtfUname, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE))))
					.addGap(147))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(25)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(jtfUname, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(label))
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(jpfPassword, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(jpfNewPassword, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(jpfOkPassword, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(54)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(btnvi))
					.addContainerGap(74, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
