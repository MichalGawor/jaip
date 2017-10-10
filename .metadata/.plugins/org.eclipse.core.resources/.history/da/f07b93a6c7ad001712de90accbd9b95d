package start;
import java.util.Arrays;

public class MyBag {
	private Item[] items_arr;
	
	public MyBag()
	{
		items_arr = new Item[10];
	}
	
	public MyBag(int length)
	{
		if(0<length && 15<length) 
			items_arr = new Item[length];
		else 
			items_arr = new Item[10];
	}
	
	boolean putItem(Item item)
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
	
	void removeALl()
	{
		Arrays.fill(items_arr, null);
	}
	
	String toStringl()
	{
		String ret_str ="";
		for(int i=0; i<items_arr.length; i++)
		{
			if(items_arr[i] != null)
			{
				ret_str += items_arr[i].toStringl() + ' ';
			}
		}
		return ret_str;
	}
}
