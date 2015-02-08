package com.lopp.game.visual;

import static com.lopp.game.handlers.b2d.B2DVars.PPM;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.Shape;

public class Rect {

	public static enum TYPE {
		STATIC,
		DYNAMIC;
	}
	
	public BodyDef bdef;
	
	public TYPE type = TYPE.STATIC;
	
	public float hx, hy;
	
	public Rect(float hx, float hy, TYPE type) {
	
		this.hx = hx / PPM;
		this.hy = hy / PPM;
		this.type = type;
		
		bdef = new BodyDef();
		bdef.type = (type == TYPE.STATIC ? BodyType.StaticBody : BodyType.DynamicBody);
		
	}
	
}
