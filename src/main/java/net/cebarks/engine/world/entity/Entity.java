package net.cebarks.engine.world.entity;

import java.io.Serializable;

import net.cebarks.engine.gfx.Animation;
import net.cebarks.engine.world.World;

public class Entity implements Serializable {
	private static final long serialVersionUID = -5630270584326621892L;
	private float velocityX;
	private float velocityY;
	private float speed;
	private World world;
	public float x;
	public float y;
	private int id;

	public Entity(World world) {
		this.world = world;
		world.addEntity(this);
		this.id = world.getId();
		speed = 1f;
	}

	public void move(int magX, int magY) {
		velocityX += magX * speed;
		velocityY += magY * speed;
	}

	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void update(double d) {
		x += velocityX * d;
		y += velocityY * d;

		velocityX = 0;
		velocityY = 0;
	}

	public void onDeath() {
		getWorld().removeEntity(this);
	}

	public World getWorld() {
		return world;
	}

	public void render() {
		getAnimation().render(x, y);
	}

	public Animation getAnimation() {
		return null;
	}
}
