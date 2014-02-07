package com.gugu42.lwjgl.collision;

import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

import com.gugu42.lwjgl.collision.entity.DummyEntity;
import com.gugu42.lwjgl.collision.entity.EntityManager;
import com.gugu42.lwjgl.collision.entity.Player;

public class GameClassAABB {

	private long lastFrame;
	
	public Player player = new Player(10, 10, 150, 150);
	public DummyEntity dummy = new DummyEntity(10, 10, 280, 280);
	public EntityManager entityManager = new EntityManager();

	public void start() {
		try {
			Display.setDisplayMode(new DisplayMode(1280, 720));
			Display.setTitle("Collision Test");
			Display.create();
		} catch (LWJGLException e) {
			System.err.println("Display wasn't initialized correctly.");
			System.exit(1);
		}

		initGL();

		entityManager.registerEntity(player);
		entityManager.registerEntity(dummy);
		entityManager.init();
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
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, 1280, 0, 720, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
	}

	public void render() {
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
		entityManager.render();
	}

	public void update() {
		int delta = getDelta();
		entityManager.update(delta);
		if(entityManager.collisionCheck()){
			//System.out.println("Collision !");
		}
	}

	public static void main(String[] args) {
		GameClassAABB game = new GameClassAABB();
		game.start();
	}
}
