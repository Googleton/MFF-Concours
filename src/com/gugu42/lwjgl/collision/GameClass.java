package com.gugu42.lwjgl.collision;

import java.util.HashSet;
import java.util.Set;

import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;
import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

import com.gugu42.lwjgl.collision.entity.Box2D;
import com.gugu42.lwjgl.collision.entity.Entity;

public class GameClass {

	
	private static long lastFrame;
	public Entity box = new Box2D(30.0f, 50.0f, 25.0f);

	private static World world = new World(new Vec2(0, -9.8f));
	private static Set<Body> bodies = new HashSet<Body>();
	
	
	public void start() {

		init();
		initGL();
		setUpObjects();
		lastFrame = getTime();
		while (!Display.isCloseRequested()) {
			render();
			update();
			Display.update();
			Display.sync(60);
		}

		Display.destroy();
		box.destroy();
	}

	public void init() {
		try {
			Display.setDisplayMode(new DisplayMode(1280, 720));
			Display.setTitle("Collision Test");
			Display.create();
		} catch (LWJGLException e) {
			System.err.println("Display wasn't initialized correctly.");
			System.exit(1);
		}
		box.setUp();
	}

	public void initGL() {
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, 640, 0, 380, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
	}

	private static void setUpObjects(){
		BodyDef boxDef = new BodyDef();
		boxDef.position.set(640/30/2, 380/30/2);
		boxDef.type = BodyType.DYNAMIC;
		PolygonShape boxShape = new PolygonShape();
		boxShape.setAsBox(0.75f, 0.75f);
		Body box = world.createBody(boxDef);
		FixtureDef boxFixture = new FixtureDef();
		boxFixture.density = 0.1f;
		boxFixture.shape = boxShape;
		box.createFixture(boxFixture);
		bodies.add(box);
		
		BodyDef groundDef = new BodyDef();
		groundDef.position.set(0, 0);
		groundDef.type = BodyType.STATIC;
		PolygonShape groundShape = new PolygonShape();
		groundShape.setAsBox(1000, 0);
		Body ground = world.createBody(groundDef);
		FixtureDef groundFixture = new FixtureDef();
		groundFixture.density = 1f;
		groundFixture.restitution = 0.3f;
		groundFixture.shape = groundShape;
		ground.createFixture(groundFixture);
		bodies.add(ground);
	}
	
	public void render() {
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
		for (Body body : bodies){
			if(body.getType() == BodyType.DYNAMIC){
				GL11.glPushMatrix();
				Vec2 bodyPosition = body.getPosition().mul(30);
				GL11.glTranslatef(bodyPosition.x, bodyPosition.y, 0);
				GL11.glRotated(Math.toDegrees(body.getAngle()), 0, 0, 1);
				GL11.glRectf(-0.75f * 30, -0.75f * 30, 0.75f * 30, 0.75f * 30);
				GL11.glPopMatrix();
			}
		}
		

	}
	
	public void update(){
		long delta = (long) getDelta();
		input(delta);
		
		world.step(1/60f, 8, 3);
	}
	
	public void input(long delta) {
		
		for(Body body : bodies){
			if(body.getType() == BodyType.DYNAMIC){
				if(Keyboard.isKeyDown(Keyboard.KEY_Q) && !Keyboard.isKeyDown(Keyboard.KEY_D)){
					body.applyAngularImpulse(0.01f);
				} 
				if (Keyboard.isKeyDown(Keyboard.KEY_D) && !Keyboard.isKeyDown(Keyboard.KEY_Q)){
					body.applyAngularImpulse(-0.01f);
				}
				
				if(Mouse.isButtonDown(0)){
					Vec2 mousePosition = new Vec2(Mouse.getX(), Mouse.getY()).mul(0.5f).mul(1/30f);
					Vec2 bodyPosition = body.getPosition();
					Vec2 force = mousePosition.sub(bodyPosition);
					body.applyForce(force, body.getPosition());
				}
			}
		}
		
		
	}

	private static long getTime() {
		return (Sys.getTime() * 1000) / Sys.getTimerResolution();
	}

	private static double getDelta() {
		long currentTime = getTime();
		double delta = (double) currentTime - (double) lastFrame;
		lastFrame = getTime();
		return delta;
	}

	public static void main(String[] args) {
		GameClass game = new GameClass();
		game.start();
	}
}
