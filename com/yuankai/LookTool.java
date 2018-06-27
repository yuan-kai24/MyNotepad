package com.yuankai;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class LookTool {

	// 查看菜单功能
	public static final void setCks() {
		MenuBar.getCks().setMnemonic(KeyEvent.VK_S);
		MenuBar.getCks().setIcon(null);
		MenuBar.getCks().addActionListener(new ActionListener() {
			// 状态栏事件
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (StatusBar.getStatusJp().isVisible()) {
					StatusBar.getStatusJp().setVisible(false);
				} else {
					StatusBar.getStatusJp().setVisible(true);
				}
			}
		});
	}
}
