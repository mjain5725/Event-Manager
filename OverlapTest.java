package com.login.project.eventoverlapping;

/**
 * This class test the overlap class
 *  
 */
public class OverlapTest {
	public static void BasicTest() {
		IEvent event1 = new TestEvent(1, 2);
		IEvent event2 = new TestEvent(3, 4);

		boolean isOverlapping = Overlap.isEventOverlapping(event1, event2);
		System.out.println(isOverlapping);
	}

	public static void OverlapTest1() {
		IEvent event1 = new TestEvent(1, 2);
		IEvent event2 = new TestEvent(2, 4);

		boolean isOverlapping = Overlap.isEventOverlapping(event1, event2);
		System.out.println(isOverlapping);
	}

	public static void OverlapTest2() {
		IEvent event1 = new TestEvent(1, 3);
		IEvent event2 = new TestEvent(2, 4);

		boolean isOverlapping = Overlap.isEventOverlapping(event1, event2);
		System.out.println(isOverlapping);
	}

	public static void OverlapTest3() {
		IEvent event1 = new TestEvent(3, 4);
		IEvent event2 = new TestEvent(1, 2);

		boolean isOverlapping = Overlap.isEventOverlapping(event1, event2);
		System.out.println(isOverlapping);
	}

	public static void main(String[] args) {
		BasicTest();
		OverlapTest1();
		OverlapTest2();
		OverlapTest3();
	}
}