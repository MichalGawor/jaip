package start;

public class MyBagPlus extends MyBag{
	protected double maxWeight;
	public MyBagPlus(int size, double weight)
	{
		super(size);
		this.maxWeight = weight;
	}
	
	@Override
	public boolean putItem(Item item)
	{
		double currWeight=0.0;
		for(int i=0; i<super.items_arr.length; i++)
		{
			if(super.items_arr[i] == null)
			{
				if(currWeight + item.getWeight() <= this.maxWeight)
				{
					super.items_arr[i] = item;
					return true;
				}
				else
					return false;
			}
			currWeight+=super.items_arr[i].getWeight();
		}
		return false;
	}
}
