package pers.jack.leave.bean;

import pers.jack.leave.common.NoticeOption;
import pers.jack.leave.common.StaffType;
import pers.jack.leave.core.BaseStaff;
import pers.jack.leave.ui.NoticeDialog;
import pers.jack.leave.ui.ResultNoticeDialog;
import pers.jack.leave.ui.listener.OnNoticeDialogOptionChooseListener;
import pers.jack.leave.util.ProjectUtils;

public class Staff extends BaseStaff implements
		OnNoticeDialogOptionChooseListener {
	private int mId;
	private String mName;

	public Staff(String name, StaffType staffType) {

		this.mId = ProjectUtils.getStaffId();
		setName(name);
		setStaffType(staffType);
	}

	public Staff(String name) {
		this(name, StaffType.NORMAL);
	}

	public int getId() {
		return mId;
	}

	public String getName() {
		return mName;
	}

	public void setName(String name) {
		this.mName = name;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Staff) {
			Staff staff = (Staff) obj;
			return staff.getId() == mId;
		}
		return super.equals(obj);

	}

	@Override
	public void handleRequest(NoticeDialog noticeDialog, LeaveNotice leaveNotice) {
		noticeDialog.setListener(this);
		noticeDialog.show(this, leaveNotice);
	}

	public void applyLeave(NoticeDialog noticeDialog, LeaveNotice leaveNotice) {
		if (getStaffType() == StaffType.DIRECTOR) {
			return;
		}
		BaseStaff supervisor = getSupervisor();
		if (supervisor != null) {
			supervisor.handleRequest(noticeDialog, leaveNotice);
		}
	}

	@Override
	public String toString() {

		return this.mName;

	}

	@Override
	public void onNoticeDialogOptionChoose(NoticeDialog noticeDialog,
			NoticeOption chooseOption, LeaveNotice leaveNotice) {
		switch (chooseOption) {
		case ENDORSE:
			BaseStaff supervisor = getSupervisor();
			if (supervisor != null) {
				supervisor.handleRequest(noticeDialog, leaveNotice);
			} else {
				ResultNoticeDialog resultNoticeDialog = new ResultNoticeDialog(
						noticeDialog.getParent());
				resultNoticeDialog.show(true, null, leaveNotice);
			}
			break;
		case DECLINE:
			ResultNoticeDialog resultNoticeDialog = new ResultNoticeDialog(
					noticeDialog.getParent());
			resultNoticeDialog.show(false, this, leaveNotice);
			break;
		default:
			break;
		}
	}
}
