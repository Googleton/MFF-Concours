package com.gugu42.lwjgl.collision;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class GameClassAABB {

	public void start(){
		try {
			Display.setDisplayMode(new DisplayMode(1280, 720));
			Display.setTitle("Collision Test");
			Display.create();
		} catch (LWJGLException e) {
			System.err.println("Display wasn't initialized correctly.");
			System.exit(1);
		}
		
		while (!Display.isCloseRequested()) {
			render();
			update();
			Display.update();
			Display.sync(60);
		}
	}
	
	public void render(){
		
	}
	
	public void update(){
		
	}
	

	
	public static void main(String[] args){
		GameClassAABB game = new GameClassAABB();
		game.start();
	}	
}
