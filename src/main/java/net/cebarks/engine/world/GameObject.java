package net.cebarks.engine.world;

public class GameObject {
	private Level level;

	protected float x;
	protected float y;

	public GameObject(Level level) {
		this.level = level;
		level.addGameObject(this);
	}

	public void update(double d) {

	}
}
