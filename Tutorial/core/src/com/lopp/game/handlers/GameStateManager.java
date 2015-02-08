package com.lopp.game.handlers;

import java.util.Stack;

import com.lopp.game.Game;
import com.lopp.game.states.GameState;
import com.lopp.game.states.GameStatePlay;

public class GameStateManager {

	private Game game;
	
	private Stack<GameState> gameStates;
	
	public static final int PLAY = 912837;
	
	public GameStateManager(Game par1) {
		this.game = par1;
		gameStates = new Stack<GameState>();
		pushState(PLAY);
	}
	
	public Game game() { return game; }
	
	public void update(float dt) {
		gameStates.peek().update(dt);
	}
	
	public void render() {
		gameStates.peek().render();
	}
	
	private GameState getState(int state) {
		if (state == PLAY) return new GameStatePlay(this);
		return null;
	}
	
	public void setState(int state) {
		popState();
		pushState(state);
	}
	
	public void pushState(int state) {
		gameStates.push(getState(state));
	}
	
	public void popState() {
		GameState g = gameStates.pop();
		g.dispose();
	}
	
}
