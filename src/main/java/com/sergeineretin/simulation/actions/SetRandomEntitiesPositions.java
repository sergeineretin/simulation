package com.sergeineretin.simulation.actions;

import com.sergeineretin.simulation.Coordinates;
import com.sergeineretin.simulation.Map;
import com.sergeineretin.simulation.entities.Grass;
import com.sergeineretin.simulation.entities.Rock;
import com.sergeineretin.simulation.entities.creatures.Herbivore;
import com.sergeineretin.simulation.entities.creatures.Predator;

public class SetRandomEntitiesPositions extends Action {

    @Override
    public void perform(Map map) {

        map.setEntity(new Rock(new Coordinates(6,6)), new Coordinates(6,6));
        map.setEntity(new Rock(new Coordinates(5,5)), new Coordinates(5,5));
        map.setEntity(new Rock(new Coordinates(5,6)), new Coordinates(5,6));
        map.setEntity(new Rock(new Coordinates(4,6)), new Coordinates(4,6));
        map.setEntity(new Rock(new Coordinates(3,6)), new Coordinates(3,6));
        map.setEntity(new Rock(new Coordinates(6,5)), new Coordinates(6,5));
        map.setEntity(new Rock(new Coordinates(6,4)), new Coordinates(6,4));
        map.setEntity(new Rock(new Coordinates(6,3)), new Coordinates(6,3));
        map.setEntity(new Grass(new Coordinates(4,4)), new Coordinates(4,4));
        map.setEntity(new Grass(new Coordinates(19,1)), new Coordinates(19,1));
        map.setEntity(new Grass(new Coordinates(13,13)), new Coordinates(13,13));
        for (int i = 0; i < (int)Math.floor(Math.random() * map.xDimension * map.yDimension ); i++) {
            int randomPositionX = (int)Math.floor(Math.random() * map.xDimension);
            int randomPositionY = (int)Math.floor(Math.random() * map.yDimension);
            if (map.isSquareEmpty(new Coordinates(randomPositionX, randomPositionY))) {
                map.setEntity(new Herbivore(new Coordinates(randomPositionX,randomPositionY),1, 4), new Coordinates(randomPositionX,randomPositionY));
                //map.setEntity(new Predator(new Coordinates(randomPositionX,randomPositionY),2, 4), new Coordinates(randomPositionX,randomPositionY));
            }
        }
        //map.setEntity(new Herbivore(new Coordinates(6,10),1, 4), new Coordinates(6,10));
        //map.setEntity(new Predator(new Coordinates(5,9),5, 4), new Coordinates(5,9));

    }
}
