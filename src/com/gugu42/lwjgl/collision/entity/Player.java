package com.gugu42.lwjgl.collision.entity;

public class Player extends EntityCollideable {

	public Player(int width, int height, int x, int y) {
		super(width, height, x, y);
	}

	@Override
	public void init() {
		System.out.println("AABB : Size : X : " + this.hitbox.r[0] + " Y : " + this.hitbox.r[1]);
	}

	@Override
	public void render() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

}
