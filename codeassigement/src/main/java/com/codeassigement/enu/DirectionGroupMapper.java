package com.codeassigement.enu;

import java.util.EnumSet;
import java.util.Set;

public enum DirectionGroupMapper {

    NORTH_SOUTH(EnumSet.of(Direction.NORTH, Direction.SOUTH)),
    EAST_WEST(EnumSet.of(Direction.EAST, Direction.WEST));

    private final Set<Direction> directions;

    DirectionGroupMapper(Set<Direction> directions) {
        this.directions = directions;
    }

    public Set<Direction> getDirections() {
        return directions;
    }

    public DirectionGroup next() {
        return this == NORTH_SOUTH ? DirectionGroup.EAST_WEST : DirectionGroup.NORTH_SOUTH;
    }
}