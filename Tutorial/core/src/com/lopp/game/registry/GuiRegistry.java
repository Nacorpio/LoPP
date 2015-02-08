package com.lopp.game.registry;

import java.util.HashMap;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lopp.game.api.Tickable;

public final class GuiRegistry {

	private static HashMap<String, Tickable> registry = new HashMap<String, Tickable>();
	
	public static final void addEntry(String par1, Tickable par2) {
		if (!registry.containsKey(par1)) {
			registry.put(par1, par2);
		}
	}
	
	public static final void updateAll(float dt) {
		for (Tickable val: registry.values()) {
			val.update(dt);
		}
	}
	
	public static final void renderAll(SpriteBatch sb, OrthographicCamera cam) {
		for (Tickable val: registry.values()) {
			val.render(sb, cam);
		}
	}
	
}
