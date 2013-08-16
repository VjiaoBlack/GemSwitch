import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


public class Grid{
	public static int GRID_WIDTH;
	public static int GRID_HEIGHT;
	
	public Gem[][] _grid;
	
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
	
	public void update(){
		for(int x = 0; x < GRID_WIDTH; x++){
			for(int y = 0; y < GRID_HEIGHT; y++){
				_grid[x][y].update();
			}
		}
	}
	
	public void draw(Graphics2D g){
		for(int x = 0; x < GRID_WIDTH; x++){
			for(int y = 0; y < GRID_HEIGHT; y++){
				_grid[x][y].draw(g);
			}
		}
	}
	
	public void setGem(Gem a, int x, int y){
		_grid[x][y] = a;
	}
	public Gem getGem(int x, int y){
		return _grid[x][y];
	}

	public void switchGems(int x1, int y1, int x2, int y2){
		Gem temp = _grid[x1][y1];
		_grid[x1][y1] = _grid[x2][y2];
		_grid[x2][y2] = temp;
	}
	
}




