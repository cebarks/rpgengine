package net.cebarks.engine;

import java.util.logging.Logger;

import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

public class GameWrapper implements Runnable {

	private boolean running;
	private Game game;
	private long lastFrame;
	private long lastFPS;
	private int fps;
	private int frames;
	private int targetFPS;

	public GameWrapper(Game game) {
		this.game = game;
		game.setGameWrapper(this);
		targetFPS = -1;
	}

	public void setWindowSize(int x, int y) {
		try {
			Display.setDisplayMode(new DisplayMode(x, y));
		} catch (LWJGLException e) {
			Logger.getGlobal().severe(e.getMessage());
		}
	}

	public void setTargetFPS(int fps) {
		targetFPS = fps;
	}

	@Override
	public void run() {
		initGL();

		lastFPS = getTime();
		updateFPS();
		game.init(this);

		while (running) {
			update();
			render();
		}

		Display.destroy();
		Keyboard.destroy();
		Mouse.destroy();
	}

	public void render() {
		game.render();
		nextFrame();
	}

	public void update() {
		game.update(getDelta());
		updateFPS();
		if (Display.isCloseRequested())
			running = false;
	}

	public void nextFrame() {
		Display.setTitle(game.getTitle());
		Display.update();
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
		if (!(targetFPS <= 0))
			Display.sync(targetFPS);
	}

	private void initGL() {
		try {
			Display.setDisplayMode(new DisplayMode(800, 600));
			Display.create();
		} catch (LWJGLException e) {
			Logger.getGlobal().severe("Couldn't instansiate the Display: " + e.getMessage());
			System.exit(1);
		}

		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glClearColor(0f, 0f, 0f, 0f);

		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

		GL11.glViewport(0, 0, Display.getWidth(), Display.getHeight());
		GL11.glMatrixMode(GL11.GL_MODELVIEW);

		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, Display.getWidth(), Display.getHeight(), 0, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
	}

	public double getDelta() {
		long time = getTime();
		double delta = (time - lastFrame);
		lastFrame = time;
		return delta / 15;
	}

	public long getTime() {
		return (Sys.getTime() * 1000) / Sys.getTimerResolution();
	}

	private void updateFPS() {
		if (getTime() - lastFPS > 1000) {
			fps = frames;
			frames = 0;
			lastFPS += 1000;
		}
		frames++;
	}

	public int getFPS() {
		return fps;
	}

	public void setVsync(boolean vsync) {
		Display.setVSyncEnabled(vsync);
	}

	public void start() {
		running = true;
		new Thread(this).start();
	}
}
