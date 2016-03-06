package com.thotael.scrappies.world;

import com.thotael.scrappies.world.terrain.Ground;
import com.thotael.scrappies.world.terrain.Mountain;

import java.util.HashMap;
import java.util.Map;

public class WorldMap {

    public Map<Integer, Row> maps = new HashMap<>();
    private int width;
    private int height;

    public WorldMap(int width, int height) {
        if (width < 3 || height < 3) {
            throw new TooSmallAreaException();
        }
        this.width = width;
        this.height = height;
        fillTheMap(width, height);
    }

    private void fillTheMap(int width, int height) {
        for (int col = 0; col < height; col++) {
            if (col == 0 || col == height - 1) {
                maps.put(col, new Row(width, new Mountain()));
            } else {
                maps.put(col, new Row(width, new Ground(), new Mountain()));
            }
        }
    }

    @Override
    public String toString() {
        return mapToString(maps);
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

    public void place(MapObject object, int x, int y){
        checkIfReachingWithinTheMap(x, y);
        checkIfLegalPlace(x, y);

        maps.get(y).getElements().set(x, object);
    }

    public MapObject getObject(int x, int y) {
        checkIfReachingWithinTheMap(x, y);

        return maps.get(y).getElements().get(x);
    }

    private void checkIfReachingWithinTheMap(int x, int y) {
        if (x >= width || y >= height) {
            throw new OutsideTheMapException(width, height, x, y);
        }
    }

    private void checkIfLegalPlace(int x, int y) {
        MapObject object = getObject(x, y);
        if (object instanceof Mountain) {
           throw new IllegalPlaceException(object, x, y);
        }
    }
}
