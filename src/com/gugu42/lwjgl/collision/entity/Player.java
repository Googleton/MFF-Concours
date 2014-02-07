package com.gugu42.lwjgl.collision.entity;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

public class Player extends Entity {

	public Player(int width, int height, int x, int y) {
		super(width, height, x, y);
	}

	public void input(int delta) {
		if (Keyboard.isKeyDown(Keyboard.KEY_Z)) {
			float dy = position.y;
			float oldY = position.y;
			dy -= 0.1 * delta;
			if (canGoto(this.position.x, dy * 2))
				this.position.y -= 0.1 * delta;
			else
				this.position.y = oldY;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
			float dy = position.y;
			float oldY = position.y;
			dy += 0.1 * delta;
			if (canGoto(this.position.x, dy))
				this.position.y += 0.1 * delta;
			else
				this.position.y = oldY;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_Q)) {
			float dx = position.x;
			float oldX = position.x;
			dx -= 0.1 * delta;
			if (canGoto(dx, this.position.y))
				this.position.x -= 0.1 * delta;
			else
				this.position.x = oldX;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
			float dx = position.x;
			float oldX = position.x;
			dx += 0.1 * delta;
			if (canGoto(dx, this.position.y))
				this.position.x += 0.1 * delta;
			else
				this.position.x = oldX;
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
		GL11.glVertex2f(this.position.x - (w / 2), this.position.y - (h / 2));
		GL11.glVertex2f(this.position.x + (w / 2), this.position.y - (h / 2));
		GL11.glVertex2f(this.position.x + (w / 2), this.position.y + (h / 2));
		GL11.glVertex2f(this.position.x - (w / 2), this.position.y + (h / 2));
		GL11.glEnd();
		GL11.glPopMatrix();
	}

	@Override
	public void update(int delta) {
		super.update(delta);
		input(delta);

	}

	@Override
	public void onCollide(Entity entity) {
		// System.out.println("[PLAYER] AHHHHHHH IT TOUCHES ME !1!!1!1!1!11!!!1!!1!!");

	}

}
