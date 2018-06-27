package com.yuankai;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * ×´Ì¬À¸
 */
public class StatusBar {
	private static JLabel status = new JLabel();
	private static JPanel jp = new JPanel();

	public static JPanel setStaus() {
		status.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		status.setHorizontalAlignment(JLabel.RIGHT);
		CreateText.getsetPosition();
		
		jp.setLayout(new BorderLayout());
		jp.add(status);
		jp.setVisible(true);
		return jp;
	}

	public static JPanel getStatusJp() {

		return jp;
	}

	public static JLabel getStatusLb() {
		return status;
	}

}
