package com.skilldistillery.jets.app;

import java.util.Scanner;
import com.skilldistillery.jets.entities.AirField;

public class JetsApplication {
	AirField af = new AirField();

	public static void main(String[] args) {
		// Only class with a main and static method
		JetsApplication jetsApp = new JetsApplication();
		jetsApp.launch();
	}

	public void launch() {
		JetsApplication ja = new JetsApplication();
		Scanner sc = new Scanner(System.in);
		int selection;
		// create the Airfield
		ja.printMenu();
		do {
			selection = sc.nextInt();
			switch(selection) {
			case 1:
				ja.printFleet();
				break;
			case 2:
				ja.flyAllJets();
				break;
			case 3:
				ja.fastestJet();
				break;
			case 4:
				ja.longestRange();
				break;
			case 5:
				ja.loadAllCargoJets();
				break;
			case 6:
				ja.dogfight();
				break;
			case 7:
				ja.addJet();
				break;
			case 8:
				ja.removeJet();
				break;
			case 9:
				ja.quitApp();
				break;
			default:
				ja.printInvalid();
				break;
			} 
		} while (selection != 9);	
		
//		
//		
//		
//		
//		
		
		sc.close();
	}

	public void printMenu() {
		System.out.println("1. List Fleet "
				+ "\n2. Fly all jets "
				+ "\n3. View fastest jet "
				+ "\n4. View jet with longest range "
				+ "\n5. Load all Cargo Jets "
				+ "\n6. Dogfight! "
				+ "\n7. Add a jet to Fleet "
				+ "\n8. Remove a jet from Fleet "
				+ "\n9. Quit ");	
	}
	
	public void printFleet() {
		af.listFleet();
		printMenu();
	}
	
	public void flyAllJets() {
		af.flyAll();
		printMenu();						
//		calls fly() for entire fleet of jets and prints out details including mach and time in flight
	}
	
	public void fastestJet() {
//		view fastestJet and print all details	
//		System.out.println(af.getSpeedInMach(0));  
		
		
	}
	
	public void longestRange() {
//		view longest range jet and print all details
		
	}
	
	public void loadAllCargoJets() {
//		print out loading cargo from loadCargo()
//		The user is presented with an option specific to the interfaces you created. 
//		For example, Load all Cargo Jets, above, finds all implementors of the CargoCarrier interface
//		and calls loadCargo() on each
	
	}
	
	public void dogfight() {
//		same ass load cargo but with fight()
		
	}
	
	public void addJet() {
//		user can add a PassengerJet to fleet, user enters information and its added to AirField
		
	}
	
	public void removeJet() {
//		user can remove a Jet from fleet, user is presented sub-menu to select a jet to delete by 
//		number. Print fleet detail with a unique #. have user select # to delete
		
		
	}

	public void quitApp() {
		System.out.println("Goodbye!");
	}

	public void printInvalid() {
		System.out.println("Invalid selection. Please enter 1-9.");
		printMenu();		
	}
}

