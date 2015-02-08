package com.lopp.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.lopp.game.Game;

public class DesktopLauncher {
	public static void main (String[] arg) {
		
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
	
		config.title = Game.TITLE;
		config.width = Game.V_WIDTH;
		config.height = Game.V_HEIGHT;
		config.fullscreen = false;
		
		new LwjglApplication(new Game(), config);
		
	}
}
