package pers.jack.leave.util;

import java.util.ArrayList;

import pers.jack.leave.bean.Staff;
import pers.jack.leave.common.ProjectConstants;
import pers.jack.leave.common.StaffType;

public class ProjectUtils {
	private static int index;

	static {
		index = ProjectConstants.INDEX_START;
	}

	private ProjectUtils() {
	};

	public static int getStaffId() {
		return index++;
	}

	public static ArrayList<Staff> getInitStaffs() {
		ArrayList<Staff> staffs = new ArrayList<Staff>();
		Staff staff = new Staff("user1", StaffType.DIRECTOR);
		staffs.add(staff);
		staff = new Staff("user2");
		staff.setSupervisor(staffs.get(0));
		staffs.add(staff);
		staff = new Staff("user3");
		staff.setSupervisor(staffs.get(1));
		staffs.add(staff);
		staff = new Staff("user4");
		staff.setSupervisor(staffs.get(2));
		staffs.add(staff);
		staff = new Staff("user5");
		staff.setSupervisor(staffs.get(3));
		staffs.add(staff);
		staff = new Staff("user6");
		staff.setSupervisor(staffs.get(4));
		staffs.add(staff);
		staff = new Staff("jack");
		staff.setSupervisor(staffs.get(0));
		staffs.add(staff);
		staff = new Staff("alan");
		staff.setSupervisor(staffs.get(6));
		staffs.add(staff);
		staff = new Staff("song");
		staff.setSupervisor(staffs.get(7));
		staffs.add(staff);
		staff = new Staff("pla");
		staff.setSupervisor(staffs.get(8));
		staffs.add(staff);
		staff = new Staff("li");
		staff.setSupervisor(staffs.get(9));
		staffs.add(staff);
		staff = new Staff("tom");
		staff.setSupervisor(staffs.get(10));
		staffs.add(staff);
		return staffs;
	}

	public static ArrayList<Staff> getStaffsExceptSelf(ArrayList<Staff> staffs,
			Staff self) {
		ArrayList<Staff> staffListRes = new ArrayList<Staff>();
		staffListRes.addAll(staffs);
		staffListRes.remove(self);
		return staffListRes;
	}

	public static ArrayList<Staff> getStaffsExceptDirector(
			ArrayList<Staff> staffs) {
		ArrayList<Staff> staffListRes = new ArrayList<Staff>();
		staffListRes.addAll(staffs);
		for (Staff staff : staffListRes) {
			if (staff.getStaffType() == StaffType.DIRECTOR) {
				staffListRes.remove(staff);
				break;
			}
		}
		return staffListRes;
	}

	public static boolean isHasDirector(ArrayList<Staff> staffs) {
		for (Staff staff : staffs) {
			if (staff.getStaffType() == StaffType.DIRECTOR) {
				return true;
			}
		}
		return false;
	}

	public static boolean isHasSubordinate(ArrayList<Staff> staffs, Staff self) {
		for (Staff staff : staffs) {
			if (self.equals(staff.getSupervisor())) {
				return true;
			}
		}
		return false;
	}

}
