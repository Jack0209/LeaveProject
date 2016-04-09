package pers.jack.leave.bean;



public class LeaveNotice {
	private Staff mFromStaff;

	private DateItem mDateItemStartYear;
	private DateItem mDateItemStartMonth;
	private DateItem mDateItemStartDay;
	private DateItem mDateItemEndYear;
	private DateItem mDateItemEndMonth;
	private DateItem mDateItemEndDay;

	public LeaveNotice() {

	}

	public Staff getFromStaff() {
		return mFromStaff;
	}

	public void setFromStaff(Staff mFromStaff) {
		this.mFromStaff = mFromStaff;
	}

	public void setDateStart(DateItem startYear, DateItem startMonth,
			DateItem startDay) {
		this.mDateItemStartYear = startYear;
		this.mDateItemStartMonth = startMonth;
		this.mDateItemStartDay = startDay;
	}

	public void setDateEnd(DateItem endYear, DateItem endMonth, DateItem endDay) {
		this.mDateItemEndYear = endYear;
		this.mDateItemEndMonth = endMonth;
		this.mDateItemEndDay = endDay;
	}
	public String getShowDateStart() {
		StringBuilder strRes = new StringBuilder();
		strRes.append(mDateItemStartYear == null ? ""
				: (mDateItemStartYear + " "));
		strRes.append(mDateItemStartMonth == null ? "" : (mDateItemStartMonth));
		strRes.append(mDateItemStartDay == null ? "" : (mDateItemStartDay));
		return strRes.toString();
	}
	public String getShowDateEnd() {
		StringBuilder strRes = new StringBuilder();
		strRes.append(mDateItemEndYear == null ? "" : (mDateItemEndYear + " "));
		strRes.append(mDateItemEndMonth == null ? "" : (mDateItemEndMonth));
		strRes.append(mDateItemEndDay == null ? "" : (mDateItemEndDay));
		return strRes.toString();
	}

}
