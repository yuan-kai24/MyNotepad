package com.yuankai;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class UseGj {
	private static CreateText jta = new CreateText();
	
	
	//菜单与文本框窗体
	public static final JPanel setCdTe()
	{
		JPanel jf = new JPanel();
		JSplitPane jspl = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		jf.setLayout(new BorderLayout());
		
		
		jspl.setDividerSize(0);
		jspl.setTopComponent(MenuBar.setCaidan());
		jspl.setBottomComponent(jta.setText());
		
		jf.add(jspl);
		return jf;
	}
	
	public static CreateText getJta()
	{
		return jta;
	}

	
	
}

