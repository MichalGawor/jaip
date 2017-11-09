package shape;

public class Circle extends Shape{
	protected int radius;
	public Circle(int x, int y, int r){
		super(x, y);
		this.radius=r;
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
		return Math.PI*Math.pow(radius, 2);
	}

	@Override
	public double getCircumference() {
		return 2*radius*Math.PI;
	}
	
}
