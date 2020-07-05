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
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
/**
 * VIP用户叫号界面类
 * @author 张文成
 * @version 1.0 2020/7.4
 * 例如：VIP v=new VIP();
 *              v.setVisible(true);
 * @see java.awt.BorderLayout;
 * @see java.awt.EventQueue;
 * @see avax.swing.JFrame;
 * ...              
 */
public class VIP extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VIP frame = new VIP();
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
	public VIP() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VIP.class.getResource("/pic/头像.jpg")));
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
					setResizable(false);
	}

	private void initialize() {
		setTitle("VIP叫号界面");
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
		
		JMenuItem menuItem_1 = new JMenuItem("销户");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Delete de=new Delete();
				de.setVisible(true);
				dispose();
			}
		});
		menu.add(menuItem_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblvi = new JLabel("尊敬的VIP客户：");
		lblvi.setFont(new Font("宋体", Font.BOLD, 18));
		
		JLabel label = new JLabel("您享受优先办理权，点击排号按钮即可查看队伍人数。");
		label.setFont(new Font("宋体", Font.BOLD, 18));
		
		JLabel label_1 = new JLabel("您好！");
		label_1.setFont(new Font("宋体", Font.BOLD, 18));
		
		JButton button = new JButton("排号");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerFrame cf=new CustomerFrame();
				cf.setVisible(true);
				dispose();
			}
		});
		
		JButton button_1 = new JButton("返回");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(56)
							.addComponent(lblvi))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(94)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(label_1)
								.addComponent(label))))
					.addContainerGap(105, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(147, Short.MAX_VALUE)
					.addComponent(button_1)
					.addGap(103)
					.addComponent(button)
					.addGap(169))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(82)
					.addComponent(lblvi)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(label_1)
					.addGap(12)
					.addComponent(label)
					.addGap(91)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addContainerGap(115, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
