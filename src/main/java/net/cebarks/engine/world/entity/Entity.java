package net.cebarks.engine.world.entity;

import net.cebarks.engine.world.GameObject;
import net.cebarks.engine.world.Level;

public class Entity extends GameObject {
	public float xToMove;
	public float yToMove;

	public Entity(Level level) {
		super(level);
	}

	public void move(int magX, int magY) {
		xToMove += magX;
		yToMove += magY;
	}

	@Override
	public void update(double d) {
		x += xToMove * d;
		y += yToMove * d;

		xToMove = 0;
		yToMove = 0;
		super.update(d);
	}
}
