package com.codeassigement.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.codeassigement.enu.ControllerStatus;
import com.codeassigement.enu.Direction;
import com.codeassigement.enu.DirectionGroup;
import com.codeassigement.enu.LightColor;

public class Intersection {

	private final Map<Direction, TrafficLight> lights = new ConcurrentHashMap<>();
	private final List<LightStateHistory> history = Collections.synchronizedList(new ArrayList<>());

	private DirectionGroup activeGroup = DirectionGroup.NORTH_SOUTH;

	private ControllerStatus status = ControllerStatus.RUNNING;

	public Intersection() {
		for (Direction d : Direction.values()) {
			lights.put(d, new TrafficLight(d));
		}
		this.activeGroup = DirectionGroup.NORTH_SOUTH;

		applyGroupColors();
		recordHistory();
	}

	public synchronized void advance() {
		if (status == ControllerStatus.PAUSED)
			return;

		for (Direction d : activeGroup.getDirections()) {
			TrafficLight light = lights.get(d);
			light.setColor(next(light.getColor()));
		}

		if (isGroupRed(activeGroup)) {
			activeGroup = activeGroup.next();
			applyGroupColors();
		}

		recordHistory();
	}

	private LightColor next(LightColor color) {
		if (color == LightColor.GREEN)
			return LightColor.YELLOW;
		if (color == LightColor.YELLOW)
			return LightColor.RED;
		return LightColor.RED;
	}

	private boolean isGroupRed(DirectionGroup group) {
		return group.getDirections().stream().allMatch(d -> lights.get(d).getColor() == LightColor.RED);
	}

	private void applyGroupColors() {
		for (DirectionGroup group : DirectionGroup.values()) {
			LightColor color = (group == activeGroup) ? LightColor.GREEN : LightColor.RED;
			group.getDirections().forEach(d -> lights.get(d).setColor(color));
		}
	}

	private void recordHistory() {
		Map<Direction, LightColor> snapshot = new EnumMap<>(Direction.class);
		lights.forEach((k, v) -> snapshot.put(k, v.getColor()));
		history.add(new LightStateHistory(LocalDateTime.now(), snapshot));
	}

	public void pause() {
		status = ControllerStatus.PAUSED;
	}

	public void resume() {
		status = ControllerStatus.RUNNING;
	}

	public Map<Direction, TrafficLight> getLights() {
		return lights;
	}

	public List<LightStateHistory> getHistory() {
		return history;
	}
}
