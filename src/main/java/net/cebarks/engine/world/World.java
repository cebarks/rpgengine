package net.cebarks.engine.world;

import java.util.ArrayList;
import java.util.List;

import net.cebarks.engine.Game;

public class Level {
	private Game game;
	private WorldStorage worldStorage;
	private List<GameObject> gameObjects;

	public Level(Game game) {
		this.game = game;
		worldStorage = new WorldStorage(this);
		gameObjects = new ArrayList<GameObject>();
	}

	public void generate() {

	}

	public void update(double d) {
		for (GameObject go : gameObjects)
			go.update(d);
	}

	public Game getGame() {
		return game;
	}

	public void addGameObject(GameObject gameObject) {
		gameObjects.add(gameObject);
	}

	public WorldStorage getWorldStorage() {
		return worldStorage;
	}
}
