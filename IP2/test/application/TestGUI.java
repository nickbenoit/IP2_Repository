package application;

import junit.framework.TestCase;

import java.awt.Component;
import java.awt.event.MouseEvent;

public class TestGUI extends TestCase {
	// Create a mouse click event
	public MouseEvent createPressed (Component component, int x, int y) {
		return new MouseEvent(component, MouseEvent.MOUSE_PRESSED, System.currentTimeMillis(), 0, x, y, 0, false);
	}
}
