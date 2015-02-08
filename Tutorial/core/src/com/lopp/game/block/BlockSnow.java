package com.lopp.game.block;

import com.lopp.game.api.Block;
import com.lopp.game.handlers.b2d.B2DVars;

public class BlockSnow extends Block {

	public BlockSnow() {
		super("Snow", 3, B2DVars.BIT_GROUND);
		setFriction(1f);
	}

	@Override
	public final int getImageIndex() {
		return 3;
	}
	
}
