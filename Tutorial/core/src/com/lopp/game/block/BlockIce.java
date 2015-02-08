package com.lopp.game.block;

import com.lopp.game.api.Block;
import com.lopp.game.handlers.b2d.B2DVars;

public class BlockIce extends Block {

	public BlockIce() {
		super("Ice", 4, B2DVars.BIT_GROUND);
		setFriction(0.2f);
	}

	public final int getImageIndex() {
		return 4;
	}
	
}
