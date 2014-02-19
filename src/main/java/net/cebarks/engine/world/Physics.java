package net.cebarks.engine.world;

import java.awt.Rectangle;

public class Physics {
	public static boolean isColliding(GameObject go1, GameObject go2) {
		Rectangle rec1 = new Rectangle((int) go1.x, (int) go1.y);
		Rectangle rec2 = new Rectangle((int) go2.x, (int) go2.y);
		return rec1.intersects(rec2);
	}
}
