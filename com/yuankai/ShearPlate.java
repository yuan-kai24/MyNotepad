package com.yuankai;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class ShearPlate {

	private static Clipboard cl = Toolkit.getDefaultToolkit().getSystemClipboard();

	// �����ı�
	public static String getCbt() {

		Transferable clT = cl.getContents(null);

		String str = null;

		if (clT != null) {
			if (clT.isDataFlavorSupported(DataFlavor.stringFlavor))
				try {
					str = (String) clT.getTransferData(DataFlavor.stringFlavor);
				} catch (UnsupportedFlavorException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return str;
	}

	// д���ı�
	public static void setWriteText(String str) {
		Transferable tText = new StringSelection(str);
		cl.setContents(tText, null);
	}
}
