package net.cebarks.engine.gfx;

import java.util.ArrayList;

import net.cebarks.engine.util.Delay;

public class Animation {

	protected ArrayList<Frame> frames;
	protected int index;
	private Delay delay;

	public Animation() {
		frames = new ArrayList<Frame>();
		delay = new Delay(0);
	}

	public Animation addFrame(String spriteLocation, int length) {
		frames.add(new Frame(new Sprite(spriteLocation), length));
		return this;
	}

	public Animation addFrame(String sprite) {
		addFrame(sprite, 30);
		return this;
	}

	public void render(float x, float y) {
		if (delay.over()) {
			index++;
			if (index >= frames.size()) {
				index = 0;
			}
			delay = new Delay(frames.get(index).getLength());
		}

		frames.get(index).render(x, y);
	}
}

class Frame {
	private Sprite sprite;
	private int length;

	public Frame(Sprite sprite2, int length) {
		sprite = sprite2;
		this.length = length;
	}

	public void render(float x, float y) {
		sprite.render(x, y);
	}

	public int getLength() {
		return length;
	}
}
