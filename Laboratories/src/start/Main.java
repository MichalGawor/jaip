package start;

public class Main {
	public static void testMe()
	{
		//create items for test purposes
		ItemPlus item_a = new ItemPlus("Royal apple 0.2");
		ItemPlus item_b = new ItemPlus("Spanish", "peach", 1.2);
		ItemPlus item_c = new ItemPlus("Chiquita", FruitName.BANANA, 0.4);
		
		System.out.println(item_a.toStringl());
		System.out.println(item_b.toStringl());
		System.out.println(item_c.toStringl());
		
		//test small bag
		SmallBag small_a = new SmallBag(); // max size 4, max weight 2.0	
		System.out.println("Small bag has (size, max weight): (" + small_a.items_arr.length + "," + small_a.maxWeight + ")");
		
		small_a.putItem(item_a);
		small_a.putItem(item_b);
		small_a.putItem(item_c);	
		System.out.println(small_a.toString());
		
		small_a.removeALl();	
		System.out.println("Items in bag after emptying " + small_a.toString());
		
		//test medium bag	
		MediumBag med_a = new MediumBag(); // max size 7, max weight 5.0
		System.out.println("Medium bag has (size, max weight): (" + med_a.items_arr.length + "," + med_a.maxWeight + ")");
		
		med_a.putItem(item_a);
		med_a.putItem(item_b);
		med_a.putItem(item_c);	
		System.out.println(med_a.toString());
		
		med_a.removeALl();
		System.out.println("Items in bag after emptying " + med_a.toString());

		//test big bag 
		BigBag big_a = new BigBag(); // max size 15, max weight 15.0
		System.out.println("Big bag has (size, max weight): (" + big_a.items_arr.length + "," + big_a.maxWeight + ")");
	
		big_a.putItem(item_a);
		big_a.putItem(item_b);
		big_a.putItem(item_c);
		System.out.println(big_a.toString());
		
		big_a.removeALl();
		System.out.println("Items in bag after emptying " + big_a.toString());
	}
	public static void main(String[] args) {
		testMe();
	}
}
