
import javax.swing.JFrame;
 
public class Game {
	private static JFrame f;
	private static Board _board;

	public static void main(String args[]) {
		_board = new Board();
		Gem.setup();
		f = new JFrame();
		f.setTitle("GemSwap");
		f.setSize(720, 808);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
		f.add(_board);
		f.setVisible(true);
		_board.run();
	}
}
