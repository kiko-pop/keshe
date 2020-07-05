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
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * 这是管理员叫号类
 * @author 张文成
 * @version 1.0 2020/7.4
 * 例如：Call call=new Call();
 *              call.setVisible(true);
 * @see java.awt.BorderLayout;
 * @see java.awt.EventQueue;
 * @see avax.swing.JFrame;
 * ...              
 */
public class Call extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Call frame = new Call();
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
	public Call(){
		initialize();
		init();	
	}



	private void init() {
		// TODO 自动生成的方法存根
		UiUtil.setFrameCenter(this);//界面居中
		setResizable(false);
	}

	private void initialize(){
		setTitle("管理员叫号");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,587, 451);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		AdminDao ad=new AdminDao();
		int n=ad.first();//现在第一个VIPnum

		String s = Integer.toString(n);
		JButton button = new JButton("重复播报");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"请"+n+"号前往柜台办理业务！");
			}
		});
		
		JButton button_1 = new JButton("大屏显示");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Screen sc=new Screen();
				sc.setVisible(true);
				dispose();
			}
		});
		
		JLabel label = new JLabel("请");
		label.setFont(new Font("宋体", Font.BOLD, 30));
		
		JLabel label_1 = new JLabel(s);
		label_1.setFont(new Font("宋体", Font.BOLD, 30));
		
		JLabel label_2 = new JLabel("号前往柜台办理业务");
		label_2.setFont(new Font("宋体", Font.BOLD, 30));
		
		JButton button_2 = new JButton("返回");
		button_2.addActionListener(new ActionListener() {
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
					.addGap(89)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(button_2)
						.addComponent(label))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_1)
							.addGap(18)
							.addComponent(label_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGap(53))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(80)
							.addComponent(button)
							.addPreferredGap(ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
							.addComponent(button_1)
							.addGap(71))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(108)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(label_1)
						.addComponent(label_2))
					.addGap(122)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_2)
						.addComponent(button)
						.addComponent(button_1))
					.addGap(119))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
