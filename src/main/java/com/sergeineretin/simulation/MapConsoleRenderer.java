package com.sergeineretin.simulation;

import com.sergeineretin.simulation.entities.Entity;

public class MapConsoleRenderer {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLACK_BACKGROUND = "\u001B[0;100m";

    public void render(Map map) {
        System.out.println();
        for (int i = map.xDimension; i >= 0; i--) {
            StringBuilder line = new StringBuilder();
            for (int j = 0; j < map.yDimension; j++) {
                Coordinates coordinates = new Coordinates(i,j);
                if (map.isSquareEmpty(coordinates)) {
                    line.append(getSpriteForEmptySquare(new Coordinates(i, j)));
                }
                else {
                    line.append(getEntitiesSprite(map.getEntity(coordinates)));
                }
            }
            System.out.println(line + ANSI_RESET);
        }
        System.out.println();
    }

    private String selectUnicodeSpriteForEntity(Entity entity) {
        return switch (entity.getClass().getSimpleName()) {
            case "Tree" -> "\uD83C\uDF33";
            case "Rock" -> "\uD83D\uDDFF";
            case "Grass" -> "\uD83C\uDF31";
            case "Herbivore" -> "\uD83D\uDC16";
            case "Predator" -> "\uD83D\uDC05";
            default -> " ";
        };
    }

    private String getEntitiesSprite(Entity entity) {
        return selectUnicodeSpriteForEntity(entity);
    }

    private String getSpriteForEmptySquare(Coordinates coordinates) {
        return ANSI_BLACK_BACKGROUND + "   ";
    }
}
