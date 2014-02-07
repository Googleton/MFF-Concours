package com.gugu42.lwjgl.collision.entity;

import java.util.ArrayList;
import java.util.List;

import com.gugu42.lwjgl.collision.utils.CollisionLibrary;

public class EntityManager {

	//Entity[] entities;
	List<Entity> entities = new ArrayList<Entity>();

	public EntityManager() {

	}

	public void update(int delta) {
		for(Entity entity : entities){
			entity.update(delta);
		}
	}

	public void init() {
		for(Entity entity : entities){
			entity.init();
		}
	}
	
	public boolean collisionCheck(){
		for(Entity entity : entities){
			for(Entity entity2 : entities){
				if(entity != entity2){
					if(entity instanceof EntityCollideable && entity2 instanceof EntityCollideable){
						EntityCollideable ent1 = (EntityCollideable)entity;
						EntityCollideable ent2 = (EntityCollideable)entity;
						return CollisionLibrary.testAABBAABB(ent1.hitbox, ent2.hitbox);
					}
					
				}
			}
		}
		return false;
	}

	public void render() {
		for(Entity entity : entities){
			entity.render();
		}
	}

	
	public void registerEntity(Entity entity){
		entities.add(entity);
	}
	
}
