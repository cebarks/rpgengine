package net.cebarks.engine.world.tile;

import java.util.HashMap;
import java.util.Map;

import net.cebarks.engine.gfx.Animation;
import net.cebarks.engine.gfx.TileAnimation;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;

public class Tile {
	public final int id;

	private boolean solid;
	private static Map<Integer, Tile> tiles = new HashMap<Integer, Tile>();

	public static final Tile empty = new TileEmpty();

	public Tile(int id) {
		this.id = id;
		tiles.put(id, this);
	}

	public boolean isSolid() {
		return solid;
	}

	protected void setSolid(boolean solid) {
		this.solid = solid;
	}

	public static Tile getByID(int id2) {
		return tiles.get(id2);
	}

	public void render(int x, int y) {
		GL11.glBegin(GL11.GL_QUADS);
		{
			GL11.glTexCoord2f(0, 0);
			GL11.glVertex2f(0, 0);
			GL11.glTexCoord2f(1, 0);
			GL11.glVertex2f(32, 0);
			GL11.glTexCoord2f(1, 1);
			GL11.glVertex2f(32, 32);
			GL11.glTexCoord2f(0, 1);
			GL11.glVertex2f(0, 32);
		}
		GL11.glEnd();
	}

	public TileAnimation getAnimation() {
		return null;
	}
}
