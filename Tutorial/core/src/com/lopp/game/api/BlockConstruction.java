package com.lopp.game.api;


public class BlockConstruction {

	private int height;
	private int width;
	
	private Block[][] blocks;
	
	public BlockConstruction(Block[][] par1, int par2, int par3) {
		blocks = new Block[height][width];
		blocks = par1;
	}
	
	public final int getHeight() {
		return height;
	}
	
	public final int getWidth() {
		return width;
	}
	
	public final void setBlock(int par1, int par2, Block par3) {
		if (par3 != null) {
			blocks[par1][par2] = par3;
		}
	}
	
	public final Block getBlock(int par1, int par2) {
		return blocks[par1][par2];
	}
	
	public final Block[][] getBlocks() {
		return blocks;
	}
	
}
