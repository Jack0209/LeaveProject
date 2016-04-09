package pers.jack.leave.common;

public enum NoticeOption {
	
	ENDORSE(ProjectConstants.NOTICE_OPTION_SHOW_ENDORSE),
	DECLINE(ProjectConstants.NOTICE_OPTION_SHOW_DECLINE);

	private String mShowOption;
	private NoticeOption(String show) {
		this.mShowOption = show;
	}

	@Override
	public String toString() {
		return this.mShowOption;
	}
}

