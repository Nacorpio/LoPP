package com.lopp.game.handlers.input;

import com.badlogic.gdx.math.Vector2;
import com.lopp.game.Game;
import com.lopp.game.handlers.b2d.B2DVars;
import com.lopp.game.states.GameStatePlay;

public class MouseHandler {

	public static int getMouseOnScreenX() {
		return (int) GameStatePlay.mouseX;
	}
	
	public static int getMouseOnScreenY() {
		return (int) (Game.V_HEIGHT - GameStatePlay.mouseY);
	}
	
	public static Vector2 getRectangleOnScreen(float x, float y, float height, float width) {
		return new Vector2(x / height, y / width);
	}
	
	public static int getBlockOnScreenX() {
		return (int) (getMouseOnScreenX() / B2DVars.BLOCK_SIZE);
	}
	
	public static int getBlockOnScreenY() {
		return (int) (getMouseOnScreenY() / B2DVars.BLOCK_SIZE);
	}
	
	public static int getMouseX() {
		return (int) (GameStatePlay.mouseX + GameStatePlay.offsetX);
	}
	
	public static int getMouseY() {
		return (int) (Game.V_HEIGHT - GameStatePlay.mouseY + GameStatePlay.offsetY);
	}
	
}
