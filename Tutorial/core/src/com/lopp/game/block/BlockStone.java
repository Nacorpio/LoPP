package com.lopp.game.block;

import com.lopp.game.api.Block;
import com.lopp.game.handlers.b2d.B2DVars;

public class BlockStone extends Block {

	public BlockStone() {
		super("Stone", 2, B2DVars.BIT_GROUND);
	}

	@Override
	public final int getImageIndex() {
		return 1;
	}
	
	@Override
	public void onEntityCollide(Object par1) {}

	@Override
	public void onObjectCollide(Object par1) {}

	@Override
	public void onLeftClickDown() {}
	
	@Override
	public void onLeftClickUp() {}

	@Override
	public void update(float dt) {}

}
