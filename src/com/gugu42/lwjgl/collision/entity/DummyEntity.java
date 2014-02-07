package com.gugu42.lwjgl.collision.entity;

import org.lwjgl.opengl.GL11;

public class DummyEntity extends EntityCollideable {

	public DummyEntity(int width, int height, int x, int y) {
		super(width, height, x, y);
	}

	@Override
	public void init() {

	}

	@Override
	public void render() {
		GL11.glPushMatrix();

		GL11.glBegin(GL11.GL_QUADS);
		GL11.glColor3f(1, 1, 0.1f);
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

	}

}
