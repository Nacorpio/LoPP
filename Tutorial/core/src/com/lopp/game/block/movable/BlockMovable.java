package com.lopp.game.block.movable;

import com.lopp.game.api.Block;
import com.lopp.game.handlers.b2d.B2DVars;

public class BlockMovable extends Block {

	public BlockMovable(String par1, int par2) {
		super(par1, par2, B2DVars.BIT_GROUND);
	}

}
