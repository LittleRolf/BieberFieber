package de.LittleRolf.BieberFieber;

import java.util.Queue;
import java.util.Stack;

public class Essensausgabe {
	
	
	
	Stack<Teller> teller;
	Queue<Bieber> bieber;
	
	TellerBieberFactory factory;
	
	public Essensausgabe() {
		factory = new TellerBieberFactory("device.xml");
		teller = factory.getTellerz();
		bieber = factory.getBieberz();
	}
	
	public static void main(String... args) {
		Essensausgabe e = new Essensausgabe();
		
		System.out.println(e.tellerstapelPasstZurSchlange());
	}
	
	public boolean tellerstapelPasstZurSchlange() {
		Bieber b;
		Teller t;
		boolean failed = false;
		while ((b=bieber.poll()) != null) {
			if (b.size.ordinal() != teller.pop().size.ordinal()) {
				failed = true;
			}
		}
		return !failed;
	}

}
