package com.gugu42.lwjgl.collision.entity;

import java.util.List;

import org.lwjgl.opengl.GL11;

import com.gugu42.lwjgl.collision.World;
import com.gugu42.lwjgl.collision.utils.Vector;

public class Tile {

	public static int TILE_WIDTH = 16;
	public static int TILE_HEIGHT = 16;

	public Vector position = new Vector();

	public boolean isSolid;

	public Tile(int x, int y) {
		this.position.x = x;
		this.position.y = y;
		this.isSolid = true;
	}

	public void render() {
		GL11.glPushMatrix();
		GL11.glBegin(GL11.GL_QUADS);
		GL11.glColor3f(0f, 1, 1f);
		GL11.glVertex2f(this.position.x - (TILE_WIDTH / 2), this.position.y - (TILE_HEIGHT / 2));
		GL11.glVertex2f(this.position.x + (TILE_WIDTH / 2), this.position.y - (TILE_HEIGHT / 2));
		GL11.glVertex2f(this.position.x + (TILE_WIDTH / 2), this.position.y + (TILE_HEIGHT / 2));
		GL11.glVertex2f(this.position.x - (TILE_WIDTH / 2), this.position.y + (TILE_HEIGHT / 2));
		GL11.glEnd();
		GL11.glPopMatrix();
	}

	public void init() {

	}

	public boolean isSolid() {
		return isSolid;
	}

	public void setSolid(boolean isSolid) {
		this.isSolid = isSolid;
	}

	public static Tile getTileAt(int x, int y, World world) {
		List<Tile> tiles = world.tiles;
		for (int i = 0; i < tiles.size(); i++) {
			if (tiles.get(i).position.x == x && tiles.get(i).position.y == y) {
				return tiles.get(i);
			}
		}
		return null;
	}

	public static Tile getTile(Tile tileAt) {
		return tileAt;
	}

}
