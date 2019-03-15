package model.units;

import java.util.ArrayList;

import model.people.Citizen;
import simulation.Address;

abstract class PoliceUnit extends Unit {
	
	private ArrayList<Citizen> passengers;//nor read nor write
	private int maxCapacity;//read only
	private int  distanceToBase;//read and write 
	
	
	public PoliceUnit(String id, Address location, int stepsPerCycle, int maxCapacity) {
		super(id,location,stepsPerCycle);
		this.maxCapacity=maxCapacity;
		passengers = new ArrayList<>();
	}
	
	public int getDistanceToBase() {
		return distanceToBase;
	}


	public void setDistanceToBase(int distanceToBase) {
		this.distanceToBase = distanceToBase;
	}
	
	public int getMaxCapacity() {
		return maxCapacity;
	}

}
