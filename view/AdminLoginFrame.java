package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import util.UiUtil;

import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * 这是管理员登录实现类
 * @author 张文成
 * @version 1.0 2020/7.4
 * 例如：AdminLoginFrame alf=new AdminLoginFrame();
 *               alf.setVisible(true);
 * @see java.awt.BorderLayout;
 * @see java.awt.EventQueue;
 * @see avax.swing.JFrame;
 * ...              
 */

public class AdminLoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField jtfNum;
	private JPasswordField jpfPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLoginFrame frame = new AdminLoginFrame();
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
	public AdminLoginFrame() {
		initialize();
		init();	
	}


	private void init() {
		// TODO 自动生成的方法存根
		
		UiUtil.setFrameCenter(this);//界面居中
		setResizable(false);
	}

	private void initialize(){
		setIconImage(Toolkit.getDefaultToolkit().getImage(AdminLoginFrame.class.getResource("/pic/头像.jpg")));
		setTitle("管理员登录界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 587, 451);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("请输入管理员信息");
		label.setFont(new Font("宋体", Font.PLAIN, 30));
		
		JLabel label_1 = new JLabel("工号");
		label_1.setFont(new Font("宋体", Font.PLAIN, 20));
		
		jtfNum = new JTextField();
		jtfNum.setFont(new Font("宋体", Font.PLAIN, 20));
		jtfNum.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("密码");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		
		jpfPassword = new JPasswordField();
		
		JButton button = new JButton("登录");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//获取工号和密码
				String num=jtfNum.getText().trim();
				String password=jpfPassword.getText().trim();
				if(num.equals("001")&&password.equals("java")) {
					ServeFrame sf=new ServeFrame();
					sf.setVisible(true);
					dispose();					
				}else {
					JOptionPane.showMessageDialog(null,"工号或密码错误");
				}
			}
		});
		
		JButton button_1 = new JButton("重置");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 jtfNum.setText("");
			     jpfPassword.setText("");
			     jtfNum.requestFocus();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(152)
							.addComponent(label))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(122)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(label_1)
								.addComponent(lblNewLabel))
							.addGap(28)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(jtfNum, GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
								.addComponent(jpfPassword, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE))))
					.addGap(167))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(148)
					.addComponent(button_1)
					.addPreferredGap(ComponentPlacement.RELATED, 146, Short.MAX_VALUE)
					.addComponent(button)
					.addGap(139))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(58)
					.addComponent(label)
					.addGap(49)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(jtfNum, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addGap(42)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(jpfPassword, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(54)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_1)
						.addComponent(button))
					.addContainerGap(59, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
