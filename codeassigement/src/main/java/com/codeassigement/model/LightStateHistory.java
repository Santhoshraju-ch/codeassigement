package com.codeassigement.model;

import java.time.LocalDateTime;
import java.util.Map;

import com.codeassigement.enu.Direction;
import com.codeassigement.enu.LightColor;

public class LightStateHistory {

	private final LocalDateTime timestamp;
	private final Map<Direction, LightColor> state;

	public LightStateHistory(LocalDateTime timestamp, Map<Direction, LightColor> state) {
		this.timestamp = timestamp;
		this.state = state;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public Map<Direction, LightColor> getState() {
		return state;
	}
}
