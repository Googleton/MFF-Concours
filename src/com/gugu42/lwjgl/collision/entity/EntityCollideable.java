package com.gugu42.lwjgl.collision.entity;

import com.gugu42.lwjgl.collision.utils.AABB;
import com.gugu42.lwjgl.collision.utils.Vector;

public abstract class EntityCollideable extends Entity {

	protected AABB hitbox;
	protected Vector position;
	
	/**
	 * Entity that has a hitbox
	 * 
	 * @param width Size ( X )
	 * @param height Size ( Y )
	 * @param x Spawning location X
	 * @param y Spawning location Y
	 */
	public EntityCollideable(int width, int height, int x, int y) {
		this.hitbox = new AABB(width, height);
		this.position.x = x;
		this.position.y = y;
	}
	
	@Override
	public void update(){
		hitbox.update(position);
	}

}
