package com.yuankai;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class LookTool {

	// �鿴�˵�����
	public static final void setCks() {
		MenuBar.getCks().setMnemonic(KeyEvent.VK_S);
		MenuBar.getCks().setIcon(null);
		MenuBar.getCks().addActionListener(new ActionListener() {
			// ״̬���¼�
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
