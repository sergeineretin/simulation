package com.sergeineretin.simulation;

import com.sergeineretin.simulation.entities.Entity;
import java.util.HashMap;

public class Map {
    public final int xDimension;
    public final int yDimension;
    private int numberOfChangesAtCurrentTurn = 0;
    public HashMap<Coordinates, Entity> getEntities() {
        return entities;
    }
    public Map(int xDimension, int yDimension) {
        this.xDimension = xDimension;
        this.yDimension = yDimension;
    }
    HashMap<Coordinates, Entity> entities = new HashMap<>();
    public void setEntity(Entity entity, Coordinates coordinates) {
        entity.coordinates = coordinates;
        entities.put(coordinates, entity);
        numberOfChangesAtCurrentTurn++;
    }
    public boolean isSquareEmpty(Coordinates coordinates){
        return !entities.containsKey(coordinates);
    }
    public void moveCreature(Coordinates from, Coordinates to){
        Entity creature = getEntity(from);
        removeEntity(from);
        setEntity(creature, to);
    }
    public void removeEntity(Coordinates coordinates) {
        numberOfChangesAtCurrentTurn++;
        entities.remove(coordinates);
    }
    public Entity getEntity(Coordinates coordinates) {
        return  entities.get(coordinates);
    }
    public int getNumberOfChangesAtCurrentTurn() {
        int value = numberOfChangesAtCurrentTurn;
        numberOfChangesAtCurrentTurn = 0;
        return value;
    }
}
