package pers.jack.leave.ui.adapter;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.event.CellEditorListener;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import pers.jack.leave.common.ProjectConstants;
import pers.jack.leave.ui.listener.OnStaffTableItemBtnClickListener;

public class StaffTableCellRenderer implements TableCellRenderer,
		TableCellEditor {

	private OnStaffTableItemBtnClickListener mClickListener;

	public void setOnItemClickListener(
			OnStaffTableItemBtnClickListener clickListener) {
		this.mClickListener = clickListener;
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		return getTableItemComponent(table, value, isSelected, row, column);
	}

	@Override
	public Object getCellEditorValue() {

		return null;

	}

	@Override
	public boolean isCellEditable(EventObject anEvent) {

		return true;

	}

	@Override
	public boolean shouldSelectCell(EventObject anEvent) {

		return true;

	}

	@Override
	public boolean stopCellEditing() {

		return true;

	}

	@Override
	public void cancelCellEditing() {

	}

	@Override
	public void addCellEditorListener(CellEditorListener l) {

	}

	@Override
	public void removeCellEditorListener(CellEditorListener l) {

	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value,
			boolean isSelected, final int row, final int column) {

		return getTableItemComponent(table, value, isSelected, row, column);

	}

	private Component getTableItemComponent(JTable table, Object value,
			boolean isSelected, final int row, final int column) {
		switch (column) {
		case 4:
			JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 14, 6));
			panel.setOpaque(true);
			panel.setBackground(ProjectConstants.COLOR_BK_CONTENT);
			JButton btnEdit = new JButton(ProjectConstants.TEXT_BTN_EDIT_STAFF);
			btnEdit.setPreferredSize(new Dimension(80, 26));
			btnEdit.setFont(ProjectConstants.FONT_BUTTON_MINI);
			btnEdit.setFocusPainted(false);
			btnEdit.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					if (mClickListener != null) {
						mClickListener.onEditBtnClick(row, column);
					}
				}
			});
			panel.add(btnEdit);
			JButton btnDelete = new JButton(
					ProjectConstants.TEXT_BTN_DELETE_STAFF);
			btnDelete.setPreferredSize(new Dimension(80, 26));
			btnDelete.setFont(ProjectConstants.FONT_BUTTON_MINI);
			btnDelete.setFocusPainted(false);
			btnDelete.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					// TODO Auto-generated method stub
					if (mClickListener != null) {
						mClickListener.onDeleteBtnClick(row, column);
					}
				}
			});
			panel.add(btnDelete);
			return panel;
		default:
			JLabel label = new JLabel();
			label.setFont(ProjectConstants.FONT_NORMAL);
			if (value != null) {
				label.setText(value.toString());
			}
			label.setForeground(ProjectConstants.COLOR_666);
			label.setVerticalAlignment(JLabel.CENTER);
			label.setHorizontalAlignment(JLabel.CENTER);
			return label;
		}

	}

}
