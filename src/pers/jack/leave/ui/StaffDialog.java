package pers.jack.leave.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import pers.jack.leave.bean.Staff;
import pers.jack.leave.common.ProjectConstants;
import pers.jack.leave.common.StaffType;
import pers.jack.leave.core.BaseDialog;
import pers.jack.leave.ui.adapter.StaffComboBoxModel;
import pers.jack.leave.ui.listener.NameInputKeyListener;
import pers.jack.leave.ui.listener.OnStaffDialogSaveBtnClickListener;
import pers.jack.leave.ui.style.ProjectMetalComboBoxUI;
import pers.jack.leave.util.ProjectUtils;

public class StaffDialog extends BaseDialog implements ActionListener,
		ChangeListener {
	private static final long serialVersionUID = -153113927341867513L;
	private JLabel mLabelName;
	private JTextField mTextFieldName;
	private JCheckBox mCheckBoxDirector;
	private JLabel mLabelSupervisor;
	private JComboBox<Staff> mComboBoxSupervisor;
	private JButton mBtnSave;

	private StaffComboBoxModel mStaffComboBoxModel;
	private OnStaffDialogSaveBtnClickListener mListener;

	private ArrayList<Staff> mDataList;
	private Staff mSelf;

	public StaffDialog(JFrame jFrame) {
		super(jFrame);
		setModal(true);
	}

	public void setListener(OnStaffDialogSaveBtnClickListener listener) {
		this.mListener = listener;
	}

	@Override
	protected int getDialogWdith() {

		return ProjectConstants.DIALOG_STAFF_WIDTH;

	}

	@Override
	protected int getDialogHeight() {

		return ProjectConstants.DIALOG_STAFF_HEIGHT;

	}

	@Override
	protected void initUtils() {
		mStaffComboBoxModel = new StaffComboBoxModel();

	}

	@Override
	protected void initViews(JPanel panelBk) {
		mLabelName = new JLabel();
		mLabelName.setText(ProjectConstants.TEXT_DILAOG_NAME);
		mLabelName.setFont(ProjectConstants.FONT_DIALOG_TITLE);
		mLabelName.setForeground(ProjectConstants.COLOR_666);
		mLabelName.setBounds(ProjectConstants.WINDOW_PADDING_LEFT,
				ProjectConstants.WINDOW_PADDING_TOP, 200, 20);
		mLabelName.setVerticalAlignment(JLabel.CENTER);

		mTextFieldName = new JTextField();
		mTextFieldName.setBounds(ProjectConstants.WINDOW_PADDING_LEFT * 2,
				ProjectConstants.WINDOW_PADDING_TOP + mLabelName.getHeight()
						+ 10, 170, 26);
		mTextFieldName.setFont(ProjectConstants.FONT_DIALOG_NORMAL);
		mTextFieldName.setForeground(ProjectConstants.COLOR_666);
		mTextFieldName.addKeyListener(new NameInputKeyListener(mTextFieldName,
				ProjectConstants.MAX_NAME));

		mCheckBoxDirector = new JCheckBox();
		mCheckBoxDirector.setBounds(ProjectConstants.WINDOW_PADDING_LEFT * 2
				+ mTextFieldName.getWidth() + 20,
				ProjectConstants.WINDOW_PADDING_TOP + mLabelName.getHeight()
						+ 10, ProjectConstants.DIALOG_STAFF_WIDTH
						- ProjectConstants.WINDOW_PADDING_LEFT * 2
						- ProjectConstants.WINDOW_PADDING_RIGHT * 2
						- mTextFieldName.getWidth() - 20, 26);
		mCheckBoxDirector.setText(ProjectConstants.TEXT_DILAOG_DIRECTOR);
		mCheckBoxDirector.setFont(ProjectConstants.FONT_DIALOG_NORMAL);
		mCheckBoxDirector.setForeground(ProjectConstants.COLOR_666);
		mCheckBoxDirector.setBackground(ProjectConstants.COLOR_BK);
		mCheckBoxDirector.setFocusPainted(false);
		mCheckBoxDirector.setVerticalAlignment(JCheckBox.CENTER);

		mLabelSupervisor = new JLabel();
		mLabelSupervisor.setText(ProjectConstants.TEXT_DILAOG_SUPERVISOR);
		mLabelSupervisor.setFont(ProjectConstants.FONT_DIALOG_TITLE);
		mLabelSupervisor.setForeground(ProjectConstants.COLOR_666);
		mLabelSupervisor.setBounds(ProjectConstants.WINDOW_PADDING_LEFT,
				ProjectConstants.WINDOW_PADDING_TOP + mLabelName.getHeight()
						+ mTextFieldName.getHeight() + 28, 200, 20);
		mLabelSupervisor.setVerticalAlignment(JLabel.CENTER);

		mComboBoxSupervisor = new JComboBox<Staff>();
		mComboBoxSupervisor.setModel(mStaffComboBoxModel);
		mComboBoxSupervisor.setBounds(
				ProjectConstants.WINDOW_PADDING_LEFT * 2,
				ProjectConstants.WINDOW_PADDING_TOP + mLabelName.getHeight()
						+ mTextFieldName.getHeight()
						+ mLabelSupervisor.getHeight() + 36,
				ProjectConstants.DIALOG_STAFF_WIDTH
						- ProjectConstants.WINDOW_PADDING_LEFT * 2
						- ProjectConstants.WINDOW_PADDING_RIGHT * 2, 26);
		mComboBoxSupervisor.setFont(ProjectConstants.FONT_DIALOG_NORMAL);
		mComboBoxSupervisor.setForeground(ProjectConstants.COLOR_666);
		mComboBoxSupervisor.setMaximumRowCount(4);
		mComboBoxSupervisor.setOpaque(true);
		mComboBoxSupervisor.setUI(new ProjectMetalComboBoxUI());

		mBtnSave = new JButton(ProjectConstants.TEXT_BTN_SAVE);
		mBtnSave.setFont(ProjectConstants.FONT_BUTTON);
		mBtnSave.setFocusPainted(false);
		mBtnSave.setBounds(
				ProjectConstants.WINDOW_PADDING_LEFT * 2,
				ProjectConstants.WINDOW_PADDING_TOP + mLabelName.getHeight()
						+ mTextFieldName.getHeight()
						+ mLabelSupervisor.getHeight()
						+ mComboBoxSupervisor.getHeight() + 76,
				ProjectConstants.DIALOG_STAFF_WIDTH
						- ProjectConstants.WINDOW_PADDING_LEFT * 2
						- ProjectConstants.WINDOW_PADDING_RIGHT * 2, 32);

		panelBk.add(mLabelName);
		panelBk.add(mTextFieldName);
		panelBk.add(mCheckBoxDirector);
		panelBk.add(mLabelSupervisor);
		panelBk.add(mComboBoxSupervisor);
		panelBk.add(mBtnSave);
	}

	@Override
	protected void initListeners() {
		mBtnSave.addActionListener(this);
		mCheckBoxDirector.addChangeListener(this);
	}

	@Override
	protected void initData() {
		if (mSelf == null) {
			setTitle(ProjectConstants.TEXT_TITLE_DIALOG_STAFF_NEW);
			mStaffComboBoxModel.setDataList(mDataList);
			mTextFieldName.setText("");
			mComboBoxSupervisor.setEnabled(true);
			mComboBoxSupervisor.setSelectedItem(null);
			mCheckBoxDirector.setSelected(false);
		} else {
			setTitle(ProjectConstants.TEXT_TITLE_DIALOG_STAFF_EDIT);
			mStaffComboBoxModel.setDataList(ProjectUtils.getStaffsExceptSelf(
					mDataList, mSelf));
			mTextFieldName.setText(mSelf.getName());
			if (mSelf.getStaffType() == StaffType.DIRECTOR) {
				mComboBoxSupervisor.setEnabled(false);
				mComboBoxSupervisor.setSelectedItem(null);
				mCheckBoxDirector.setSelected(true);
			} else {
				mComboBoxSupervisor.setEnabled(true);
				mComboBoxSupervisor.setSelectedItem(mSelf.getSupervisor());
				mCheckBoxDirector.setSelected(false);
			}
		}
		mComboBoxSupervisor.updateUI();
		mComboBoxSupervisor.setUI(new ProjectMetalComboBoxUI());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String name = mTextFieldName.getText().trim();
		if (name == null || name.isEmpty()) {
			JOptionPane.showMessageDialog(this,
					ProjectConstants.HINT_ERROR_NAME,
					ProjectConstants.HINT_ERROR_TITLE,
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		if (mCheckBoxDirector.isSelected()
				&& ProjectUtils
						.isHasDirector(mStaffComboBoxModel.getDataList())) {
			JOptionPane.showMessageDialog(this,
					ProjectConstants.HINT_ERROR_DIRECTOR_ONLY,
					ProjectConstants.HINT_ERROR_TITLE,
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		if (!mCheckBoxDirector.isSelected()
				&& mStaffComboBoxModel.getSelectedItem() == null) {
			JOptionPane.showMessageDialog(this,
					ProjectConstants.HINT_ERROR_SUPERVISOR,
					ProjectConstants.HINT_ERROR_TITLE,
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		Staff staff;
		if (mSelf == null) {
			staff = new Staff(name);
		} else {
			staff = mSelf;
			staff.setName(name);
		}
		staff.setStaffType(mCheckBoxDirector.isSelected() ? StaffType.DIRECTOR
				: StaffType.NORMAL);
		staff.setSupervisor(mCheckBoxDirector.isSelected() ? null
				: mStaffComboBoxModel.getSelectedItem());

		if (mListener != null) {
			mListener.onStaffEditFinish(staff);
		}
		setVisible(false);

	}

	public void show(ArrayList<Staff> staffList, Staff self) {
		this.mDataList = staffList;
		this.mSelf = self;
		initData();
		setVisible(true);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		mComboBoxSupervisor.setEnabled(!mCheckBoxDirector.isSelected());
		if (mCheckBoxDirector.isSelected()) {
			mComboBoxSupervisor.setSelectedItem(null);
		}
		mComboBoxSupervisor.setUI(new ProjectMetalComboBoxUI());
	}

}
