package com.lopp.game.item;

public class ItemWeapon extends Item {

	private float bullets_per_magazine; // The amount of bullets per magazine.
	
	private float fire_rate; // The amount of bullets per second
	private float dpb; // Damage per bullet	
	private float dpm; // Damage per meter
	
	private float dh = 100;
	private float dm = 75;
	private float dl = 25;
	
	public ItemWeapon(String par1, int par2) {
		super(par1, par2);
	}

	public EnumItemType getType() {
		return EnumItemType.WEAPON;
	}
	
	public float getDamagePerBullet() {
		return dpb;
	}
	
	public final ItemWeapon setDamage(float par1, float par2, float par3) {
		dh = par1; dm = par2; dl = par3;
		return this;
	}
	
	/**
	 * Returns the amount of damage a headshot subtracts from the victim.
	 * @param m the distance (m) from the victim.
	 * @return the damage.
	 */
	public final float getDamageHeadshot(float m) {
		return dh - m;
	}
	
	/**
	 * Returns the amount of damage a shot to the middle body subtracts from the victim.
	 * @param m the distance (m) from the victim.
	 * @return the damage.
	 */
	public final float getDamageMiddle(float m) {
		return dm - m;
	}
	
	/**
	 * Returns the amount of damage a shot to the lower body subtracts from the victim.
	 * @param m the distance (m) from the victim.
	 * @return the damage.
	 */
	public final float getDamageLower(float m) {
		return dl - m;
	}
	
}
