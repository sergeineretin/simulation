package com.sergeineretin.simulation.actions;

import com.sergeineretin.simulation.Coordinates;
import com.sergeineretin.simulation.Map;
import com.sergeineretin.simulation.entities.Entity;
import com.sergeineretin.simulation.entities.creatures.Creature;

import java.util.HashMap;

public class MoveCreatures extends Action {
    @Override
    public void perform(Map map) {
        HashMap<Coordinates, Entity> curMap = new HashMap<Coordinates, Entity>(map.getEntities());
        for (var entry : curMap.entrySet()) {
            Entity value = entry.getValue();
            Coordinates key= entry.getKey();
            if (value instanceof Creature)
            {
                ((Creature) value).makeMove(map);
                if (value.coordinates != key) {
                    map.moveCreature(key, value.coordinates);
                }
            }
        }
    }
}
