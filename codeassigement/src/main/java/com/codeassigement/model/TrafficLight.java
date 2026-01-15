package com.codeassigement.model;



import java.time.LocalDateTime;
import java.util.Map;

import com.codeassigement.enu.Direction;
import com.codeassigement.enu.LightColor;

public class TrafficLight {

    private final Direction direction;
    private LightColor color;

    public TrafficLight(Direction direction) {
        this.direction = direction;
        this.color = LightColor.RED; 
    }

    public Direction getDirection() {
        return direction;
    }

    public LightColor getColor() {
        return color;
    }

    public void setColor(LightColor color) {
        this.color = color;
    }
}