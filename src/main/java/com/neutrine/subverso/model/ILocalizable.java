/**
 * 
 */
package com.neutrine.subverso.model;

/**
 * @author Luiz Pican�o
 *
 */
public interface ILocalizable {
	Location getLocation();
	void setLocation(Location location);
	
	Location getVelocity();
	void setVelocity(Location velocity);

	Location getAcceleration();
	void setAcceleration(Location acceleration);
	
}
