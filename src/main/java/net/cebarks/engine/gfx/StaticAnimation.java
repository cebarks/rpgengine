package net.cebarks.engine.gfx;

public class StaticAnimation extends Animation {
	public StaticAnimation(String spriteLocation) {
		addFrame(spriteLocation);
	}

	@Override
	public void render(float x, float y) {
		super.render(x, y);
	}
}
