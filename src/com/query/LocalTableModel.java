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
		super(new Object[][] {}, new String[] { "���ݱ��", "ҵ������", "��ס���", "���/��",
				"����ҵ��", "��ע" });
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