package start;
import java.util.Arrays;

public class MyBag {
	private Item[] items_arr;
	
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
	
	public static void testMe()
	{
		//initialize default bag and 3 items for test purpose
		MyBag test_default = new MyBag();
		Item item_a = new Item();
		Item item_b = new Item("knife", 2.4);
		Item item_c = new Item("fork", 2.0);
		
		//put items into default bag
		
		test_default.putItem(item_a);
		System.out.println("Put item " + item_a.toStringl());
		test_default.putItem(item_b);
		System.out.println("Put item " + item_b.toStringl());
		test_default.putItem(item_c);
		System.out.println("Put item " + item_c.toStringl());
		
		//items in bag
		System.out.println("\n" + test_default.toString());
		
		//empty default bag
		test_default.removeALl();
		System.out.println("Items in bag after emptying \n" + test_default.toString());
		
		//create custom bag and put items into it
		MyBag test_custom = new MyBag(2);
		
		//put items into custom bag
		test_custom.putItem(item_a);
		System.out.println("Put item " + item_a.toStringl());
		test_custom.putItem(item_b);
		System.out.println("Put item " + item_b.toStringl());
		test_custom.putItem(item_c);
		System.out.println("Put item " + item_c.toStringl());
		
		//items inside the custom bag
		System.out.println("\n" + test_custom.toString());
		
		//empty custom bag
		test_custom.removeALl();
		System.out.println("Items in bag after emptying " + test_custom.toString());
	}	
	
	public static void main(String[] args)
	{
		testMe();
	}
}
