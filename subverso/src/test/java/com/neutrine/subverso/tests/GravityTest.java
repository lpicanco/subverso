/**
 * 
 */
package com.neutrine.subverso.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.neutrine.subverso.model.Atom;
import com.neutrine.subverso.model.Electron;
import com.neutrine.subverso.model.IMassive;
import com.neutrine.subverso.model.Location;
import com.neutrine.subverso.model.Proton;
import com.neutrine.subverso.model.interactions.Gravity;
import com.neutrine.subverso.tests.model.FakeMassive;

/**
 * @author Luiz Picanço
 * 
 */
public class GravityTest {

	/**
	 * Test method for
	 * {@link com.neutrine.subverso.model.interactions.Gravity#calculateForce(com.neutrine.subverso.model.IMassive, com.neutrine.subverso.model.IMassive, double)}
	 * .
	 */
	@Test
	public void testCalculateForce() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link com.neutrine.subverso.model.interactions.Gravity#interact(com.neutrine.subverso.model.IMassive, com.neutrine.subverso.model.IMassive, double)}
	 * .
	 */
	@Test
	public void testInteract() {
		IMassive earth = createFakeMassive(5.98e24);
		//IMassive moon = createFakeMassive(7.35e22);
		IMassive person = createFakeMassive(100);

		int radius = 6378100;
		int distance = 500;
		
		earth.getLocation().add(new Location(1, 0, 1, 0));
		//moon.getLocation().add(new Location(0, 3.84e8, 0, 0));
		person.getLocation().add(new Location(1, radius, 1, 0));	

		Location baseLocation = Location.invert(person.getLocation());
		
		person.getLocation().setY(radius + distance);
		
		System.out.println("A location: " + earth.getLocation());
		System.out.println("B location: " + person.getLocation());

		Gravity g = new Gravity();

		for (int i = 0; i < 10; i++) {
			g.interact(earth, person, 1);

			System.out.println("A new location: " + earth.getLocation());
			Location pos = new Location(0,0,0,i + 1);
			pos.add(person.getLocation());
			pos.add(baseLocation);
			System.out.println("B new location: " + pos);
			System.out.println("Distance: " + 
				Location.distance(earth.getLocation(), person.getLocation()));
		}

		// assertTrue(condition)
	}
	
	private IMassive createFakeMassive(double mass) {
		FakeMassive body = new FakeMassive();
		body.setMass(mass);
		return body;
	}

	private Atom createHidrogenAtom() {
		Atom hidrogen = new Atom();

		Electron electron = new Electron();
		hidrogen.addElectron(electron);

		Proton proton = new Proton();
		hidrogen.addProton(proton);

		return hidrogen;
	}

}
