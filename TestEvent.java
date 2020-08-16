package com.login.project.eventoverlapping;

import java.time.LocalDateTime;

public class TestEvent implements IEvent {
	int mStartOffset;
	int mEndOffset;

	TestEvent(int startOffset, int endOffset) {
		mStartOffset = startOffset;
		mEndOffset = endOffset;
	}

	@Override
	public LocalDateTime getStartofEvent() {
		return LocalDateTime.now().plusHours(mStartOffset);
	}

	@Override
	public LocalDateTime getEndOfEvent() {
		return LocalDateTime.now().plusHours(mEndOffset);
	}

	@Override
	public String toString() {
		return "Event [" + mStartOffset + ", " + mEndOffset + "]";
	}
}
