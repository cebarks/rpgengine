package net.cebarks.engine.world;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import net.cebarks.engine.world.tile.Tile;

public class WorldChunk implements Externalizable {
	private Tile[][] background;
	private Tile[][] midground;
	private Tile[][] foreground;

	public int x;
	public int y;

	public WorldChunk(int x, int y) {
		background = new Tile[16][16];
		midground = new Tile[16][16];
		foreground = new Tile[16][16];
	}

	public void setTile(Tile tile, EnumWorldLevel level, int x, int y) {
		switch (level) {
			case BACKGROUND:
				background[x][y] = tile;
			case MIDGROUND:
				midground[x][y] = tile;
			case FOREGROUND:
				foreground[x][y] = tile;
		}
	}

	public void setTile(int id, EnumWorldLevel level, int x, int y) {
		setTile(Tile.getByID(id), level, x, y);
	}

	public Tile getTile(EnumWorldLevel level, int i, int j) {
		switch (level) {
			default:
				return null;
			case BACKGROUND:
				return background[x][y];
			case MIDGROUND:
				return midground[x][y];
			case FOREGROUND:
				return foreground[x][y];
		}
	}

	public int getTileID(EnumWorldLevel level, int i, int j) {
		return getTile(level, i, j).id;
	}

	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeInt(x);
		out.writeInt(y);
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 16; j++) {
				out.writeInt(background[i][j].id);
				out.writeInt(midground[i][j].id);
				out.writeInt(foreground[i][j].id);
			}
		}
	}

	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		x = in.readInt();
		y = in.readInt();
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 16; j++) {
				background[i][j] = Tile.getByID(in.readInt());
				midground[i][j] = Tile.getByID(in.readInt());
				foreground[i][j] = Tile.getByID(in.readInt());
			}
		}
	}

	public void update() {
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 16; j++) {
				midground[i][j].update(x * i, y * j);
				foreground[i][j].update(x * i, y * j);
			}
		}
	}

	public void render() {
		for (int x = 0; x < 16; x++) {
			for (int y = 0; y < 16; y++) {
				// getTile(EnumWorldLevel.BACKGROUND, x, y).render(x * 32, y *
				// 32);
				// getTile(EnumWorldLevel.MIDGROUND, x, y).render(x * 32, y *
				// 32);
				// getTile(EnumWorldLevel.FOREGROUND, x, y).render(x * 32, y *
				// 32);
			}
		}
	}

	public void renderBackground() {
		for (int x = 0; x < 16; x++) {
			for (int y = 0; y < 16; y++) {
				getTile(EnumWorldLevel.BACKGROUND, x, y).render(x * 32, y * 32);
				getTile(EnumWorldLevel.MIDGROUND, x, y).render(x * 32, y * 32);
			}
		}
	}

	public void renderForeground() {
		for (int x = 0; x < 16; x++) {
			for (int y = 0; y < 16; y++) {
				getTile(EnumWorldLevel.FOREGROUND, x, y).render(x * 32, y * 32);
			}
		}
	}
}
