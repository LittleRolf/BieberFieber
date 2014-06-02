package de.LittleRolf.BieberFieber;

public class Teller {

	public enum Size {BIG, SMALL};
	
	public Size size;
	
	public Teller(Teller.Size s) {
		this.size = s;
	}
}
