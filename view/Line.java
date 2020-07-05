package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.AdminDao;
import util.UiUtil;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * 排队类
 * @author 张文成
 * @version 1.0 2020/7.4
 * 例如：Line line=new Line();
 *              line.setVisible(true);
 * @see java.awt.BorderLayout;
 * @see java.awt.EventQueue;
 * @see avax.swing.JFrame;
 * ...              
 */
public class Line extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Line frame = new Line();
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
	public Line(){
		initialize();
		init();	
	}


	private void init() {
		// TODO 自动生成的方法存根
		UiUtil.setFrameCenter(this);//界面居中
		setResizable(false);
	}

	private void initialize(){
		setTitle("排队界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		 AdminDao ad=new AdminDao();
		int n=ad.num();//现存多少在排队
        int m=n-1;
		String s = Integer.toString(n-2);
		String q = Integer.toString(m);
		JLabel label = new JLabel("前面还有");
		label.setFont(new Font("宋体", Font.BOLD, 30));
		
		JLabel label_1 = new JLabel("位在排队");
		label_1.setFont(new Font("宋体", Font.BOLD, 30));
		
		JLabel label_2 = new JLabel(s);
		label_2.setFont(new Font("宋体", Font.BOLD, 30));
		
		JButton button = new JButton("返回");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerFrame cf=new CustomerFrame();
				cf.setVisible(true);
				dispose();
			}
		});
		JLabel label_3 = new JLabel("您是");
		label_3.setFont(new Font("宋体", Font.BOLD, 30));
		
		JLabel label_4 = new JLabel(q);
		label_4.setFont(new Font("宋体", Font.BOLD, 30));
		
		JLabel label_5 = new JLabel("号");
		label_5.setFont(new Font("宋体", Font.BOLD, 30));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(40)
									.addComponent(label)
									.addGap(30))
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addContainerGap(94, Short.MAX_VALUE)
									.addComponent(label_3)
									.addGap(67)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(label_4)
								.addComponent(label_2))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(28)
									.addComponent(label_1))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(61)
									.addComponent(label_5))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(187)
							.addComponent(button)))
					.addContainerGap(36, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(49)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(label_1)
						.addComponent(label_2))
					.addPreferredGap(ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_5)
						.addComponent(label_3)
						.addComponent(label_4))
					.addGap(37)
					.addComponent(button)
					.addGap(51))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
