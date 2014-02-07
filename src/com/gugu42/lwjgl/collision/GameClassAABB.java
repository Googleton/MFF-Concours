package com.gugu42.lwjgl.collision;

import java.awt.Font;

import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.TrueTypeFont;

import com.gugu42.lwjgl.collision.entity.DummyEntity;
import com.gugu42.lwjgl.collision.entity.EntityManager;
import com.gugu42.lwjgl.collision.entity.Player;
import com.gugu42.lwjgl.collision.entity.Tile;

public class GameClassAABB {

	private long lastFrame;
	
	public static World world = new World();

	public static TrueTypeFont font;

	public Player player = new Player(100, 100, 150, 150);
	public DummyEntity dummy = new DummyEntity(100, 100, 280, 280);
	public EntityManager entityManager = new EntityManager();

	public Tile testTile = new Tile(150, 450);
	
	public void start() {
		try {
			Display.setDisplayMode(new DisplayMode(1280, 720));
			Display.setTitle("Collision Test");
			Display.create();
		} catch (LWJGLException e) {
			System.err.println("Display wasn't initialized correctly.");
			System.exit(1);
		}

		Font awtFont = new Font("Times New Roman", Font.BOLD, 24);
		font = new TrueTypeFont(awtFont, false);

		initGL();

		entityManager.registerEntity(player);
		entityManager.registerEntity(dummy);
		entityManager.init();
		world.tiles.add(testTile);
		while (!Display.isCloseRequested()) {
			render();
			update();
			Display.update();
			Display.sync(60);
		}
	}

	public long getTime() {
		return (Sys.getTime() * 1000) / Sys.getTimerResolution();
	}

	public int getDelta() {
		long time = getTime();
		int delta = (int) (time - lastFrame);
		lastFrame = time;
		return delta;
	}

	public void initGL() {
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glShadeModel(GL11.GL_SMOOTH);
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		GL11.glDisable(GL11.GL_LIGHTING);

		GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
		GL11.glClearDepth(1);

		GL11.glViewport(0, 0, 1280, 720);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);

		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, 1280, 720, 0, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
	}

	public void render() {
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
		entityManager.render();
		testTile.render();
	}

	public void update() {
		int delta = getDelta();
		entityManager.update(delta);
	}

	public static void main(String[] args) {
		GameClassAABB game = new GameClassAABB();
		game.start();
	}
}
