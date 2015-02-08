package com.lopp.game.handlers.input;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.lopp.game.api.Block;
import com.lopp.game.block.BlockAir;
import com.lopp.game.block.BlockIce;
import com.lopp.game.states.GameStatePlay;

public class MyInputProcessor extends InputAdapter {

	public boolean keyDown(int k) {
		if (k == Keys.D) {
			MyInput.setKey(MyInput.BUTTON1, true);
		}
		if (k == Keys.A) {
			MyInput.setKey(MyInput.BUTTON2, true);
		}
		if (k == Keys.SPACE) {
			MyInput.setKey(MyInput.BUTTON3, true);
		}
		if (k == Keys.SHIFT_LEFT) {
			MyInput.setKey(MyInput.BUTTON6, true);
		}
		if (k == Keys.ESCAPE) {
			MyInput.setKey(MyInput.BUTTON7, true);
		}
		return true;
	}
	
	public boolean mouseMoved(int screenX, int screenY){
		GameStatePlay.mouseX = screenX;
		GameStatePlay.mouseY = screenY;
		return true;
	}
	
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		
		if (button == 0) {
			
			MyInput.setKey(MyInput.BUTTON4, true);
			
			int bx = MouseHandler.getBlockOnScreenX();
			int by = MouseHandler.getBlockOnScreenY();
			
			Block block = (Block) GameStatePlay.blockWorld.getBlock(bx, by);
			if (block != null) {
				GameStatePlay.blockWorld.setBlock(bx, by, new BlockIce());
				block.onLeftClickDown();
			}
			
			return true;
			
		} 
		
		if (button == 1) {
			
			MyInput.setKey(MyInput.BUTTON5, true);
			
			int bx = MouseHandler.getBlockOnScreenX();
			int by = MouseHandler.getBlockOnScreenY();
			
			Block block = (Block) GameStatePlay.blockWorld.getBlock(bx, by);
			if (block != null) {
				Fixture fix = block.fix;
				if (fix != null && !(block instanceof BlockAir)) {
					GameStatePlay.world.destroyBody(fix.getBody());
					GameStatePlay.blockWorld.setBlock(bx, by, new BlockAir());
				}				
			}
			
			return true;
			
		}
		
		return false;
		
	}
	
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		if (button == 0) {
			MyInput.setKey(MyInput.BUTTON4, false);
			Block block = (Block) GameStatePlay.blockWorld.getBlock(MouseHandler.getBlockOnScreenX(), MouseHandler.getBlockOnScreenY());
			block.onLeftClickUp();
		}
		if (button == 1) {
			MyInput.setKey(MyInput.BUTTON5, false);
		}
		return true;
	}
	
	public boolean keyUp(int k) {
		if (k == Keys.D) {
			MyInput.setKey(MyInput.BUTTON1, false);
		}
		if (k == Keys.A) {
			MyInput.setKey(MyInput.BUTTON2, false);
		}
		if (k == Keys.SPACE) {
			MyInput.setKey(MyInput.BUTTON3, false);
		}
		if (k == Keys.SHIFT_LEFT) {
			MyInput.setKey(MyInput.BUTTON6, false);
		}
		if (k == Keys.ESCAPE) {
			MyInput.setKey(MyInput.BUTTON7, false);
		}
		return true;
	}
	
}
