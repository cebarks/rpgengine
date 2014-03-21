package net.cebarks.engine.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Timer extends Thread {
	private long targetTime;
	private Method method;
	private Object o;
	private Object[] args;

	private Timer(int time, Object object, Method method, Object... args) {
		new Thread(this).start();
		this.method = method;
		this.args = args;
		o = object;
		targetTime = System.currentTimeMillis() + time;
	}

	/**
	 * @param time
	 *            - the time in ms to wait
	 * @param o
	 *            - object the method belongs to
	 * @param m
	 *            - the method to be invoked when timer is up
	 * @param args
	 *            - any arguments to the method
	 */
	public static Timer delayInvoke(int time, Object object, Method method, Object... args) {
		return new Timer(time, object, method, args);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Method getMethod(Object object, String name) {
		Method m = null;

		try {
			if (object instanceof Class) {
				m = ((Class) object).getMethod(name);
			} else {
				m = object.getClass().getMethod(name);
			}
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return m;
	}

	@Override
	public void run() {
		boolean flag = true;
		while (flag) {
			if (System.currentTimeMillis() >= targetTime) {
				try {
					method.invoke(o, args);
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
				flag = false;

			} else {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
