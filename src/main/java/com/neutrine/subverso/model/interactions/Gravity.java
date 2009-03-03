package com.neutrine.subverso.model.interactions;

import com.neutrine.subverso.model.Constants;
import com.neutrine.subverso.model.ILocalizable;
import com.neutrine.subverso.model.IMassive;
import com.neutrine.subverso.model.Location;
import com.sun.xml.internal.messaging.saaj.soap.ver1_1.Body1_1Impl;

public class Gravity  {
	// TODO: Realizar processamento em fases: Realizar build do subverso para cada instante de tempo.
	
	/**
	 * @param mass1 massa em kg
	 * @param mass2 massa em kg
	 * @param distance distância em m
	 * @return Força de atração entre os corpos em N
	 */
	/* 
	 If a 50 kg (110 lb) girl sat 0.5 m (19.7 in) from a boy who was 75 kg (165 lb), what would be the gravitational attraction between them?
		Substituting the values into the equation, you get:
  		F = GMm/R² = (6.67*10-11 N-m²/kg²)(50 kg)(75 kg)/(0.5 m)(0.5 m) = 10-6 N or one-millionth of a Newton
	 */
	
	public double calculateForce(IMassive body1, IMassive body2, double distance) {
		
		//F = GMm/R²
		double force = (Constants.G * body1.getMass() * body2.getMass()) / Math.pow(distance, 2); 
		
		return force;
	}
	
	public void interact(IMassive body1, IMassive body2, double duration) {
		
		Location distanceAB = Location.distance(body1.getLocation(), body2.getLocation());
		Location distanceBA = Location.distance(body2.getLocation(), body1.getLocation());
		double norm = distanceAB.normalize();
		
		double g1X = calculateg(body1, norm) * (distanceBA.getX() < 0 ? -1 : 1);
		double g1Y = calculateg(body1, norm) * (distanceBA.getY() < 0 ? -1 : 1);
		double g1Z = calculateg(body1, norm) * (distanceBA.getZ() < 0 ? -1 : 1);

		double g2X = calculateg(body2, norm) * (distanceAB.getX() < 0 ? -1 : 1);
		double g2Y = calculateg(body2, norm) * (distanceAB.getY() < 0 ? -1 : 1);
		double g2Z = calculateg(body2, norm) * (distanceAB.getZ() < 0 ? -1 : 1);
		
		double offSet1X = calculateVelocity(g2X, duration);
		double offSet1Y = calculateVelocity(g2Y, duration);
		double offSet1Z = calculateVelocity(g2Z, duration);
		
		double offSet2X = calculateVelocity(g1X, duration);
		double offSet2Y = calculateVelocity(g1Y, duration);
		double offSet2Z = calculateVelocity(g1Z, duration);

		Location newVelocity = new Location(offSet1X, offSet1Y, offSet1Z, 0);
		body1.getVelocity().add(newVelocity);
		
		newVelocity = new Location(offSet2X, offSet2Y, offSet2Z, 0);
		body2.getVelocity().add(newVelocity);
	}
	
	private double calculateg(IMassive body, double distance) {
		double g = (Constants.G * body.getMass()) / Math.pow(distance, 2);
		return g;
	}

	private double calculateVelocity(double g, double duration) {
		// v = v0 + ((g + a) * t))
		return g * duration;
	}
}
