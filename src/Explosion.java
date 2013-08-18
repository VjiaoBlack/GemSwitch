import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Explosion {
	private int _xGridCor;
	private int _yGridCor;
	private int _stage;
	private int _counter;
	private static BufferedImage explosion = null;
	private static int SIZE = 64;
	
	public Explosion(int x, int y){
		try {
			explosion = ImageIO.read(new File("res/pop.png"));
		} catch (IOException e){
			e.printStackTrace();
		}
		
		_xGridCor = x;
		_yGridCor = y;
		_stage = -1;
		_counter = -1;
	}
	
	public void explode(){
		_stage = 0;
		_counter = 0;
	}
	
	public void update(){
		if (_counter != -1){
			_counter++;
			if (_stage != -1)
				_stage = _counter / 2;
		}
		if (_counter >= 8){
			_counter = -1;
			_stage = -1;
		}
	}
	
	public void draw(Graphics2D g){
		if (_counter != -1){
			g.drawImage(explosion,
					   Board.BORDER_WIDTH + Board.LEFT_MARGIN_WIDTH      + _xGridCor * SIZE, 
					   Board.TOP_BORDER_HEIGHT + Board.TOP_MARGIN_HEIGHT + _yGridCor * SIZE,
					   Board.BORDER_WIDTH + Board.LEFT_MARGIN_WIDTH      + (_xGridCor + 1) * SIZE, 
					   Board.TOP_BORDER_HEIGHT + Board.TOP_MARGIN_HEIGHT + (_yGridCor + 1) * SIZE,
				       16*(_stage), 0, 16 * (_stage + 1), 16,
				       null);
		}
	}
	
	
}
