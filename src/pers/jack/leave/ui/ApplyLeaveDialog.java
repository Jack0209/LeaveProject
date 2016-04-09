package pers.jack.leave.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import pers.jack.leave.bean.DateItem;
import pers.jack.leave.bean.DateItem.DateMode;
import pers.jack.leave.bean.LeaveNotice;
import pers.jack.leave.bean.Staff;
import pers.jack.leave.common.ProjectConstants;
import pers.jack.leave.core.BaseDialog;
import pers.jack.leave.ui.adapter.DateComboBoxModel;
import pers.jack.leave.ui.adapter.StaffComboBoxModel;
import pers.jack.leave.ui.listener.OnApplyLeaveDialogSubmitBtnClickListener;
import pers.jack.leave.ui.style.ProjectMetalComboBoxUI;
import pers.jack.leave.util.ProjectUtils;
import pers.jack.leave.util.TimeFormatUtil;

public class ApplyLeaveDialog extends BaseDialog implements ItemListener,
		ActionListener {
	private static final long serialVersionUID = 8199426484882061148L;

	private JLabel mLabelFrom;
	private JComboBox<Staff> mComboBoxFrom;
	private JLabel mLabelStart;
	private JComboBox<DateItem> mComboBoxStartYear;
	private JComboBox<DateItem> mComboBoxStartMonth;
	private JComboBox<DateItem> mComboBoxStartDay;
	private JLabel mLabelEnd;
	private JComboBox<DateItem> mComboBoxEndYear;
	private JComboBox<DateItem> mComboBoxEndMonth;
	private JComboBox<DateItem> mComboBoxEndDay;
	private JButton mBtnSubmit;

	private StaffComboBoxModel mStaffComboBoxModel;
	private DateComboBoxModel mDateComboBoxModelStartYear;
	private DateComboBoxModel mDateComboBoxModelStartMonth;
	private DateComboBoxModel mDateComboBoxModelStartDay;
	private DateComboBoxModel mDateComboBoxModelEndYear;
	private DateComboBoxModel mDateComboBoxModelEndMonth;
	private DateComboBoxModel mDateComboBoxModelEndDay;

	private OnApplyLeaveDialogSubmitBtnClickListener mListener;

	private ArrayList<Staff> mDataList;

	public ApplyLeaveDialog(JFrame jFrame) {
		super(jFrame);
		setModal(true);
		setTitle(ProjectConstants.TEXT_TITLE_DIALOG_LEAVE);

	}

	public void setListener(OnApplyLeaveDialogSubmitBtnClickListener listener) {
		this.mListener = listener;
	}

	@Override
	protected int getDialogWdith() {
		return ProjectConstants.DIALOG_LEAVE_WIDTH;

	}

	@Override
	protected int getDialogHeight() {
		return ProjectConstants.DIALOG_LEAVE_HEIGHT;

	}

	@Override
	protected void initUtils() {
		mStaffComboBoxModel = new StaffComboBoxModel();
		mDateComboBoxModelStartYear = new DateComboBoxModel(2017, 2016,
				DateMode.YEAR);
		mDateComboBoxModelStartMonth = new DateComboBoxModel(12, 1,
				DateMode.MONTH);
		mDateComboBoxModelStartDay = new DateComboBoxModel(31, 1, DateMode.DAY);
		mDateComboBoxModelEndYear = new DateComboBoxModel(2017, 2016,
				DateMode.YEAR);
		mDateComboBoxModelEndMonth = new DateComboBoxModel(12, 1,
				DateMode.MONTH);
		mDateComboBoxModelEndDay = new DateComboBoxModel(31, 1, DateMode.DAY);
	}

	@Override
	protected void initViews(JPanel panelBk) {
		mLabelFrom = new JLabel();
		mLabelFrom.setText(ProjectConstants.TEXT_DILAOG_FROM);
		mLabelFrom.setFont(ProjectConstants.FONT_DIALOG_TITLE);
		mLabelFrom.setForeground(ProjectConstants.COLOR_666);
		mLabelFrom.setBounds(ProjectConstants.WINDOW_PADDING_LEFT,
				ProjectConstants.WINDOW_PADDING_TOP, 200, 20);
		mLabelFrom.setVerticalAlignment(JLabel.CENTER);

		mComboBoxFrom = new JComboBox<Staff>();
		mComboBoxFrom.setModel(mStaffComboBoxModel);
		mComboBoxFrom.setBounds(ProjectConstants.WINDOW_PADDING_LEFT * 2,
				ProjectConstants.WINDOW_PADDING_TOP + mLabelFrom.getHeight()
						+ 16, ProjectConstants.DIALOG_LEAVE_WIDTH
						- ProjectConstants.WINDOW_PADDING_LEFT * 2
						- ProjectConstants.WINDOW_PADDING_RIGHT * 2, 26);
		mComboBoxFrom.setFont(ProjectConstants.FONT_DIALOG_NORMAL);
		mComboBoxFrom.setForeground(ProjectConstants.COLOR_666);
		mComboBoxFrom.setMaximumRowCount(4);
		mComboBoxFrom.setOpaque(true);
		mComboBoxFrom.setUI(new ProjectMetalComboBoxUI());

		mLabelStart = new JLabel();
		mLabelStart.setText(ProjectConstants.TEXT_DILAOG_DATE_START);
		mLabelStart.setFont(ProjectConstants.FONT_DIALOG_TITLE);
		mLabelStart.setForeground(ProjectConstants.COLOR_666);
		mLabelStart.setBounds(ProjectConstants.WINDOW_PADDING_LEFT,
				ProjectConstants.WINDOW_PADDING_TOP + mLabelFrom.getHeight()
						+ mComboBoxFrom.getHeight() + 36,
				ProjectConstants.DIALOG_LEAVE_WIDTH
						- ProjectConstants.WINDOW_PADDING_LEFT
						- ProjectConstants.WINDOW_PADDING_RIGHT, 26);
		mLabelStart.setVerticalAlignment(JLabel.CENTER);

		mComboBoxStartYear = new JComboBox<DateItem>();
		mComboBoxStartYear.setModel(mDateComboBoxModelStartYear);
		mComboBoxStartYear
				.setBounds(
						ProjectConstants.WINDOW_PADDING_LEFT * 2,
						ProjectConstants.WINDOW_PADDING_TOP
								+ mLabelFrom.getHeight()
								+ mComboBoxFrom.getHeight()
								+ mLabelStart.getHeight() + 52,
						(int) ((ProjectConstants.DIALOG_LEAVE_WIDTH
								- ProjectConstants.WINDOW_PADDING_LEFT * 2
								- ProjectConstants.WINDOW_PADDING_RIGHT * 2 - 40) * 0.4),
						26);
		mComboBoxStartYear.setFont(ProjectConstants.FONT_DIALOG_NORMAL);
		mComboBoxStartYear.setForeground(ProjectConstants.COLOR_666);
		mComboBoxStartYear.setMaximumRowCount(4);
		mComboBoxStartYear.setOpaque(true);
		mComboBoxStartYear.setUI(new ProjectMetalComboBoxUI());

		mComboBoxStartMonth = new JComboBox<DateItem>();
		mComboBoxStartMonth.setModel(mDateComboBoxModelStartMonth);
		mComboBoxStartMonth
				.setBounds(
						ProjectConstants.WINDOW_PADDING_LEFT * 2
								+ mComboBoxStartYear.getWidth() + 21,
						ProjectConstants.WINDOW_PADDING_TOP
								+ mLabelFrom.getHeight()
								+ mComboBoxFrom.getHeight()
								+ mLabelStart.getHeight() + 52,
						(int) ((ProjectConstants.DIALOG_LEAVE_WIDTH
								- ProjectConstants.WINDOW_PADDING_LEFT * 2
								- ProjectConstants.WINDOW_PADDING_RIGHT * 2 - 40) * 0.3),
						26);
		mComboBoxStartMonth.setFont(ProjectConstants.FONT_DIALOG_NORMAL);
		mComboBoxStartMonth.setForeground(ProjectConstants.COLOR_666);
		mComboBoxStartMonth.setMaximumRowCount(4);
		mComboBoxStartMonth.setOpaque(true);
		mComboBoxStartMonth.setUI(new ProjectMetalComboBoxUI());

		mComboBoxStartDay = new JComboBox<DateItem>();
		mComboBoxStartDay.setModel(mDateComboBoxModelStartDay);
		mComboBoxStartDay
				.setBounds(
						ProjectConstants.WINDOW_PADDING_LEFT * 2
								+ mComboBoxStartYear.getWidth()
								+ mComboBoxStartMonth.getWidth() + 42,
						ProjectConstants.WINDOW_PADDING_TOP
								+ mLabelFrom.getHeight()
								+ mComboBoxFrom.getHeight()
								+ mLabelStart.getHeight() + 52,
						(int) ((ProjectConstants.DIALOG_LEAVE_WIDTH
								- ProjectConstants.WINDOW_PADDING_LEFT * 2
								- ProjectConstants.WINDOW_PADDING_RIGHT * 2 - 40) * 0.3),
						26);
		mComboBoxStartDay.setFont(ProjectConstants.FONT_DIALOG_NORMAL);
		mComboBoxStartDay.setForeground(ProjectConstants.COLOR_666);
		mComboBoxStartDay.setMaximumRowCount(4);
		mComboBoxStartDay.setOpaque(true);
		mComboBoxStartDay.setUI(new ProjectMetalComboBoxUI());

		mLabelEnd = new JLabel();
		mLabelEnd.setText(ProjectConstants.TEXT_DILAOG_DATE_END);
		mLabelEnd.setFont(ProjectConstants.FONT_DIALOG_TITLE);
		mLabelEnd.setForeground(ProjectConstants.COLOR_666);
		mLabelEnd.setBounds(ProjectConstants.WINDOW_PADDING_LEFT,
				ProjectConstants.WINDOW_PADDING_TOP + mLabelFrom.getHeight()
						+ mComboBoxFrom.getHeight() + mLabelStart.getHeight()
						+ mComboBoxStartYear.getHeight() + 72,
				ProjectConstants.DIALOG_LEAVE_WIDTH
						- ProjectConstants.WINDOW_PADDING_LEFT
						- ProjectConstants.WINDOW_PADDING_RIGHT, 26);
		mLabelEnd.setVerticalAlignment(JLabel.CENTER);

		mComboBoxEndYear = new JComboBox<DateItem>();
		mComboBoxEndYear.setModel(mDateComboBoxModelEndYear);
		mComboBoxEndYear
				.setBounds(
						ProjectConstants.WINDOW_PADDING_LEFT * 2,
						ProjectConstants.WINDOW_PADDING_TOP
								+ mLabelFrom.getHeight()
								+ mComboBoxFrom.getHeight()
								+ mLabelStart.getHeight()
								+ mComboBoxStartYear.getHeight()
								+ mLabelEnd.getHeight() + 88,
						(int) ((ProjectConstants.DIALOG_LEAVE_WIDTH
								- ProjectConstants.WINDOW_PADDING_LEFT * 2
								- ProjectConstants.WINDOW_PADDING_RIGHT * 2 - 40) * 0.4),
						26);
		mComboBoxEndYear.setFont(ProjectConstants.FONT_DIALOG_NORMAL);
		mComboBoxEndYear.setForeground(ProjectConstants.COLOR_666);
		mComboBoxEndYear.setMaximumRowCount(4);
		mComboBoxEndYear.setOpaque(true);
		mComboBoxEndYear.setUI(new ProjectMetalComboBoxUI());

		mComboBoxEndMonth = new JComboBox<DateItem>();
		mComboBoxEndMonth.setModel(mDateComboBoxModelEndMonth);
		mComboBoxEndMonth
				.setBounds(
						ProjectConstants.WINDOW_PADDING_LEFT * 2
								+ mComboBoxEndYear.getWidth() + 21,
						ProjectConstants.WINDOW_PADDING_TOP
								+ mLabelFrom.getHeight()
								+ mComboBoxFrom.getHeight()
								+ mLabelStart.getHeight()
								+ mComboBoxStartYear.getHeight()
								+ mLabelEnd.getHeight() + 88,
						(int) ((ProjectConstants.DIALOG_LEAVE_WIDTH
								- ProjectConstants.WINDOW_PADDING_LEFT * 2
								- ProjectConstants.WINDOW_PADDING_RIGHT * 2 - 40) * 0.3),
						26);
		mComboBoxEndMonth.setFont(ProjectConstants.FONT_DIALOG_NORMAL);
		mComboBoxEndMonth.setForeground(ProjectConstants.COLOR_666);
		mComboBoxEndMonth.setMaximumRowCount(4);
		mComboBoxEndMonth.setOpaque(true);
		mComboBoxEndMonth.setUI(new ProjectMetalComboBoxUI());

		mComboBoxEndDay = new JComboBox<DateItem>();
		mComboBoxEndDay.setModel(mDateComboBoxModelEndDay);
		mComboBoxEndDay
				.setBounds(
						ProjectConstants.WINDOW_PADDING_LEFT * 2
								+ mComboBoxEndYear.getWidth()
								+ mComboBoxEndMonth.getWidth() + 42,
						ProjectConstants.WINDOW_PADDING_TOP
								+ mLabelFrom.getHeight()
								+ mComboBoxFrom.getHeight()
								+ mLabelStart.getHeight()
								+ mComboBoxStartYear.getHeight()
								+ mLabelEnd.getHeight() + 88,
						(int) ((ProjectConstants.DIALOG_LEAVE_WIDTH
								- ProjectConstants.WINDOW_PADDING_LEFT * 2
								- ProjectConstants.WINDOW_PADDING_RIGHT * 2 - 40) * 0.3),
						26);
		mComboBoxEndDay.setFont(ProjectConstants.FONT_DIALOG_NORMAL);
		mComboBoxEndDay.setForeground(ProjectConstants.COLOR_666);
		mComboBoxEndDay.setMaximumRowCount(4);
		mComboBoxEndDay.setOpaque(true);
		mComboBoxEndDay.setUI(new ProjectMetalComboBoxUI());

		mBtnSubmit = new JButton(ProjectConstants.TEXT_BTN_SUBMIT);
		mBtnSubmit.setFont(ProjectConstants.FONT_BUTTON);
		mBtnSubmit.setFocusPainted(false);
		mBtnSubmit.setBounds(
				ProjectConstants.WINDOW_PADDING_LEFT * 2,
				ProjectConstants.WINDOW_PADDING_TOP + mLabelFrom.getHeight()
						+ mComboBoxFrom.getHeight() + mLabelStart.getHeight()
						+ mComboBoxStartYear.getHeight()
						+ mLabelEnd.getHeight() + mComboBoxEndYear.getHeight()
						+ 138, ProjectConstants.DIALOG_LEAVE_WIDTH
						- ProjectConstants.WINDOW_PADDING_LEFT * 2
						- ProjectConstants.WINDOW_PADDING_RIGHT * 2, 32);

		panelBk.add(mLabelFrom);
		panelBk.add(mComboBoxFrom);
		panelBk.add(mLabelStart);
		panelBk.add(mComboBoxStartYear);
		panelBk.add(mComboBoxStartMonth);
		panelBk.add(mComboBoxStartDay);
		panelBk.add(mLabelEnd);
		panelBk.add(mComboBoxEndYear);
		panelBk.add(mComboBoxEndMonth);
		panelBk.add(mComboBoxEndDay);
		panelBk.add(mBtnSubmit);

	}

	@Override
	protected void initListeners() {
		mBtnSubmit.addActionListener(this);
		mComboBoxStartYear.addItemListener(this);
		mComboBoxStartMonth.addItemListener(this);
		mComboBoxEndYear.addItemListener(this);
		mComboBoxEndMonth.addItemListener(this);
	}

	@Override
	protected void initData() {
		if (mDataList != null) {
			mStaffComboBoxModel.setDataList(ProjectUtils
					.getStaffsExceptDirector(mDataList));
		}
		mStaffComboBoxModel.setSelectedItem(null);
		mComboBoxStartYear.setSelectedItem(null);
		mComboBoxStartMonth.setSelectedItem(null);
		mComboBoxStartDay.setSelectedItem(null);
		mComboBoxEndYear.setSelectedItem(null);
		mComboBoxEndMonth.setSelectedItem(null);
		mComboBoxEndDay.setSelectedItem(null);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			if (e.getSource() == mComboBoxStartMonth
					|| e.getSource() == mComboBoxStartYear) {
				DateItem chooseMonth = (DateItem) mComboBoxStartMonth
						.getSelectedItem();
				if (chooseMonth != null) {
					int year = -1;
					DateItem chooseYear = (DateItem) mComboBoxStartYear
							.getSelectedItem();
					if (chooseYear != null) {
						year = chooseYear.getIntValue();
					}
					mDateComboBoxModelStartDay.setMaxValue(getMaxDay(year,
							chooseMonth.getIntValue()));
					mComboBoxStartDay.updateUI();
					mComboBoxStartDay.setUI(new ProjectMetalComboBoxUI());

				}
			} else {
				DateItem chooseMonth = (DateItem) mComboBoxEndMonth
						.getSelectedItem();
				if (chooseMonth != null) {
					int year = -1;
					DateItem chooseYear = (DateItem) mComboBoxEndYear
							.getSelectedItem();
					if (chooseYear != null) {
						year = chooseYear.getIntValue();
					}
					mDateComboBoxModelEndDay.setMaxValue(getMaxDay(year,
							chooseMonth.getIntValue()));
					mComboBoxEndDay.updateUI();
					mComboBoxEndDay.setUI(new ProjectMetalComboBoxUI());
				}
			}
		}
	}

	private int getMaxDay(int year, int month) {
		int maxDay;
		switch (month) {
		case 2:
			maxDay = 28;
			if (year != -1 && year % 4 == 0) {
				maxDay = 29;
			}
			break;
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			maxDay = 31;
			break;
		default:
			maxDay = 30;
			break;
		}
		return maxDay;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Staff staffFrom = (Staff) mComboBoxFrom.getSelectedItem();
		if (staffFrom == null) {
			JOptionPane.showMessageDialog(this,
					ProjectConstants.HINT_ERROR_LEAVE_STAFF,
					ProjectConstants.HINT_ERROR_TITLE,
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		DateItem startYear = (DateItem) mComboBoxStartYear.getSelectedItem();
		DateItem startMonth = (DateItem) mComboBoxStartMonth.getSelectedItem();
		DateItem startDay = (DateItem) mComboBoxStartDay.getSelectedItem();
		if (startYear == null || startMonth == null || startDay == null) {
			JOptionPane.showMessageDialog(this,
					ProjectConstants.HINT_ERROR_LEAVE_DATE_START,
					ProjectConstants.HINT_ERROR_TITLE,
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		DateItem endYear = (DateItem) mComboBoxEndYear.getSelectedItem();
		DateItem endMonth = (DateItem) mComboBoxEndMonth.getSelectedItem();
		DateItem endDay = (DateItem) mComboBoxEndDay.getSelectedItem();
		if (endYear == null || endMonth == null || endDay == null) {
			JOptionPane.showMessageDialog(this,
					ProjectConstants.HINT_ERROR_LEAVE_DATE_END,
					ProjectConstants.HINT_ERROR_TITLE,
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		if (!TimeFormatUtil.compareDate(startYear.getIntValue(),
				startMonth.getIntValue(), startDay.getIntValue(),
				endYear.getIntValue(), endMonth.getIntValue(),
				endDay.getIntValue())) {
			JOptionPane.showMessageDialog(this,
					ProjectConstants.HINT_ERROR_LEAVE_DATE,
					ProjectConstants.HINT_ERROR_TITLE,
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		LeaveNotice leaveNotice = new LeaveNotice();
		leaveNotice.setFromStaff(staffFrom);
		leaveNotice.setDateStart(startYear, startMonth, startDay);
		leaveNotice.setDateEnd(endYear, endMonth, endDay);
		setVisible(false);
		if (this.mListener != null) {
			this.mListener.onApplyLeaveSubmit(leaveNotice);
		}

	}

	public void show(ArrayList<Staff> staffList) {
		this.mDataList = staffList;
		initData();
		setVisible(true);
	}
}
