package com.login.project.eventoverlapping;

import java.time.LocalDateTime;

/**
 * IEvent interface class contains following methods getStartofEvent()
 * getEndofEvent() toString()
 */
public interface IEvent {

	/**
	 * Gets the start time and date of an event in LocalDateTime format
	 * 
	 * @return local start time and date
	 * 
	 */
	public LocalDateTime getStartofEvent();

	/**
	 * Gets the end time and date of an event in LocalDateTime format
	 * 
	 * @return local end time and date
	 * 
	 */

	public LocalDateTime getEndOfEvent();

	/**
	 * @return the subject of an event
	 * 
	 */
	public String toString();
}
