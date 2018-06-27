package com.yuankai;

import javax.imageio.*;
import javax.swing.*;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

public class Notepad {

	private static JFrame jf = new JFrame("���±�");

	public static void main(String[] args) {
		Notepad.initInterdace();
		
	}

	public static void initInterdace() {
		
		jf.setLayout(new BorderLayout());
		Notepad.setTitileIco(jf, "/imge/1.png");
		JSplitPane jspl = new JSplitPane(JSplitPane.VERTICAL_SPLIT);

		jspl.setTopComponent(UseGj.setCdTe());
		// ����״̬��
		jspl.setDividerSize(0);

		jf.add(jspl);
		jf.add(StatusBar.setStaus(), BorderLayout.SOUTH);
		jf.setVisible(true);
		jf.setSize(800, 600);
		
		Notepad.seyClooseAct();
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	// ����ͼ��
	private static final void setTitileIco(JFrame jf, String str) {
		try {
			Image imge = ImageIO.read(jf.getClass().getResource(str));
			jf.setIconImage(imge);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//�ر��¼�����
	private static void seyClooseAct()
	{
		jf.addWindowListener(new WindowListener() {
			public void windowOpened(WindowEvent arg0) {}
			public void windowIconified(WindowEvent arg0) {}
			public void windowDeiconified(WindowEvent arg0) {}
			public void windowDeactivated(WindowEvent arg0) {}
			public void windowClosing(WindowEvent arg0) {
				if(CreateText.isChangeT())
				{
					int change = JOptionPane.showConfirmDialog(null, "�Ƿ񽫱������", "���±�", 0);
					if(change == JOptionPane.YES_NO_OPTION)
					{
						if(FileTool.getTextpath() == null)
						{
							FileTool.setSave("����");
						}
						else
						{
							FileTool.setPreserve();
						}
						
					}
				}
			}
			public void windowClosed(WindowEvent arg0) {}
			public void windowActivated(WindowEvent arg0) {}
		});
		
	}

	public static JFrame getJf()
	{
		return jf;
	}
}
