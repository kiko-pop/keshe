package util;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class UiUtil {
	/**
	 * 专门做界面效果的类
	 * @author 张文成
	 * @version 1.0 2020/7.4
	 */
	private UiUtil() {	
	}
	public static void setFrameCenter(JFrame jf) {
		//获取工具对象
		Toolkit tk = Toolkit.getDefaultToolkit();
		//获取屏幕的宽和高
		Dimension d=tk.getScreenSize();
		double screenWidth=d.getWidth();
		double screenHeigth=d.getHeight();
		//获取窗体的宽和高
		int frameWidth=jf.getWidth();
		int frameHeight=jf.getHeight();
		//获取新的宽和高
		int width=(int)(screenWidth-frameWidth)/2;
		int height=(int)(screenHeigth-frameHeight)/2;
		//设置窗体坐标
		jf.setLocation(width,height);
	}
}
