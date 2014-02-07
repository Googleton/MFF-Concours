package com.gugu42.lwjgl.collision.entity;

import java.util.ArrayList;
import java.util.List;

import com.gugu42.lwjgl.collision.GameClassAABB;
import com.gugu42.lwjgl.collision.World;
import com.gugu42.lwjgl.collision.utils.AABB;
import com.gugu42.lwjgl.collision.utils.Vector;

public abstract class Entity {

	protected World world = GameClassAABB.world;
	protected Vector position = new Vector();
	protected float w;
	protected float h;

	protected AABB aabb;

	public boolean noclip = false;

	protected List<Entity> alreadyCollisionsChecked = new ArrayList<Entity>();

	public Entity(int width, int height, int x, int y) {
		this.aabb = new AABB(x, y, width, height);
		this.w = width;
		this.h = height;
		this.position.x = x;
		this.position.y = y;
	}

	public abstract void init();

	public abstract void render();

	public void update(int delta) {
		aabb.setX(this.position.x);
		aabb.setY(this.position.y);
		if (!noclip) {
			this.checkCollisions();
		}
	}

	public abstract void onCollide(Entity entity);

	public AABB clipAABB() {
		return aabb.set(this.position.x, this.position.y, w, h);
	}

	public void checkCollisions() {
		for (int i = 0; i < world.entities.size(); i++) {
			Entity e = world.entities.get(i);
			if (e != this)
				if (e != null && !alreadyCollisionsChecked.contains(e)) {
					if (e.clipAABB().collide(clipAABB())) {
						e.onCollide(this);
						this.onCollide(e);
					}
					e.alreadyCollisionsChecked.add(this);
				}
		}
		// doBlockCollisions();
		alreadyCollisionsChecked.clear();
	}

	public boolean canGoto(float posX, float posY) {
		if (!noclip)
			for (int x1 = 0; x1 < w; x1++) {
				for (int y1 = 0; y1 < h; y1++) {
					float px = ((float) x1 + posX) / Tile.TILE_WIDTH;
					float py = ((float) y1 + posY) / Tile.TILE_HEIGHT;

					int gridX = (int) (px >= 0 ? Math.floor(px) : Math
							.floor(px));
					int gridY = (int) (py);
					Tile t = Tile.getTile(world.getTileAt(gridX, gridY));
					if(t == null){
						return true;
					}
					if (t!= null && t.isSolid())
						return false;
				}
			}
		return true;
	}
}