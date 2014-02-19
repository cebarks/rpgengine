package net.cebarks.engine;

import java.util.Random;
import java.util.logging.Logger;

import net.cebarks.engine.util.XSRandom;

public abstract class Game {
	private String title;
	private Random random;
	private GameWrapper wrapper;

	public Game(String title) {
		this.title = title;
		random = new XSRandom();
	}

	public abstract void init(GameWrapper wrapper);

	public abstract void render();

	public abstract void update(double d);

	protected void setGameWrapper(GameWrapper wrapper) {
		this.wrapper = wrapper;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String newTitle) {
		title = newTitle;
	}

	public Random getRandom() {
		return random;
	}

	public int getFPS() {
		return wrapper.getFPS();
	}

	public Logger getLogger() {
		return Logger.getGlobal();
	}
}
