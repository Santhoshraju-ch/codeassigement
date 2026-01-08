package com.codeassigements.enu;

public enum Directions {

	NORTH, WEST, SOUTH, EAST;

	public Directions left() {
		return values()[(ordinal() + 3) % 4];
	}

	public Directions right() {
		return values()[(ordinal() + 1) % 4];
	}
}
