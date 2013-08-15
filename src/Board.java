import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D; 
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
 

public class Board extends Canvas{
	public static final int LEFT_MARGIN_WIDTH = 256, TOP_MARGIN_HEIGHT = 64, BORDER_WIDTH = 8, 
							 TOP_BORDER_HEIGHT = 32, BOTTOM_BORDER_HEIGHT = 8, 
							RIGHT_MARGIN_WIDTH = 64;
	
	private Grid _grid;
	private BufferedImage _background;
	
	private boolean _running;
	
	public Board(){
		_grid = new Grid(6,10);
		try {
		    _background = ImageIO.read(new File("res/background.png"));
		} catch (IOException e) {
			System.out.println("Problem with loading background");
		}
		
	}
	
	public void run(){
		_running = true;
		while (_running){
			update();
			repaint();
		}
	}
	
	public void shutdown(){
		_running = false;
	}

	public void paint(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(_background, 0, 0, 720, 744, 0, 0, 720, 744, null);
		
		_grid.draw(g2);
	
	}
	
	public void update(){
		
	}
	
}




