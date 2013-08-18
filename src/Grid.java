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
	
	private Gem[] _combo1, _combo2;
	
	public Grid(int _width, int _height){
		GRID_WIDTH = _width;
		GRID_HEIGHT = _height;
		_grid = new Gem[GRID_WIDTH][GRID_HEIGHT];
		for(int x = 0; x < GRID_WIDTH; x++){
			for(int y = 0; y < GRID_HEIGHT; y++){
				_grid[x][y] = new Gem(x, y);
			}
		}
		_combo1 = new Gem[5];
		_combo2 = new Gem[5];
		for (int i = 0; i < 5; i++)
			_combo1[i] = _combo2[i] = null;
		
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
	
	public int searchRow(int y){
		int count2 = 1;
		int count = 1;
		int ans = 0;
		boolean isFirst = true;
		String temp = null;
		
		for(int i = 0; i <= GRID_WIDTH; i++){
			if (i < GRID_WIDTH && _grid[i][y].getType().equals(temp)){
				count++;
				if (_grid[i][y].isSliding() || _grid[i][y].isFalling())
					break;
			} 
			
			if (i == GRID_WIDTH || !_grid[i][y].getType().equals(temp)){ // this needs to be changed to include groups of 3's at the ends;
				if (count >= 3){
					if (isFirst)
						count2 = count;
					//make gems fall here
					for (int j = i-count; j < i; j++){
						for (int k = y; k > 0; k--){
							_grid[j][k] = _grid[j][k-1];
							_grid[j][k].fallDown(1);
						}
						_grid[j][0] = new Gem(j,0);
					}
					isFirst = false;
				}
				if (i < GRID_WIDTH)
					temp = _grid[i][y].getType();
				
				count = 1;
			}
			
		}
		if (count >= 3){
			ans += count * 10;
		}
		if (count2 >= 3){
			ans += count2 * 10;
		}
		return ans;
	}
	
	public int searchCol(int x){
		int count2 = 1;
		int count = 1;
		int ans = 0;
		boolean isFirst = true;
		String temp = null;
		
		for(int i = 0; i <= GRID_HEIGHT; i++){
			if (i < GRID_HEIGHT && _grid[x][i].getType().equals(temp)){
				count++;
				if (_grid[x][i].isSliding() || _grid[x][i].isFalling())
					break;
			} 
			if (i == GRID_HEIGHT || !_grid[x][i].getType().equals(temp)){
				if (count >= 3){
					if (isFirst)
						count2 = count;
					//make gems fall here
					for (int j = i-1; j >= 0; j--){
							if (j - count >= 0){
								_grid[x][j] = _grid[x][j-count];
								_grid[x][j].fallDown(count);
							}
							else
								_grid[x][j] = new Gem(x,j);
					}
					isFirst = false;
				}
				if(i < GRID_HEIGHT)
					temp = _grid[x][i].getType();
				count = 1;
			}
			
		}
		if (count >= 3){
			ans += count * 10;
		}
		if (count2 >= 3){
			ans += count2 * 10;
		}
		return ans;
	}
	
	
}




