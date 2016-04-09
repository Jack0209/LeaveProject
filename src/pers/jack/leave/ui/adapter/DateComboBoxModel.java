package pers.jack.leave.ui.adapter;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

import pers.jack.leave.bean.DateItem;
import pers.jack.leave.bean.DateItem.DateMode;

public class DateComboBoxModel implements ComboBoxModel<DateItem> {

	private int mMaxValue;
	private int mMinValue;
	private DateMode mDateMode;

	private DateItem mDateItemSelect;

	public DateComboBoxModel(int maxValue, int minValue, DateMode dateMode) {
		setDateMode(dateMode);
		setMaxValue(maxValue);
		setMinValue(minValue);
	}

	@Override
	public int getSize() {
		if (mMaxValue > mMinValue) {
			return mMaxValue - mMinValue + 1;
		}
		return 0;
	}

	@Override
	public DateItem getElementAt(int index) {
		return new DateItem(mMinValue + index, mDateMode);
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
			mDateItemSelect = null;
		}
		if (anItem instanceof DateItem) {
			mDateItemSelect = (DateItem) anItem;
		}
	}

	@Override
	public DateItem getSelectedItem() {
		return mDateItemSelect;
	}

	public int getMaxValue() {
		return mMaxValue;
	}

	public void setMaxValue(int maxValue) {
		if (mDateItemSelect != null && mDateItemSelect.getIntValue() > maxValue) {
			mDateItemSelect.setIntValue(maxValue);
		}
		this.mMaxValue = maxValue;
	}

	public int getMinValue() {
		return mMinValue;
	}

	public void setMinValue(int minValue) {
		this.mMinValue = minValue;
	}

	public DateMode getDateMode() {
		return mDateMode;
	}

	public void setDateMode(DateMode dateMode) {
		this.mDateMode = dateMode;
	}

}
