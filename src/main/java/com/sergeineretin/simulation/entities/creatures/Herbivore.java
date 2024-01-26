package com.sergeineretin.simulation.entities.creatures;

import com.sergeineretin.simulation.Coordinates;
import com.sergeineretin.simulation.Map;
import com.sergeineretin.simulation.entities.Grass;

public class Herbivore extends Creature {
    public Herbivore(Coordinates coordinates, int speed, int hitPoints) {
        super(coordinates, speed, hitPoints);
    }
    @Override
    public void makeMove(Map map) {
        Coordinates grassCoordinates = getTargetCoordinates(map, "Grass");
        if(path.isEmpty())
            backtrace(bfs(coordinates,grassCoordinates,map), coordinates, grassCoordinates);
        if(path.size() > speed && canMove(path.get(speed - 1), map)) {
            coordinates = path.get(speed - 1);
            if (speed > 0) {
                path.subList(0, speed).clear();
            }
        }
        else if(!path.isEmpty() && canMove(path.get(path.size() - 1), map)) {
            map.removeEntity(path.get(path.size() - 1));
            coordinates = path.get(path.size() - 1);
            path.subList(0, path.size()).clear();
        }
    }
    @Override
    public boolean canMove(Coordinates coordinates, Map map) {
        if (coordinates.x > 0 && coordinates.x < map.xDimension && coordinates.y > 0 && coordinates.y < map.yDimension)
            return map.getEntity(coordinates) instanceof Grass || map.isSquareEmpty(coordinates);
        return false;
    }

}
