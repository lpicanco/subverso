package com.neutrine.subverso.model;

import java.util.ArrayList;

public class Nucleus {
	private ArrayList<Neutron> neutrons;
	private ArrayList<Proton> protons;
	
	public Nucleus() {
		neutrons = new ArrayList<Neutron>();
		protons = new ArrayList<Proton>();
	}
	
	public double getMass() {
		double mass = 0;
		
		for (Neutron neutron : neutrons) {
			mass += neutron.getMass();
		}
		
		for (Proton proton: protons) {
			mass += proton.getMass();
		}
		
		return mass;
	}	
	
	public void setProtons(ArrayList<Proton> protons) {
		this.protons = protons;
	}
	public ArrayList<Proton> getProtons() {
		return protons;
	}
	public ArrayList<Neutron> getNeutrons() {
		return neutrons;
	}
	public void setNeutrons(ArrayList<Neutron> neutrons) {
		this.neutrons = neutrons;
	}

}
