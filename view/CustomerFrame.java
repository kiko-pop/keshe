package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
import javax.swing.event.AncestorListener;

import dao.AdminDao;
import dao.UserDao;
import service.UserDaoSevice;

import javax.swing.event.AncestorEvent;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JTextField;
/**
 * 普通用户叫号类
 * @author 张文成
 * @version 1.0 2020/7.4
 * 例如：CustomerFrame cf=new CustomerFrame();
 *              cf.setVisible(true);
 * @see java.awt.BorderLayout;
 * @see java.awt.EventQueue;
 * @see avax.swing.JFrame;
 * ...              
 */
public class CustomerFrame extends JFrame {

	private JPanel contentPane;
	private JTextField jtfUname;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerFrame frame = new CustomerFrame();
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
	public CustomerFrame() {
		initialize();
		init();
	}

	private void init() {
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
		setTitle("普通用户叫号界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 465);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("用户设置");
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("修改密码");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangePassword cp=new ChangePassword();
				cp.setVisible(true);
				dispose();
			}
		});
		menu.add(menuItem);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("销户");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Delete de=new Delete();
				de.setVisible(true);
				dispose();
			}
		});
		menu.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("亲爱的客户：");
		label.setFont(new Font("宋体", Font.BOLD, 18));
		
		JLabel label_1 = new JLabel("您好！");
		label_1.setFont(new Font("宋体", Font.BOLD, 18));
		
		JLabel label_2 = new JLabel("点击排号按钮即可查看前面排队情况。");
		label_2.setFont(new Font("宋体", Font.BOLD, 18));
		
		JLabel lblvip = new JLabel("成为VIP享有优先办理权。");
		lblvip.setFont(new Font("宋体", Font.BOLD, 18));

		JButton button = new JButton("排号");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num;
				String uname=jtfUname.getText().trim();
				 AdminDao ad=new AdminDao();
				 boolean flag=ad.refer(uname);	
                 
				 if(flag) {
					 num=ad.num();
					 UserDao ud = new UserDaoSevice();
				     boolean id=ud.identity(uname);//标记是否是VIP
				     if(id) {
				    	 int ID=1;				    	
				    	 ad.insertLine(num, uname, ID);
				     }else {
				    	 int ID=0;
				    	 ad.insertLine(num, uname, ID);
				     }
					 Line l=new Line();
					 l.setVisible(true);
					 dispose();
				 }else {
					 JOptionPane.showMessageDialog(null, "此用户不存在！");
					 jtfUname.setText("");
			         jtfUname.requestFocus();
				 }
				
			}
		});
		JButton button_1 = new JButton("返回");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JLabel label_3 = new JLabel("请再次输入用户名，点击排号进入队列。");
		label_3.setFont(new Font("宋体", Font.BOLD, 18));
		
		JLabel label_4 = new JLabel("用户名");
		label_4.setFont(new Font("宋体", Font.PLAIN, 18));
		
		jtfUname = new JTextField();
		jtfUname.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(62)
							.addComponent(label))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(103)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(label_2)
								.addComponent(label_1))))
					.addContainerGap(158, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(103)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblvip)
							.addContainerGap(261, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(button)
								.addComponent(label_3))
							.addContainerGap())))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(129)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(50)
							.addComponent(label_4)
							.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
							.addComponent(jtfUname, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addComponent(button_1))
					.addContainerGap(234, GroupLayout.PREFERRED_SIZE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(56)
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_2)
					.addGap(12)
					.addComponent(lblvip)
					.addGap(18)
					.addComponent(label_3)
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(jtfUname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4))
					.addGap(39)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_1)
						.addComponent(button))
					.addContainerGap(78, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
