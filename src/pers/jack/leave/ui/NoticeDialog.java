package pers.jack.leave.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import pers.jack.leave.bean.LeaveNotice;
import pers.jack.leave.bean.Staff;
import pers.jack.leave.common.NoticeOption;
import pers.jack.leave.common.ProjectConstants;
import pers.jack.leave.core.BaseDialog;
import pers.jack.leave.ui.listener.OnNoticeDialogOptionChooseListener;

public class NoticeDialog extends BaseDialog implements ActionListener {
	private static final long serialVersionUID = -3037606296278800952L;

	private JLabel mLabelTo;
	private JLabel mLabelContent;
	private JButton mBtnEndorse;
	private JButton mBtnDecline;

	private Staff mStaffTo;
	private LeaveNotice mLeaveNotice;

	private OnNoticeDialogOptionChooseListener mListener;

	public NoticeDialog(JFrame jFrame) {
		super(jFrame);
		setModal(true);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

	}

	@Override
	protected int getDialogWdith() {
		return ProjectConstants.DIALOG_NOTICE_WIDTH;

	}

	@Override
	protected int getDialogHeight() {
		return ProjectConstants.DIALOG_NOTICE_HEIGHT;

	}

	public void setListener(OnNoticeDialogOptionChooseListener listener) {
		this.mListener = listener;
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

		mBtnEndorse = new JButton(ProjectConstants.TEXT_BTN_ENDORSE);
		mBtnEndorse.setFont(ProjectConstants.FONT_BUTTON);
		mBtnEndorse.setFocusPainted(false);
		mBtnEndorse
				.setBounds(
						ProjectConstants.WINDOW_PADDING_LEFT * 2,
						ProjectConstants.WINDOW_PADDING_TOP
								+ mLabelTo.getHeight()
								+ mLabelContent.getHeight(),
						(ProjectConstants.DIALOG_LEAVE_WIDTH
								- ProjectConstants.WINDOW_PADDING_LEFT * 2 - ProjectConstants.WINDOW_PADDING_RIGHT * 2) / 2 - 10,
						32);

		mBtnDecline = new JButton(ProjectConstants.TEXT_BTN_DECLINE);
		mBtnDecline.setFont(ProjectConstants.FONT_BUTTON);
		mBtnDecline.setFocusPainted(false);
		mBtnDecline
				.setBounds(
						ProjectConstants.WINDOW_PADDING_LEFT * 2
								+ mBtnEndorse.getWidth() + 20,
						ProjectConstants.WINDOW_PADDING_TOP
								+ mLabelTo.getHeight()
								+ mLabelContent.getHeight(),
						(ProjectConstants.DIALOG_LEAVE_WIDTH
								- ProjectConstants.WINDOW_PADDING_LEFT * 2 - ProjectConstants.WINDOW_PADDING_RIGHT * 2) / 2 - 10,
						32);

		panelBk.add(mLabelTo);
		panelBk.add(mLabelContent);
		panelBk.add(mBtnEndorse);
		panelBk.add(mBtnDecline);
	}

	@Override
	protected void initListeners() {
		mBtnEndorse.addActionListener(this);
		mBtnDecline.addActionListener(this);

	}

	@Override
	protected void initData() {
		setTitle(ProjectConstants.TEXT_TITLE_DIALOG_NOTICE);
		String strLabelTo = "";
		String strLabelContent = "";
		if (this.mStaffTo != null) {
			strLabelTo = String.format(ProjectConstants.TEXT_DILAOG_MSG_TO,
					this.mStaffTo.toString());
		}
		if (this.mLeaveNotice != null) {
			strLabelContent = String.format(
					ProjectConstants.TEXT_DILAOG_MSG_CONTENT, this.mLeaveNotice
							.getFromStaff().toString(), this.mLeaveNotice
							.getShowDateStart(), this.mLeaveNotice
							.getShowDateEnd());
		}
		mLabelTo.setText(strLabelTo);
		mLabelContent.setText(strLabelContent);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		setVisible(false);
		if (e.getSource() == mBtnEndorse) {

			if (this.mLeaveNotice != null && mListener != null) {
				mListener.onNoticeDialogOptionChoose(this,
						NoticeOption.ENDORSE, this.mLeaveNotice);
			}
		} else if (e.getSource() == mBtnDecline) {

			if (this.mLeaveNotice != null && mListener != null) {
				mListener.onNoticeDialogOptionChoose(this,
						NoticeOption.DECLINE, this.mLeaveNotice);
			}

		}

	}

	public void show(Staff toStaff, LeaveNotice leaveNotice) {
		this.mStaffTo = toStaff;
		this.mLeaveNotice = leaveNotice;
		initData();
		setVisible(true);
	}
}
