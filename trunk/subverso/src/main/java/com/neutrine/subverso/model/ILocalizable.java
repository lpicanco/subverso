/**
 * 
 */
package com.neutrine.subverso.model;

/**
 * @author Luiz Picanço
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
