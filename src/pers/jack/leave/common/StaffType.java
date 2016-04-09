package pers.jack.leave.common;

public enum StaffType {
	NORMAL(ProjectConstants.STAFF_TYPE_SHOW_STAFF),
	DIRECTOR(ProjectConstants.STAFF_TYPE_SHOW_DIRECTOR);

	private String mShowType;

	private StaffType(String show) {
		this.mShowType = show;
	}

	@Override
	public String toString() {
		return this.mShowType;
	}

}
