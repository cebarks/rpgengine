package net.cebarks.engine.event;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import net.cebarks.engine.Game;

public class EventManager {
	private Game game;
	private List<IEventHandler> handlers;
	private Queue<Event> events;

	public EventManager(Game game) {
		this.game = game;
		handlers = new ArrayList<IEventHandler>();
		events = new PriorityQueue<Event>();
	}

	public void registerEventHandler(IEventHandler handler) {
		handlers.add(handler);
	}

	public void removeEventHandler(IEventHandler handler) {
		handlers.remove(handler);
	}

	public Game getGame() {
		return game;
	}

	public void dispatchEvents() {
		while (!events.isEmpty()) {
			Event e = events.poll();
			while (e != null) {
				for (IEventHandler handler : handlers) {
					handler.handleEvent(e);
				}
			}
		}
	}
}
