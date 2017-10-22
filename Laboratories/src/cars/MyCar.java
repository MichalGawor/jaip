package cars;

public class MyCar {
	protected double tankCapacity;
	protected double fuelConsumption;
	protected CarMakers maker;
	protected double mileage;
	protected double fuelLevel;
	protected double lastTrip;

	public MyCar()
	{
		this.tankCapacity = 40;
		this.fuelConsumption = 5;
		this.maker = CarMakers.NOTKNOWN;
		this.mileage = 0.0;
		this.fuelLevel = 0.0;
		this.lastTrip = 0.0;
	}
	
	public MyCar(String s)
	{
		this();
		if(s.split(";_\t").length == 4)
		{
			if(20<Double.parseDouble(s.split(" ")[0]) && Double.parseDouble(s.split(" ")[0])<80)
			{
				this.tankCapacity = Double.parseDouble(s.split(" ")[0]);
			}
			if(3<Double.parseDouble(s.split(" ")[1]) && Double.parseDouble(s.split(" ")[1])<20)
				this.fuelConsumption = Double.parseDouble(s.split(" ")[1]); 
			this.maker = CarMakers.convertString(s.split(" ")[2]);		
		}
	}
	
	public boolean tankIt(double howMuch)
	{
		if(this.tankCapacity < this.fuelLevel + howMuch)
			return false;
		else
		{
			this.fuelLevel+=howMuch;
			return true;
		}
	}
	
	public boolean startTrip(double tripDistance)
	{
		if(this.fuelLevel/this.fuelConsumption > tripDistance)
		{
			this.mileage+=tripDistance;
			this.fuelLevel-=this.fuelConsumption*tripDistance;
			this.lastTrip=tripDistance;
			return true;
		}
		else
			return false; 
	}
	
	public double getMileage()
	{
		return this.mileage;
	}
	
	public double getLastTripDistance()
	{
		return this.lastTrip;
	}
	
	public double getFuelLevel()
	{
		return this.fuelLevel;
	}
	
	public String toString()
	{
		String s = "Car manufacturer: ";
		return s + this.maker + "Tank capacity: " + this.tankCapacity +
				"Fuel level: " + this.tankCapacity + "Fuel consumption: " +
				this.fuelConsumption + "Mileage: " + this.mileage + 
				"Last trip distance: " + this.lastTrip;
	}
}
