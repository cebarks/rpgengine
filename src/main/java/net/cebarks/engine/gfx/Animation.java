package net.cebarks.engine.gfx;

import java.util.ArrayList;

public class Animation {

	private ArrayList<Frame> frames;
	private int index;

	public Animation() {
		frames = new ArrayList<Frame>();
	}

	public void addFrame(String spriteLocation, int length) {
		frames.add(new Frame(new Sprite(spriteLocation), length));
	}

	public void addFrame(String sprite) {
		addFrame(sprite, 30);
	}

	public void render(float x, float y) {
		if (frames.get(index).render(x, y))
			index++;
	}
}

class Frame {
	private Sprite sprite;

	private int length;
	private int curLength;

	public Frame(Sprite sprite2, int length) {
		sprite = sprite2;
		this.length = length;
	}

	public boolean render(float x, float y) {
		if (curLength >= length) {
			curLength = 0;
			return true;
		}

		sprite.render(x, y);
		curLength++;
		return false;
	}
}
