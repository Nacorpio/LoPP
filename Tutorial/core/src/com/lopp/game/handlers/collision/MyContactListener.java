package com.lopp.game.handlers.collision;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.lopp.game.api.Block;
import com.lopp.game.entity.Entity;

public class MyContactListener implements ContactListener {

	private int numFootContacts;
	
	// Called when two fixtures collide.
	@Override
	public void beginContact(Contact contact) {
		
		Fixture fa = contact.getFixtureA();
		Fixture fb = contact.getFixtureB();
		
		// if (fb == null || fa == null) return;
		
		if (fa.getUserData() != null && fa.getUserData() == "foot") {		
			numFootContacts++;
		}
		
		if (fb.getUserData() != null && fb.getUserData() == "foot") {
			numFootContacts++;
		}
		
		if (fa.getUserData() != null && fa.getUserData() instanceof Entity) {
			Entity entity = (Entity) fa.getUserData();
			entity.onObjectCollision(fb.getUserData());
		}
		
		if (fb.getUserData() != null && fb.getUserData() instanceof Entity) {
			Entity entity = (Entity) fb.getUserData();
			entity.onObjectCollision(fa.getUserData());
		}
		
		if (fa.getUserData() != null && fa.getUserData() instanceof Block && fb.getUserData() == "player") {
			Block block = (Block) fa.getUserData();
			block.onObjectCollide(fb.getUserData());
		}
		
		if (fb.getUserData() != null && fb.getUserData() instanceof Block && fa.getUserData() == "player") {
			Block block = (Block) fb.getUserData();
			block.onObjectCollide(fa.getUserData());
		}
		
	}

	// Called when two fixtures no longer collide.
	@Override
	public void endContact(Contact contact) {
		
		Fixture fa = contact.getFixtureA();
		Fixture fb = contact.getFixtureB();
	
		if (fb == null || fa == null) return;
		
		if (fa.getUserData() != null && fa.getUserData() == "foot") {
			numFootContacts--;
		}
		
		if (fb.getUserData() != null && fb.getUserData() == "foot") {
			numFootContacts--;
		}
		
	}

	public boolean isPlayerOnGround() { return numFootContacts >= 1; }
	
	// 1. Collision detection.
	// 2. PreSolve
	// 3. Collision handling
	
	@Override
	public void preSolve(Contact contact, Manifold oldManifold) {}

	@Override
	public void postSolve(Contact contact, ContactImpulse impulse) {}

}
