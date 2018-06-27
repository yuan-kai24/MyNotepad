package com.yuankai;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class FormatTool {
	// ¸ñÊ½²Ëµ¥¹¦ÄÜ
	public static final void setGss() {
		MenuBar.getGss(0).setMnemonic(KeyEvent.VK_W);
		MenuBar.getGss(0).addActionListener(new ActionListener() {
			// ×Ô¶¯»»ÐÐ¹¦ÄÜ
			@Override
			public void actionPerformed(ActionEvent arg0) {
				UseGj.getJta();
				// TODO Auto-generated method stub
				if (!CreateText.getJTexts().getLineWrap()) {
					
					CreateText.getJTexts().setLineWrap(true);
					StatusBar.getStatusJp().setVisible(false);
					MenuBar.getCks().setEnabled(false);
					CreateText.getJsp().setHorizontalScrollBarPolicy(
							JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
				} else {
					
					CreateText.getJTexts().setLineWrap(false);
					StatusBar.getStatusJp().setVisible(true);
					MenuBar.getCks().setEnabled(true);
					CreateText.getJsp().setHorizontalScrollBarPolicy(
							JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
				}

			}
		});
		MenuBar.getGss(1).setMnemonic(KeyEvent.VK_F);
		MenuBar.getGss(1).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				FormatTool.setFontSize();
			}
		});
	}

	static String MyFont = "Î¢ÈíÑÅºÚ";
	static String Fontset = "³£¹æ";
	static String MyfontSize = "15";
	static Map<String, Integer> map = new HashMap<String, Integer>();
	
	private static String clearHtml(String strb)
	{
		StringBuffer str = new StringBuffer(strb);
		int min = str.indexOf("<");
		int max = str.indexOf(">");
		int len = str.length();
		
		while((min <= max && min <= len && max <= len && min >= 0 && max >= 0))
		{
			str = str.replace(min, max+1, "");
			min = str.indexOf("<");
			max = str.indexOf(">");
			len = str.length();
		}
		
		
		return str.toString();
	}
	
	
	private static void setFontSize() {
		final JDialog jd = new JDialog();
		jd.setLayout(null);
		
		map.put("³£¹æ", Font.PLAIN);
		map.put("´ÖÌå", Font.BOLD);
		map.put("ÇãÐ±", Font.ITALIC);
		map.put("´ÖÌå ÇãÐ±", Font.BOLD + Font.ITALIC);
		
		
		FormatTool.setFontSizeAction(jd);

		jd.setSize(530, 450);
		int x = Notepad.getJf().getX();
		int y = Notepad.getJf().getY();
		jd.setResizable(false);
		jd.setLocation(x + 100, y + 80);
		jd.setVisible(true);
		jd.setTitle("×ÖÌå");
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void setFontSizeAction(final JDialog jd) {
		/*-----------------------------------------------*/
		JPanel jplook = new JPanel();
		final JLabel jlcs = new JLabel("AbCdEfG", JLabel.CENTER);
		jplook.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		jplook.setBorder(BorderFactory.createTitledBorder("Ê¾Àý"));
		jplook.setBounds(10, 280, 280, 120);
		jplook.add(jlcs);

		/*-----------------------------------------------*/

		/*-----------------------------------------------*/
		final JTextField[] jtf = { new JTextField(), new JTextField(),
				new JTextField() };
		jtf[0].setBounds(10, 40, 260, 25);
		jtf[0].setText(MyFont);
		jtf[1].setBounds(280, 40, 120, 25);
		jtf[1].setText(Fontset);
		jtf[2].setBounds(410, 40, 100, 25);
		jtf[2].setText(MyfontSize);
		/*-----------------------------------------------*/

		/*-----------------------------------------------*/
		JLabel jl1 = new JLabel("×ÖÌå(F)");
		jl1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		jl1.setBounds(20, 10, 100, 30);
		final JScrollPane jspw = new JScrollPane();
		GraphicsEnvironment fonts = GraphicsEnvironment
				.getLocalGraphicsEnvironment();
		String[] strfile = fonts.getAvailableFontFamilyNames();
		
		for(int i = 0;i < strfile.length;i++)strfile[i] = "<html><font face=\""+strfile[i] + "\">"+strfile[i]+"</font></html>";

		final JList jliw = new JList(strfile);
		jliw.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				// TODO Auto-generated method stub
				jtf[0].setText(clearHtml((String) jliw.getSelectedValue()));
				
				jlcs.setFont(new Font((String) jtf[0].getText(),
						map.get(jtf[1].getText()), Integer.parseInt(jtf[2].getText())));
			}
		});
		jliw.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		jspw.setViewportView(jliw);
		jspw.setBounds(10, 70, 260, 200);
		/*-----------------------------------------------*/

		/*-----------------------------------------------*/
		JLabel jl2 = new JLabel("×ÖÐÍ(V)");
		jl2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		jl2.setBounds(290, 10, 100, 30);
		final JScrollPane jspf = new JScrollPane();
		String[] str = { "³£¹æ", "<html><i>ÇãÐ±</i></html>", "<html><b>´ÖÌå</b></html>", "<html><b><i>´ÖÌå ÇãÐ±</i></b></html>" };

		final JList jli = new JList(str);
		jli.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				// TODO Auto-generated method stub
				jtf[1].setText(clearHtml((String) jli.getSelectedValue()));
				FormatTool.clearHtml(jli.getSelectedValue().toString());
				jlcs.setFont(new Font(MyFont, map.get(jtf[1].getText()),
						Integer.parseInt(jtf[2].getText())));
			}
		});

		jli.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		jspf.setViewportView(jli);
		jspf.setBounds(280, 70, 120, 200);
		/*-----------------------------------------------*/
		/*-----------------------------------------------*/
		JLabel jl3 = new JLabel("×ÖºÅ(S)");
		jl3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		jl3.setBounds(420, 10, 100, 30);
		final JScrollPane jsps = new JScrollPane();
		Integer[] strs = new Integer[100];
		for (int i = 1; i < 100; i++)
			strs[i] = i;

		final JList jlis = new JList(strs);
		jlis.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				// TODO Auto-generated method stub
				jtf[2].setText(jlis.getSelectedValue().toString());
				jlcs.setFont(new Font(jtf[0].getText(), map.get(jtf[1].getText()), (Integer) jlis
						.getSelectedValue()));
			}
		});

		jlis.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		jsps.setViewportView(jlis);
		jsps.setBounds(410, 70, 100, 200);
		/*-----------------------------------------------*/

		/*-----------------------------------------------*/
		JButton confirm = new JButton("È·¶¨");
		confirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

				MyFont = jtf[0].getText();
				Fontset = jtf[1].getText();
				MyfontSize = jtf[2].getText();

				CreateText.getJTexts().setFont(
						new Font(MyFont, map.get(Fontset), Integer
								.parseInt(MyfontSize)));
				jd.dispose();
			}
		});
		confirm.setBounds(410, 300, 80, 40);
		/*-----------------------------------------------*/

		for (int i = 0; i < jtf.length; i++)
			jd.add(jtf[i]);

		jd.add(jl1);
		jd.add(jspw);
		jd.add(jl2);
		jd.add(jspf);
		jd.add(jl3);
		jd.add(jsps);
		jd.add(jplook);

		jd.add(confirm);
	}
}
