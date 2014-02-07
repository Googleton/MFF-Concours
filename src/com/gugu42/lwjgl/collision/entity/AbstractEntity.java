package com.gugu42.lwjgl.collision.entity;

import org.lwjgl.util.Rectangle;

public abstract class AbstractEntity implements Entity {
	protected float x;
	protected float y;
	protected float boundsX;
	protected float boundsY;
	
	protected Rectangle bounds;

	public float getBoundsX() {
		return boundsX;
	}

	public void setBoundsX(float boundsX) {
		this.boundsX = boundsX;
	}

	public float getBoundsY() {
		return boundsY;
	}

	public void setBoundsY(float boundsY) {
		this.boundsY = boundsY;
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public void setX(float x) {
		this.x = x;
	}

	public void setY(float y) {
		this.y = y;
	}

	public void setLocation(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public void moveX(float velocity, long delta) {
		this.setX(this.getX() + (velocity * delta));
	}

	public void moveY(float velocity, long delta) {
		this.setY(this.getY() + (velocity * delta));
	}
	
	public void update(){
		 bounds.setLocation((int)getX(), (int)getY());
	}

	public void setUp(){
		bounds.setBounds((int)getX(), (int)getY(), (int)boundsX, (int)boundsY);
	}

	public abstract void destroy();

	public abstract void draw();
}
