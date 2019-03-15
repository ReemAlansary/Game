package model.people;

import model.disasters.Disaster;
import simulation.Address;
import simulation.Rescuable;
import simulation.Simulatable;

public class Citizen implements Simulatable,Rescuable  {


	private CitizenState state;
	private Disaster disaster;// read only getter in here or in super only ?

	private Address location;// getter and setter here or in super only ?
	private String nationalID;// read only
	private String name;// read only
	private int age; // read only
	private int hp;// starts with 100?
	private int bloodLoss;// starts with 0
	private int toxicity;// starts with 0
	
	public Citizen(Address location, String nationalID, String name, int age) {
		this.location = location;
		this.nationalID = nationalID;
		this.name = name;
		this.age = age;
		this.state = state.SAFE;
		this.hp = 100;
		this.bloodLoss = 0;
		this.toxicity = 0;


	}

	public CitizenState getState() {
		return state;
	}

	public void setState(CitizenState state) {
		this.state = state;
	}

	public Address getLocation() {// remove this?
		return location;
	}

	public void setLocation(Address location) {// remove this?
		this.location = location;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getBloodLoss() {
		return bloodLoss;
	}

	public void setBloodLoss(int bloodLoss) {
		this.bloodLoss = bloodLoss;
	}

	public int getToxicity() {
		return toxicity;
	}

	public void setToxicity(int toxicity) {
		this.toxicity = toxicity;
	}

	public Disaster getDisaster() {
		return disaster;
	}

	public String getNationalID() {
		return nationalID;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

}
