import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Cursor {
	
	private static BufferedImage CURSOR = null;
	private static int SIZE = 64;
	
	private int _xGridCor, _yGridCor;
	private double _xOffset, _yOffset, _yVel, _xVel; //this is later for keyboard control
	
	public Cursor(){
		try {
		    CURSOR = ImageIO.read(new File("res/cursor.png"));
		} catch (IOException e) {
			System.out.println("Cursor image import broken");
		}
		_xGridCor = 2;
		_yGridCor = 4;
		_xOffset = _yOffset = _yVel = _xVel = 0;
	}
	
	public void setXGridCor(int x){
		_xGridCor = x;
	}
	public void setYGridCor(int y){
		_yGridCor = y;
	}
	
	public void draw(Graphics2D g){
		g.drawImage(CURSOR,
				   Board.BORDER_WIDTH + Board.LEFT_MARGIN_WIDTH + _xGridCor * SIZE, 
				   Board.TOP_BORDER_HEIGHT + Board.TOP_MARGIN_HEIGHT + _yGridCor * SIZE,
				   Board.BORDER_WIDTH + Board.LEFT_MARGIN_WIDTH + (_xGridCor + 1) * SIZE, 
				   Board.TOP_BORDER_HEIGHT + Board.TOP_MARGIN_HEIGHT + (_yGridCor + 1) * SIZE,
			       0, 0, SIZE, SIZE,
			       null);
	}
}
