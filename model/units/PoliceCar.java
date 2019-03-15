package model.units;

import simulation.Address;

public class PoliceCar extends PoliceUnit implements Car{
	
	private boolean siren;
	
	public PoliceCar(String id, Address location, int stepsPerCycle) {
		super(id, location, stepsPerCycle, 6);
		siren = true;
	}
	
	public boolean isSiren() {
		return siren;
	}
	
	public void setSiren(boolean siren) {
		this.siren = siren;
	}
}
