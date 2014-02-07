package com.gugu42.lwjgl.collision.entity;

import java.util.ArrayList;
import java.util.List;

public class EntityManager {

	//Entity[] entities;
	List<Entity> entities = new ArrayList<Entity>();

	public EntityManager() {

	}

	public void update() {
		for(Entity entity : entities){
			entity.update();
		}
	}

	public void init() {
		for(Entity entity : entities){
			entity.init();
		}
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
