package com.gugu42.lwjgl.collision.entity;

import java.util.ArrayList;
import java.util.List;

import com.gugu42.lwjgl.collision.GameClassAABB;
import com.gugu42.lwjgl.collision.World;

public class EntityManager {

	// Entity[] entities;
	List<Entity> entities = new ArrayList<Entity>();
	public World world = GameClassAABB.world;

	public EntityManager() {

	}

	public void update(int delta) {
		for (Entity entity : entities) {
			entity.update(delta);
		}
	}

	public void init() {
		for (Entity entity : entities) {
			entity.init();
		}
	}

	public void render() {
		for (Entity entity : entities) {
			entity.render();
		}
	}

	public void registerEntity(Entity entity) {
		entities.add(entity);
		world.addEntity(entity);
	}

}
