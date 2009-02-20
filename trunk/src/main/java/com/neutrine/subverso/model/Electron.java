package com.neutrine.subverso.model;

public class Electron {
	private double mass;
	
	public Electron() {
		double c = 9.10938188d;
		mass = c * Math.pow(10, -28); 
	}

	public double getMass() {
		return mass;
	}
}
