package com.thotael.scrappies.world;

import com.thotael.scrappies.world.animalcule.Scrappy;
import com.thotael.scrappies.world.terrain.Ground;

import java.util.Arrays;

public class Map {

    private int width;
    private int height;
    private MapObject[][] map;

    public Map(int width, int height) {
        this.width = width;
        this.height = height;
        this.map = new MapObject[height][width];
        for (MapObject[] row : map) {
            Arrays.fill(row, new Ground());
        }
    }

    @Override
    public String toString() {
        return mapToString(map);
    }

    private String mapToString(MapObject[][] array) {
        String result = "";

        for (int i = 0; i < array.length; i++) {
            MapObject[] row = array[i];
            for (MapObject cell : row) {
                result += cell.getAppearance();
            }
            if (i < array.length - 1) {
                result += "\n";
            }
        }
        return result;
    }

    public void place(Scrappy scrappy, int x, int y) throws OutsideTheMapPlacementException {
        if (x >= width || y >= height) {
            throw new OutsideTheMapPlacementException(width, height, x, y);
        }
        map[x][y] = scrappy;
    }

}
