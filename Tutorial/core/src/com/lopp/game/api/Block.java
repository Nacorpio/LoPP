package com.lopp.game.api;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.lopp.game.Game;
import com.lopp.game.block.BlockAir;
import com.lopp.game.handlers.b2d.B2DVars;
import com.lopp.game.states.GameStatePlay;

public class Block {

	private String name;
	private int id;
	
	private float friction = 1f;
	private float density = 0;
	
	public Vector2 position;
	
	public Fixture fix;
	public short bitCat;
	
	public Block(String par1, int par2, short par3) {
		name = par1;
		id = par2;
		bitCat = par3;
		init();
	}
	
	public final String getName() {
		return name;
	}
	
	public final float getDensity() {
		return density;
	}
	
	public final float getFriction() {
		return friction;
	}
	
	public final int getId() {
		return id;
	}
	
	public int getImageIndex() {
		return 0;
	}
	
	public final void setDensity(float par1) { density = par1; }
	public final void setFriction(float par1) { friction = par1; }
	
	public void onEntityCollide(Object par1) {}
	
	public void onObjectCollide(Object par1) {}
	
	public void onLeftClickDown() {}
	
	public void onLeftClickUp() {}
	
	public void update(float dt) {}
	
	public void init() {}
	
	public void render(SpriteBatch sb, OrthographicCamera cam) {

		if (fix != null && (!(this instanceof BlockAir))) {
			
			Body body = fix.getBody();
			TextureRegion[][] texreg = TextureRegion.split(GameStatePlay.res.getTexture("blocks"), 32, 32);
			
			Game.sb.setProjectionMatrix(Game.cam.combined);
			
			Game.sb.begin();
			Game.sb.draw(texreg[0][getImageIndex()], body.getPosition().x * B2DVars.PPM - 32 / 2, body.getPosition().y * B2DVars.PPM - 32 / 2);
			Game.sb.end();

		}
		
	}
	
}
