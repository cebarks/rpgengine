package net.cebarks.engine.util;

import java.util.Random;

@SuppressWarnings("serial")
public class XSRandom extends Random {
	/**
	 *
	 */
	private static final long serialVersionUID = 1273864162608516207L;
	private long seed;

	public XSRandom(long seed) {
		this.seed = seed;
	}

	public XSRandom() {
		this(System.nanoTime());
	}

	@Override
	protected int next(int nbits) {
		long x = seed;
		x ^= (x << 21);
		x ^= (x >>> 35);
		x ^= (x << 4);
		seed = x;
		x &= ((1L << nbits) - 1);
		return (int) x;
	}
}
