package com.yuankai;

import java.awt.Font;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/*
 * 菜单区域
 */
public class MenuBar {

	private static final JMenuItem[] wjs = { 
			new JMenuItem("新建(N)"),
			new JMenuItem("打开(O)"), 
			new JMenuItem("保存(S)"),
			new JMenuItem("另存为(A)"),
			new JMenuItem("页面设置(U)"),
			new JMenuItem("打印(P)"),
			new JMenuItem("退出(X)")
			};
	//文件子菜单

	private static JMenuItem[] bjs = { 
			new JMenuItem("撤销(U)"),
			new JMenuItem("剪切(T)"), 
			new JMenuItem("复制(C)"),
			new JMenuItem("粘贴(P)"),
			new JMenuItem("删除(L)"),
			new JMenuItem("查找(F)"), 
			new JMenuItem("查找下一个(N)"),
			new JMenuItem("替换(R)"), 
			new JMenuItem("转到(G)"),
			new JMenuItem("全选(A)"), 
			new JMenuItem("时间/日期(D)")
			};
	//编辑子菜单
	private static JMenuItem[] gss = { 
			new JMenuItem("自动换行(W)"),
			new JMenuItem("字体(F)") 
			};
	//格式子菜单
	private static JMenuItem cks = new JMenuItem("状态栏(S)");
	//查看子菜单
	private static JMenuItem[] bzs = { 
			new JMenuItem("查看帮助(H)"),
			new JMenuItem("关于记事本(A)")
			};
	//帮助子菜单
	

	// 菜单设置
	public static JMenuBar setCaidan() {
		JMenuBar bar = new JMenuBar();
		/*--------------------------------------------------*/
		JMenu wj = new JMenu("文件(F)");
		wj.setFont(new Font("微软雅黑", Font.PLAIN, 15));

		wj.setMnemonic(KeyEvent.VK_F);
		
		FileTool.setWjs();

		for (int i = 0; i < wjs.length; i++) {
			wjs[i].setFont(new Font("微软雅黑", Font.PLAIN, 15));
			wj.add(wjs[i]);
			if (i == 3 || i == 5) {
				wj.addSeparator();
			}
		}
		/*--------------------------------------------------*/
		/*--------------------------------------------------*/
		JMenu bj = new JMenu("编辑(E)");
		bj.setFont(new Font("微软雅黑", Font.PLAIN, 15));

		bj.setMnemonic(KeyEvent.VK_E);

		EditTool.setBjs();

		for (int i = 0; i < bjs.length; i++) {
			bjs[i].setFont(new Font("微软雅黑", Font.PLAIN, 15));
			bj.add(bjs[i]);
			if (i == 0 || i == 4 || i == 8) {
				bj.addSeparator();
			}
		}
		/*--------------------------------------------------*/
		/*--------------------------------------------------*/
		JMenu gs = new JMenu("格式(O)");
		gs.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		gs.setMnemonic(KeyEvent.VK_O);
		
		FormatTool.setGss();
		
		for (int i = 0; i < gss.length; i++) {
			gss[i].setFont(new Font("微软雅黑", Font.PLAIN, 15));
			gs.add(gss[i]);
		}
		/*--------------------------------------------------*/
		/*--------------------------------------------------*/
		JMenu ck = new JMenu("查看(V)");
		ck.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		ck.setMnemonic(KeyEvent.VK_V);
		
		LookTool.setCks();
		
		cks.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		ck.add(cks);
		/*--------------------------------------------------*/
		/*--------------------------------------------------*/
		JMenu bz = new JMenu("帮助(H)");
		bz.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		bz.setMnemonic(KeyEvent.VK_H);
		
		HelpTool.setBzs();
		
		for (int i = 0; i < bzs.length; i++) {
			bzs[i].setFont(new Font("微软雅黑", Font.PLAIN, 15));
			bz.add(bzs[i]);
			if (i == 0)
				bz.addSeparator();
		}
		/*--------------------------------------------------*/

		bar.add(wj);
		bar.add(bj);
		bar.add(gs);
		bar.add(ck);
		bar.add(bz);
		
		return bar;
	}
	

	public static final JMenuItem getWjs(int i) {
		return wjs[i];
	}
	
	public static final JMenuItem getBjs(int i) {
		return bjs[i];
	}
	
	public static final JMenuItem getGss(int i) {
		return gss[i];
	}
	
	public static final JMenuItem getBzs(int i) {
		return bzs[i];
	}
	
	public static final JMenuItem getCks() {
		return cks;
	}

}
