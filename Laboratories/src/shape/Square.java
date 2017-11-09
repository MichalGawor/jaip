package shape;

public class Square extends Shape{
	protected int side;
	public Square(int x, int y, int sideSize){
		super(x, y);
		this.side=sideSize;
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
		return Math.pow(this.side, 2);
	}
	@Override
	public double getCircumference() {
		return 4*this.side;
	}
	
}
