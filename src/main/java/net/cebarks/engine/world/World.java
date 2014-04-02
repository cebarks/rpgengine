package net.cebarks.engine.world;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import net.cebarks.engine.Game;
import net.cebarks.engine.util.SLAPI;
import net.cebarks.engine.world.entity.Entity;

public class World {
	private Game game;
	private ArrayList<Entity> entities;
	private IWorldGenerator worldGenerator;
	private WorldChunk[][] chunks;
	private int curID;

	public World(Game game, IWorldGenerator generator) {
		this.game = game;
		this.worldGenerator = generator;
		entities = new ArrayList<Entity>();
		chunks = new WorldChunk[64][64];
	}

	public void generate() {
		for (EnumWorldLevel level : EnumWorldLevel.values())
			for (int i = 0; i < 64; i++) {
				for (int j = 0; j < 64; j++) {
					chunks[i][j] = worldGenerator.generate(level, i, j);
					System.out.println("Chunk Generated @ L: " + level.id + " " + i + "," + j);
				}
			}
	}

	public void update(double d) {
		for (Entity go : entities)
			go.update(d);
		for (WorldChunk chunk : getChunkArray())
			chunk.update();
	}

	public ArrayList<WorldChunk> getChunkArray() {
		ArrayList<WorldChunk> result = new ArrayList<WorldChunk>();
		for (WorldChunk[] wca : chunks)
			for (WorldChunk wc : wca)
				result.add(wc);
		return result;
	}

	public WorldChunk[][] getChunks() {
		return chunks;
	}

	public WorldChunk getChunk(int x, int y) {
		return chunks[x][y];
	}

	public void addChunk(WorldChunk chunk) {
		chunks[chunk.x][chunk.y] = chunk;
	}

	public Game getGame() {
		return game;
	}

	public void addEntity(Entity entity) {
		entities.add(entity);
	}

	public void loadChunk(int i, int j) {
		try {
			addChunk((WorldChunk) SLAPI.load("c." + i + "." + j + ".wcs"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void saveChunk(int i, int j) {
		try {
			SLAPI.save(chunks[i][j], "c." + i + "." + j + ".wcs");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getId() {
		return curID++;
	}

	public ArrayList<Entity> getEntities() {
		return entities;
	}

	public void removeEntity(Entity go) {
		entities.remove(go);
	}
}
