package simulation;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import model.units.*;
import simulation.Address;
import model.infrastructure.ResidentialBuilding;
import model.people.Citizen;
import model.disasters.Disaster;
import model.disasters.Fire;
import model.disasters.GasLeak;
import model.disasters.Injury;
import model.disasters.Infection;



public class Simulator  {
	private int currentCycle;
	private ArrayList<ResidentialBuilding> buildings;
	private ArrayList<Citizen> citizens;
	private ArrayList<Unit> emergencyUnits;
	private ArrayList<Disaster> plannedDisasters;
	private ArrayList<Disaster> executedDisasters;
	private Address[][] world;
	
	public Simulator() throws Exception {
		buildings = new ArrayList<ResidentialBuilding>();
		citizens = new ArrayList<Citizen>();
		emergencyUnits = new ArrayList<Unit>();
		plannedDisasters = new ArrayList<Disaster>();
		executedDisasters = new ArrayList<Disaster>();
		world = new Address[10][10];
		for(int i = 0; i<world.length; i++)
			for(int j = 0; j<world[i].length; j++) {
				world[i][j] = new Address(i,j);
			}
		
		loadBuildings("buildings.csv");
		loadCitizens("citizens.csv");
		loadDisasters("disasters.csv");
		loadUnits("units.csv");
	}

	public static ArrayList<String> readFile(String filePath) throws Exception{
		String in = "";
		ArrayList<String> result = new ArrayList<String>();
		FileReader reader = new FileReader(filePath);
		BufferedReader b = new BufferedReader(reader);
		while((in = b.readLine())!=null) 
			result.add(in);
		return result;
	}
	
	private void loadUnits(String filePath) throws Exception{
		ArrayList<String> in = readFile(filePath);
		for(int i = 0; i<in.size(); i++) {
			 String[] current = in.get(i).split(",");
			 String type = current[0];
			 String id = current[1];
			 int spc = Integer.parseInt(current[2]);
			 switch(type) {
			 	case "AMB": emergencyUnits.add(new Ambulance(id,world[0][0],spc));break;
			 	case "DCU": emergencyUnits.add(new DiseaseControlUnit(id,world[0][0],spc));break;
			 	case "GCU": emergencyUnits.add(new GasControlUnit(id,world[0][0],spc));break;
			 	case "FTK": emergencyUnits.add(new FireTruck(id,world[0][0],spc));break;
			 	case "EVC": emergencyUnits.add(new Evacuator(id,world[0][0],spc,Integer.parseInt(current[3])));
			 }
		}
	}
	
	private void loadBuildings(String filePath) throws Exception{
		ArrayList<String> in = readFile(filePath);
		for(int i = 0; i<in.size(); i++) {
			String[] current = in.get(i).split(",");
			int x_coord = Integer.parseInt(current[0]);
			int y_coord = Integer.parseInt(current[1]);
			buildings.add(new ResidentialBuilding(world[x_coord][y_coord]));
			
		}
	}
	
	private void loadCitizens(String filePath) throws Exception{
		ArrayList<String> in = readFile(filePath);
		for(int i = 0; i<in.size(); i++) {
			String[] current = in.get(i).split(",");
			int x_coord = Integer.parseInt(current[0]);
			int y_coord = Integer.parseInt(current[1]);
			String id = current[2];
			String name = current[3];
			int age = Integer.parseInt(current[4]);
			Citizen citizen = new Citizen(world[x_coord][y_coord],id,name,age);
			int j;
			for(j = 0; j<buildings.size(); j++) {
				if(buildings.get(j).getLocation().getX() == x_coord &&
				   buildings.get(j).getLocation().getY() == y_coord) break;
			}
			if(j<buildings.size())
			buildings.get(j).getOccupants().add(citizen);
			citizens.add(citizen);
		}
	}
	
	private void loadDisasters(String filePath) throws Exception{
		ArrayList<String> in = readFile(filePath);
		for(int i = 0; i<in.size(); i++) {
			String[] current = in.get(i).split(",");
			int sc = Integer.parseInt(current[0]);
			String type = current[1];
			switch(type) {
				case "INJ": int j = 0;
							for(j = 0; j<citizens.size(); j++) 
							{
								if(citizens.get(j).getNationalID().equals(current[2]))break;
							}
							plannedDisasters.add(new Injury(sc,citizens.get(j)));break;
				case "INF": int l = 0;
							for(l = 0; l<citizens.size(); l++) 
							{
								if(citizens.get(l).getNationalID().equals(current[2]))break;
							}
							plannedDisasters.add(new Infection(sc,citizens.get(l)));break;
				case "FIR": int k = 0; 
							for(k = 0; k<buildings.size(); k++) {
								if(buildings.get(k).getLocation().getX() == Integer.parseInt(current[2]) && 
								   buildings.get(k).getLocation().getY() == Integer.parseInt(current[3]))break;
							}
							plannedDisasters.add(new Fire(sc,buildings.get(k)));break;
				case "GLK": int h = 0; 
							for(h = 0; h<buildings.size(); h++) {
								if(buildings.get(h).getLocation().getX() == Integer.parseInt(current[2]) && 
								   buildings.get(h).getLocation().getY() == Integer.parseInt(current[3]))break;
							}
							plannedDisasters.add(new GasLeak(sc,buildings.get(h)));
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		Simulator s = new Simulator();
		ArrayList<Citizen> c = s.citizens;
		for(Citizen ci : c) {
			System.out.println(ci.getAge());
		}
		
	}
}
