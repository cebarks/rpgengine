package net.cebarks.engine.gfx;

import java.io.IOException;
import java.util.logging.Logger;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class Sprite {
	private Texture texture;
	private float scale;

	protected Sprite(String location) {
		this(location, 1F);
	}

	protected Sprite(String location, float scale) {
		try {
			texture = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream(location));
		} catch (IOException e) {
			Logger.getGlobal().severe("Couldn't load texture: " + location);
		} catch (RuntimeException e) {
			Logger.getGlobal().severe("Resource not found: " + location);
		}
		this.scale = 1 / scale;
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
			GL11.glVertex2f(texture.getTextureWidth() / scale, 0);
			GL11.glTexCoord2f(1, 1);
			GL11.glVertex2f(texture.getTextureWidth() / scale, texture.getTextureHeight() / scale);
			GL11.glTexCoord2f(0, 1);
			GL11.glVertex2f(0, texture.getTextureHeight() / scale);
		}
		GL11.glEnd();
		GL11.glPopMatrix();
	}
}
