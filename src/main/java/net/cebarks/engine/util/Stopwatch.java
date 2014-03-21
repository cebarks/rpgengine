package net.cebarks.engine.util;

public class Stopwatch {
	private long time = 0;

	public Stopwatch start() {
		time = System.currentTimeMillis();
		return this;
	}

	/**
	 * @return the time in ms since start was called
	 */
	public long stop() {
		return System.currentTimeMillis() - time;
	}
}
