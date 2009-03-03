package com.neutrine.subverso.monitor.test;

import java.util.logging.Logger;

import com.jme.app.SimpleGame;
import com.jme.bounding.BoundingBox;
import com.jme.math.Vector3f;
import com.jme.renderer.ColorRGBA;
import com.jme.scene.shape.Arrow;
import com.jme.scene.shape.Sphere;
import com.neutrine.subverso.model.IMassive;
import com.neutrine.subverso.model.Location;
import com.neutrine.subverso.model.Particle;
import com.neutrine.subverso.model.interactions.Gravity;
import com.neutrine.subverso.tests.model.FakeMassive;

public class SimpleView extends SimpleGame {
	
	Particle earth;
	Particle person;	
	private Sphere s1;
	private Sphere s2;
	static float elapsed = 0;
	
	@Override
	protected void simpleInitGame() {	
		s1 = new Sphere("Earth", 60, 60, 1);
		s2 = new Sphere("Person", 60, 60, 1);
		//s2.setModelBound(new BoundingBox());
        //s2.updateModelBound();
		rootNode.attachChild(s1);
		rootNode.attachChild(s2);
		
		initObjects();
		
		updateView();
	}
	
	@Override
	protected void simpleUpdate() {
		if (timer.getTimeInSeconds() - elapsed >= 0.01) {
			interact();
			updateView();
			elapsed = timer.getTimeInSeconds();
			System.out.println("Seconds: " + elapsed);
		}	
	}
	
	private void initObjects() {
		earth = createFakeMassive(1e12);//5.98e24);
		person = createFakeMassive(100e7);
		int offset = 100000;
		int radius = offset + 0;//6378100;
		int distance = 50;
		cam.setLocation(new Vector3f(offset, offset, offset + 500));
			
		earth.getLocation().add(new Location(offset + 0, offset + 0, offset + 0, 0));
		person.getLocation().add(new Location(radius + distance, radius + distance, radius + distance, 0));
		
		person.setVelocity(new Location(-1, 0, 0, 0));
	}
	
	private void interact() {
		Gravity g = new Gravity();
		g.interact(earth, person, 1);
		earth.apply(1);
		person.apply(1);
	}
	
	private void updateView() {
		s1.setLocalTranslation((float)earth.getLocation().getX(), (float)earth.getLocation().getY(), (float)earth.getLocation().getZ());
		s2.setLocalTranslation((float)person.getLocation().getX(), (float)person.getLocation().getY(), (float)person.getLocation().getZ());
		System.out.println("Earth: " + earth.getLocation());
		System.out.println("Person: " + person.getLocation());
		
		System.out.println("Person Velocity: " + person.getVelocity());
	}
	
	private Particle createFakeMassive(double mass) {
		FakeMassive body = new FakeMassive();
		body.setMass(mass);
		//body.setVelocity(new Location(10, 10, 0, 0));
		return body;
	}	
	
	public static void main(String[] args) {
		SimpleView view = new SimpleView();
		view.start();
	}

}
