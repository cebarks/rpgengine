package net.cebarks.engine.world;

import java.util.ArrayList;
import java.util.List;

import net.cebarks.engine.util.SLAPI;

public class WorldStorage {
	private Level level;

	private WorldChunk[][] chunks;

	public WorldStorage(Level level) {
		this.level = level;
		chunks = new WorldChunk[6][6];
	}

	public List<WorldChunk> getChunks() {
		List<WorldChunk> result = new ArrayList<WorldChunk>();
		for (WorldChunk[] wca : chunks)
			for (WorldChunk wc : wca)
				result.add(wc);
		return result;
	}

	public WorldChunk getChunk(int x, int y) {
		return chunks[x][y];
	}

	public void addChunk(WorldChunk chunk) {
		chunks[chunk.x][chunk.y] = chunk;
	}

	public Level getLevel() {
		return level;
	}

	public void loadChunk(int x1, int y1) {
		try {
			addChunk((WorldChunk) SLAPI.load("c." + x1 + "." + y1 + ".wcs"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
