package pers.jack.leave.core;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import pers.jack.leave.common.ProjectConstants;

public abstract class BaseFrame extends JFrame {
	private int mLocationWidth;
	private int mLocationHeight;

	protected JPanel mPanelBk;

	public BaseFrame() {
		super();
		this.setResizable(false);
		this.setTitle(ProjectConstants.TEXT_TITLE);
		this.setSize(ProjectConstants.WINDOW_WIDTH,
				ProjectConstants.WINDOW_HEIGHT);
		Toolkit toolkit = getToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		mLocationWidth = (new Double(screenSize.getWidth())).intValue();
		mLocationHeight = (new Double(screenSize.getHeight())).intValue();
		this.setLocation((mLocationWidth - ProjectConstants.WINDOW_WIDTH) / 2,
				(mLocationHeight - ProjectConstants.WINDOW_HEIGHT) / 2);

		this.getContentPane().setLayout(null);
		setIconImage(toolkit.createImage(getClass().getResource(
				ProjectConstants.URL_ICON)));
		mPanelBk = new JPanel();
		mPanelBk.setLayout(null);
		mPanelBk.setBounds(0, 0, ProjectConstants.WINDOW_WIDTH,
				ProjectConstants.WINDOW_HEIGHT);
		mPanelBk.setOpaque(true);
		mPanelBk.setBackground(ProjectConstants.COLOR_BK);
		this.add(mPanelBk);

		initUtils();
		initViews(mPanelBk);
		initListeners();
		initData();
	}

	protected abstract void initUtils();

	protected abstract void initViews(JPanel panelBk);

	protected abstract void initListeners();

	protected abstract void initData();

}
