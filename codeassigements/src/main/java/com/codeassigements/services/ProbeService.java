package com.codeassigements.services;

import org.springframework.stereotype.Service;

import com.codeassigements.model.Grid;
import com.codeassigements.model.Probe;

@Service
public class ProbeService {
	public Probe execute(Grid grid, Probe probe, String commands) {

		for (char command : commands.toCharArray()) {
			switch (command) {
			case 'L' -> probe.setDirection(probe.getDirection().left());
			case 'R' -> probe.setDirection(probe.getDirection().right());
			case 'F' -> move(grid, probe, 1);
			case 'B' -> move(grid, probe, -1);
			}
		}
		return probe;
	}

	private void move(Grid grid, Probe probe, int step) {
		int newX = probe.getX();
		int newY = probe.getY();

		switch (probe.getDirection()) {
		case NORTH -> newY += step;
		case SOUTH -> newY -= step;
		case EAST -> newX += step;
		case WEST -> newX -= step;
		}

		if (grid.isValid(newX, newY)) {
			probe.setX(newX);
			probe.setY(newY);
			probe.visit();
		}
	}
}