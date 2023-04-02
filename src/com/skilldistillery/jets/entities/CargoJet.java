package com.skilldistillery.jets.entities;

public class CargoJet extends Jet implements CargoCarrier {
	
	public CargoJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}
	
	public double getSpeedInMach() {
		double mach = getSpeed() * 0.001303;
		return Math.round(mach * 100.0) / 100.0;
	}
	
	public void fly() {		
		double flightTime = (double) (getRange() / getSpeed());
		System.out.printf("Cargo Jet - Flight time: " + (Math.round(flightTime * 100.0) /100.0) + ", Mach speed: " + getSpeedInMach() + ", Details of ");
	}

	@Override
	public void loadCargo() {
		System.out.println("loading cargo in... " + getModel());
	}

}
