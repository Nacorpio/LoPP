package com.lopp.game.entity;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.lopp.game.handlers.b2d.B2DVars;

public class Entity {

	private String name;
	private int id;
	
	public Vector2 pos;
	public Fixture fix;
	
	private float xSize = B2DVars.DEFAULT_ENTITY_WIDTH;
	private float ySize = B2DVars.DEFAULT_ENTITY_HEIGHT;
	
	private BodyType btype = BodyType.StaticBody;
	
	public Entity(String par1, int par2, BodyType par3) {
		name = par1;
		id = par2;
		btype = par3;
	}
	
	public final String getName() {
		return name;
	}

	public final int getId() {
		return id;
	}
	
	public final BodyType getBodyType() {
		return btype;
	}
	
	public Vector2 getPosition() {
		Vector2 fixvec = fix.getBody().getPosition();
		return new Vector2(fixvec.x, fixvec.y);
	}
	
	public float getXSize() {
		return xSize;
	}
	
	public float getYSize() {
		return ySize;
	}
	
	public void render(SpriteBatch sb, OrthographicCamera cam) {}
	
	public void update(float dt) {
		pos = fix.getBody().getPosition();
	}
	
	public void onObjectCollision(Object par1) {
		
		// If the object is an entity, fire the onEntityCollision event.
		if (par1 instanceof Entity) {
			onEntityCollision((Entity) par1);
		}
		
	}
	
	public void onEntityCollision(Entity par1) {}
	
}
