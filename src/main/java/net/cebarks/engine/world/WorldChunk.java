package net.cebarks.engine.world;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import net.cebarks.engine.world.tile.Tile;

public class WorldChunk implements Externalizable {
	private WorldStorage worldStorage;
	private Tile[][] tiles;

	public int x;
	public int y;

	public WorldChunk(WorldStorage worldStorage) {
		this.worldStorage = worldStorage;
		tiles = new Tile[15][15];
	}

	public void setTile(Tile tile, int x, int y) {
		tiles[x][y] = tile;
	}

	public void setTile(int id, int x, int y) {
		tiles[x][y] = Tile.getByID(id);
	}

	public WorldStorage getWorldStorage() {
		return worldStorage;
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeInt(x);
		out.writeInt(y);
		for (int i = 0; i < 16; i++)
			for (int j = 0; j < 16; j++)
				out.writeInt(tiles[i][j].id);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		x = in.readInt();
		y = in.readInt();
		for (int i = 0; i < 16; i++)
			for (int j = 0; j < 16; j++)
				tiles[i][j] = Tile.getByID(in.readInt());
	}

	public Tile getTile(int i, int j) {
		return tiles[i][j];
	}

	public int getTileID(int i, int j) {
		return getTile(i, j).id;
	}
	
	
}
