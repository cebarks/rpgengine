package net.cebarks.engine.world.tile;

import java.util.HashMap;
import java.util.Map;

import net.cebarks.engine.gfx.TileAnimation;

public class Tile {
	public final int id;

	private boolean solid;
	private static Map<Integer, Tile> tiles = new HashMap<Integer, Tile>();

	public static final Tile empty = new TileEmpty();

	public Tile(int id) {
		this.id = id;
		tiles.put(id, this);
	}

	public void update(int i, int j) {
		
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

	public TileAnimation getAnimation() {
		return null;
	}

	public void render(float x, float y) {
		getAnimation().render(x * 32, y * 32);
	}
}
