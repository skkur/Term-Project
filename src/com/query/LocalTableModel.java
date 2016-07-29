package com.query;

@SuppressWarnings("serial")
public class LocalTableModel extends javax.swing.table.DefaultTableModel {
	@SuppressWarnings("rawtypes")
	Class[] types = new Class[] { java.lang.Object.class,
			java.lang.String.class, java.lang.String.class,
			java.lang.String.class, java.lang.String.class,
			java.lang.String.class };
	boolean[] canEdit = new boolean[] { false, false, false, false, false,
			false };

	public LocalTableModel() {
		super(new Object[][] {}, new String[] { "房屋编号", "业主姓名", "居住面积", "物费/月",
				"交物业费", "备注" });
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return types[columnIndex];
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return canEdit[columnIndex];
	}

}