package com.lopp.game.api;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface Tickable {

	public void render(SpriteBatch bs, OrthographicCamera cam);

	/**
	 * Fired when an update has to be made on this tickable.
	 * @param dt the delta time.
	 */
	public void update(float dt);
	
	/**
	 * Returns whether this tickable object is queued for being updated.
	 * @return true/false.
	 */
	public boolean queuedForUpdate();
	
}
