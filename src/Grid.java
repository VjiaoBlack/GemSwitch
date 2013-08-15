import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


public class Grid implements KeyListener, MouseListener, MouseMotionListener{
	public static int GRID_WIDTH;
	public static int GRID_HEIGHT;
	
	public Gem[][] _grid;
	
	private int _cursorX, _cursorY;
	
	public Grid(int _width, int _height){
		GRID_WIDTH = _width;
		GRID_HEIGHT = _height;
		_grid = new Gem[GRID_WIDTH][GRID_HEIGHT];
		for(int x = 0; x < GRID_WIDTH; x++){
			for(int y = 0; y < GRID_HEIGHT; y++){
				_grid[x][y] = new Gem(x, y, Gem.getType((int) (Math.random() * 5)));
			}
		}
		
	}
	
	public void update(int x1, int y1, int x2, int y2){
		//remember: only update when a swap is made.
		//check the 2 gems that were updated
	}
	
	public void draw(Graphics2D g){
		for(int x = 0; x < GRID_WIDTH; x++){
			for(int y = 0; y < GRID_HEIGHT; y++){
				_grid[x][y].draw(g);
			}
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		
		System.out.println(x);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}




