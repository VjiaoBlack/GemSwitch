import java.awt.Graphics2D;
import java.awt.Image;
import java.util.HashMap;


public class Gem {
	
	private static int[][] SLIDE = {
		{-1,  0, 1, 0, 0, 0, 0, 0, 0},
		{ 0, -1, 0, 0, 0, 0, 0, 0, 1}
	};
	private static final int SIZE = 48;
	
	private static final HashMap<String,Image> IMAGES = new HashMap<String,Image>();
	
	
	private String _type;
	private int _xGridCor, _yGridCor;
	private double _xCor, _yCor, _yVel;
	private boolean _isFalling, _onGrid;
	private int _sliding;
	
	public void setup(){
		Image placeholder = null;
		IMAGES.put("ruby", placeholder);
		IMAGES.put("sapphire", placeholder);
		IMAGES.put("emerald", placeholder);
		IMAGES.put("topaz", placeholder);
		IMAGES.put("diamond", placeholder);
	}
	
	public Gem(int x, String type){
		_type = type;
		_xGridCor = x;
		_yGridCor = 0 /* help */;
		_yVel = 4;
		_isFalling = true;
		_onGrid = false;
		_sliding = -1;
	}
	
	public int getXGridCor(){
		return _xGridCor;
	}
	
	public int getYGridCor(){
		return _yGridCor;
	}
	
	public void draw(Graphics2D g){
		g.drawImage(IMAGES.get(_type),
				   /*xgridoffset +*/ _xGridCor * SIZE, /*ygridoffset +*/ _yGridCor * SIZE,
				   /*xgridoffset +*/ (_xGridCor + 1) * SIZE, /*ygridoffset +*/ (_yGridCor + 1) * SIZE,
			       0, 0, 48, 48,									//check this, is the max x/y 48??
			       null);
			// get the texture from the static hashmap of textures, then draw it with xcor and ycor
	}
	
	public void update(){
		if (_isFalling) {
			_yCor += _yVel;
			
			
		}
		
		if (_isFalling && _yCor <= _yGridCor * SIZE + _yVel /* + gridoffset */){
			_isFalling = false;
			_yCor = _yGridCor * SIZE /* + gridoffset */;
		}
		
		if (_sliding != -1) {
			
			
			
		} else {
			
		}
	}
	
	public void swap(Gem target){
		int dX = target.getXGridCor() - _xGridCor;
		int dY = target.getYGridCor() - _yGridCor;
		
		dX += 1;  // 0, 2
		dY += 2;  // 1, 3
		dX = (int) Math.pow(2,dX); // 1, 4
		dY = (int) Math.pow(2,dY); // 2, 8

		_sliding = dX + dY; // up: 1  down: 8  left: 0  right: 2
						   // note that there is no other combination of dX and dY to get 0, 1, 2, or 8
		
	}
}
