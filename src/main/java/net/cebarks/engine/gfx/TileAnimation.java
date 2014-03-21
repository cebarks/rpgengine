package net.cebarks.engine.gfx;

public class TileAnimation extends Animation {

	@Override
	public Animation addFrame(String spriteLocation, int length) {
		frames.add(new Frame(new Sprite(spriteLocation, 1f, 32, 32), length));
		return this;
	}
}
