package pers.jack.leave.ui;

import java.awt.Color;
import java.util.Locale;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import pers.jack.leave.common.ProjectConstants;


public class LeaveApp {
	
	public static void main(String[] args) {
		String lookAndFeel = UIManager.getCrossPlatformLookAndFeelClassName();
		try {
			UIManager.setLookAndFeel(lookAndFeel);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		UIManager.put("Button.select", ProjectConstants.COLOR_BTN_SELECT);
		UIManager.put("Button.background", ProjectConstants.COLOR_BTN_NORMAL);
		UIManager.put("Button.foreground", Color.WHITE);
		UIManager.put("ComboBox.buttonBackground", ProjectConstants.COLOR_BTN_NORMAL);
		UIManager.put("ComboBox.background", Color.WHITE);

		UIManager.put("OptionPane.messageFont", ProjectConstants.FONT_DIALOG_TITLE);
		UIManager.put("OptionPane.messageForeground", ProjectConstants.COLOR_666);
		UIManager.put("OptionPane.buttonFont",ProjectConstants.FONT_DIALOG_NORMAL);
		
		JOptionPane.setDefaultLocale(Locale.ENGLISH);
		
		MainFrame mainFrame = new MainFrame();
		mainFrame.setVisible(true);
	}

}
