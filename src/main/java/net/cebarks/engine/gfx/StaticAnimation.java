package net.cebarks.engine.gfx;

public class StaticAnimation extends Animation {
	protected Sprite sprite;

	public StaticAnimation(String spriteLocation, float scale) {
		this.sprite = new Sprite(spriteLocation, scale);
	}

	public StaticAnimation(String spriteLocation) {
		this(spriteLocation, 1F);
	}

	@Override
	public void render(float x, float y) {
		sprite.render(x, y);
	}

	public Sprite getSprite() {
		return sprite;
	}
}
