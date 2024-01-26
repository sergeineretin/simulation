package com.sergeineretin.simulation.entities;

import com.sergeineretin.simulation.Coordinates;

abstract public class Entity {
    public Coordinates coordinates;

    public Entity(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}
