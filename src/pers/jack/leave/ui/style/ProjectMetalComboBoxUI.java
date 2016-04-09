package pers.jack.leave.ui.style;

import javax.swing.plaf.metal.MetalComboBoxUI;

import pers.jack.leave.common.ProjectConstants;


public class ProjectMetalComboBoxUI extends MetalComboBoxUI {
	@Override
	public void configureArrowButton() {
		super.configureArrowButton();
		if (arrowButton != null) {
			arrowButton.setBackground(ProjectConstants.COLOR_BTN_NORMAL);
		}
	}
}
