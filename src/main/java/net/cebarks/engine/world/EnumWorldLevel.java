package net.cebarks.engine.world;

public enum EnumWorldLevel {
	BACKGROUND(0), MIDGROUND(1), FOREGROUND(2);
	
	public int id;
	
	private EnumWorldLevel(int id) {
		this.id = id;
	}
}
