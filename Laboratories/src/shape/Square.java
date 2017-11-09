package shape;

public class Square extends Shape{
	protected int side;
	public Square(int x, int y, int sideSize){
		super(x, y);
		if(sideSize>0) {
			this.side=sideSize;
		}
		else
			throw new IllegalArgumentException("Side length mus be bigger than 0");
	}
	
	@Override
	public void moveNorthSouth(int len) {
	}
	
	@Override
	public void moveEastWest(int len) {
		if(len > 0)
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
