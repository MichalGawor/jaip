package shape;

public class Rectangle extends Shape{
	protected int xSide;
	protected int ySide;
	public Rectangle(int x, int y, int xSideSize, int ySideSize){
		super(x, y);
		if(xSideSize>0 && ySideSize>0) {
			this.xSide=xSideSize;
			this.ySide=ySideSize;
		}
		else
			throw new IllegalArgumentException("None of the sides can equal zero");
	}
	
	@Override
	public void moveNorthSouth(int len) {
	}
	
	@Override
	public void moveEastWest(int len) {
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
