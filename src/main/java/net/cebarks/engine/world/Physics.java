package net.cebarks.engine.world;

import java.awt.Rectangle;

import net.cebarks.engine.world.entity.Entity;

public class Physics {
	public static boolean isColliding(Entity e1, Entity e2) {
		Rectangle rec1 = new Rectangle((int) e1.x, (int) e1.y);
		Rectangle rec2 = new Rectangle((int) e2.x, (int) e2.y);
		return rec1.intersects(rec2);
	}

	public static void physicsUpdate(World world) {

	}
}
