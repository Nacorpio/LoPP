package com.lopp.game.api.gui;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lopp.game.api.Tickable;

public class Button implements Tickable {

	@Override
	public void render(SpriteBatch bs, OrthographicCamera cam) {}

	@Override
	public void update(float dt) {}

	@Override
	public boolean queuedForUpdate() {
		return false;
	}

}
