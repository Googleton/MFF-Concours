package com.gugu42.lwjgl.collision.entity;

import static org.lwjgl.opengl.GL11.GL_TRIANGLES;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2f;

public class Box2D extends AbstractEntity {
	protected float size;

	public Box2D(float x, float y, float size) {
		this.x = x;
		this.y = y;
		this.boundsX = size;
		this.boundsY = size;
		this.size = size;
	}

	public Box2D() {
		this.x = this.y = this.size = this.boundsX = this.boundsY = 0;
	}

	@Override
	public void setUp() {
	}

	@Override
	public void destroy() {
	}
	
	@Override
	public void draw() {
		glBegin(GL_TRIANGLES);
		glVertex2f(x + size / 2, y + size / 2);
		glVertex2f(x + size / 2, y - size / 2);
		glVertex2f(x - size / 2, y - size / 2);
		glVertex2f(x - size / 2, y - size / 2);
		glVertex2f(x - size / 2, y + size / 2);
		glVertex2f(x + size / 2, y + size / 2);
		glEnd();
	}

}