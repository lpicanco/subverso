package com.neutrine.subverso.model;

import java.util.ArrayList;

import com.neutrine.subverso.model.atom.Connection;

public class Molecule {
	private ArrayList<Connection> connections;

	public Molecule() {
		connections = new ArrayList<Connection>();
	}
	
	public ArrayList<Connection> getConnections() {
		return connections;
	}

	public void setConnections(ArrayList<Connection> connections) {
		this.connections = connections;
	}
	
	

}
