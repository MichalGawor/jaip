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
		if(s.split(";|_|\t").length == 3)
		{
			if(20<Double.parseDouble(s.split(";|_|\t")[0]) && Double.parseDouble(s.split(";|_|\t")[0])<80)
			{
				this.tankCapacity = Double.parseDouble(s.split(";|_|\t")[0]);
			}
			if(3<Double.parseDouble(s.split(";|_|\t")[1]) && Double.parseDouble(s.split(";|_|\t")[1])<20)
				this.fuelConsumption = Double.parseDouble(s.split(";|_|\t")[1]); 
			this.maker = CarMakers.convertString(s.split(";|_|\t")[2]);		
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
		if(this.fuelLevel > tripDistance*this.fuelConsumption/100)
		{
			this.mileage+=tripDistance;
			this.fuelLevel-=tripDistance*this.fuelConsumption/100;
			this.lastTrip=tripDistance;
			return true;
		}
		else
			return false; 
	}
	
	public String toString()
	{
		String s = "\tCar manufacturer: ";
		return s + this.maker + "\n\tTank capacity: " + this.fuelLevel +
				"/" + this.tankCapacity + "\n\tFuel consumption: " +
				this.fuelConsumption + "\n\tMileage: " + this.mileage + 
				"\n\tLast trip distance: " + this.lastTrip;
	}
	
	public static void testMe()
	{
		MyCar defaultCar = new MyCar();
		System.out.println("Create default car. " + 
				"\nExpected value of operation:\n" +
				"\tCar manufacturer: NOTKNOWN\n" +
				"\tTank capacity: 0.0/40.0\n" +
				"\tFuel consumption: 5.0\n" +
				"\tMileage: 0.0\n" +
				"\tLast trip distance: 0.0\n" +
				"Actual value: \n" +
				defaultCar.toString());
		
		defaultCar.tankIt(20);
		System.out.println("\n\nTank a car with 20l.\n " + 
				"Expected value of operation:\n " +
				"\tTank capacity: 20.0/40.0\n " +
				"\nActual value: \n" +
				"\tTank capacity: " + defaultCar.fuelLevel + "/" + defaultCar.tankCapacity+ "\n");
		
		defaultCar.tankIt(30);
		System.out.println("\n\nTank a car with aditional 30l. " + 
				"\nExpected value of operation:\n" +
				"\tTank capacity: 20.0/40.0\n" +
				"Actual value: \n" +
				"\tTank capacity: " + defaultCar.fuelLevel + "/" + defaultCar.tankCapacity+ "\n");
		
		defaultCar.startTrip(100);
		System.out.println("\n\nGo for a short trip 100km. " + 
				"\nExpected value of operation:\n" +
				"\tTank capacity: 15.0/40.0\n" +
				"\tMileage: 100.0\n" +
				"\tLast trip distance: 100.0\n" +
				"Actual value: \n" +
				"\tTank capacity: " + defaultCar.fuelLevel + "/" + defaultCar.tankCapacity+ "\n" +
				"\tMileage: " + defaultCar.mileage + "\n" +
				"\tLast trip distance: " + defaultCar.lastTrip + "\n");
		
		defaultCar.startTrip(500);
		System.out.println("\n\nTry to go too far (500km). " + 
				"\nExpected value of operation:\n" +
				"\tTank capacity: 15.0/40.0\n" +
				"\tMileage: 100.0\n" +
				"\tLast trip distance: 100.0\n" +
				"Actual value: \n" +
				"\tTank capacity: " + defaultCar.fuelLevel + "/" + defaultCar.tankCapacity+ "\n" +
				"\tMileage: " + defaultCar.mileage + "\n" +
				"\tLast trip distance: " + defaultCar.lastTrip + "\n");
		
		//test custom car
		MyCar customCar = new MyCar("60;10_BMW");
		System.out.println("Create customt car. " + 
				"\nExpected value of operation:\n" +
				"\tCar manufacturer: BMW\n" +
				"\tTank capacity: 0.0/60.0\n" +
				"\tFuel consumption: 10.0\n" +
				"\tMileage: 0.0\n" +
				"\tLast trip distance: 0.0\n" +
				"Actual value: \n" +
				customCar.toString());
		
		customCar.tankIt(20);
		System.out.println("\n\nTank a car with 20l.\n " + 
				"Expected value of operation:\n " +
				"\tTank capacity: 20.0/60.0\n " +
				"\nActual value: \n" +
				"\tTank capacity: " + customCar.fuelLevel + "/" + customCar.tankCapacity+ "\n");
		
		customCar.tankIt(50);
		System.out.println("\n\nTank a car with aditional 50l. " + 
				"\nExpected value of operation:\n" +
				"\tTank capacity: 20.0/60.0\n" +
				"Actual value: \n" +
				"\tTank capacity: " + customCar.fuelLevel + "/" + customCar.tankCapacity+ "\n");
		
		customCar.startTrip(100);
		System.out.println("\n\nGo for a short trip 100km. " + 
				"\nExpected value of operation:\n" +
				"\tTank capacity: 10.0/60.0\n" +
				"\tMileage: 100.0\n" +
				"\tLast trip distance: 100.0\n" +
				"Actual value: \n" +
				"\tTank capacity: " + customCar.fuelLevel + "/" + customCar.tankCapacity+ "\n" +
				"\tMileage: " + customCar.mileage + "\n" +
				"\tLast trip distance: " + customCar.lastTrip + "\n");
		
		customCar.startTrip(500);
		System.out.println("\n\nTry to go too far (500km). " + 
				"\nExpected value of operation:\n" +
				"\tTank capacity: 10.0/60.0\n" +
				"\tMileage: 100.0\n" +
				"\tLast trip distance: 100.0\n" +
				"Actual value: \n" +
				"\tTank capacity: " + customCar.fuelLevel + "/" + customCar.tankCapacity+ "\n" +
				"\tMileage: " + customCar.mileage + "\n" +
				"\tLast trip distance: " + customCar.lastTrip + "\n");
	}
	public static void main(String[] args) 
	{
		testMe();
	}
}

