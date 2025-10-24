package jframetest;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import textproc.GeneralWordCounter;

public class TestFrame {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> createWindow("BookReader", 100, 300));
	}
	
	private void createWindow(GeneralWordCounter counter, String title, 
							int width, int height) {
			JFrame frame = new JFrame(title);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Container pane = frame.getContentPane();
	}
}
