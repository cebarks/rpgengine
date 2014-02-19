package net.cebarks.engine.util;

import org.lwjgl.Sys;

public class Time {

	public static long curTime;
	public static long lastTime;

	public static long getTime() {
		return ((Sys.getTime() * 1000) / Sys.getTimerResolution());
	}

	public static long getDelta() {
		return curTime - lastTime;
	}

	public static void updateTime() {
		lastTime = curTime;
		curTime = getTime();
	}

	public static void init() {
		lastTime = getTime();
		curTime = getTime();
	}
}
