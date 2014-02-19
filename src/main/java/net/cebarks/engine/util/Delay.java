package net.cebarks.engine.util;

public class Delay {

	private int goal;
	private long startTime;

	public Delay(int delay) {
		goal = delay;
	}

	public void start() {
		startTime = Time.getTime();
	}

	public boolean over() {
		return (Time.getTime() >= (startTime + goal));
	}
}
