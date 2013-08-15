import java.awt.Canvas;
import java.awt.Image;

import javax.swing.JFrame;

public class Game {
	private JFrame _frame;
	private static Board _board;

	public static void main(String args[]) {
		_board = new Board();
		Gem.setup();
		
		
		JFrame f = new JFrame();
		f.setTitle("GemSwap");
		f.setSize(720, 744);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(_board);
		f.setVisible(true);
		
		_board.run();
	}
}
