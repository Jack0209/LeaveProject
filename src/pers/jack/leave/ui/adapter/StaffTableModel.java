package pers.jack.leave.ui.adapter;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import pers.jack.leave.bean.Staff;
import pers.jack.leave.common.ProjectConstants;
import pers.jack.leave.common.StaffType;

public class StaffTableModel extends AbstractTableModel {
	private static final long serialVersionUID = 5943319526638074653L;
	private ArrayList<Staff> mDataList;

	public StaffTableModel() {
		mDataList = new ArrayList<Staff>();
	}

	public StaffTableModel(ArrayList<Staff> dataList) {
		setDataList(dataList);
	}

	@Override
	public int getRowCount() {
		if (this.mDataList != null) {
			return this.mDataList.size();
		}
		return 0;

	}

	@Override
	public int getColumnCount() {
		return 5;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Staff staff = getValueAt(rowIndex);
		if (staff != null) {
			switch (columnIndex) {
			case 0:// 第1列返回员工编号
				return staff.getId();
			case 1:// 第2列返回员工姓名
				return staff.getName();
			case 2:// 第3列返回员工上级
				return staff.getSupervisor();
			case 3:// 第4列返回员工是否为主管
				return staff.getStaffType() == StaffType.DIRECTOR ? "√" : null;
			default:
				break;
			}
		}
		return null;
	}

	public Staff getValueAt(int rowIndex) {
		if (this.mDataList != null && rowIndex >= 0
				&& rowIndex < this.mDataList.size()) {
			return this.mDataList.get(rowIndex);
		}
		return null;
	}

	public ArrayList<Staff> getDataList() {
		return mDataList;
	}

	public void setDataList(ArrayList<Staff> dataList) {
		this.mDataList = dataList;
		fireTableDataChanged();
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {

		return columnIndex == 4;
	}

	@Override
	public String getColumnName(int column) {

		switch (column) {
		case 0:
			return ProjectConstants.TEXT_TABLE_TITLE_INDEX;
		case 1:
			return ProjectConstants.TEXT_TABLE_TITLE_NAME;
		case 2:
			return ProjectConstants.TEXT_TABLE_TITLE_SUPERVISOR;
		case 3:
			return ProjectConstants.TEXT_TABLE_TITLE_TYPE;
		case 4:
			return ProjectConstants.TEXT_TABLE_TITLE_OPERATION;
		default:
			break;
		}
		return super.getColumnName(column);

	}

	public boolean deleteStaff(int index) {
		boolean res = false;
		Staff staff = getValueAt(index);
		if (staff != null) {
			res = mDataList.remove(staff);
			fireTableDataChanged();
		}
		return res;
	}

	public void refreshOne(Staff staff) {
		int index = mDataList.indexOf(staff);
		if (index == -1) {
			mDataList.add(staff);
		} else {
			mDataList.remove(index);
			mDataList.add(index, staff);
		}
		fireTableDataChanged();
	}

}
