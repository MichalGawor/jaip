package shape;

public class Rectangle extends Shape{
	protected int xSide;
	protected int ySide;
	public Rectangle(int x, int y, int xSideSize, int ySideSize){
		super(x, y);
		this.xSide=xSideSize;
		this.ySide=ySideSize;
	}
	@Override
	public void moveNothSouth(int len) {
		this.y_coordinate+=len;
	}
	@Override
	public void moveEastWest(int len) {
		this.x_coordinate+=len;
	}
	@Override
	public double getArea() {
		return xSide*ySide;
	}
	@Override
	public double getCircumference() {
		return (2*this.xSide)+(2*this.ySide); 
	}
	
}
