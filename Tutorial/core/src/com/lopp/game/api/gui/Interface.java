package com.lopp.game.api.gui;

import static com.lopp.game.handlers.b2d.B2DVars.PPM;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.lopp.game.Game;
import com.lopp.game.api.Tickable;
import com.lopp.game.handlers.b2d.B2DVars;
import com.lopp.game.states.GameStatePlay;

public class Interface implements Tickable {

	public Fixture fix;
	
	private String title;
	
	private float height;
	private float width;
	
	protected float x = 500;
	protected float y = 500;
	
	public Interface(String par1, float par2, float par3) {
		
		title = par1;
		height = par2;
		width = par3;
		
	}
	
	public final String getTitle() {
		return title;
	}
	
	public final float getHeight() {
		return height;
	}
	
	public final float getWidth() {
		return width;
	}
	
	public final Vector2 getPosition() {
		return new Vector2(x, y);
	}
	
	public final void hide() {
		if (fix != null) {
			GameStatePlay.world.destroyBody(fix.getBody());
		}
	}
	
	//
	
	public String getTextureName() { return ""; }
	
	//
	
	public void onMouseHover(int x, int y) {}
	
	public void onMouseLeftClick(int x, int y) {}
	
	public void onMouseRightClick(int x, int y) {}

	@Override
	public void render(SpriteBatch bs, OrthographicCamera cam) {}

	@Override
	public void update(float dt) {
		
		BodyDef bdef = new BodyDef();
		FixtureDef fdef = new FixtureDef();
		PolygonShape shape = new PolygonShape();
		
		bdef.type = BodyType.StaticBody;
		bdef.position.set(x / PPM, y / PPM);
		
		Body body = GameStatePlay.world.createBody(bdef);
		shape.setAsBox(width / PPM, height / PPM);
		
		fdef.shape = shape;
		fdef.filter.categoryBits = B2DVars.BIT_INTERFACE;
		fdef.filter.maskBits = -1;
		
		Fixture fix = body.createFixture(fdef);
		fix.setUserData(this);
		
		this.fix = fix;
	
		Game.sb.setProjectionMatrix(Game.cam.combined);
			
		Game.sb.begin();
		Game.sb.draw(GameStatePlay.res.getTexture("gui_template"), x * PPM - width / 2, y * PPM - height / 2, width, height);
		Game.sb.end();
		
	}

	@Override
	public boolean queuedForUpdate() {
		return false;
	}
	
}
