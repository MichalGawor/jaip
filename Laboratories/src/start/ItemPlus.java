package start;

public class ItemPlus extends Item
{
	private FruitName fName;
	public ItemPlus(String s)
	{		
		super(s.split(" ")[1], Double.parseDouble(s.split(" ")[2]));
		this.fName.convertToFruit(s.split( " ")[1]);

	}
	public ItemPlus(String name, String fruit, double weight)
	{
		super(name, weight);
		this.fName.convertToFruit(fruit);
	}
	public ItemPlus(String name, FruitName fname, double weight)
	{
		super(name, weight);
		this.fName = fname;
	}
	public String toStringl()
	{
		return super.toStringl() + this.fName.getStringl();
	}
}
