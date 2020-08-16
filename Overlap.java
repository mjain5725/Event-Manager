package com.login.project.eventoverlapping;

/**
 * Checks if two events are overlapping
 */
public class Overlap {

	/**
	 * Checks if two events are overlapping
	 * 
	 * @return true if end of event1 is after start of event2 and start of event1 is
	 *         before end of event2 or else
	 * @return false
	 * 
	 * @param event1 First event
	 * @param event2 Second event
	 */
	public static boolean isEventOverlapping(IEvent event1, IEvent event2) {
		if (event1.getEndOfEvent().isAfter(event2.getStartofEvent())
				&& event1.getStartofEvent().isBefore(event2.getEndOfEvent()))
			return true;
		return false;
	}
}
