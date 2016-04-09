package pers.jack.leave.ui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import pers.jack.leave.bean.LeaveNotice;
import pers.jack.leave.bean.Staff;
import pers.jack.leave.common.ProjectConstants;
import pers.jack.leave.core.BaseFrame;
import pers.jack.leave.ui.adapter.StaffTableCellRenderer;
import pers.jack.leave.ui.adapter.StaffTableModel;
import pers.jack.leave.ui.listener.OnApplyLeaveDialogSubmitBtnClickListener;
import pers.jack.leave.ui.listener.OnStaffDialogSaveBtnClickListener;
import pers.jack.leave.ui.listener.OnStaffTableItemBtnClickListener;
import pers.jack.leave.util.ProjectUtils;

public class MainFrame extends BaseFrame implements
		OnStaffTableItemBtnClickListener, ActionListener,
		OnStaffDialogSaveBtnClickListener,
		OnApplyLeaveDialogSubmitBtnClickListener {
	private static final long serialVersionUID = -2645026203894855457L;

	private JLabel mLabelListTitle;
	private JTable mTableList;
	private JScrollPane mJScrollPanel;

	private JPanel mPanelBtn;
	private JButton mBtnAddStaff;
	private JButton mBtnApplyLeave;

	private StaffTableCellRenderer mTableCellRenderer;
	private StaffDialog mDialogStaff;
	private ApplyLeaveDialog mDialogApplyLeave;

	private StaffTableModel mTableModel;

	public MainFrame() {
		super();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	@Override
	protected void initUtils() {

		mTableCellRenderer = new StaffTableCellRenderer();
		mTableModel = new StaffTableModel();

	}

	@Override
	protected void initViews(JPanel panelBk) {
		mLabelListTitle = new JLabel();
		mLabelListTitle.setText(ProjectConstants.TEXT_TABLE_TITLE);
		mLabelListTitle.setFont(ProjectConstants.FONT_TITLE);
		mLabelListTitle.setForeground(ProjectConstants.COLOR_666);
		mLabelListTitle.setBounds(ProjectConstants.WINDOW_PADDING_LEFT,
				ProjectConstants.WINDOW_PADDING_TOP, 200, 40);
		mLabelListTitle.setVerticalAlignment(JLabel.CENTER);

		mTableList = new JTable();
		mTableList.setModel(mTableModel);
		// mTableList.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		mTableList.setOpaque(true);
		mTableList.setBackground(ProjectConstants.COLOR_BK_CONTENT);
		mTableList.setDefaultRenderer(Object.class, mTableCellRenderer);
		mTableList.setDefaultEditor(Object.class, mTableCellRenderer);
		mTableList.setRowHeight(40);
		mTableList.getColumnModel().getColumn(0).setPreferredWidth(100);
		mTableList.getColumnModel().getColumn(1).setPreferredWidth(200);
		mTableList.getColumnModel().getColumn(2).setPreferredWidth(200);
		mTableList.getColumnModel().getColumn(3).setPreferredWidth(100);
		mTableList.getColumnModel().getColumn(4).setPreferredWidth(240);

		mTableList.getTableHeader().setFont(ProjectConstants.FONT_TABLE_TITLE);
		mTableList.getTableHeader().setForeground(ProjectConstants.COLOR_666);
		mTableList.getTableHeader().setBackground(
				ProjectConstants.COLOR_BK_CONTENT);
		mTableList.getTableHeader().setPreferredSize(
				new Dimension(mTableList.getTableHeader().getWidth(), 44));

		mJScrollPanel = new JScrollPane();
		mJScrollPanel.setViewportView(mTableList);
		mJScrollPanel.setBounds(ProjectConstants.WINDOW_PADDING_LEFT,
				mLabelListTitle.getHeight()
						+ ProjectConstants.WINDOW_PADDING_TOP,
				ProjectConstants.WINDOW_WIDTH
						- ProjectConstants.WINDOW_PADDING_LEFT
						- ProjectConstants.WINDOW_PADDING_RIGHT, 350);
		mJScrollPanel.setOpaque(true);
		mJScrollPanel.setBackground(ProjectConstants.COLOR_BK_CONTENT);
		JScrollBar scrollBar = mJScrollPanel.getVerticalScrollBar();
		scrollBar.setBackground(ProjectConstants.COLOR_BK);
		scrollBar.setOpaque(true);

		mPanelBtn = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 30));
		int btnWidth = (ProjectConstants.WINDOW_WIDTH
				- ProjectConstants.WINDOW_PADDING_LEFT
				- ProjectConstants.WINDOW_PADDING_RIGHT - 20) / 2;
		mPanelBtn.setOpaque(true);
		mPanelBtn.setBackground(ProjectConstants.COLOR_BK);

		mBtnAddStaff = new JButton(ProjectConstants.TEXT_BTN_ADD_STAFF);
		mBtnAddStaff.setPreferredSize(new Dimension(btnWidth, 32));
		mBtnAddStaff.setFont(ProjectConstants.FONT_BUTTON);
		mBtnAddStaff.setFocusPainted(false);
		mPanelBtn.add(mBtnAddStaff);

		mBtnApplyLeave = new JButton(ProjectConstants.TEXT_BTN_APPLY_LEAVE);
		mBtnApplyLeave.setPreferredSize(new Dimension(btnWidth, 32));
		mBtnApplyLeave.setFont(ProjectConstants.FONT_BUTTON);
		mBtnApplyLeave.setFocusPainted(false);
		mPanelBtn.add(mBtnApplyLeave);
		mPanelBtn.setBounds(
				ProjectConstants.WINDOW_PADDING_LEFT - 24,
				ProjectConstants.WINDOW_PADDING_TOP
						+ mLabelListTitle.getHeight()
						+ mJScrollPanel.getHeight(),
				ProjectConstants.WINDOW_WIDTH
						- ProjectConstants.WINDOW_PADDING_LEFT
						- ProjectConstants.WINDOW_PADDING_RIGHT + 48, 120);

		panelBk.add(mLabelListTitle);
		panelBk.add(mJScrollPanel);
		panelBk.add(mPanelBtn);

	}

	@Override
	protected void initListeners() {

		mTableCellRenderer.setOnItemClickListener(this);
		mBtnAddStaff.addActionListener(this);
		mBtnApplyLeave.addActionListener(this);
	}

	@Override
	protected void initData() {
		mTableModel.setDataList(ProjectUtils.getInitStaffs());

	}

	@Override
	public void onDeleteBtnClick(int row, int column) {
		if (ProjectUtils.isHasSubordinate(mTableModel.getDataList(),
				mTableModel.getValueAt(row))) {
			JOptionPane.showMessageDialog(this,
					ProjectConstants.HINT_ERROR_DELETE,
					ProjectConstants.HINT_ERROR_TITLE,
					JOptionPane.ERROR_MESSAGE);
		} else {
			mTableModel.deleteStaff(row);
		}

	}

	@Override
	public void onEditBtnClick(int row, int column) {
		if (mDialogStaff == null) {
			mDialogStaff = new StaffDialog(this);
			mDialogStaff.setListener(this);
		}
		mDialogStaff.show(mTableModel.getDataList(),
				mTableModel.getValueAt(row));

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mBtnAddStaff) {
			if (mDialogStaff == null) {
				mDialogStaff = new StaffDialog(this);
				mDialogStaff.setListener(this);
			}
			mDialogStaff.show(mTableModel.getDataList(), null);
		} else if (e.getSource() == mBtnApplyLeave) {
			if (mDialogApplyLeave == null) {
				mDialogApplyLeave = new ApplyLeaveDialog(this);
				mDialogApplyLeave.setListener(this);
			}
			mDialogApplyLeave.show(mTableModel.getDataList());

		}

	}

	@Override
	public void onStaffEditFinish(Staff staff) {
		if (staff != null) {
			mTableModel.refreshOne(staff);
		}
	}

	@Override
	public void onApplyLeaveSubmit(LeaveNotice leaveNotice) {
		if (leaveNotice != null) {
			leaveNotice.getFromStaff().applyLeave(new NoticeDialog(this),
					leaveNotice);
		}
	}
}
