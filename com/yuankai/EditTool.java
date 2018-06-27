package com.yuankai;

import java.awt.Color;
import java.awt.Font;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

public class EditTool {

	// 保存查询与替换字符
	private static String reps = null;
	private static String mrep = null;

	// 编辑菜单功能
	public static final void setBjs() {
		MenuBar.getBjs(0)
				.setAccelerator(
						KeyStroke.getKeyStroke(KeyEvent.VK_Z,
								KeyEvent.CTRL_MASK, true));
		MenuBar.getBjs(0).setMnemonic(KeyEvent.VK_U);
		MenuBar.getBjs(0).setEnabled(false);
		MenuBar.getBjs(0).addActionListener(new ActionListener() {
			// 撤销
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				CreateText.getUndomg().undo();
			}
		});
		MenuBar.getBjs(1)
				.setAccelerator(
						KeyStroke.getKeyStroke(KeyEvent.VK_X,
								KeyEvent.CTRL_MASK, true));
		MenuBar.getBjs(1).setMnemonic(KeyEvent.VK_T);
		MenuBar.getBjs(1).setEnabled(false);
		MenuBar.getBjs(1).addActionListener(new ActionListener() {
			// 剪切
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

				CreateText.getJTexts().cut();
			}
		});
		MenuBar.getBjs(2)
				.setAccelerator(
						KeyStroke.getKeyStroke(KeyEvent.VK_C,
								KeyEvent.CTRL_MASK, true));
		MenuBar.getBjs(2).setMnemonic(KeyEvent.VK_C);
		MenuBar.getBjs(2).setEnabled(false);
		MenuBar.getBjs(2).addActionListener(new ActionListener() {
			// 复制操作
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				CreateText.getJTexts().copy();
			}
		});
		MenuBar.getBjs(3)
				.setAccelerator(
						KeyStroke.getKeyStroke(KeyEvent.VK_V,
								KeyEvent.CTRL_MASK, true));
		MenuBar.getBjs(3).setMnemonic(KeyEvent.VK_P);
		MenuBar.getBjs(3).setEnabled(false);
		MenuBar.getBjs(3).addActionListener(new ActionListener() {
			// 粘贴操作
			@Override
			public void actionPerformed(ActionEvent arg0) {
				UseGj.getJta();
				// TODO Auto-generated method stub
				CreateText.getJTexts().paste();

			}
		});
		MenuBar.getBjs(4).setMnemonic(KeyEvent.VK_L);
		MenuBar.getBjs(4).setEnabled(false);
		MenuBar.getBjs(4).addActionListener(new ActionListener() {
			// 删除
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

				try {  
					Robot robot = new Robot();//创建Robot对象  
					robot.keyPress(KeyEvent.VK_DELETE);
					robot.keyRelease(KeyEvent.VK_DELETE);
			        } catch (Exception e) {  
			            // TODO Auto-generated catch block  
			            e.printStackTrace();  
			        }
				
			}
		});
		MenuBar.getBjs(5)
				.setAccelerator(
						KeyStroke.getKeyStroke(KeyEvent.VK_F,
								KeyEvent.CTRL_MASK, true));
		MenuBar.getBjs(5).setMnemonic(KeyEvent.VK_F);
		MenuBar.getBjs(5).setEnabled(false);

		MenuBar.getBjs(5).addActionListener(new ActionListener() {
			// 查询
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				EditTool.setSelect();
			}
		});

		MenuBar.getBjs(6).setMnemonic(KeyEvent.VK_N);
		MenuBar.getBjs(6).setEnabled(false);
		MenuBar.getBjs(6).addActionListener(new ActionListener() {
			//查询下一个
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(reps != null)
				{
					EditTool.setSelectRep(true, true);
				}
				else
				{
					
					EditTool.setSelect();
				}
			}
		});
		MenuBar.getBjs(7)
				.setAccelerator(
						KeyStroke.getKeyStroke(KeyEvent.VK_H,
								KeyEvent.CTRL_MASK, true));
		MenuBar.getBjs(7).setMnemonic(KeyEvent.VK_R);
		MenuBar.getBjs(7).addActionListener(new ActionListener() {
			// 替换
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				EditTool.setReplace();
			}
		});

		MenuBar.getBjs(8)
				.setAccelerator(
						KeyStroke.getKeyStroke(KeyEvent.VK_G,
								KeyEvent.CTRL_MASK, true));
		MenuBar.getBjs(8).setMnemonic(KeyEvent.VK_G);
		MenuBar.getBjs(8).setEnabled(false);

		MenuBar.getBjs(9)
				.setAccelerator(
						KeyStroke.getKeyStroke(KeyEvent.VK_A,
								KeyEvent.CTRL_MASK, true));
		MenuBar.getBjs(9).setMnemonic(KeyEvent.VK_A);

		MenuBar.getBjs(9).addActionListener(new ActionListener() {
			// 全选
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				CreateText.getJTexts().selectAll();
			}
		});

		MenuBar.getBjs(10).setMnemonic(KeyEvent.VK_D);
		MenuBar.getBjs(10).addActionListener(new ActionListener() {
			// 添加日期
			@Override
			public void actionPerformed(ActionEvent arg0) {
				UseGj.getJta();
				// TODO Auto-generated method stub
				CreateText.getJTexts().append(EditTool.getDate());
			}
		});
	}

	// 替换
	private static JDialog setReplace() {
		JDialog jd = new JDialog();
		jd.setLayout(null);

		final JTextField jtf = new JTextField();
		final JTextField jtf2 = new JTextField();

		jtf.setBounds(80, 20, 200, 30);
		jtf2.setBounds(80, 70, 200, 30);

		JLabel jl = new JLabel("查找类容:");
		JLabel jl2 = new JLabel("替换为:");

		jl.setBounds(11, 20, 120, 30);
		jl2.setBounds(25, 70, 120, 30);
		jl.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		jl2.setFont(new Font("微软雅黑", Font.PLAIN, 15));

		final JButton rep = new JButton("替换(R)");
		final JButton repnext = new JButton("查找下一个(F)");
		JButton repall = new JButton("全部替换(A)");

		rep.setEnabled(false);
		rep.setMnemonic(KeyEvent.VK_R);
		repnext.setEnabled(false);
		repnext.setMnemonic(KeyEvent.VK_F);
		repall.setMnemonic(KeyEvent.VK_A);
		rep.setBounds(290, 46, 80, 30);
		repnext.setBounds(200, 120, 150, 30);
		repall.setBounds(30, 120, 150, 30);
		
		jtf.addCaretListener(new CaretListener() {

			@Override
			public void caretUpdate(CaretEvent arg0) {
				// TODO Auto-generated method stub
				reps = jtf.getText();

				if ("".equals(reps)) {
					rep.setEnabled(false);
					repnext.setEnabled(false);
				} else {
					rep.setEnabled(true);
					repnext.setEnabled(true);
				}
			}
		});
		jtf2.addCaretListener(new CaretListener() {

			@Override
			public void caretUpdate(CaretEvent arg0) {
				// TODO Auto-generated method stub
				mrep = jtf2.getText();

			}
		});

		repnext.addActionListener(new ActionListener() {
			// 查询下一个
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				EditTool.setSelectRep(true, true);
			}
		});

		repall.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

				int max = CreateText.getJTexts().getText().length();
				int min = CreateText.getJTexts().getText().indexOf(reps);

				if (max > min && !"".equals(reps)) {

					String[] str = CreateText.getJTexts().getText().split(reps);
					String str2 = "";
					for (int i = 0; i < str.length; i++) {

						str2 += str[i].replaceAll(reps, mrep) + mrep;
					}

					CreateText.getJTexts().setText(str2);
				}
			}

		});

		rep.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

				String str = CreateText.getJTexts().getSelectedText();
				if (reps.equals(str)) {
					CreateText.getJTexts().replaceSelection(mrep);
					int scope = reps.length();
					int len = CreateText.getJTexts().getCaretPosition();
					CreateText.getJTexts().select(len - scope, len);

				} else {
					JOptionPane.showConfirmDialog(null, "未找到" + reps, "记事本", 0);
				}
			}
		});

		jtf.setText(reps);
		jtf2.setText(mrep);

		jd.add(jtf);
		jd.add(jtf2);
		jd.add(jl);
		jd.add(jl2);

		jd.add(rep);
		jd.add(repnext);
		jd.add(repall);

		jd.setSize(400, 220);
		jd.setTitle("替换");
		int x = Notepad.getJf().getX();
		int y = Notepad.getJf().getY();
		jd.setResizable(false);
		jd.setLocation(x + 200, y + 100);
		jd.setVisible(true);

		return jd;

	}

	static boolean upandfl = true, lefrig = true;

	// 查找
	private static void setSelect() {

		JDialog jd = new JDialog();
		jd.setLayout(null);
		jd.setTitle("查询");

		final JTextField jtf = new JTextField();
		
		jtf.setBounds(100, 20, 200, 20);

		JLabel jl = new JLabel("查找类容(N):");
		jl.setBounds(10, 15, 100, 30);
		jl.setFont(new Font("微软雅黑", 15, 15));

		final JButton repnext = new JButton("查找下一个(F)");
		repnext.setEnabled(false);
		repnext.setMnemonic(KeyEvent.VK_F);
		repnext.setBounds(320, 15, 150, 30);
		repnext.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				EditTool.setSelectRep(upandfl, lefrig);
			}
		});

		final JCheckBox jcb = new JCheckBox("区分大小写(C)");
		jcb.setMnemonic(KeyEvent.VK_C);
		jcb.setFont(new Font("微软雅黑", 15, 15));
		jcb.setBounds(10, 50, 120, 30);
		jcb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(jcb.isSelected())
				{
					upandfl = false;
				}
				else
				{
					upandfl = true;
				}
			}
		});

		/*------------------------------------------------------*/
		JPanel jp = new JPanel();
		jp.setLayout(null);
		jp.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		jp.setBorder(BorderFactory.createTitledBorder("方向"));
		jp.setBounds(150, 50, 200, 80);
		JRadioButton up = new JRadioButton("向上(U)");
		JRadioButton lo = new JRadioButton("向下(D)");
		ButtonGroup bg = new ButtonGroup();
		bg.add(up);
		bg.add(lo);
		up.setMnemonic(KeyEvent.VK_U);
		lo.setMnemonic(KeyEvent.VK_D);
		lo.setSelected(true);
		up.setBounds(10, 20, 80, 30);
		lo.setBounds(100, 20, 80, 30);
		up.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				lefrig = false;
			}
		});
		lo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				lefrig = true;
			}
		});

		jp.add(up);
		jp.add(lo);
		/*------------------------------------------------------*/

		jtf.addCaretListener(new CaretListener() {

			@Override
			public void caretUpdate(CaretEvent arg0) {
				// TODO Auto-generated method stub
				reps = jtf.getText();
				if (!"".equals(jtf.getText())) {
					repnext.setEnabled(true);
				} else {
					repnext.setEnabled(false);
				}
			}
		});

		jd.add(jtf);
		jd.add(jl);
		jd.add(repnext);
		jd.add(jcb);
		jd.add(jp);

		
		if(reps != null)
		{
			jtf.setText(reps);
			repnext.setEnabled(true);
		}
		jd.setSize(500, 200);
		int x = Notepad.getJf().getX();
		int y = Notepad.getJf().getY();
		jd.setResizable(false);
		jd.setLocation(x + 100, y + 100);
		jd.setVisible(true);

	}

	// 查询
	private static void setSelectRep(boolean upandfl, boolean lefrig) {
		String strb = CreateText.getJTexts().getText();

		int len = CreateText.getJTexts().getCaretPosition();
		int max = CreateText.getJTexts().getText().length();
		String str;
		int ch;
		String rep = reps;
		if (upandfl) {
			rep = rep.toLowerCase();
			strb = strb.toLowerCase();
		}
		if (lefrig) {
			str = strb.substring(len, max);
			ch = str.indexOf(rep);
		} else {
			str = strb.substring(0, len - 1);
			ch = str.lastIndexOf(rep);
		}

		int scope = rep.length();

		if (ch >= 0 && ch < max) {
			if (lefrig)
				CreateText.getJTexts().select(len + ch, len + ch + scope);
			else
				CreateText.getJTexts().select(ch, ch + scope);

		} else {
			JOptionPane.showConfirmDialog(null, "未找到" + reps, "记事本", 0);
		}

	}

	// 日期
	public static final String getDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd- HH:mm ");
		Date date = new Date();
		String str = sdf.format(date) + String.format("%tA", date);
		return str;

	}

}
