package com.thotael.scrappies.world;

import com.thotael.scrappies.animalcule.Scrappy;

import java.util.Arrays;

public class Map {

    private static final String FILLER_CHAR = "_";

    private String[][] map;

    public Map(int height, int width) {
        this.map = new String[width][height];
        for (String[] row : map) {
            Arrays.fill(row, FILLER_CHAR);
        }
    }

    @Override
    public String toString() {
        return mapToString(map);
    }

    private String mapToString(String[][] array) {
        String result = "";

        for (int i = 0; i < array.length; i++) {
            String[] row = array[i];
            for (String cell : row) {
                result += cell;
            }
            if (i < array.length - 1) {
                result += "\n";
            }
        }
        return result;
    }

    public void place(Scrappy scrappy, int x, int y) {
        map[x][y] = scrappy.getAppearance();
    }
}
