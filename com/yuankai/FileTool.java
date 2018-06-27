package com.yuankai;

import java.awt.FileDialog;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterJob;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileTool {

	private static String textpath = null;// �ĵ�·��
	

	// �ļ��˵�����
	public static final void setWjs() {
		MenuBar.getWjs(0)
				.setAccelerator(
						KeyStroke.getKeyStroke(KeyEvent.VK_N,
								KeyEvent.CTRL_MASK, true));
		MenuBar.getWjs(0).setMnemonic(KeyEvent.VK_N);
		MenuBar.getWjs(0).addActionListener(new ActionListener() {
			// �½�
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				FileTool.setNew();

			}
		});
		MenuBar.getWjs(1)
				.setAccelerator(
						KeyStroke.getKeyStroke(KeyEvent.VK_O,
								KeyEvent.CTRL_MASK, true));
		MenuBar.getWjs(1).addActionListener(new ActionListener() {
			// ��
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (CreateText.isChangeT()) {
					int change = JOptionPane.showConfirmDialog(null, "�Ƿ񽫱������",
							"���±�", 0);
					switch (change) {
					case JOptionPane.YES_NO_OPTION:
						FileTool.setPreserve();
						FileTool.setOpenPath();
						break;
					case JOptionPane.NO_OPTION:
						FileTool.setOpenPath();
						break;
					default:
						break;
					}
				} else {

					FileTool.setOpenPath();
				}

			}
		});
		MenuBar.getWjs(2)
				.setAccelerator(
						KeyStroke.getKeyStroke(KeyEvent.VK_S,
								KeyEvent.CTRL_MASK, true));
		MenuBar.getWjs(2).setMnemonic(KeyEvent.VK_S);
		MenuBar.getWjs(2).addActionListener(new ActionListener() {
			// ����
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (textpath == null) {
					FileTool.setSave("����");
				} else {
					FileTool.setPreserve();
				}

			}
		});
		MenuBar.getWjs(3).setMnemonic(KeyEvent.VK_A);
		MenuBar.getWjs(3).addActionListener(new ActionListener() {
			// ���Ϊ
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				FileTool.setSave("���Ϊ");
			}
		});
		MenuBar.getWjs(4).setMnemonic(KeyEvent.VK_U);
		MenuBar.getWjs(4).addActionListener(new ActionListener() {
			//ҳ������
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				FileTool.setPrintf(true);
				
			}
		});
		MenuBar.getWjs(5)
				.setAccelerator(
						KeyStroke.getKeyStroke(KeyEvent.VK_P,
								KeyEvent.CTRL_MASK, true));
		MenuBar.getWjs(5).addActionListener(new ActionListener() {
			//��ӡ
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				FileTool.setPrintf(false);
			}
		});
		MenuBar.getWjs(6).setMnemonic(KeyEvent.VK_X);
		MenuBar.getWjs(6).addActionListener(new ActionListener() {
			// �˳�
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				FileTool.setExit();
			}
		});
	}

	// �½�
	private static final void setNew() {
		if (CreateText.isChangeT()) {
			int change = JOptionPane.showConfirmDialog(null, "�Ƿ񽫱������", "���±�",
					0);
			switch (change) {
			case JOptionPane.YES_NO_OPTION:
				if (textpath == null) {
					FileTool.setSave("����");
				} else {
					FileTool.setPreserve();
				}
				CreateText.getJTexts().setText("");
				textpath = null;
				CreateText.setChangeT(false);
				break;
			case JOptionPane.CLOSED_OPTION:
				break;
			case JOptionPane.NO_OPTION:
				CreateText.getJTexts().setText("");
				textpath = null;
				CreateText.setChangeT(false);
				break;
			default:

				break;
			}

		} else {
			CreateText.getJTexts().setText("");
			textpath = null;
			CreateText.setChangeT(false);
		}
	}

	// �˳�
	private static final void setExit() {
		if (CreateText.isChangeT()) {
			int change = JOptionPane.showConfirmDialog(null, "�Ƿ񽫱������", "���±�",
					0);
			switch (change) {
			case JOptionPane.YES_NO_OPTION:
				if (textpath == null) {
					FileTool.setSave("����");
				} else {
					FileTool.setPreserve();
				}
				break;
			case JOptionPane.NO_OPTION:
				System.exit(0);
				break;
			default:
				System.exit(1);
				break;
			}
		} else {
			System.exit(0);
		}
	}

	// ��
	private static void setOpenPath() {

		JFileChooser jfc = new JFileChooser(".");
		FileFilter ff = new FileNameExtensionFilter("�ı��ĵ�(*.txt)", "txt");
		jfc.setAcceptAllFileFilterUsed(false);
		jfc.setFileFilter(ff);
		if (jfc.showDialog(null, null) == 0) {
			CreateText.getJTexts().setText("");
			textpath = jfc.getSelectedFile().getAbsolutePath();

			Notepad.getJf().setTitle(textpath);

			try {
				InputStream input = new BufferedInputStream(
						new FileInputStream(textpath));

				byte[] by = new byte[1024];
				int len = input.read(by);
				while (len != -1) {
					CreateText.getJTexts().append(
							new String(by, 0, len));
					len = input.read(by);
				}

				input.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		CreateText.setChangeT(false);
	}

	// ����·��ѡ��
	public static void setSave(String strname) {
		FileDialog fd = new FileDialog(new JFrame(), strname, FileDialog.SAVE);
		fd.setVisible(true);

		if (fd.getDirectory() != null) {

			textpath = fd.getDirectory() + fd.getFile() + ".txt";
			if (textpath.lastIndexOf(".txt.txt") != -1) {
				textpath = fd.getDirectory() + fd.getFile();
			}

			Notepad.getJf().setTitle(textpath);
			FileTool.setPreserve();
		}

	}

	// ֱ�ӱ���
	public static void setPreserve() {
		StringBuffer str = new StringBuffer();

		try {
			OutputStream out = new BufferedOutputStream(new FileOutputStream(
					textpath));
			
			String[] lines = CreateText.getJTexts().getText().split("\n");
			for(int i = 0;i < lines.length;i++)
			{
				str.append(lines[i] + "\r\n");
			}			

			out.write(str.toString().getBytes("utf-8"));
			out.close();
			CreateText.setChangeT(false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// ��ӡ
	private static final void setPrintf(boolean whether) {
		
		PrinterJob print = PrinterJob.getPrinterJob();
		HashPrintRequestAttributeSet attr = new HashPrintRequestAttributeSet();
		if(whether)
		{
			Robot robot = null;
			try {  
		            robot = new Robot();//����Robot����  
		        } catch (Exception e) {  
		            // TODO Auto-generated catch block  
		            e.printStackTrace();  
		        }
			robot.keyPress(KeyEvent.VK_ALT);
			robot.keyPress(KeyEvent.VK_S);
			robot.keyRelease(KeyEvent.VK_S);
			robot.keyRelease(KeyEvent.VK_ALT);
			
		}
		
		
		print.printDialog(attr);
	}

	public static String getTextpath() {
		return textpath;
	}

}
