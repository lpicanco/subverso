package com.neutrine.subverso.model.atom;

import com.neutrine.subverso.model.Atom;

public class Connection {
	private Atom first;
	private Atom second;
	
	public Connection() {
	
	}
	
	public Connection(Atom first, Atom second) {
		this.first = first;
		this.second = second;
	}
	
	public Atom getFirst() {
		return first;
	}
	public void setFirst(Atom first) {
		this.first = first;
	}
	public Atom getSecond() {
		return second;
	}
	public void setSecond(Atom second) {
		this.second = second;
	}
}
