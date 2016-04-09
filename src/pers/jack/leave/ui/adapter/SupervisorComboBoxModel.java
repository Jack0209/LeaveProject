package pers.jack.leave.ui.adapter;

import java.util.ArrayList;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

import pers.jack.leave.bean.Staff;

public class SupervisorComboBoxModel implements ComboBoxModel<Staff> {
	private ArrayList<Staff> mDataList;

	private Staff mStaffSelect;

	public void setDataList(ArrayList<Staff> dataList) {
		this.mDataList = dataList;
	}

	public ArrayList<Staff> getDataList() {
		return this.mDataList;
	}

	@Override
	public int getSize() {
		if (mDataList != null) {
			return mDataList.size();
		}
		return 0;

	}

	@Override
	public Staff getElementAt(int index) {

		if (mDataList != null && index >= 0 && index < mDataList.size()) {
			return mDataList.get(index);
		}
		return null;

	}

	@Override
	public void addListDataListener(ListDataListener l) {

	}

	@Override
	public void removeListDataListener(ListDataListener l) {

	}

	@Override
	public void setSelectedItem(Object anItem) {
		if (anItem == null) {
			mStaffSelect = null;
		}
		if (anItem instanceof Staff) {
			mStaffSelect = (Staff) anItem;
		}
	}

	@Override
	public Staff getSelectedItem() {
		return mStaffSelect;
	}

}
