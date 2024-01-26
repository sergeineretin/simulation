package com.sergeineretin.simulation;

import com.sergeineretin.simulation.actions.Action;
import com.sergeineretin.simulation.actions.MoveCreatures;
import com.sergeineretin.simulation.actions.SetRandomEntitiesPositions;

public class Simulation {
    Simulation()
    {
        SetRandomEntitiesPositions setRandomEntitiesPositions = new SetRandomEntitiesPositions();
        setRandomEntitiesPositions.perform(map);
    }
    Map map = new Map(30,30);
    MapConsoleRenderer mapConsoleRenderer = new MapConsoleRenderer();
    private int moveCounter = 1;
    public void startSimulation() {
        while (!endSimulation()) {
            nextTurn();
        }
    }
    public void nextTurn()
    {
        mapConsoleRenderer.render(map);
        Action moveCreatures = new MoveCreatures();
        moveCreatures.perform(map);
        moveCounter = map.getNumberOfChangesAtCurrentTurn();
    }
    public boolean endSimulation() {
        return moveCounter == 0;
    }
}
