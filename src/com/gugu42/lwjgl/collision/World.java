package com.gugu42.lwjgl.collision;

import java.util.ArrayList;
import java.util.List;

import com.gugu42.lwjgl.collision.entity.Entity;
import com.gugu42.lwjgl.collision.entity.Tile;

public class World {
	//World contains entities, tiles etc...
	
	public List<Entity> entities = new ArrayList<Entity>();
	public List<Tile> tiles = new ArrayList<Tile>();
	
	public World(){
		init();
	}
	
	public void init(){
		
	}
	
	public void addEntity(Entity entity){
		entities.add(entity);
	}
	
	public Tile getTileAt(int x, int y){
		return Tile.getTileAt(x, y, this);
	}
	
}
