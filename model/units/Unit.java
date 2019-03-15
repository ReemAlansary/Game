package model.units;

import simulation.Address;
import simulation.Rescuable;
import simulation.Simulatable;

public abstract class Unit implements Simulatable {

	private String unitID;//read only
	private UnitState state;
	private Address location;
	private Rescuable target;//read only
	private int distanceToTarget;//nor read nor write 
	private int stepsPerCycle;//read only
	
	public Unit(String id, Address location, int stepsPerCycle){
		unitID=id;
		this.location=location;
		this.stepsPerCycle=stepsPerCycle;
		this.state=state.IDLE;
	}

	public String getUnitID() {
		return unitID;
	}

	public UnitState getState() {
		return state;
	}

	public void setState(UnitState state) {
		this.state = state;
	}

	public Address getLocation() {
		return location;
	}

	public void setLocation(Address location) {
		this.location = location;
	}

	public Rescuable getTarget() {
		return target;
	}

	public int getStepsPerCycle() {
		return stepsPerCycle;
	}

	
	
	
}
