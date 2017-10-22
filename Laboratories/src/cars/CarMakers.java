package cars;

public enum CarMakers {
	FIAT, FORD, VOLVO, BMW, CHRYSLER, GM, NOTKNOWN;
	
	public static CarMakers convertString(String s)
	{
		switch(s.toUpperCase())
		{
		case "FIAT":
			return FIAT;
		case "FORD":
			return FORD;
		case "VOLVO":
			return VOLVO;
		case "BMW":
			return BMW;
		case "CHRYSLER":
			return CHRYSLER;
		case "GM":
			return GM;
		default:
			return NOTKNOWN;
		}
	}
	
	public String showMaker()
	{
		if(this.name() == "GM" || this.name() == "BMW")
			return this.name();
		else
			return this.name().substring(0, 1) + this.name().substring(1).toLowerCase();
	}
}
