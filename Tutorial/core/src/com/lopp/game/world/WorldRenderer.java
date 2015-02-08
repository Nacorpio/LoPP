package com.lopp.game.world;

import static com.lopp.game.handlers.b2d.B2DVars.PPM;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.ChainShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.lopp.game.Game;
import com.lopp.game.api.Block;
import com.lopp.game.api.gui.Interface;
import com.lopp.game.block.BlockAir;
import com.lopp.game.block.movable.BlockMovable;
import com.lopp.game.entity.Entity;
import com.lopp.game.entity.EntityPlayer;
import com.lopp.game.handlers.b2d.B2DVars;
import com.lopp.game.states.GameStatePlay;
import com.lopp.game.visual.Rect;

public class WorldRenderer {

	private World world;
	
	public WorldRenderer(World par1) {
		world = par1;
	}
	
	public final Fixture renderInterface(Interface par1, Vector2 par2) {
		
		BodyDef bdef = new BodyDef();
		FixtureDef fdef = new FixtureDef();
		PolygonShape shape = new PolygonShape();
		
		bdef.type = BodyType.StaticBody;
		bdef.position.set(par2.x / PPM, par2.y / PPM);
		
		Body body = world.createBody(bdef);
		shape.setAsBox(par1.getWidth() / PPM, par1.getHeight() / PPM);
		
		fdef.shape = shape;
		fdef.filter.categoryBits = B2DVars.BIT_INTERFACE;
		fdef.filter.maskBits = -1;
		
		Fixture fix = body.createFixture(fdef);
		fix.setUserData(par1);
		
		par1.fix = fix;
		
		//
		
		return fix;
		
	}
	
	public final Fixture renderPlayer(EntityPlayer par1, Vector2 par2) {
		
		Fixture entity = renderEntity(par1, par2);
		PolygonShape pol = new PolygonShape();
		FixtureDef fdef = new FixtureDef();
		
		pol.setAsBox((B2DVars.DEFAULT_ENTITY_WIDTH - 2) / PPM, 2 / PPM, new Vector2(0, -45 / PPM), 0);
		fdef.shape = pol;
		fdef.filter.categoryBits = B2DVars.BIT_PLAYER;
		fdef.filter.maskBits = B2DVars.BIT_GROUND;
		fdef.isSensor = true;
		
		Fixture fix = entity.getBody().createFixture(fdef);
		fix.setUserData("foot");
		
		return fix;
		
	}
	
	public final Fixture renderEntity(Entity par1, Vector2 par2) {
		
		BodyDef bdef = new BodyDef();
		FixtureDef fdef = new FixtureDef();
		
		bdef.type = par1.getBodyType();
		bdef.position.set(new Vector2(par2.x / B2DVars.PPM, par2.y / B2DVars.PPM));
		
		Body body = world.createBody(bdef);
		
		PolygonShape shape = new PolygonShape();
		shape.setAsBox(par1.getXSize() / B2DVars.PPM , par1.getYSize() / B2DVars.PPM);
		
		fdef.shape = shape;
		fdef.filter.categoryBits = B2DVars.BIT_PLAYER;
		fdef.filter.maskBits = B2DVars.BIT_PLAYER | B2DVars.BIT_GROUND;
		
		Fixture fix = body.createFixture(fdef);
		par1.fix = fix;
		
		fix.setUserData(par1);
		
		return fix;
		
	}
	
	public final void resetPlayer(EntityPlayer par1) {
		if (par1.fix != null) {
			par1.fix.getBody().destroyFixture(par1.fix.getBody().getFixtureList().first());
		}
	}
	
	public final void clearWorld(BlockWorld par1) {
		
		for (int y = 0; y < B2DVars.MAP_SIZE; y++) {
			for (int x = 0; x < B2DVars.MAP_SIZE; x++) {
				
				Block block = par1.getBlock(x, y);
				
				if (block.fix != null) {
					world.destroyBody(block.fix.getBody());
				}
				
			}
		}
		
	}
	
	public final void renderWorld(BlockWorld par1) {
		
		clearWorld(par1);
		
		for (int row = 0; row < B2DVars.MAP_SIZE; row++) {
			for (int col = 0; col < B2DVars.MAP_SIZE; col++) {
				
				int blockSize = (int) B2DVars.BLOCK_SIZE;
				Block block = par1.getBlock(col, row);
				
				block.init();
				
				// Check if it exists
				if (block == null) continue;
				if (block instanceof BlockAir) continue;
				
				// Create body
				BodyDef bdef = new BodyDef();
				FixtureDef fdef = new FixtureDef();
				
				if (block instanceof BlockMovable) {
					bdef.type = BodyType.DynamicBody;
				} else {
					bdef.type = BodyType.StaticBody;
				}
				
				bdef.position.set(
					(col + 0.5f) * blockSize / PPM,
					(row + 0.5f) * blockSize / PPM
				);
				
				ChainShape cs = new ChainShape();
				Vector2[] v = new Vector2[5];
				
				v[0] = new Vector2(-blockSize / 2 / PPM, -blockSize / 2 / PPM);
				v[1] = new Vector2(-blockSize / 2 / PPM, blockSize / 2 / PPM);
				v[2] = new Vector2(blockSize / 2 / PPM, blockSize / 2 / PPM);
				v[3] = new Vector2(blockSize / 2 / PPM, -blockSize / 2 / PPM);
				v[4] = new Vector2(-blockSize / 2 / PPM, -blockSize / 2 / PPM);
				
				cs.createChain(v);
				
				fdef.friction = block.getFriction();
				fdef.density = block.getDensity();
				
				fdef.shape = cs;
				
				fdef.filter.categoryBits = B2DVars.BIT_GROUND;
				fdef.filter.maskBits = B2DVars.BIT_PLAYER | B2DVars.BIT_GROUND;
				
				if (block instanceof BlockAir) {
					fdef.isSensor = true;
					fdef.filter.categoryBits = B2DVars.BIT_AIR_BLOCK;
					fdef.filter.maskBits = -1;
				} else {
					fdef.isSensor = false;
				}
				
				
				Body body = world.createBody(bdef);
				Fixture fix = body.createFixture(fdef);
				
				block.fix = fix;
				
				block.position = new Vector2(col, row);
				
				fix.setUserData(block);
				
//				if (block.fix != null && (!(block instanceof BlockAir))) {
//					
//					body = fix.getBody();
//					TextureRegion[][] texreg = TextureRegion.split(GameStatePlay.res.getTexture("blocks"), 32, 32);
//					
//					Game.sb.setProjectionMatrix(Game.cam.combined);
//					
//					Game.sb.begin();
//					Game.sb.draw(texreg[0][block.getImageIndex()], body.getPosition().x * B2DVars.PPM - 32 / 2, body.getPosition().y * B2DVars.PPM - 32 / 2);
//					Game.sb.end();
//
//				}
				
			}
		}
		
	}
	
	public final boolean renderRectF(Rect par1, String par2, float par3, float par4) {
		
		if (par1 != null) {
			
			par1.bdef.position.set(new Vector2(par3 / PPM, par4 / PPM));
			
			Body b = world.createBody(par1.bdef);
			
			PolygonShape shape = new PolygonShape();
			shape.setAsBox(par1.hx, par1.hy);
			
			FixtureDef fdef = new FixtureDef();
			fdef.shape = shape;
			
			Fixture f = b.createFixture(fdef);
			f.setUserData(par2);
			
			return true;
			
		}
		
		return false;
		
	}
	
	public final boolean renderRectD(Rect par1, double par2, double par3) {
		return false;
	}
	
	public final World getWorld() {
		return world;
	}
	
}
