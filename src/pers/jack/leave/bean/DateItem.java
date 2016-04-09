package pers.jack.leave.bean;

import pers.jack.leave.common.ProjectConstants;

public class DateItem {
	public enum DateMode {
		YEAR, MONTH, DAY;
	}

	private int mIntValue;
	private DateMode mDateMode;

	public DateItem() {
		setIntValue(0);
	}

	public DateItem(int intValue) {
		setIntValue(intValue);
	}

	public DateItem(int intValue, DateMode dateMode) {
		setIntValue(intValue);
		setDateMode(dateMode);
	}

	public void setIntValue(int intValue) {
		if (intValue < 0) {
			intValue = 0;
		}
		this.mIntValue = intValue;
	}

	public void setDateMode(DateMode dateMode) {
		this.mDateMode = dateMode;
	}

	public int getIntValue() {
		return this.mIntValue;
	}

	public DateMode getDateMode() {
		return mDateMode;
	}

	@Override
	public String toString() {
		switch (mDateMode) {
		case DAY:
			return mIntValue
					+ ProjectConstants.DAYS[mIntValue >= 4 ? 3
							: (mIntValue - 1)];
		case MONTH:
			if (mIntValue <= 12) {
				return ProjectConstants.MONTHS[mIntValue - 1];
			}
		case YEAR:
		default:
			return mIntValue + "";
		}

	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof DateItem) {
			return mIntValue == ((DateItem) obj).mIntValue;
		}
		return super.equals(obj);

	}
}
