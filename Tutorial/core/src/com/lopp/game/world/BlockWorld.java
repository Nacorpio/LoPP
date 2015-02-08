package com.lopp.game.world;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.lopp.game.api.Block;
import com.lopp.game.api.Tickable;
import com.lopp.game.block.BlockAir;
import com.lopp.game.entity.Entity;
import com.lopp.game.handlers.b2d.B2DVars;

public class BlockWorld implements Tickable {
	
	public Block[][] blocks = new Block[(int) B2DVars.MAP_SIZE][(int) B2DVars.MAP_SIZE];
	public Array<Entity> entities = new Array<Entity>();
	
	public BlockWorld() {
		for (int row = 0; row < B2DVars.MAP_SIZE; row++) {
			for (int col = 0; col < B2DVars.MAP_SIZE; col++) {
				blocks[row][col] = new BlockAir();		
			}
		}
	}
	
	public final BlockWorld setBlock(int par1, int par2, Block par3) {
		blocks[par1][par2] = par3;
		return this;
	}
	
	public final Block getBlock(int par1, int par2) {
		return blocks[par1][par2];
	}

	//
	
	public void renderEntities(WorldRenderer par1) {
		
	}
	
	public void init() {
		
	}
	
	@Override
	public void render(SpriteBatch bs, OrthographicCamera cam) {
		
		for (int y = 0; y < B2DVars.MAP_SIZE; y++) {
			for (int x = 0; x < B2DVars.MAP_SIZE; x++) {
				blocks[x][y].render(bs, cam);
			}
		}
		
	}

	@Override
	public void update(float dt) {
		
		for (int y = 0; y < B2DVars.MAP_SIZE; y++) {
			for (int x = 0; x < B2DVars.MAP_SIZE; x++) {
				blocks[x][y].update(dt);
			}
		}
		
	}

	@Override
	public boolean queuedForUpdate() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
