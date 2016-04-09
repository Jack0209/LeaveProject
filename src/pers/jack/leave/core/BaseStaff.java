package pers.jack.leave.core;

import pers.jack.leave.bean.LeaveNotice;
import pers.jack.leave.common.StaffType;
import pers.jack.leave.ui.NoticeDialog;

public abstract class BaseStaff {
	private StaffType mStaffType;
	protected BaseStaff mSupervisor;

	public StaffType getStaffType() {
		if (mStaffType == null) {
			mStaffType = StaffType.NORMAL;
		}
		return mStaffType;
	}

	public void setStaffType(StaffType staffType) {
		this.mStaffType = staffType;
		if (this.mStaffType == StaffType.DIRECTOR) {
			this.mSupervisor = null;
		}
	}

	public void setSupervisor(BaseStaff supervisor) {
		if (this.mStaffType == StaffType.DIRECTOR) {
			return;
		}
		this.mSupervisor = supervisor;
	}

	public BaseStaff getSupervisor() {
		if (this.mStaffType == StaffType.DIRECTOR) {
			return null;
		}
		return this.mSupervisor;
	}

	public abstract void handleRequest(NoticeDialog noticeDialog,
			LeaveNotice leaveNotice);

}
