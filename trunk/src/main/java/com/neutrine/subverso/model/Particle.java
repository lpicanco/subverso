package com.neutrine.subverso.model;

public abstract class Particle implements IMassive {

	private Location location;
	private Location velocity;
	private Location acceleration;
	protected double mass;
	
	public Particle() {
		location = new Location(0, 0, 0, 0);
		velocity = new Location(0, 0, 0, 0);
		acceleration = new Location(0, 0, 0, 0);
	}
	
	public void apply(double duration) {
		double offSetX = calculateDeslocation(getAcceleration().getX(), getVelocity().getX(), duration);
		double offSetY = calculateDeslocation(getAcceleration().getY(), getVelocity().getY(), duration);
		double offSetZ = calculateDeslocation(getAcceleration().getZ(), getVelocity().getZ(), duration);

		Location newLocation = new Location(offSetX, offSetY, offSetZ, duration);
		getLocation().add(newLocation);
	}
	
	private double calculateDeslocation(double acceleration, double velocity, double duration) {
		//return ((g + acceleration) * duration) + velocity;
		// s = s0 + (v0 * t) + (0.5 * g * (t * t))
		double s = (velocity * duration) + (0.5 * acceleration * (duration * duration));
		return s;
	}	
	
	@Override
	public double getMass() {
		return mass;
	}

	@Override
	public Location getLocation() {
		return location;
	}

	@Override
	public void setLocation(Location location) {
		this.location = location;
	}

	@Override
	public Location getAcceleration() {
		return acceleration;
	}

	@Override
	public Location getVelocity() {
		return velocity;
	}

	@Override
	public void setAcceleration(Location acceleration) {
		this.acceleration = acceleration;
	}

	@Override
	public void setVelocity(Location velocity) {
		this.velocity = velocity;
	}
}
