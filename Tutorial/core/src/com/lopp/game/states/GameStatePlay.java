package com.lopp.game.states;

import static com.lopp.game.handlers.b2d.B2DVars.PPM;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.lopp.game.Game;
import com.lopp.game.api.Block;
import com.lopp.game.api.Tickable;
import com.lopp.game.api.gui.Interface;
import com.lopp.game.block.BlockDirt;
import com.lopp.game.entity.Entity;
import com.lopp.game.entity.EntityPlayer;
import com.lopp.game.handlers.Content;
import com.lopp.game.handlers.GameStateManager;
import com.lopp.game.handlers.b2d.B2DVars;
import com.lopp.game.handlers.collision.MyContactListener;
import com.lopp.game.handlers.input.MyInput;
import com.lopp.game.registry.GuiRegistry;
import com.lopp.game.world.BlockWorld;
import com.lopp.game.world.WorldRenderer;

public class GameStatePlay extends GameState {

	public static World world;
	public static WorldRenderer worldr;
	
	//
	
	private Box2DDebugRenderer b2dr;
	private OrthographicCamera b2dCam; 

	//
	
	public static MyContactListener cl;
	public static Content res;
	public static BlockWorld blockWorld;

	//
	
	public static float offsetX = (B2DVars.BLOCK_SIZE * B2DVars.MAP_SIZE) / 2;
	public static float offsetY = (B2DVars.BLOCK_SIZE * B2DVars.MAP_SIZE) / 2;
	
	public static float shiftX = Game.V_WIDTH / 2;
	public static float shiftY = Game.V_HEIGHT / 2;
	
	public static float mouseX = 0;
	public static float mouseY = 0;
	
	//
	
	public static Array<Tickable> tick_queue;
	public static EntityPlayer playerEntity;
	
	// public static Interface int1;
	
	public GameStatePlay(GameStateManager gsm) {
		
		super(gsm);
		
		res = Game.res;
		reloadResources();
		
		// Initialization
		tick_queue = new Array<Tickable>();
		world = new World(new Vector2(0, -9.82f), true);
		worldr = new WorldRenderer(world);
		cl = new MyContactListener();
		world.setContactListener(cl);		
		b2dr = new Box2DDebugRenderer();
		
		blockWorld = new BlockWorld();
		updateWorld();
		
		// Render the world
		worldr.renderWorld(blockWorld);
		
		// Render an interface
		// int1 = new Interface("interface1", 100, 100);
		// worldr.renderInterface(int1, new Vector2(1000, 500));
		
		// GuiRegistry.addEntry("gui_template", int1);a
		
		// Render the player
		playerEntity = new EntityPlayer();
		worldr.renderPlayer(playerEntity, new Vector2(660, 400));
		
		// Add to the tick queue
		
		// Initialize the camera
		b2dCam = new OrthographicCamera();
		b2dCam.setToOrtho(false, Game.V_WIDTH / PPM, Game.V_HEIGHT / PPM);

	}
	
	public final void updateWorld() {
		for (int x = 0; x < 64; x++) {
			blockWorld.setBlock(x, 5, new BlockDirt());
		}
	}
	
	public void loadGUI() {
		
	}
	
	public void reloadResources() {
		res.loadTexture("Player/p1_front.png", "p_front");
		res.loadTexture("Player/p1_stand.png", "p_stand");
		res.loadTexture("gui-template.png", "gui_template");
	}
	
	@Override
	public void handleInput() {
		
		if (MyInput.isPressed(MyInput.BUTTON7)) {
			Gdx.app.exit();
		}
		
		playerEntity.handleKeys();
		
	}

	@Override
	public void update(float dt) {	
	
		world.step(dt, 6, 2);	
		
		GuiRegistry.updateAll(dt);
		
		blockWorld.update(dt);
		
		// Update (tick) the player
		playerEntity.update(dt);
		
		// Update (tick) all entities
		for (Entity e: blockWorld.entities) {
			e.update(dt);
		}
	
		// Handle the input (keys)
		handleInput();
		
	}

	@Override
	public void render() {
		
		// clear
		Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
		GuiRegistry.renderAll(sb, cam);
		
		BitmapFont font = new BitmapFont();
		
		sb.setProjectionMatrix(cam.combined);
		sb.begin();
		font.draw(sb, String.valueOf("FPS: " + Gdx.app.getGraphics().getFramesPerSecond()), 50, Game.V_HEIGHT - 50);
		sb.end();
		
		
		// Render the world
		worldr.renderWorld(blockWorld);
		
		// Render the player
		playerEntity.render(sb, cam);
		
		// Render all entities
		for (Entity e: blockWorld.entities) {
			e.render(sb, cam);
		}
		
		// Render all blocks
		for (int y = 0; y < B2DVars.MAP_SIZE; y++) {
			for (int x = 0; x < B2DVars.MAP_SIZE; x++) {
				
				Block block = blockWorld.getBlock(x, y);
				block.render(sb, cam);
				
			}
		}
		
		// draw
		b2dr.render(world, b2dCam.combined);
		
	}

	@Override
	public void dispose() {}
	
}
