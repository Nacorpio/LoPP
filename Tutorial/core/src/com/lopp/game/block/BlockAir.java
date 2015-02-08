package com.lopp.game.block;
import com.lopp.game.api.Block;
import com.lopp.game.handlers.b2d.B2DVars;

public class BlockAir extends Block {

	public BlockAir() {
		super("Air", 0, B2DVars.BIT_AIR_BLOCK);
	}

	public final int getImageIndex() {
		return 2;
	}
	
	@Override
	public void onEntityCollide(Object par1) {}

	@Override
	public void onObjectCollide(Object par1) {}

	@Override
	public void onLeftClickDown() {}

	@Override
	public void update(float dt) {}

}
