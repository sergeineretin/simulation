package com.sergeineretin.simulation.entity.creature;

import com.sergeineretin.simulation.Coordinates;
import com.sergeineretin.simulation.entity.Entity;

public abstract class Creature extends Entity {
    public int speed;
    public int hitPoints;
    public Creature(Coordinates coordinates, int speed, int hitPoints) {
        super(coordinates);
        this.speed = speed;
        this.hitPoints = hitPoints;
    }
    public abstract void makeMove();
}
