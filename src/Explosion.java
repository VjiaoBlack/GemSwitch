import java.awt.Graphics2D;


public class Explosion {
	private int _xcor;
	private int _ycor;
	private int _stage;
	
	private int _counter;
	
	public Explosion(int x, int y){
		_xcor = x;
		_ycor = y;
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
				_stage = _counter % 10;
		}
		if (_counter >= 40){
			_counter = -1;
			_stage = -1;
		}
	}
	
	public void draw(Graphics2D g){
		if (_counter != -1){
			
		}
	}
	
	
}
