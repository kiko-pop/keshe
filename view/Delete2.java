package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.AdminDao;
import dao.UserDao;
import domain.Admin;
import service.UserDaoSevice;
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
/**
 * 管理员销户类
 * @author 张文成
 * @version 1.0 2020/7.4
 * 例如：Delete2 de=new Delete2();
 *              de.setVisible(true);
 * @see java.awt.BorderLayout;
 * @see java.awt.EventQueue;
 * @see avax.swing.JFrame;
 * ...              
 */
public class Delete2 extends JFrame {

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
					Delete2 frame = new Delete2();
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
	public Delete2(){
		initialize();
		init();	
	}

	private void init() {
		// TODO 自动生成的方法存根
		UiUtil.setFrameCenter(this);//界面居中
		setResizable(false);
	}

	private void initialize() {
		setTitle("删除用户信息");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("请输入要删除的用户信息");
		
		JLabel label_1 = new JLabel("账号");
		
		jtfUname = new JTextField();
		jtfUname.setColumns(10);
		
		JLabel label_2 = new JLabel("密码");
		
		jpfPassword = new JPasswordField();
		
		JButton button = new JButton("删除普通用户");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String uname=jtfUname.getText().trim();
				String password=jpfPassword.getText().trim();
				AdminDao ad=new AdminDao();
				Admin admin=new Admin();				
				boolean seek=ad.refer(uname);//先查询总表有没有此人
				if(seek) {
					ad.delete(uname);
					  // 调用用户操作的功能进行销户
					UserDao ud = new UserDaoSevice();
					ud.delete(uname,password,false);		        
					JOptionPane.showMessageDialog(null, "删除成功！");
					ServeFrame sf=new ServeFrame();
					sf.setVisible(true);
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "查无此人");
					jtfUname.setText("");
		            jpfPassword.setText("");
		            jtfUname.requestFocus();
				}
				
			}
		});
		
		JButton btnvip = new JButton("删除VIP用户");
		btnvip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String uname=jtfUname.getText().trim();
				String password=jpfPassword.getText().trim();
				AdminDao ad=new AdminDao();
				Admin admin=new Admin();				
				boolean seek=ad.refer(uname);//先查询总表有没有此人
				if(seek) {
					ad.delete(uname);
					  // 调用用户操作的功能进行销户
					UserDao ud = new UserDaoSevice();
					ud.delete(uname,password,true);		        
					JOptionPane.showMessageDialog(null, "删除成功！");
					ServeFrame sf=new ServeFrame();
					sf.setVisible(true);
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "查无此人");
					jtfUname.setText("");
		            jpfPassword.setText("");
		            jtfUname.requestFocus();
				}
				}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(118)
							.addComponent(label))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(88)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(label_2)
								.addComponent(label_1))
							.addGap(45)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(jpfPassword)
								.addComponent(jtfUname)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(67)
							.addComponent(button)
							.addGap(51)
							.addComponent(btnvip)))
					.addContainerGap(54, Short.MAX_VALUE))
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
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(jpfPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(btnvip))
					.addContainerGap(30, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
