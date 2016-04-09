package pers.jack.leave.ui.listener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

public class NameInputKeyListener implements KeyListener {
	private JTextField mTextField;
	private int mMax;

	public NameInputKeyListener(JTextField textField, int max) {
		this.mTextField = textField;
		this.mMax = max;

	}

	@Override
	public void keyTyped(KeyEvent e) {
		if (mTextField != null && mTextField.getText().length() > mMax) {
			e.setKeyChar('\0');
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

}
