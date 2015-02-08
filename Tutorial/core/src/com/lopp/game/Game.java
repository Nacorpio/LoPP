package com.lopp.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lopp.game.handlers.Content;
import com.lopp.game.handlers.GameStateManager;
import com.lopp.game.handlers.input.MyInput;
import com.lopp.game.handlers.input.MyInputProcessor;

public class Game extends ApplicationAdapter {
	
	public static final String TITLE = "BlockGame";
	public static final int V_WIDTH = 1200;
	public static final int V_HEIGHT = 700;
	public static final int SCALE = 2;
	
	public static final float STEP = 1 / 60f;
	private float accum;
	
	public static SpriteBatch sb;
	public static OrthographicCamera cam;
	public static OrthographicCamera hudCam;
	
	private GameStateManager gsm;
	
	public static Content res;
	
	@Override
	public void create () {
		
		Gdx.input.setInputProcessor(new MyInputProcessor());
		
		res = new Content();
		res.loadTexture("blocks.png", "blocks");
		res.loadTexture("bunny.png", "bunny");
		
		sb = new SpriteBatch();
		cam = new OrthographicCamera();
		cam.setToOrtho(false, V_WIDTH, V_HEIGHT);	
		hudCam = new OrthographicCamera();
		hudCam.setToOrtho(false, V_WIDTH, V_HEIGHT);
		
		gsm = new GameStateManager(this);
		
	}

	@Override
	public void render () {
		
		accum += Gdx.graphics.getDeltaTime();
		
		while (accum >= STEP) {
			accum -= STEP;
			gsm.update(STEP);
			gsm.render();
			MyInput.update();
		}
		
	}
	
	public void dispose() {
		
	}
	
	public SpriteBatch getSpriteBatch() { return sb; }
	public OrthographicCamera getCamera() { return cam; }
	public OrthographicCamera getHUDCamera() { return hudCam; }
	
	public void resize(int w, int h) {}
	public void pause() {}	
	public void resume() {}
	
}
