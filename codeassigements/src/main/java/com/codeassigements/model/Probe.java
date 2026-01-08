package com.codeassigements.model;

import java.util.ArrayList;
import java.util.List;

import com.codeassigements.enu.Directions;

public class Probe {
	private int x;
	private int y;
	private Directions directions;
	private List<Position> visited;
	
	
	public Probe(int x, int y, Directions directions) {
		this.x = x;
		this.y = y;
		this.directions = directions;
		this.visited = new ArrayList<>(); 
		this.visited.add(new Position(x, y)); 
	}

	
	public void visit() {
		visited.add(new Position(x, y));
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Directions getDirection() {
		return directions;
	}

	public void setDirection(Directions directions) {
		this.directions = directions;
	}

	public List<Position> getVisited() {
		return visited;
	}
}
