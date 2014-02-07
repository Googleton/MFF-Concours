package com.gugu42.lwjgl.collision.entity;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

public class Player extends EntityCollideable {

	public Player(int width, int height, int x, int y) {
		super(width, height, x, y);
	}

	public void input(int delta) {
		if (Keyboard.isKeyDown(Keyboard.KEY_Z)) {
			this.position.y += 0.1f * delta;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
			this.position.y -= 0.1f * delta;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_Q)) {
			this.position.x -= 0.1f * delta;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
			this.position.x += 0.1f * delta;
		}
	}

	@Override
	public void init() {
		System.out.println("[PLAYER]I was initialized. And it felt good.");
	}

	@Override
	public void render() {
		GL11.glPushMatrix();
		GL11.glBegin(GL11.GL_QUADS);
		GL11.glColor3f(1, 1, 1f);
		GL11.glVertex2f(this.position.x - 50, this.position.y - 50);
		GL11.glVertex2f(this.position.x + 50, this.position.y - 50);
		GL11.glVertex2f(this.position.x + 50, this.position.y + 50);
		GL11.glVertex2f(this.position.x - 50, this.position.y + 50);
		GL11.glEnd();
		GL11.glPopMatrix();
	}

	@Override
	public void update(int delta) {
		super.update(delta);
		input(delta);
	}

}
