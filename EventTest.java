package com.login.project.eventoverlapping;

import java.time.ZonedDateTime;
/**
 * This class test the Event class
 * 
 */
public class EventTest {

	static String sEventSubject = "Hi";

	public static void BasicEventTest() {
		ZonedDateTime start = ZonedDateTime.parse("2007-12-03T10:14:30+01:00");
		ZonedDateTime end = ZonedDateTime.parse("2007-12-03T10:15:30+01:00");
		try {
			Event event1 = new Event(start, end, sEventSubject);
		} catch (EventException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void EventStartGreaterThanEnd() {
		ZonedDateTime start = ZonedDateTime.parse("2007-12-03T10:16:30+01:00");
		ZonedDateTime end = ZonedDateTime.parse("2007-12-03T10:15:30+01:00");
		try {
			Event event1 = new Event(start, end, sEventSubject);
		} catch (EventException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void EventStartEqualsEnd() {
		ZonedDateTime start = ZonedDateTime.parse("2007-12-03T10:15:30+01:00");
		ZonedDateTime end = ZonedDateTime.parse("2007-12-03T10:15:30+01:00");
		try {
			Event event1 = new Event(start, end, sEventSubject);
		} catch (EventException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void DifferentTimezoneEvent() {
		ZonedDateTime start = ZonedDateTime.parse("2007-12-03T10:14:30+05:30[Asia/Calcutta]");
		ZonedDateTime end = ZonedDateTime.parse("2007-12-03T10:15:30+01:00");
		try {
			Event event1 = new Event(start, end, sEventSubject);
		} catch (EventException e) {
			System.out.println(e.getMessage());
		}

	}

	public static void StringTest() {
		ZonedDateTime start = ZonedDateTime.parse("2007-12-03T10:14:30+01:00");
		ZonedDateTime end = ZonedDateTime.parse("2007-12-03T10:15:30+01:00");
		try {
			Event event = new Event(start, end, sEventSubject);
			System.out.println(event.toString());
		} catch (EventException e) {
			System.out.println(e.getMessage());
		}

	}

	public static void main(String[] args) {
		BasicEventTest();
		EventStartGreaterThanEnd();
		EventStartEqualsEnd();
		DifferentTimezoneEvent();
		StringTest();
	}
}