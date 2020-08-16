package com.login.project.eventoverlapping;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Creates a List of events and check for all overlapping events
 * 
 */
public class Calendar {

	private ArrayList<IEvent> events = new ArrayList<IEvent>();

	/**
	 * Add events in ArrayList
	 * 
	 */
	public boolean addEvent(IEvent event) {
		return events.add(event);
	}

	public boolean removeEvent(IEvent event) {
		return events.remove(event);
	}

	/**
	 * @return the size of event ArrayList
	 * 
	 */
	public int getTotalEventCount() {
		return events.size();
	}

	/**
	 * Creates an HaspMap with key as an event and value as ArrayList of overlapping
	 * events
	 * 
	 * @return the HashMap
	 */
	public HashMap<IEvent, ArrayList<IEvent>> getOverlappingEvents() {
		HashMap<IEvent, ArrayList<IEvent>> overlappingEvents = new HashMap<IEvent, ArrayList<IEvent>>();
		for (int i = 0; i < events.size(); i++) {
			ArrayList<IEvent> overlappedEvents = new ArrayList<IEvent>();
			for (int j = i + 1; j < events.size(); j++) {
				if (Overlap.isEventOverlapping(events.get(i), events.get(j))) {
					overlappedEvents.add(events.get(j));
				}
			}
			if (overlappedEvents.size() > 0)
				overlappingEvents.put(events.get(i), overlappedEvents);
		}
		return overlappingEvents;
	}
}
