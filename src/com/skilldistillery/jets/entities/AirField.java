package com.skilldistillery.jets.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//	Only AirField can talk to fleet
public class AirField {
	private List<Jet> fleet;
	String fileName = "jets.txt";
	Scanner sc = new Scanner(System.in);

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
		for (int i = 0; i < fleet.size(); i++) {
			System.out.println(fleet.get(i).toString());
		}
	}

	public void flyAll() {
		List<Jet> fleet = getFleet();
		for (int i = 0; i < fleet.size(); i++) {
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
			if (jet.getSpeed() > fastest.getSpeed()) {
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
			if (jet.getRange() > longest.getRange()) {
				longest = jet;
			}
		}
		System.out.println("Longest Range Jet: " + longest.toString());
	}

	public void loadAllCargoJets() {
		List<Jet> fleet = getFleet();
		for (int i = 0; i < fleet.size(); i++) {
			Jet jet = fleet.get(i);
			if (jet instanceof CargoJet) {
				CargoJet cargo = (CargoJet) jet;
				cargo.loadCargo();
			}
		}
	}

	public void dogfight() {
		List<Jet> fleet = getFleet();
		for (int i = 0; i < fleet.size(); i++) {
			Jet jet = fleet.get(i);
			if (jet instanceof FighterJet) {
				FighterJet fighter = (FighterJet) jet;
				fighter.fight();
			}
		}
	}

	public void addJet() {
		System.out.println("You are creating a new Passenger Jet" + "\nEnter model (ex. Jumbo Jet): ");
		String model = sc.nextLine();
		System.out.println("Enter speed in MPH (ex. 500.0): ");
		double speed = sc.nextDouble();
		System.out.println("Enter range in miles (ex. 400): ");
		int range = sc.nextInt();
		System.out.println("Enter price (ex. 10000000): ");
		long price = sc.nextLong();
		PassengerJet newJet = new PassengerJet(model, speed, range, price);
		fleet.add(newJet);
		System.out.println("Added jet to fleet: " + newJet.toString());
	}

	public void removeJet() {
		System.out.println("Select a number to remove that jet from fleet (ex. 1 or 2 or...): ");
		for (int i = 0; i < fleet.size(); i++) {
			System.out.println(i + 1 + ". " + fleet.get(i).toString());
		}
		int delete = sc.nextInt() - 1;
		List<Jet> fleet = getFleet();
		Jet deleteJet = fleet.get(delete);
		fleet.remove(deleteJet);
		System.out.println("Jet removed from fleet. Fleet Status: ");
		for (Jet jet : fleet) {
			System.out.println(jet.toString());
		}
	}
}
