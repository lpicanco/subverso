/**
 * 
 */
package com.neutrine.subverso.tests.model;

import com.neutrine.subverso.model.IMassive;
import com.neutrine.subverso.model.Location;

/**
 * @author Luiz Picanço
 *
 */
public class FakeMassive implements IMassive {

	private Location location;
	private double mass;

	public FakeMassive() {
		location = new Location(0, 0, 0, 0);
	}
	
	/* (non-Javadoc)
	 * @see com.neutrine.subverso.model.IMassive#getMass()
	 */
	@Override
	public double getMass() {
		return mass;
	}

	public void setMass(double mass) {
		this.mass = mass;
	}
	
	/* (non-Javadoc)
	 * @see com.neutrine.subverso.model.ILocalizable#getLocation()
	 */
	@Override
	public Location getLocation() {
		// TODO Auto-generated method stub
		return location;
	}

	/* (non-Javadoc)
	 * @see com.neutrine.subverso.model.ILocalizable#setLocation(com.neutrine.subverso.model.Location)
	 */
	@Override
	public void setLocation(Location location) {
		this.location = location;

	}

}
