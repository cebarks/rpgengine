package net.cebarks.engine.gfx;

import net.cebarks.engine.world.Level;
import net.cebarks.engine.world.WorldChunk;

import org.lwjgl.opengl.GL11;

public class LevelRenderer {

	private Level level;

	public LevelRenderer(Level level) {
		this.level = level;
	}

	public void render() {
		GL11.glPushMatrix();
		for (WorldChunk chunk : level.getWorldStorage().getChunks())
			for (int x = 0; x < 16; x++)
				for (int y = 0; y < 16; y++)
					chunk.getTile(x, y).render(x * 32, y * 32);
		GL11.glPopMatrix();
	}
}
