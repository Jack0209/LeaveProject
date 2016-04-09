package pers.jack.leave.core;

import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

import pers.jack.leave.common.ProjectConstants;


public abstract class BaseDialog extends JDialog {
	private int mWidth;
	private int mHeight;

	protected JFrame mParent;
	protected JPanel mPanelBk;

	public BaseDialog(JFrame jFrame) {
		super(jFrame);
		mParent = jFrame;
		init();
	}

	public JFrame getParent() {
		return mParent;
	}

	private void init() {
		mWidth = getDialogWdith();
		mHeight = getDialogHeight();

		this.setResizable(false);
		this.setTitle(ProjectConstants.TEXT_TITLE);
		this.setSize(mWidth, mHeight);
		Point point = mParent.getLocationOnScreen();
		Dimension dimension = mParent.getSize();
		this.setLocation(point.x + dimension.width / 2 - mWidth / 2, point.y
				+ dimension.height / 2 - mHeight / 2);

		this.getContentPane().setLayout(null);
		mPanelBk = new JPanel();
		mPanelBk.setLayout(null);
		mPanelBk.setBounds(0, 0, mWidth, mHeight);
		mPanelBk.setOpaque(true);
		mPanelBk.setBackground(ProjectConstants.COLOR_BK);
		this.add(mPanelBk);
		initUtils();
		initViews(mPanelBk);
		initListeners();
		initData();
	}

	protected abstract int getDialogWdith();

	protected abstract int getDialogHeight();

	protected abstract void initUtils();

	protected abstract void initViews(JPanel panelBk);

	protected abstract void initListeners();

	protected abstract void initData();

}
