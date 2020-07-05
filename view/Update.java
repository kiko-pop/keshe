package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.AdminDao;
import domain.Admin;
import util.UiUtil;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
/**
 * 营业员更改用户密码界面类
 * @author 张文成
 * @version 1.0 2020/7.4
 * 例如：Update u=new Update();
 *              u.setVisible(true);
 * @see java.awt.BorderLayout;
 * @see java.awt.EventQueue;
 * @see avax.swing.JFrame;
 * ...              
 */
public class Update extends JFrame {

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
					Update frame = new Update();
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
	public Update(){
		initialize();
		init();	
	}

	private void init() {
		// TODO 自动生成的方法存根
		UiUtil.setFrameCenter(this);//界面居中
		setResizable(false);
	}

	private void initialize() {
		setTitle("更改用户密码");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("请输入要更改密码的用户信息");
		
		JLabel label_1 = new JLabel("账号");
		
		jtfUname = new JTextField();
		jtfUname.setColumns(10);
		
		JButton button = new JButton("更改普通用户");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String uname=jtfUname.getText().trim();
				String password=jpfPassword.getText().trim();
				AdminDao ad=new AdminDao();
				Admin admin=new Admin();
				admin.setUname(uname);
				admin.setPassword(password);
				ad.update(admin);
				ad.updateStat(admin);
				JOptionPane.showMessageDialog(null, "更改密码成功！");
				ServeFrame sf=new ServeFrame();
				sf.setVisible(true);
				dispose();
				
			}
		});
		
		JButton btnvip = new JButton("更改VIP用户");
		btnvip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String uname=jtfUname.getText().trim();
				String password=jpfPassword.getText().trim();
				AdminDao ad=new AdminDao();
				Admin admin=new Admin();
				admin.setUname(uname);
				admin.setPassword(password);
				ad.updateVIP(admin);
				ad.updateStat(admin);
				JOptionPane.showMessageDialog(null, "更改密码成功！");
				ServeFrame sf=new ServeFrame();
				sf.setVisible(true);
				dispose();
			}
		});
		
		JLabel label_2 = new JLabel("新密码");
		
		jpfPassword = new JPasswordField();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(118)
							.addComponent(label))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(67)
							.addComponent(button)
							.addGap(51)
							.addComponent(btnvip))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(106)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(label_1)
								.addComponent(label_2))
							.addGap(27)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(jpfPassword)
								.addComponent(jtfUname))))
					.addContainerGap(76, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(38)
					.addComponent(label)
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(jtfUname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(jpfPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2))
					.addGap(41)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(btnvip))
					.addContainerGap(42, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
