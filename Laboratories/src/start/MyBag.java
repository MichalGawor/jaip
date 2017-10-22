package start;
import java.util.Arrays;

public class MyBag {
	protected Item[] items_arr;
	
	public MyBag()
	{
		this(10);
	}
	
	public MyBag(int length)
	{
		if(0<length && 15>length) 
			items_arr = new Item[length];
		else 
			items_arr = new Item[10];
	}
	
	public boolean putItem(Item item)
	{
		for(int i=0; i<items_arr.length; i++)
		{
			if(items_arr[i] == null)
			{
				items_arr[i] = item;
				return true;
			}
		}
		return false;
	}
	
	public void removeALl()
	{
		Arrays.fill(items_arr, null);
	}
	
	public String toString()
	{
		String ret_str = "";
		double total_weight = 0.0;
		int nb_inside = 0;
		
		for(int i=0; i<items_arr.length; i++)
		{
			if(items_arr[i] != null)
			{
				ret_str += items_arr[i].toStringl() + '\n';
				total_weight += items_arr[i].getWeight();
				nb_inside++;
			}
		}
		return "Total items inside the bag: " + nb_inside + '/' + items_arr.length + "\nTotal weight of the bag: " +
				total_weight + "\n" + ret_str;
	}
}
