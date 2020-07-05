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
import javax.swing.LayoutStyle.ComponentPlacement;
/**
 * 查询用户信息界面类
 * @author 张文成
 * @version 1.0 2020/7.4
 * 例如：Select s=new Select();
 *              s.setVisible(true);
 * @see java.awt.BorderLayout;
 * @see java.awt.EventQueue;
 * @see avax.swing.JFrame;
 * ...              
 */
public class Select extends JFrame {

	private JPanel contentPane;
	private JTextField jtfUname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Select frame = new Select();
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
	public Select(){
		initialize();
		init();	
	}

	private void init() {
		// TODO 自动生成的方法存根
		UiUtil.setFrameCenter(this);//界面居中
		setResizable(false);
	}

	private void initialize() {
		setTitle("查询用户信息");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("请输入要查询的用户账号");
		
		JLabel label_1 = new JLabel("账号");
		
		jtfUname = new JTextField();
		jtfUname.setColumns(10);
		
		JButton btnvip = new JButton("查询");
		btnvip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String uname=jtfUname.getText().trim();
				AdminDao ad=new AdminDao();
				Admin admin=new Admin();
				admin=ad.selectOne(uname);
				String password="";
				password=admin.getPassword();
				JOptionPane.showMessageDialog(null, "账号:"+uname+"密码："+password);
				ServeFrame sf=new ServeFrame();
				sf.setVisible(true);
				dispose();
				
			}
		});
		
		JButton button = new JButton("返回");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ServeFrame sf=new ServeFrame();
				sf.setVisible(true);
				dispose();
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
							.addComponent(label_1)
							.addGap(45)
							.addComponent(jtfUname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(151, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(107, Short.MAX_VALUE)
					.addComponent(button)
					.addGap(83)
					.addComponent(btnvip)
					.addGap(118))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(38)
					.addComponent(label)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(29)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(jtfUname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_1))
							.addPreferredGap(ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
							.addComponent(button)
							.addGap(47))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnvip)
							.addGap(49))))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
