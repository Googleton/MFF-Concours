package com.gugu42.lwjgl.collision.entity;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

public class Player extends Entity {

	public Player(int width, int height, int x, int y) {
		super(width, height, x, y);
	}

	public void input(int delta) {
		if (Keyboard.isKeyDown(Keyboard.KEY_Z)) {
			this.position.y -= 0.1 * delta;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
			if(canGoto(this.position.x, this.position.y += 0.1*delta))
			this.position.y += 0.1 * delta;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_Q)) {
			this.position.x -= 0.1 * delta;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
			this.position.x += 0.1 * delta;

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
//		System.out.println("[PLAYER] AHHHHHHH IT TOUCHES ME !1!!1!1!1!11!!!1!!1!!");
		
	}

}
