package com.lopp.game.entity;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.lopp.game.handlers.input.MyInput;
import com.lopp.game.inventory.Inventory;
import com.lopp.game.states.GameStatePlay;

public class EntityPlayer extends Entity {

	private String displayName = getName();
	
	private float walkSpeedX = 5;
	private float walkSpeedY = -5;
	
	private float jumpHeight = 100;
	private float health = 100;

	private boolean isCrouching = false;
	
	//
	
	private Inventory inventory;
	
	public EntityPlayer() {
		super("player", 0, BodyType.DynamicBody);
	}

	public String getDisplayName() {
		return displayName;
	}
	
	public float getWalkSpeedX() {
		return walkSpeedX;
	}
	
	public float getWalkSpeedY() {
		return walkSpeedY;
	}
	
	public float getJumpHeight() {
		return jumpHeight;
	}
	
	public Vector2 getPosition() {
		return pos;
	}
	
	public float getHealth() {
		return health;
	}
	
	@Override
	public final void update(float dt) {
		while (isCrouching) {
			Body body = fix.getBody();
			body.destroyFixture(body.getFixtureList().first());
			GameStatePlay.worldr.renderPlayer(this, pos);
		}
	}
	
	@Override
	public final void render(SpriteBatch sb, OrthographicCamera cam) {
		
	}
	
	public final void handleKeys() {
		
		if (MyInput.isDown(MyInput.BUTTON6)) {
			isCrouching = true;
		}
		
		if (MyInput.isDown(MyInput.BUTTON1)) {
			fix.getBody().applyForceToCenter(7.5f, 0, true);
		}
		
		if (MyInput.isDown(MyInput.BUTTON2)) {
			fix.getBody().applyForceToCenter(-7.5f, 0, true);
			
		}
		
		if (MyInput.isDown(MyInput.BUTTON4)) {
			
		}
		
		if (MyInput.isDown(MyInput.BUTTON3)) {
			if (GameStatePlay.cl.isPlayerOnGround()) {
				fix.getBody().applyForceToCenter(0, 75, true);
			}
		}
		
	}
	
}
