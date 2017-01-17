/**
 * this class is for all moving objects 
 * 
 *
 */
public class MovingObjects {

	private double x ;
	
	private double y  ; 
	
	private double xSpeed ; 
	
	private double ySpeed; 
	
	
	public void setX(int x){
		this.x =x;
	}
	public void setY(int y){
		this.y=y;
	}
	public void setXSpeed(int xSpeed){
		this.xSpeed = xSpeed;
	}
	public void setYSpeed(int ySpeed){
		this.ySpeed = ySpeed;
	}
	public double getYSpeed(){
		return ySpeed; 
	}
	public double  getXSpeed(){
		
		return xSpeed;
	}
	
	public double getX(){
		return x;
	}
	
	public double getY(){
		return y;
	}

	
	
	
}
