package com.yuankai;

import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.undo.UndoManager;

/*
 * 文本区域
 */
public class CreateText {

	// 文本框
	private static JTextArea jta = new JTextArea();

	static UndoManager undomg = new UndoManager();
	
	private static boolean changeT = false;// 文档是否发生改变

	private static JScrollPane jsp = new JScrollPane(jta);
	static int line = 1, col = 1;

	// 文本框设置
	public JScrollPane setText() {

		// 默认显示滚动条
		jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		setTextAction();

		jta.setLineWrap(false);// 设置自动换行为false
		jta.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		jsp.setVisible(true);
		return jsp;
	}

	private static final void setTextAction() {
		jta.addCaretListener(new CaretListener() {
			// 文本框类容变动事件
			@Override
			public void caretUpdate(CaretEvent arg0) {
				// TODO Auto-generated method stub

				getsetPosition();
				if (undomg.canUndo()) {
					MenuBar.getBjs(0).setEnabled(true);
				} else {
					MenuBar.getBjs(0).setEnabled(false);
				}

				if (ShearPlate.getCbt() != null) {
					MenuBar.getBjs(3).setEnabled(true);
				} else {
					MenuBar.getBjs(3).setEnabled(false);
				}
				
				if(!"".equals(jta.getText()))
				{
					MenuBar.getBjs(5).setEnabled(true);
					MenuBar.getBjs(6).setEnabled(true);
				}
				else
				{
					MenuBar.getBjs(5).setEnabled(false);
					MenuBar.getBjs(6).setEnabled(false);
				}

				if (jta.getSelectedText() != null) {
					MenuBar.getBjs(1).setEnabled(true);
					MenuBar.getBjs(2).setEnabled(true);
					MenuBar.getBjs(4).setEnabled(true);
					
				} else {
					MenuBar.getBjs(1).setEnabled(false);
					MenuBar.getBjs(2).setEnabled(false);
					MenuBar.getBjs(4).setEnabled(false);
					
				}
			}
		});

		// 检测焦点
		jta.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub
			}

			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
				if (ShearPlate.getCbt() != null) {
					MenuBar.getBjs(3).setEnabled(true);
				}

			}
		});

		jta.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				CreateText.setChangeT(true);
			}

			@Override
			public void insertUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				CreateText.setChangeT(true);
			}

			@Override
			public void changedUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				System.out.print("属性变化");
			}
		});

		jta.getDocument().addUndoableEditListener(undomg);

	}

	public static void getsetPosition() {
		try {
			int c = jta.getCaretPosition();
			line = jta.getLineOfOffset(c) + 1; // 行
			col = c - jta.getLineStartOffset(line - 1) + 1;// 列
			
			StatusBar.getStatusLb()
					.setText("第" + line + "行，第" + col + "列      ");

		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static UndoManager getUndomg() {
		return undomg;
	}
	
	public static JTextArea getJTexts() {
		return jta;
	}

	public static JScrollPane getJsp() {
		return jsp;
	}
	
	public static final boolean isChangeT() {
		return changeT;
	}

	public static final void setChangeT(boolean whether) {
		changeT = whether;
	}

}
