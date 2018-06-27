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
 * �ı�����
 */
public class CreateText {

	// �ı���
	private static JTextArea jta = new JTextArea();

	static UndoManager undomg = new UndoManager();
	
	private static boolean changeT = false;// �ĵ��Ƿ����ı�

	private static JScrollPane jsp = new JScrollPane(jta);
	static int line = 1, col = 1;

	// �ı�������
	public JScrollPane setText() {

		// Ĭ����ʾ������
		jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		setTextAction();

		jta.setLineWrap(false);// �����Զ�����Ϊfalse
		jta.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		jsp.setVisible(true);
		return jsp;
	}

	private static final void setTextAction() {
		jta.addCaretListener(new CaretListener() {
			// �ı������ݱ䶯�¼�
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

		// ��⽹��
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
				System.out.print("���Ա仯");
			}
		});

		jta.getDocument().addUndoableEditListener(undomg);

	}

	public static void getsetPosition() {
		try {
			int c = jta.getCaretPosition();
			line = jta.getLineOfOffset(c) + 1; // ��
			col = c - jta.getLineStartOffset(line - 1) + 1;// ��
			
			StatusBar.getStatusLb()
					.setText("��" + line + "�У���" + col + "��      ");

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
