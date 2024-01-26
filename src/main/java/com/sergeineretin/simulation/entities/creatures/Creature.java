package com.sergeineretin.simulation.entities.creatures;

import com.sergeineretin.simulation.Coordinates;
import com.sergeineretin.simulation.Map;
import com.sergeineretin.simulation.entities.Entity;

import java.util.*;

public abstract class Creature extends Entity {
    public int speed;
    public int hitPoints;
    List<Coordinates> path = new LinkedList<>();

    public Creature(Coordinates coordinates, int speed, int hitPoints) {
        super(coordinates);
        this.speed = speed;
        this.hitPoints = hitPoints;
    }
    public abstract void makeMove(Map map);

    public double distanceHeuristic(Coordinates start, Coordinates end) {
        return Math.sqrt((start.x - end.x) * (start.x - end.x) + ((start.y - end.y) * (start.y - end.y)));
    }
    public HashMap<Coordinates, Coordinates> bfs(Coordinates start, Coordinates end, Map map) {
        Queue<Coordinates> queue = new PriorityQueue<>();
        HashMap<Coordinates,Coordinates> visited = new HashMap<>();
        queue.add(start);
        while (!queue.isEmpty())
        {
            Coordinates node = queue.poll();
            if (node.equals(end))
                return visited;
            for (Coordinates coordinates :
                 expand(node, map)) {
                if (!visited.containsKey(coordinates)){
                    queue.add(coordinates);
                    visited.put(coordinates, node);
                }
            }
        }
        return null;
    }
    public void backtrace (HashMap<Coordinates,Coordinates> visited, Coordinates start, Coordinates end) {
        if (visited != null){
            path.add(end);
            while (!Objects.equals(path.get(path.size() - 1), start)) {
                path.add(visited.get(path.get(path.size() - 1)));
            }
            Collections.reverse(path);
            path.remove(0);
        }
    }
    public Coordinates getTargetCoordinates(Map map, String nameOfInstance) {
        Coordinates grassCoords = new Coordinates(0,0);
        double minDistance = distanceHeuristic(new Coordinates(0,0), new Coordinates(map.xDimension,map.yDimension));
        for (java.util.Map.Entry<Coordinates, Entity> entry : map.getEntities().entrySet()) {
            Entity value = entry.getValue();
            Coordinates key= entry.getKey();
            if (value.getClass().getSimpleName().equals(nameOfInstance)) {
                double dh = distanceHeuristic(coordinates, key);
                if (dh < minDistance){
                    grassCoords = key;
                    minDistance = dh;
                }
            }
        }
        return grassCoords;
    }
    public List<Coordinates> expand(Coordinates currNode, Map map) {
        List<Coordinates> childs = new ArrayList<>();
        if (canMove(new Coordinates(currNode.x + 1, currNode.y), map))
            childs.add(new Coordinates(currNode.x + 1, currNode.y));
        if (canMove(new Coordinates(currNode.x, currNode.y + 1), map))
            childs.add(new Coordinates(currNode.x, currNode.y + 1));
        if (canMove(new Coordinates(currNode.x + 1, currNode.y + 1), map))
            childs.add(new Coordinates(currNode.x + 1, currNode.y + 1));
        if (canMove(new Coordinates(currNode.x - 1, currNode.y), map))
            childs.add(new Coordinates(currNode.x - 1, currNode.y));
        if (canMove(new Coordinates(currNode.x, currNode.y - 1), map))
            childs.add(new Coordinates(currNode.x, currNode.y - 1));
        if (canMove(new Coordinates(currNode.x - 1, currNode.y - 1), map))
            childs.add(new Coordinates(currNode.x - 1, currNode.y - 1));
        if (canMove(new Coordinates(currNode.x + 1, currNode.y - 1), map))
            childs.add(new Coordinates(currNode.x + 1, currNode.y - 1));
        if (canMove(new Coordinates(currNode.x - 1, currNode.y + 1),map))
            childs.add(new Coordinates(currNode.x - 1, currNode.y + 1));
        return childs;
    }
    public abstract boolean canMove(Coordinates coordinates, Map map);
}
