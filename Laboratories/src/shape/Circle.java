package shape;

public class Circle extends Shape{
	protected int radius;
	public Circle(int x, int y, int r){
		super(x, y);
		if(r > 0) {
			this.radius=r;
		}
	else
		throw new IllegalArgumentException("Radius must be bigger than 0");
	}

	@Override
	public void moveNorthSouth(int len) {
		if(len>0)
			this.y_coordinate+=len;	
	}

	@Override
	public void moveEastWest(int len) {
	}

	@Override
	public double getArea() {
		return Math.PI*Math.pow(radius, 2);
	}

	@Override
	public double getCircumference() {
		return 2*radius*Math.PI;
	}
	
}
