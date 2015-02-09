package com.lopp.game.schedule;

import com.badlogic.gdx.utils.Array;
import com.lopp.game.api.Tickable;

public class UpdateQueue {

	private Array<Tickable> queue;
	
	public UpdateQueue() {
		queue = new Array<Tickable>();
		queue.ordered = false;
	}

	public final void updateNext(float dt) {
		if (queue.size > 0) {
			for (int i = 0; i < queue.size; i++) {
				Tickable var = queue.get(i);
				var.update(dt);
				queue.removeIndex(i);
			}
		}
	}
	
	public final boolean hasNext() {
		return queue.size > 0;
	}
	
	public UpdateQueue queue(int par1, Tickable par2) {
		if (queue.get(par1) == null) {
			queue.set(par1, par2);
		}
		return this;
	}
	
	public UpdateQueue queue(Tickable par1) {
		queue.add(par1);
		return this;
	}
	
	public final Tickable[] getQueue() {
		return queue.toArray();
	}
	
}
