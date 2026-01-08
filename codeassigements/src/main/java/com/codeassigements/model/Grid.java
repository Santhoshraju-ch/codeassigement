package com.codeassigements.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Grid {
	private int width;
	private int height;
	private Set<Position> obstacles;

	
	
	
	public Grid(int width, int height, List<Position> list) {
		super();
		this.width = width;
		this.height = height;
		
		if (list != null) {
	        this.obstacles = new HashSet<>(list);
	    } else {
	        this.obstacles = new HashSet<>(); 
	    }
	}

	public boolean isValid(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height)
			return false;
		return !obstacles.contains(new Position(x, y));
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Set<Position> getObstacles() {
		return obstacles;
	}

	public void setObstacles(Set<Position> obstacles) {
		this.obstacles = obstacles;
	}

}