package com.codeassigements.dto;

import java.util.List;

import com.codeassigements.enu.Directions;
import com.codeassigements.model.Position;

public class SimpleProbeInput {
	private int gridWidth;
	private int gridHeight;
	private List<Position> obstacles;
	private int startX;
	private int startY;
	private Directions startDirections;
	private String commands;

	public int getGridWidth() {
		return gridWidth;
	}

	public void setGridWidth(int gridWidth) {
		this.gridWidth = gridWidth;
	}

	public int getGridHeight() {
		return gridHeight;
	}

	public void setGridHeight(int gridHeight) {
		this.gridHeight = gridHeight;
	}

	public List<Position> getObstacles() {
		return obstacles;
	}

	public void setObstacles(List<Position> obstacles) {
		this.obstacles = obstacles;
	}

	public int getStartX() {
		return startX;
	}

	public void setStartX(int startX) {
		this.startX = startX;
	}

	public int getStartY() {
		return startY;
	}

	public void setStartY(int startY) {
		this.startY = startY;
	}

	public Directions getStartDirections() {
		return startDirections;
	}

	public void setStartDirection(Directions startDirections) {
		this.startDirections = startDirections;
	}

	public String getCommands() {
		return commands;
	}

	public void setCommands(String commands) {
		this.commands = commands;
	}

}
