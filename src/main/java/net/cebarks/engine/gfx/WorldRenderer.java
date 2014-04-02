package net.cebarks.engine.gfx;

import net.cebarks.engine.world.World;
import net.cebarks.engine.world.WorldChunk;
import net.cebarks.engine.world.entity.Entity;

public class WorldRenderer {

	private World world;

	public WorldRenderer(World world) {
		this.world = world;
	}

	public void render() {
		for (WorldChunk chunk : world.getChunkArray()) {
			chunk.renderBackground();
		}

		for (Entity e : world.getEntities())
			e.render();

		for (WorldChunk chunk : world.getChunkArray()) {
			chunk.renderForeground();
		}
	}
}
