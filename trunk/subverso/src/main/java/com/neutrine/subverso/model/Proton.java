package com.neutrine.subverso.model;

public class Proton {
	private double mass;
	
	public Proton() {
		double c = 1.67262158d;
		mass = c * Math.pow(10, -24); 
	}

	public double getMass() {
		return mass;
	}
}
