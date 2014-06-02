package de.LittleRolf.BieberFieber;

import java.util.Queue;
import java.util.Stack;

public class Essensausgabe {

	Stack<Teller> teller;
	Queue<Bieber> bieber;
	
	TellerBieberFactory factory;
	
	public Essensausgabe() {
		factory = new TellerBieberFactory("Ulf");
		teller = factory.getTellerz();
		bieber = factory.getBieberz();
	}
	
	public static void main(String... args) {
		
	}
	
	public boolean tellerstapelPasstZurSchlange() {
		Bieber b;
		Teller t;
		while ()
	}

}
