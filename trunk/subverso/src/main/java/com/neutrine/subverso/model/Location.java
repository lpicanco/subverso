package com.neutrine.subverso.model;

public class Location {
	private double x;
	private double y;
	private double z;
	private double t;

	/**
	 * 
	 * @param x
	 *            position
	 * @param y
	 *            position
	 * @param z
	 *            position
	 * @param t
	 *            time
	 */
	public Location(double x, double y, double z, double t) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.t = t;
	}

	public void add(Location l) {
		this.x += l.getX();
		this.y += l.getY();
		this.z += l.getZ();
		this.t += l.getT();
	}

	public static Location invert(Location loc) {
		return new Location(-1 * loc.getX(), -1 * loc.getY(), -1 * loc.getZ(), -1 * loc.getT());
	}

	public static Location distance(Location loc1, Location loc2) {
		return new Location(loc2.getX() - loc1.getX(), loc2.getY()
				- loc1.getY(), loc2.getZ() - loc1.getZ(), loc2.getT()
				- loc1.getT());
	}

	public boolean intersect(Location a, double radiusA, Location b,
			double radiusB) {
		double aXStart = a.getX() - (radiusA / 2);
		double aXEnd = a.getX() + (radiusA / 2);
		double aYStart = a.getY() - (radiusA / 2);
		double aYEnd = a.getY() + (radiusA / 2);
		double aZStart = a.getZ() - (radiusA / 2);
		double aZEnd = a.getZ() + (radiusA / 2);
		double aTStart = a.getT() - (radiusA / 2);
		double aTEnd = a.getT() + (radiusA / 2);

		double bXStart = b.getX() - (radiusB / 2);
		double bXEnd = b.getX() + (radiusB / 2);
		double bYStart = b.getY() - (radiusB / 2);
		double bYEnd = b.getY() + (radiusB / 2);
		double bZStart = b.getZ() - (radiusB / 2);
		double bZEnd = b.getZ() + (radiusB / 2);
		double bTStart = b.getT() - (radiusB / 2);
		double bTEnd = b.getT() + (radiusB / 2);

		return ((bXStart >= aXStart && bXStart <= aXEnd) || (bXEnd >= aXStart && bXEnd <= aXEnd))
				&& ((bYStart >= aYStart && bYStart <= aYEnd) || (bYEnd >= aYStart && bYEnd <= aYEnd))
				&& ((bZStart >= aZStart && bZStart <= aZEnd) || (bZEnd >= aYStart && bZEnd <= aZEnd))
				&& ((bTStart >= aTStart && bTStart <= aTEnd) || (bTEnd >= aTStart && bTEnd <= aTEnd));
	}

	public double normalize() {
		return Math.pow((Math.pow(getX(), 2) + Math.pow(getY(), 2)
				+ Math.pow(getZ(), 2) + Math.pow(getT(), 2)), 0.5);
	}

	/**
	 * {@inheritdoc}
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer("(");
		sb.append(x).append(",").append(y).append(",").append(z).append(",")
				.append(t);
		sb.append(")");
		return sb.toString();
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}

	public double getT() {
		return t;
	}

	public void setT(double t) {
		this.t = t;
	}

}
