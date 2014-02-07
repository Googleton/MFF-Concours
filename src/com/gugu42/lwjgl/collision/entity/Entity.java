package com.gugu42.lwjgl.collision.entity;


public interface Entity {
	public float getX();

	public float getY();

	public void setX(float x);

	public void setY(float y);

	public void setLocation(float x, float y);

	public void setUp();

	public void destroy();

	public void draw();
	
	public void moveX(float velocity, long delta);
	
	public void moveY(float velocity, long delta);
	
}
