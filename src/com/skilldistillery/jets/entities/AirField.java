package com.skilldistillery.jets.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//	Only AirField can talk to fleet
public class AirField {
	private List<Jet> fleet;
	String fileName = "jets.txt";

	public AirField() {
		// populate its fleet from file
		readFromFile(fileName);

	}

	public List<Jet> readFromFile(String fileName) {
		fleet = new ArrayList<>();
		// read in various Jet types from file.
		try (BufferedReader bufIn = new BufferedReader(new FileReader(fileName))) {
			String aJet;
			Jet newJet = null;
			while ((aJet = bufIn.readLine()) != null) {
				// as you read in a Jet, create a Jet.
				String[] jetDetails = aJet.split(",");
				String name = jetDetails[0];
				String model = jetDetails[1];
				double speed = Double.parseDouble(jetDetails[2]);
				int range = Integer.parseInt(jetDetails[3]);
				long price = Long.parseLong(jetDetails[4]);
				// create appropriate jet based on all jet details
				if (name.equals("Cargo")) {
					newJet = new CargoJet(model, speed, range, price);
				} else if (name.equals("Fighter")) {
					newJet = new FighterJet(model, speed, range, price);
				} else if (name.equals("Passenger")) {
					newJet = new PassengerJet(model, speed, range, price);
				} else if (name.equals("Blimp")) {
					newJet = new Blimp(model, speed, range, price);
				} else if (name.equals("Wing Suit")) {
					newJet = new WingSuit(model, speed, range, price);
				}
				fleet.add(newJet);
			}
		} catch (IOException e) {
			System.err.println(e);
		}
		// and add that specific Jet type to your fleet list
		return fleet;
	}

	public List<Jet> getFleet() {
		return fleet;
	}

	public void setFleet(List<Jet> fleet) {
		this.fleet = fleet;
	}
	
	public void listFleet() {
		List<Jet> fleet = getFleet();
		for(int i = 0; i < fleet.size(); i++) {
			System.out.println(fleet.get(i).toString());
		}
	}
	
	public void flyAll() {
		List<Jet> fleet = getFleet();
		for(int i = 0; i < fleet.size(); i++) {
			Jet jet = fleet.get(i);
			jet.fly();
			System.out.println(jet);
		}
	}
	
	public void fastestJet() {
		List<Jet> fleet = getFleet();
		Jet fastest = fleet.get(0);
		for (int i = 0; i < fleet.size(); i++) {
			Jet jet = fleet.get(i);
			if(jet.getSpeed() > fastest.getSpeed()) {
				fastest = jet;
			}
		}
		System.out.println("Fastest Jet: " + fastest.toString());
	}

	public void longRange() {
		List<Jet> fleet = getFleet();
		Jet longest = fleet.get(0);
		for (int i = 0; i < fleet.size(); i++) {
			Jet jet = fleet.get(i);
			if(jet.getRange() > longest.getRange()) {
				longest = jet;
			}
		}
		System.out.println("Fastest Jet: " + longest.toString());
	}
	
}
