package com.yuankai;

import java.awt.Font;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/*
 * �˵�����
 */
public class MenuBar {

	private static final JMenuItem[] wjs = { 
			new JMenuItem("�½�(N)"),
			new JMenuItem("��(O)"), 
			new JMenuItem("����(S)"),
			new JMenuItem("���Ϊ(A)"),
			new JMenuItem("ҳ������(U)"),
			new JMenuItem("��ӡ(P)"),
			new JMenuItem("�˳�(X)")
			};
	//�ļ��Ӳ˵�

	private static JMenuItem[] bjs = { 
			new JMenuItem("����(U)"),
			new JMenuItem("����(T)"), 
			new JMenuItem("����(C)"),
			new JMenuItem("ճ��(P)"),
			new JMenuItem("ɾ��(L)"),
			new JMenuItem("����(F)"), 
			new JMenuItem("������һ��(N)"),
			new JMenuItem("�滻(R)"), 
			new JMenuItem("ת��(G)"),
			new JMenuItem("ȫѡ(A)"), 
			new JMenuItem("ʱ��/����(D)")
			};
	//�༭�Ӳ˵�
	private static JMenuItem[] gss = { 
			new JMenuItem("�Զ�����(W)"),
			new JMenuItem("����(F)") 
			};
	//��ʽ�Ӳ˵�
	private static JMenuItem cks = new JMenuItem("״̬��(S)");
	//�鿴�Ӳ˵�
	private static JMenuItem[] bzs = { 
			new JMenuItem("�鿴����(H)"),
			new JMenuItem("���ڼ��±�(A)")
			};
	//�����Ӳ˵�
	

	// �˵�����
	public static JMenuBar setCaidan() {
		JMenuBar bar = new JMenuBar();
		/*--------------------------------------------------*/
		JMenu wj = new JMenu("�ļ�(F)");
		wj.setFont(new Font("΢���ź�", Font.PLAIN, 15));

		wj.setMnemonic(KeyEvent.VK_F);
		
		FileTool.setWjs();

		for (int i = 0; i < wjs.length; i++) {
			wjs[i].setFont(new Font("΢���ź�", Font.PLAIN, 15));
			wj.add(wjs[i]);
			if (i == 3 || i == 5) {
				wj.addSeparator();
			}
		}
		/*--------------------------------------------------*/
		/*--------------------------------------------------*/
		JMenu bj = new JMenu("�༭(E)");
		bj.setFont(new Font("΢���ź�", Font.PLAIN, 15));

		bj.setMnemonic(KeyEvent.VK_E);

		EditTool.setBjs();

		for (int i = 0; i < bjs.length; i++) {
			bjs[i].setFont(new Font("΢���ź�", Font.PLAIN, 15));
			bj.add(bjs[i]);
			if (i == 0 || i == 4 || i == 8) {
				bj.addSeparator();
			}
		}
		/*--------------------------------------------------*/
		/*--------------------------------------------------*/
		JMenu gs = new JMenu("��ʽ(O)");
		gs.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		gs.setMnemonic(KeyEvent.VK_O);
		
		FormatTool.setGss();
		
		for (int i = 0; i < gss.length; i++) {
			gss[i].setFont(new Font("΢���ź�", Font.PLAIN, 15));
			gs.add(gss[i]);
		}
		/*--------------------------------------------------*/
		/*--------------------------------------------------*/
		JMenu ck = new JMenu("�鿴(V)");
		ck.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		ck.setMnemonic(KeyEvent.VK_V);
		
		LookTool.setCks();
		
		cks.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		ck.add(cks);
		/*--------------------------------------------------*/
		/*--------------------------------------------------*/
		JMenu bz = new JMenu("����(H)");
		bz.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		bz.setMnemonic(KeyEvent.VK_H);
		
		HelpTool.setBzs();
		
		for (int i = 0; i < bzs.length; i++) {
			bzs[i].setFont(new Font("΢���ź�", Font.PLAIN, 15));
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
