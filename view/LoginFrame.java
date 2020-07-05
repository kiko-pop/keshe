package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import java.awt.Button;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import dao.UserDao;
import service.UserDaoSevice;
import util.UiUtil;

import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.Toolkit;
import javax.swing.JRadioButton;
/**
 * 用户登录界面类
 * @author 张文成
 * @version 1.0 2020/7.4
 * 例如：LoginFrame lf=new LoginFrame();
 *              lf.setVisible(true);
 * @see java.awt.BorderLayout;
 * @see java.awt.EventQueue;
 * @see avax.swing.JFrame;
 * ...              
 */
public class LoginFrame extends JFrame{

	private JFrame frame;
	private JTextField jtfUname;
	private JPasswordField jpfPassword;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame window = new LoginFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginFrame() {
		initialize();
		init();	
	}



	private void init() {
		// TODO 自动生成的方法存根
		 ImageIcon icon = new ImageIcon("src\\pic\\2.jpg"); 

			// 将图片放入label中
			JLabel label = new JLabel(icon);

			// 设置label的大小
			label.setBounds(0, 0, 600, 500);		
			
			// 获取窗口的第二层，将label放入
			frame.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
			JPanel panel = new JPanel();
			panel.setForeground(Color.BLACK);
			// 获取frame的顶层容器,并设置为透明
			JPanel j = (JPanel) frame.getContentPane();
			j.setOpaque(false);
			// 必须设置为透明的。否则看不到图片
			panel.setOpaque(false);
			frame.getContentPane().add(panel, BorderLayout.NORTH);
			panel.setLayout(new BorderLayout(0, 0));
			
			UiUtil.setFrameCenter(frame);//界面居中
			frame.setResizable(false);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame =  new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setForeground(new Color(144, 238, 144));
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(LoginFrame.class.getResource("/pic/头像.jpg")));
		frame.setFont(new Font("方正姚体", Font.PLAIN, 12));
		frame.setBackground(Color.LIGHT_GRAY);
		frame.setTitle("银行排队叫号系统客户端");
		frame.setBounds(100, 100, 587, 451);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel label = new JLabel("账号");
		label.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		JLabel label_1 = new JLabel("密码");
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		JLabel label_2 = new JLabel("欢迎登录吉大银行");
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("华文行楷", Font.PLAIN, 30));
		
		JButton button = new JButton("注册");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisteFrame rf=new RegisteFrame();
				rf.setVisible(true);//注册界面出现
				//frame.dispose();//释放登录界面屏幕资源
			}
		});
		button.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		
		JButton button_1 = new JButton("登录");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//获取用户名和密码
				String uname=jtfUname.getText().trim();
				String password=jpfPassword.getText().trim();
				//用正则表达式做数据校验
				   String unameRegex = "\\w{1,8}";
			        String passwordRegex = "\\w{1,8}";

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
			        UserDao ud = new UserDaoSevice();
			        boolean id=ud.identity(uname);
			        boolean flag = ud.login(uname, password,id);
			      //  System.out.println(flag);
			        if (flag) {			            
			            if(id) {
			            	JOptionPane.showMessageDialog(null,"VIP登录成功！");
			            	goVIP();
			            }
			            else {
			            	JOptionPane.showMessageDialog(null,"用户登录成功！");
			            	goCustomerFrame();}
			        } else {
			            JOptionPane.showMessageDialog(null,"用户名或者密码有误");
			            jtfUname.setText("");
			            jpfPassword.setText("");
			            jtfUname.requestFocus();
			        }
			}

			private void goVIP() {
				// TODO 自动生成的方法存根
				 jtfUname.setText("");
		         jpfPassword.setText("");
				new VIP().setVisible(true);
				//frame.dispose();//释放
			}

			private void goCustomerFrame() {
				// TODO 自动生成的方法存根
				 jtfUname.setText("");
		         jpfPassword.setText("");
				new CustomerFrame().setVisible(true);//界面出现
				//frame.dispose();//释放
			}
		});
		button_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		
		jtfUname = new JTextField();
		jtfUname.setFont(new Font("华文隶书", Font.BOLD, 18));
		jtfUname.setColumns(15);
		
		jpfPassword = new JPasswordField();
		jpfPassword.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JButton button_1_1 = new JButton("重置");
		button_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 jtfUname.setText("");
			     jpfPassword.setText("");
			     jtfUname.requestFocus();
			}
		});
		button_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(92)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
							.addGap(92)
							.addComponent(button_1_1, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
							.addGap(52))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(136)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(label)
								.addComponent(label_1))
							.addGap(49)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(jpfPassword)
								.addComponent(jtfUname))
							.addPreferredGap(ComponentPlacement.RELATED, 86, Short.MAX_VALUE)))
					.addContainerGap(32, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(165, Short.MAX_VALUE)
					.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 376, GroupLayout.PREFERRED_SIZE)
					.addGap(40))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(45)
					.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addGap(44)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(jtfUname, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(48)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(jpfPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(56)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1_1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_1))
					.addContainerGap())
		);
		frame.getContentPane().setLayout(groupLayout);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
	}
}
