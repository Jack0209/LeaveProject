package pers.jack.leave.common;

import java.awt.Color;
import java.awt.Font;

public class ProjectConstants {

	public static final String STAFF_TYPE_SHOW_STAFF = "Staff";
	public static final String STAFF_TYPE_SHOW_DIRECTOR = "Director";
	public static final String NOTICE_OPTION_SHOW_ENDORSE = "Endorse";
	public static final String NOTICE_OPTION_SHOW_DECLINE = "Decline";

	public static final int INDEX_START = 1;
	public static final int MAX_NAME = 15;

	public static final String TIME_FORMAT = "yyyy-MM-dd";

	public static final String TEXT_TITLE = "Leave Application";
	public static final String TEXT_TITLE_DIALOG_STAFF_NEW = "New Staff";
	public static final String TEXT_TITLE_DIALOG_STAFF_EDIT = "Edit Staff Information";
	public static final String TEXT_TITLE_DIALOG_LEAVE = "Apply Leave";
	public static final String TEXT_TITLE_DIALOG_NOTICE = "Notice Message";

	public static final String TEXT_TABLE_TITLE = "Staff List";
	public static final String TEXT_TABLE_TITLE_INDEX = "Staff Index";
	public static final String TEXT_TABLE_TITLE_NAME = "Staff Name";
	public static final String TEXT_TABLE_TITLE_SUPERVISOR = "Supervisor";
	public static final String TEXT_TABLE_TITLE_TYPE = "Is Director";
	public static final String TEXT_TABLE_TITLE_OPERATION = "Operation";

	public static final String TEXT_BTN_ADD_STAFF = "Add  Staff";
	public static final String TEXT_BTN_APPLY_LEAVE = "Apply  Leave";
	public static final String TEXT_BTN_DELETE_STAFF = "Delete";
	public static final String TEXT_BTN_EDIT_STAFF = "Edit";

	public static final String TEXT_BTN_SAVE = "Save";
	public static final String TEXT_BTN_SUBMIT = "Submit";
	public static final String TEXT_BTN_ENDORSE = "Endorse";
	public static final String TEXT_BTN_DECLINE = "Decline";
	public static final String TEXT_BTN_CLOSE = "Close";

	public static final String TEXT_DILAOG_NAME = "Name";
	public static final String TEXT_DILAOG_SUPERVISOR = "Supervisor";
	public static final String TEXT_DILAOG_DIRECTOR = "is Director";

	public static final String TEXT_DILAOG_FROM = "From Staff";
	public static final String TEXT_DILAOG_DATE_START = "Start Date";
	public static final String TEXT_DILAOG_DATE_END = "End Date";

	public static final String TEXT_DILAOG_MSG_TO = "<Html>To <font color=\"#00bb9c\"><b>%s</b></font> :</Html>";
	public static final String TEXT_DILAOG_MSG_CONTENT = "<Html><div>Staff  <font color=\"#00bb9c\"><b>%s</b></font>  applied for a leave from  <font color=\"#00bb9c\"><b>%s</b></font>  to  <font color=\"#00bb9c\"><b>%s</b></font> .</div></Html>";
	public static final String TEXT_DILAOG_MSG_CONTENT_ALLENDORSE = "<Html>Your leave application ( from <font color=\"#00bb9c\"><b>%s</b></font> to <font color=\"#00bb9c\"><b>%s</b></font> ) has been approved.</Html>";
	public static final String TEXT_DILAOG_MSG_CONTENT_DECLINE = "<Html>Your leave application ( from <font color=\"#00bb9c\"><b>%s</b></font> to <font color=\"#00bb9c\"><b>%s</b></font> ) has been declined by <font color=\"#00bb9c\"><b>%s</b></font>.</Html>";

	public static final String HINT_ERROR_TITLE = "Error";
	public static final String HINT_ERROR_NAME = "Staff name cannot be empty";
	public static final String HINT_ERROR_DIRECTOR_ONLY = "Already have a director(Please cancel it firstly)";
	public static final String HINT_ERROR_SUPERVISOR = "The staff’s supervisor can not be empty";
	public static final String HINT_ERROR_DELETE = "Have other staff under supervise, please cancel it firstly";
	public static final String HINT_ERROR_LEAVE_DATE = "Error date";
	public static final String HINT_ERROR_LEAVE_STAFF = "Please choose a applicant";
	public static final String HINT_ERROR_LEAVE_DATE_START = "Please set a start date";
	public static final String HINT_ERROR_LEAVE_DATE_END = "Please set a end date";
	public static final String[] MONTHS = { "Jan.", "Feb.", "Mar.", "Apr.",
			"May.", "Jun", "Jul.", "Aug.", "Sep.", "Oct.", "Nov.", "Dec." };
	public static final String[] DAYS = { "st", "nd", "rd", "th" };

	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 540;
	public static final int WINDOW_PADDING_TOP = 20;
	public static final int WINDOW_PADDING_LEFT = 24;
	public static final int WINDOW_PADDING_RIGHT = 28;

	public static final int DIALOG_STAFF_WIDTH = 400;
	public static final int DIALOG_STAFF_HEIGHT = 280;

	public static final int DIALOG_LEAVE_WIDTH = 400;
	public static final int DIALOG_LEAVE_HEIGHT = 400;

	public static final int DIALOG_NOTICE_WIDTH = 400;
	public static final int DIALOG_NOTICE_HEIGHT = 200;

	public static final Font FONT_TITLE = new Font(null, Font.BOLD, 20);
	public static final Font FONT_BUTTON = new Font(null, Font.PLAIN, 16);
	public static final Font FONT_BUTTON_MINI = new Font(null, Font.PLAIN, 14);
	public static final Font FONT_TABLE_TITLE = new Font(null, Font.BOLD, 14);
	public static final Font FONT_NORMAL = new Font(null, Font.PLAIN, 16);

	public static final Font FONT_DIALOG_NORMAL = new Font(null, Font.PLAIN, 16);
	public static final Font FONT_DIALOG_TITLE = new Font(null, Font.BOLD, 18);

	public static final Color COLOR_333 = new Color(51, 51, 51);
	public static final Color COLOR_666 = new Color(102, 102, 102);
	public static final Color COLOR_999 = new Color(153, 153, 153);
	public static final Color COLOR_CCC = new Color(204, 204, 204);
	public static final Color COLOR_EEE = new Color(238, 238, 238);
	public static final Color COLOR_BK = new Color(248, 248, 248);
	public static final Color COLOR_BK_CONTENT = new Color(255, 255, 255);
	public static final Color COLOR_BTN_SELECT = new Color(0, 170, 140);
	public static final Color COLOR_BTN_NORMAL = new Color(0, 187, 156);

	public static final String URL_ICON = "/drawable/ic_launcher.png";

}
