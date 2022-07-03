package piano.test;

import java.awt.Toolkit;

public class TestScreen {
	
	private static final double WIDTH = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	private static final double HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(WIDTH);
		System.out.println(HEIGHT);
	}

}
