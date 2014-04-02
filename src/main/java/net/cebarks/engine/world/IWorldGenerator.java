package net.cebarks.engine.world;

public interface IWorldGenerator {
	public WorldChunk generate(EnumWorldLevel level, int x, int y);
}
