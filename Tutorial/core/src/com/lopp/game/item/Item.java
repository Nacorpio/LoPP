package com.lopp.game.item;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lopp.game.api.Tickable;
import com.lopp.game.entity.Entity;

public class Item implements Tickable {

	private String name;
	private int id;
	
	private EnumItemType type;
	private EnumTier tier;
	
	public Entity firstOwner;
	public Entity currentOwner;
	
	public Item(String par1, int par2) {
		name = par1;
		id = par2;
	}
	
	public String getDisplayName() {
		return name;
	}
	
	public final String getName() {
		return name;
	}
	
	public final int getId() {
		return id;
	}
	
	//
	
	public EnumTier getTier() {
		return tier;
	}
	
	public EnumItemType getType() {
		return type;
	}
	
	//
	
	public int getImageIndex() {
		return -1;
	}
	
	/**
	 * Fired when the Item has been picked up from the ground.
	 */
	public void onItemPickUp() {}
	
	/**
	 * Fired prior to the Item being dropped on the ground.
	 */
	public void onItemPreDrop() {}
	
	/**
	 * Fired when a keystroke occurs on the right (->) mouse button.
	 */
	public void onMouseRightClick() {}
	
	/**
	 * Fired when a keystroke occurs on the left (<-) mouse button.
	 */
	public void onMouseLeftClick() {}

	@Override
	public void render(SpriteBatch bs, OrthographicCamera cam) {}

	@Override
	public void update(float dt) {}

	@Override
	public boolean queuedForUpdate() { return false; }
	
	
}
