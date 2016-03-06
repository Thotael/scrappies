package com.thotael.scrappies.world;

import com.thotael.scrappies.world.terrain.Ground;
import com.thotael.scrappies.world.terrain.Mountain;

import java.util.HashMap;
import java.util.Map;

public class WorldMap {

    private int width;
    private int height;
    private Map<Integer, Row> content = new HashMap<>();

    public WorldMap(int width, int height) {
        if (width < 3 || height < 3) {
            throw new TooSmallAreaException();
        }
        this.width = width;
        this.height = height;
        fillTheMap(width, height);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Map<Integer, Row> getContent() {
        return content;
    }

    private void fillTheMap(int width, int height) {
        for (int col = 0; col < height; col++) {
            if (col == 0 || col == height - 1) {
                content.put(col, new Row(width, new Mountain()));
            } else {
                content.put(col, new Row(width, new Ground(), new Mountain()));
            }
        }
    }

    @Override
    public String toString() {
        return mapToString(content);
    }

    private String mapToString(Map<Integer, Row> map) {
        StringBuilder sb = new StringBuilder();

        map.values()
                .forEach(row -> appendSBWithRowElements(sb, row));

        return sb.toString();
    }

    private void appendSBWithRowElements(StringBuilder sb, Row row) {
        row.getElements().stream()
                .map(MapObject::getAppearance)
                .forEach(sb::append);
        sb.append("\n");
    }

    public void checkIfReachingWithinTheMap(int x, int y) {
        if (x >= width || y >= height) {
            throw new OutsideTheMapException(width, height, x, y);
        }
    }

    public MapObject getObject(int x, int y) {
        checkIfReachingWithinTheMap(x, y);

        return content.get(y).getElements().get(x);
    }
}
