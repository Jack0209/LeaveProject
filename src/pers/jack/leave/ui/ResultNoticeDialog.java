package pers.jack.leave.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import pers.jack.leave.bean.LeaveNotice;
import pers.jack.leave.bean.Staff;
import pers.jack.leave.common.ProjectConstants;
import pers.jack.leave.core.BaseDialog;

public class ResultNoticeDialog extends BaseDialog implements ActionListener {
	private static final long serialVersionUID = 3172128529196900198L;
	private JLabel mLabelTo;
	private JLabel mLabelContent;
	private JButton mBtnCloose;

	private Staff mStaffDecline;
	private LeaveNotice mLeaveNotice;

	private boolean isAllEndorse;

	public ResultNoticeDialog(JFrame jFrame) {
		super(jFrame);
		setModal(true);
		// setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

	}

	@Override
	protected int getDialogWdith() {
		return ProjectConstants.DIALOG_NOTICE_WIDTH;

	}

	@Override
	protected int getDialogHeight() {
		return ProjectConstants.DIALOG_NOTICE_HEIGHT;

	}

	@Override
	protected void initUtils() {

	}

	@Override
	protected void initViews(JPanel panelBk) {
		mLabelTo = new JLabel();
		mLabelTo.setFont(ProjectConstants.FONT_DIALOG_TITLE);
		mLabelTo.setForeground(ProjectConstants.COLOR_666);
		mLabelTo.setBounds(ProjectConstants.WINDOW_PADDING_LEFT,
				ProjectConstants.WINDOW_PADDING_TOP, 200, 20);
		mLabelTo.setVerticalAlignment(JLabel.CENTER);

		mLabelContent = new JLabel();
		mLabelContent.setFont(ProjectConstants.FONT_DIALOG_NORMAL);
		mLabelContent.setForeground(ProjectConstants.COLOR_666);
		mLabelContent.setBounds(ProjectConstants.WINDOW_PADDING_LEFT * 2,
				ProjectConstants.WINDOW_PADDING_TOP + mLabelTo.getHeight(),
				ProjectConstants.DIALOG_NOTICE_WIDTH
						- ProjectConstants.WINDOW_PADDING_LEFT * 2
						- ProjectConstants.WINDOW_PADDING_RIGHT * 2, 76);
		mLabelContent.setVerticalAlignment(JLabel.CENTER);

		mBtnCloose = new JButton(ProjectConstants.TEXT_BTN_CLOSE);
		mBtnCloose.setFont(ProjectConstants.FONT_BUTTON);
		mBtnCloose.setFocusPainted(false);
		mBtnCloose.setBounds(ProjectConstants.WINDOW_PADDING_LEFT * 2,
				ProjectConstants.WINDOW_PADDING_TOP + mLabelTo.getHeight()
						+ mLabelContent.getHeight(),
				ProjectConstants.DIALOG_LEAVE_WIDTH
						- ProjectConstants.WINDOW_PADDING_LEFT * 2
						- ProjectConstants.WINDOW_PADDING_RIGHT * 2, 32);

		panelBk.add(mLabelTo);
		panelBk.add(mLabelContent);
		panelBk.add(mBtnCloose);
	}

	@Override
	protected void initListeners() {
		mBtnCloose.addActionListener(this);

	}

	@Override
	protected void initData() {
		setTitle(ProjectConstants.TEXT_TITLE_DIALOG_NOTICE);
		String strLabelTo = "";
		String strLabelContent = "";
		if (this.mLeaveNotice != null) {
			strLabelTo = String.format(ProjectConstants.TEXT_DILAOG_MSG_TO,
					this.mLeaveNotice.getFromStaff().toString());
			if (this.isAllEndorse) {
				strLabelContent = String.format(
						ProjectConstants.TEXT_DILAOG_MSG_CONTENT_ALLENDORSE,
						this.mLeaveNotice.getShowDateStart(),
						this.mLeaveNotice.getShowDateEnd());
			} else {
				strLabelContent = String.format(
						ProjectConstants.TEXT_DILAOG_MSG_CONTENT_DECLINE,
						this.mLeaveNotice.getShowDateStart(),
						this.mLeaveNotice.getShowDateEnd(),
						this.mStaffDecline.toString());
			}
		}
		mLabelTo.setText(strLabelTo);
		mLabelContent.setText(strLabelContent);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		setVisible(false);
	}

	public void show(boolean isAllEndorse, Staff staffDecline,
			LeaveNotice leaveNotice) {
		this.isAllEndorse = isAllEndorse;
		this.mStaffDecline = staffDecline;
		this.mLeaveNotice = leaveNotice;
		initData();
		setVisible(true);
	}
}
