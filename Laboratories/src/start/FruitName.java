package start;

public enum FruitName {
	APPLE, BANANA, PLUM, PEACH, UNKNOWN;
	
	public static FruitName convertToFruit(String s)
	{
		switch(s.toUpperCase())
		{
		case "APPLE":
			return APPLE;
		case "BANANA":
			return BANANA;
		case "PLUM":
			return PLUM;
		case "PEACH":
			return PEACH;
		default:
			return UNKNOWN;
		}
	}
	
	public String getStringl()
	{
		return this.name().substring(0, 1) + this.name().substring(1).toLowerCase();
	}
}
