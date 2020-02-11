//Wesley Tam
//February 6, 2020
//This is the Traveler object, adds distance traveled to Traveler

public class Traveler {
	//fields
	private int distanceTraveled;
	private String name;
	
	//constructor
	public Traveler(String name) {
		this.distanceTraveled = 0;
		this.name = name;
	}
	
	//methods
	public int getDistanceTraveled() {
		return distanceTraveled;
	}
	
	public void travel(int miles) {
		distanceTraveled += miles;
	}
	
	public String getName() {
		return name;
	}
}