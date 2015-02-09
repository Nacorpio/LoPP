package com.lopp.game.inventory;

import com.badlogic.gdx.utils.Array;
import com.lopp.game.item.Item;

public class Inventory {

	private Array<Item> items;
	
	public Inventory() {
		items = new Array<Item>();
	}
	
	public Inventory(Item... par1) {
		this();
		items.addAll(par1);
	}
	
}
