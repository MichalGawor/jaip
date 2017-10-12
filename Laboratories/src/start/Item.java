package start;

public class Item 
{
	private String name;
	private double weight;
	public Item()
	{
		this("noname", 1.0);	
	}
	public Item(String new_name, double new_weight)
	{
		if(new_weight<=10.0 && new_weight>0.0)
		{
			this.name = new_name;
			this.weight = new_weight;
		}
		else
		{
			this.name = "noname";
			this.weight = 1.0;
		}	
	}
	public String toStringl()
	{
		return this.name + ' ' + this.weight;
	}
	
	public double getWeight()
	{
		return this.weight;
	}
}
