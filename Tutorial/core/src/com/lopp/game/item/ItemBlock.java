package com.lopp.game.item;

import com.lopp.game.api.Block;

public class ItemBlock extends Item {

	private Block block;
	
	public ItemBlock(Block par1, String par2, int par3) {
		super(par2, par3);
		block = par1;
	}
	
	@Override
	public final EnumItemType getType() {
		return EnumItemType.BLOCK;
	}
	
}
