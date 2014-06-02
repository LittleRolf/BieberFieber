package de.LittleRolf.BieberFieber;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TellerBieberFactory {

	public TellerBieberFactory(String path) {
		
	}
	
	public Queue<Bieber> getBieberz() {
		Queue<Bieber> q = new LinkedList<Bieber>();
		q.add(new Bieber("Ulf",Bieber.Size.BIG));
		q.add(new Bieber("Klein-Peda",Bieber.Size.SMALL));
		return q;
	}
	
	public Stack<Teller> getTellerz() {
		Stack<Teller> t = new Stack<Teller>();
		
		t.push(new Teller(Teller.Size.SMALL));
		t.push(new Teller(Teller.Size.BIG));
		return t;
	}

}
