package pers.jack.leave.ui.listener;

import pers.jack.leave.bean.LeaveNotice;
import pers.jack.leave.common.NoticeOption;
import pers.jack.leave.ui.NoticeDialog;

public interface OnNoticeDialogOptionChooseListener {
	public void onNoticeDialogOptionChoose(NoticeDialog dialog,
			NoticeOption chooseOption, LeaveNotice leaveNotice);

}
