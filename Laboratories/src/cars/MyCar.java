package cars;
import java.lang.NumberFormatException;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
				try{
					this.tankCapacity = Double.parseDouble(s.split(";|_|\t")[0]);
				} catch(NumberFormatException ex){
					this.tankCapacity = 40;
				}
			}
			if(3<Double.parseDouble(s.split(";|_|\t")[1]) && Double.parseDouble(s.split(";|_|\t")[1])<20)
			{
				try{
					this.fuelConsumption = Double.parseDouble(s.split(";|_|\t")[1]); 
				} catch(NumberFormatException ex){
					this.fuelConsumption = 5;
				}
			}
			try{
				this.maker = CarMakers.convertString(s.split(";|_|\t")[2]);		
			} catch(NumberFormatException ex){
				this.maker = CarMakers.NOTKNOWN;
			}
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
				"\n\tLast trip distance: " + this.lastTrip + "\n";
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
		MyCar customCar = new MyCar("dd;10_BMW");
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
	
	@Test
	public static void testDefaultMyCar()
	{
		MyCar defaultCar = new MyCar();
		assertEquals(defaultCar.toString(), 
				"\tCar manufacturer: NOTKNOWN\n" +
				"\tTank capacity: 0.0/40.0\n" +
				"\tFuel consumption: 5.0\n" +
				"\tMileage: 0.0\n" +
				"\tLast trip distance: 0.0\n");
		//tank too much
		assertEquals(defaultCar.tankIt(50), false);
		//tank 30l
		assertEquals(defaultCar.tankIt(30), true);
		assertEquals(defaultCar.toString(), 
				"\tCar manufacturer: NOTKNOWN\n" +
				"\tTank capacity: 30.0/40.0\n" +
				"\tFuel consumption: 5.0\n" +
				"\tMileage: 0.0\n" +
				"\tLast trip distance: 0.0\n");
		//try too long trip
		assertEquals(defaultCar.startTrip(800), false);
		//go for trip
		assertEquals(defaultCar.startTrip(100), true);
		assertEquals(defaultCar.toString(), 
				"\tCar manufacturer: NOTKNOWN\n" +
				"\tTank capacity: 25.0/40.0\n" +
				"\tFuel consumption: 5.0\n" +
				"\tMileage: 100.0\n" +
				"\tLast trip distance: 100.0\n");
		//go for second trip
		assertEquals(defaultCar.startTrip(200), true);
		assertEquals(defaultCar.toString(), 
				"\tCar manufacturer: NOTKNOWN\n" +
				"\tTank capacity: 15.0/40.0\n" +
				"\tFuel consumption: 5.0\n" +
				"\tMileage: 300.0\n" +
				"\tLast trip distance: 200.0\n");
	}
	
	@Test
	public static void testCustomMyCar()
	{
		//test constructors
		MyCar customCar = new MyCar("asdf");
		assertEquals(customCar.toString(), 
				"\tCar manufacturer: NOTKNOWN\n" +
				"\tTank capacity: 0.0/40.0\n" +
				"\tFuel consumption: 5.0\n" +
				"\tMileage: 0.0\n" +
				"\tLast trip distance: 0.0\n");
		customCar = new MyCar("10;20");
		assertEquals(customCar.toString(), 
				"\tCar manufacturer: NOTKNOWN\n" +
				"\tTank capacity: 0.0/40.0\n" +
				"\tFuel consumption: 5.0\n" +
				"\tMileage: 0.0\n" +
				"\tLast trip distance: 0.0\n");
		customCar = new MyCar("20_20\tBMW;ad");
		assertEquals(customCar.toString(), 
				"\tCar manufacturer: NOTKNOWN\n" +
				"\tTank capacity: 0.0/40.0\n" +
				"\tFuel consumption: 5.0\n" +
				"\tMileage: 0.0\n" +
				"\tLast trip distance: 0.0\n");
		customCar = new MyCar("kk;dd_BMW");
		assertEquals(customCar.toString(), 
				"\tCar manufacturer: BMW\n" +
				"\tTank capacity: 0.0/40.0\n" +
				"\tFuel consumption: 5.0\n" +
				"\tMileage: 0.0\n" +
				"\tLast trip distance: 0.0\n");
		customCar = new MyCar("60;10\tbmw"); 
		assertEquals(customCar.toString(), 
				"\tCar manufacturer: BMW\n" +
				"\tTank capacity: 0.0/60.0\n" +
				"\tFuel consumption: 10.0\n" +
				"\tMileage: 0.0\n" +
				"\tLast trip distance: 0.0\n");
		//tank too much
		assertEquals(customCar.tankIt(80), false);
		assertEquals(customCar.toString(), 
				"\tCar manufacturer: BMW\n" +
				"\tTank capacity: 0.0/60.0\n" +
				"\tFuel consumption: 10.0\n" +
				"\tMileage: 0.0\n" +
				"\tLast trip distance: 0.0\n");
		//tank 50l
		assertEquals(customCar.tankIt(50), true);
		assertEquals(customCar.toString(), 
				"\tCar manufacturer: BMW\n" +
				"\tTank capacity: 50.0/60.0\n" +
				"\tFuel consumption: 10.0\n" +
				"\tMileage: 0.0\n" +
				"\tLast trip distance: 0.0\n");
		//try too long trip
		assertEquals(customCar.startTrip(700), false);
		assertEquals(customCar.toString(), 
				"\tCar manufacturer: BMW\n" +
				"\tTank capacity: 50.0/60.0\n" +
				"\tFuel consumption: 10.0\n" +
				"\tMileage: 0.0\n" +
				"\tLast trip distance: 0.0\n");	
		//go for trip
		assertEquals(customCar.startTrip(100), true);
		assertEquals(customCar.toString(), 
				"\tCar manufacturer: BMW\n" +
				"\tTank capacity: 40.0/60.0\n" +
				"\tFuel consumption: 10.0\n" +
				"\tMileage: 100.0\n" +
				"\tLast trip distance: 100.0\n");
		//go for second trip
		assertEquals(customCar.startTrip(200), true);
		assertEquals(customCar.toString(), 
				"\tCar manufacturer: BMW\n" +
				"\tTank capacity: 20.0/60.0\n" +
				"\tFuel consumption: 10.0\n" +
				"\tMileage: 300.0\n" +
				"\tLast trip distance: 200.0\n");	
	}
	
	public static void main(String[] args) {
		testDefaultMyCar();
	}
}

