package net.cebarks.engine.gfx;

import java.io.IOException;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class Sprite {
	private Texture texture;
	private float scale;
	private float width;
	private float height;

	protected Sprite(String location) {
		this(location, 1F);
	}

	protected Sprite(String location, float scale) {
		this(location, scale, -1, -1);
	}

	protected Sprite(String location, float scale, int width, int height) {
		try {
			texture = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream(location));
		} catch (IOException e) {
			System.out.println("Couldn't load texture: " + location);
		} catch (RuntimeException e) {
			System.out.println("Resource not found: " + location);
		}

		if (width == -1 || height == -1) {
			width = texture.getImageWidth();
			height = texture.getImageHeight();
		}

		this.width = width / (1 / scale);
		this.height = height / (1 / scale);
	}

	protected void render(float x, float y) {
		GL11.glPushMatrix();
		texture.bind();
		GL11.glTranslatef(x, y, 0);
		GL11.glBegin(GL11.GL_QUADS);
		{
			GL11.glTexCoord2f(0, 0);
			GL11.glVertex2f(0, 0);
			GL11.glTexCoord2f(1, 0);
			GL11.glVertex2f(width, 0);
			GL11.glTexCoord2f(1, 1);
			GL11.glVertex2f(width, height);
			GL11.glTexCoord2f(0, 1);
			GL11.glVertex2f(0, height);
		}
		GL11.glEnd();
		GL11.glPopMatrix();
	}
}
