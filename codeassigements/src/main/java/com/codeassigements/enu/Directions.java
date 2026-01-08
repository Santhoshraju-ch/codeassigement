package com.codeassigements.enu;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Directions {

	 N, S, E, W;

	@JsonCreator
	public static Directions fromString(String value) {
		return Directions.valueOf(value.toUpperCase());
	}

	public Directions left() {
		return values()[(ordinal() + 3) % 4];
	}

	public Directions right() {
		return values()[(ordinal() + 1) % 4];
	}
}
