package com.lopp.game.handlers.input;

public class MyInput {

	public static boolean[] keys;
	public static boolean[] pkeys;
	
	public static final int NUM_KEYS = 7;
	
	// Button "D" (walk to the right (x+))
	public static final int BUTTON1 = 0;
	
	// Button "A" (walk to the left (x-))
	public static final int BUTTON2 = 1;
	
	// Button "SPACE" (jump (y+))
	public static final int BUTTON3 = 2;
	
	// Left mouse button
	public static final int BUTTON4 = 3;
	
	// Right mouse button
	public static final int BUTTON5 = 4;
	
	// Left shift
	public static final int BUTTON6 = 5;
	
	// Escape (exit)
	public static final int BUTTON7 = 6;
	
	static {
		keys = new boolean[NUM_KEYS];
		pkeys = new boolean[NUM_KEYS];
	}
	
	public static void update() {
		for (int i = 0; i < NUM_KEYS; i++) {
			pkeys[i] = keys[i];
		}
	}
	
	public static void setKey(int i, boolean b) { keys[i] = b; }
	public static boolean isDown(int i) { return keys[i]; }
	public static boolean isPressed(int i) { return keys[i] && !pkeys[i]; }
	
}
