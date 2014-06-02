package de.LittleRolf.BieberFieber;

public class Bieber {

	public enum Size {BIG, SMALL};
	
	public Size size;
	public String name;
	
	public Bieber(String name, Bieber.Size s) {
		this.name = name;
		this.size = s;
	}
}
