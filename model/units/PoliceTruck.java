package model.units;

import simulation.Address;

public class PoliceTruck extends PoliceUnit implements Truck{
	
	private ReconstructionSpeed rspeed;
	
	
	public PoliceTruck(String id, Address location, int stepsPerCycle, ReconstructionSpeed reconstructionSpeed) {
		super(id, location, stepsPerCycle, 20);
		rspeed = reconstructionSpeed;
	}
	
	public ReconstructionSpeed getRspeed() {
		return rspeed;
	}
}
