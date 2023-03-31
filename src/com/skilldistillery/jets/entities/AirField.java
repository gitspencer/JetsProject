package com.skilldistillery.jets.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AirField {
//	Only airfield can talk to Jets
	private List<Jet> fleet; 
	String fileName = "jets.txt";
	
	public AirField() {
		//populate its fleet from file
	}
	
	
	public List<Jet> readFromFile(String fileName) {
		List<Jet> jets = new ArrayList<>();
		//read in various Jet types from file. 
		try (BufferedReader bufIn = new BufferedReader(new FileReader(fileName))) {
			  String aJet;
			  while ((aJet = bufIn.readLine()) != null) {
				  //as you read in a Jet, create a Jet.
				 String[] jetDetails = aJet.split(",");
				 //create appropriate jet based on all jet details
				 
				 
//				 if(jetDetails[0] = Cargo) {
//					// create a Cargo Jet	 
//				 } else if (jetDetails[0] = Fighter) {
//				 	// create a Fighter Jet
				 
				 
			  }
			}
			catch (IOException e) {
			  System.err.println(e);
			}
		//and add that specific Jet type to your jets list
		
		
		
		return jets;
	}
	
}
