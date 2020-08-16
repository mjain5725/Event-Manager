package com.login.project.eventoverlapping;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class test the Calendar class
 * 
 */
public class CalenderTest {
	
	public static void OverlappedEventSize(HashMap<IEvent, ArrayList<IEvent>> list) {
		list.entrySet().stream().forEach(e -> System.out
				.println("Key Id: " + e.getKey().toString() + " Overlapped Elements: " + e.getValue().size()));
	}

	public static void OverlappedEventSubject(HashMap<IEvent, ArrayList<IEvent>> list) {
		list.entrySet().stream().forEach(e -> System.out
				.println("Key Id: " + e.getKey().toString() + " Overlapped with: " + e.getValue().toString()));
	}

	public static void BasicAddTest() {
		Calendar calender = new Calendar();
		IEvent event = new TestEvent(1, 2);
		calender.addEvent(event);
		System.out.print(calender.getTotalEventCount() + "\t");
		System.out.println(calender.getOverlappingEvents().size());
	}

	public static void BasicRemoveTest() {
		Calendar calender = new Calendar();
		IEvent event = new TestEvent(1, 2);
		calender.addEvent(event);
		System.out.print(calender.getTotalEventCount() + "\t");
		System.out.println(calender.getOverlappingEvents().size());
		calender.removeEvent(event);
		System.out.print(calender.getTotalEventCount() + "\t");
		System.out.println(calender.getOverlappingEvents().size());
	}
	
	public static void EmptyEventsTest() {
		Calendar calender = new Calendar();
		System.out.print(calender.getTotalEventCount() + "\t");
		System.out.println(calender.getOverlappingEvents().size());
	}

	public static void AddMultipleEventsTest() {
		Calendar calender = new Calendar();
		for (int size = 0; size < 10; size++) {
			IEvent event = new TestEvent(1, 2);
			calender.addEvent(event);
		}
		System.out.println(calender.getTotalEventCount());
		OverlappedEventSize(calender.getOverlappingEvents());
	}

	public static void GetOverlappedEventsTest() {
		Calendar calender = new Calendar();
		IEvent event1 = new TestEvent(1, 3);
		calender.addEvent(event1);
		IEvent event2 = new TestEvent(2, 4);
		calender.addEvent(event2);
		IEvent event3 = new TestEvent(3, 4);
		calender.addEvent(event3);
		System.out.println(calender.getTotalEventCount());
		OverlappedEventSize(calender.getOverlappingEvents());
	}

	public static void RealEventsTest() throws EventException {
		Calendar calender = new Calendar();
		ZonedDateTime start1 = ZonedDateTime.parse("2019-04-01T16:24:11.252+05:30[Asia/Calcutta]");
		ZonedDateTime end1 = ZonedDateTime.parse("2019-04-01T17:24:11.252+05:30[Asia/Calcutta]");
		IEvent event1 = new Event(start1, end1, "Buy Vegetables");
		calender.addEvent(event1);
		ZonedDateTime start2 = ZonedDateTime.parse("2019-04-01T13:24:11.252+05:30[Asia/Calcutta]");
		ZonedDateTime end2 = ZonedDateTime.parse("2019-04-01T19:24:11.252+05:30[Asia/Calcutta]");
		IEvent event2 = new Event(start2, end2, "Hair Cut");
		calender.addEvent(event2);
		ZonedDateTime start3 = ZonedDateTime.parse("2019-04-01T16:24:11.252+05:30[Asia/Calcutta]");
		ZonedDateTime end3 = ZonedDateTime.parse("2019-04-01T18:24:11.252+05:30[Asia/Calcutta]");
		IEvent event3 = new Event(start3, end3, "Zoom meeting");
		calender.addEvent(event3);
		System.out.println(calender.getTotalEventCount());
		OverlappedEventSubject(calender.getOverlappingEvents());
	}

	public static void GetNonOverlappedEventsTest() {
		Calendar calender = new Calendar();
		IEvent event1 = new TestEvent(1, 2);
		calender.addEvent(event1);
		IEvent event2 = new TestEvent(2, 4);
		calender.addEvent(event2);
		System.out.println(calender.getTotalEventCount());
		OverlappedEventSize(calender.getOverlappingEvents());
	}

	public static void main(String[] args) throws EventException {
		BasicAddTest();
		BasicRemoveTest();
		EmptyEventsTest();
		AddMultipleEventsTest();
		GetOverlappedEventsTest();
		GetNonOverlappedEventsTest();
		RealEventsTest();
	}
}
