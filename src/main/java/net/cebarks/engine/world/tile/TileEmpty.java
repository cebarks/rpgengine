package net.cebarks.engine.world.tile;

import org.lwjgl.opengl.GL11;

public class TileEmpty extends Tile {
	public TileEmpty() {
		super(-1);
		setSolid(false);
	}

	@Override
	public void render(float x, float y) {
		GL11.glBegin(GL11.GL_QUADS);
		{
			GL11.glColor3f(1, 1, 1);
			GL11.glVertex2f(x, y);
			GL11.glVertex2f(x + 32, y);
			GL11.glVertex2f(x + 32, y + 32);
			GL11.glVertex2f(x, y + 32);
		}
		GL11.glEnd();
	}
}
