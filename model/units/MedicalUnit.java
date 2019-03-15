package model.units;

import simulation.Address;

abstract public class MedicalUnit extends Unit{
	
	private int healingAmount = 10;
	private int treatmentAmount = 10;
	
	public MedicalUnit(String id, Address location, int stepsPerCycle) {
		super(id,location,stepsPerCycle);
	}
}
