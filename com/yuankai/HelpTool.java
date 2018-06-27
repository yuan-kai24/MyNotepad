package com.yuankai;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JDialog;
import javax.swing.JLabel;

public class HelpTool {
	// 帮助菜单功能
	public static final void setBzs() {
		MenuBar.getBzs(0).setMnemonic(KeyEvent.VK_H);
		MenuBar.getBzs(1).setMnemonic(KeyEvent.VK_A);
		MenuBar.getBzs(1).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				HelpTool.setAboutText();
			}
		});
	}
	
	private static void setAboutText()
	{
		JDialog jd = new JDialog();
		
		JLabel jl = new JLabel("凯凯制作",JLabel.CENTER);
		jl.setFont(new Font("楷体", Font.BOLD, 30));
		jd.add(jl);
		
		
		jd.setTitle("关于记事本");
		jd.setSize(200,200);
		int x = Notepad.getJf().getX();
		int y = Notepad.getJf().getY();
		jd.setResizable(false);
		jd.setLocation(x + 300, y + 200);
		jd.setVisible(true);
	}
}
