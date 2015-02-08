package com.lopp.game.block;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.lopp.game.Game;
import com.lopp.game.api.Block;
import com.lopp.game.handlers.b2d.B2DVars;
import com.lopp.game.states.GameStatePlay;

public class BlockDirt extends Block {

	public BlockDirt() {
		super("Dirt", 1, B2DVars.BIT_GROUND);
	}

	@Override
	public final int getImageIndex() {
		return 0;
	}
	
	@Override
	public void onEntityCollide(Object par1) {}

	@Override
	public void onObjectCollide(Object par1) {}

	@Override
	public void onLeftClickDown() {}

	@Override
	public void update(float dt) {}
	
	@Override
	public void init() {}

}
