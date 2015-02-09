package com.lopp.game.item;

import com.lopp.game.api.serialization.ISerializable;

public class ItemStack implements ISerializable {

	public final int MAX_STACK_SIZE = 64;
	
	private Item item;
	private int stackSize = 1;
	
	public ItemStack(Item par1, int par2) {
		item = par1;
		stackSize = par2;
	}

	public final int getSize() {
		return stackSize;
	}
	
	public final ItemStack setSize(int par1) {
		if (par1 <= MAX_STACK_SIZE) {
			stackSize = par1;
		}
		return this;
	}
	
	public final Item getItem() {
		return item;
	}

	@Override
	public String getIdString() {
		return "itemStack";
	}

	@Override
	public String getNativeString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getLocalString() {
		return "";
	}
	
}
