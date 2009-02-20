package com.neutrine.subverso.tests;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import com.neutrine.subverso.model.Atom;
import com.neutrine.subverso.model.Electron;
import com.neutrine.subverso.model.Proton;

public class MoleculeTest {
	
	@Test
	public void hidrogenTest() {		
		Atom hidrogen = createHidrogenAtom();
		
		double mass = 1.6738e-24;
		Assert.assertTrue(Math.abs(mass - hidrogen.getMass()) < (1e-25));
	}
	
	@Test
	public void createOnegOfHAtoms() {
		Double qtd = 1 / createHidrogenAtom().getMass();
		/*ArrayList<Atom> atoms = new ArrayList<Atom>();
		
		for (int i =0; i < 10000) {
			atoms.add(createHidrogenAtom());
		}
		
		return atoms;*/
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
