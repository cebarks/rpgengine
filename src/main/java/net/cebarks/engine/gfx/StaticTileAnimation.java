package net.cebarks.engine.gfx;

public class StaticTileAnimation extends TileAnimation {
	protected Sprite sprite;

	public StaticTileAnimation(String spriteLocation) {
		this.sprite = new Sprite(spriteLocation, 1F, 32, 32);
	}

	@Override
	public void render(float x, float y) {
		sprite.render(x, y);
	}

	public Sprite getSprite() {
		return sprite;
	}
}
