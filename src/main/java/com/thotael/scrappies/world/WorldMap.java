package com.thotael.scrappies.world;

import com.thotael.scrappies.world.terrain.Ground;

import java.util.HashMap;
import java.util.Map;

public class WorldMap {

    public Map<Integer, Row> maps = new HashMap<>();
    private int width;
    private int height;

    public WorldMap(int width, int height) {
        this.width = width;
        this.height = height;

        for (int col = 0; col < height; col++) {
            maps.put(col, new Row(width, new Ground()));
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

    public void place(MapObject object, int x, int y) throws OutsideTheMapPlacementException {
        if (x >= width || y >= height) {
            throw new OutsideTheMapPlacementException(width, height, x, y);
        }
        maps.get(y).getElements().set(x, object);
    }

}
