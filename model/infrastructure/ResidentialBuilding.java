package model.infrastructure;

import java.util.ArrayList;

import model.disasters.Disaster;
import model.people.Citizen;
import simulation.Address;
import simulation.Rescuable;
import simulation.Simulatable;

public class ResidentialBuilding implements Simulatable ,Rescuable  {
	private Address location;
	private int structuralIntegrity;//starts with 100
	private int fireDamage;//starts with 0
	private int gasLevel;//starts with 0
	private int foundationDamage; //starts with 0
	private ArrayList<Citizen> occupants;//read only // already getters in class citizens !
	private Disaster disaster;//read only 
	
	
	
	
	
	 public ResidentialBuilding(Address location){
		this.location=location;
		this.fireDamage=0;
		this.gasLevel=0;
		this.foundationDamage=0;
		this.structuralIntegrity=100;
		occupants = new ArrayList<>();
		
	}

	public Address getLocation() {
		return location;
	}

	public int getStructuralIntegrity() {
		return structuralIntegrity;
	}

	public int getFireDamage() {
		return fireDamage;
	}

	public int getGasLevel() {
		return gasLevel;
	}

	public int getFoundationDamage() {
		return foundationDamage;
	}

	public ArrayList<Citizen> getOccupants() {
		return occupants;
	}

	public Disaster getDisaster() {
		return disaster;
	}

	public void setFireDamage(int fireDamage) {
		this.fireDamage = fireDamage;
	}

	public void setGasLevel(int gasLevel) {
		this.gasLevel = gasLevel;
	}

	public void setFoundationDamage(int foundationDamage) {
		this.foundationDamage = foundationDamage;
	}

	public void setStructuralIntegrity(int structuralIntegrity) {
		this.structuralIntegrity = structuralIntegrity;
	}
}
