package shape;

public abstract class Shape implements Moveable{
	protected int x_coordinate;
	protected int y_coordinate;
	public abstract double getArea();
	public abstract double getCircumference();
	
	public Shape(int x, int y){
		this.x_coordinate = x;
		this.y_coordinate = y;
	}
	
	public int getX() {
		return this.x_coordinate;
	}
	
	public int getY() {
		return this.y_coordinate;
	}
	
	public String toString(){
		return "[" + this.x_coordinate + "," + this.y_coordinate + "]";
	}
}
