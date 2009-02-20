package com.neutrine.subverso.model;

import java.util.ArrayList;

public class Atom implements IMassive {
	private Nucleus nucleus;
	private ArrayList<Electron> electrons;
	private Location location;
	
	public Atom() {
		nucleus = new Nucleus();
		electrons = new ArrayList<Electron>();
		location = new Location(0, 0, 0, 0);
	}
	
	public void addProton(Proton proton) {
		nucleus.getProtons().add(proton);
	}
	
	public void addElectron(Electron electron) {
		electrons.add(electron);
	}
	
	public double getMass() {
		double mass = 0;
	
		for(Electron electron: electrons) {
			mass += electron.getMass();
		}
		
		mass += nucleus.getMass();
		
		return mass;
	}
	
	public Nucleus getNucleus() {
		return nucleus;
	}
	public void setNucleus(Nucleus nucleus) {
		this.nucleus = nucleus;
	}
	public ArrayList<Electron> getElectrons() {
		return electrons;
	}
	public void setElectrons(ArrayList<Electron> electrons) {
		this.electrons = electrons;
	}

	public Location getLocation() {
		return location;
	}

	@Override
	public void setLocation(Location location) {
		this.location = location;
	}
	
}
