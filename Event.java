package com.login.project.eventoverlapping;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

/**
 * Creates an Event
 */
public class Event implements IEvent {
	private LocalDateTime mEventLocalStart;
	private LocalDateTime mEventLocalEnd;
	private String mEventSubject;

	/**
	 * Takes in start of event end of event in any time zone stores the start of
	 * event in mEventLocalStart which is local time for that event stores the end
	 * of event in mEventLocalEnd which is local time for that event throws
	 * exception if start time of event is after event end time throws exception if
	 * time zone of event start time is different than event end time
	 * 
	 * @param eventstart   The start time of an event.
	 * @param eventend     The end time of an event.
	 * @param eventSubject The subject of an event.
	 * 
	 */
	public Event(ZonedDateTime eventstart, ZonedDateTime eventend, String eventSubject) throws EventException {
		if (eventstart.isAfter(eventend) || eventstart.equals(eventend))
			throw new EventException("Start of Event should be less than End of Event");
		if (!eventstart.getZone().equals(eventend.getZone()))
			throw new EventException("Start and End Events should be in the same Timezone");
		this.mEventLocalStart = eventstart.toLocalDateTime();
		this.mEventLocalEnd = eventend.toLocalDateTime();
		this.mEventSubject = eventSubject;
	}

	/**
	 * @return the local start time of an event
	 */
	public LocalDateTime getStartofEvent() {
		return mEventLocalStart;
	}

	/**
	 * @return the local end time of an event
	 */
	public LocalDateTime getEndOfEvent() {
		return mEventLocalEnd;
	}

	/**
	 * Returns the subject of an event
	 */
	public String toString() {
		return mEventSubject;
	}
}