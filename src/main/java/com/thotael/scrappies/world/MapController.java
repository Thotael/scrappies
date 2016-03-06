package com.thotael.scrappies.world;

import com.thotael.scrappies.world.terrain.Mountain;

public class MapController {

    private WorldMap map;

    public MapController(WorldMap map) {
        this.map = map;
    }

    public void place(MapObject object, int x, int y){
        map.checkIfReachingWithinTheMap(x, y);
        checkIfLegalPlace(x, y);

        map.getContent().get(y).getElements().set(x, object);
    }

    private void checkIfLegalPlace(int x, int y) {
        MapObject object = map.getObject(x, y);
        if (object instanceof Mountain) {
            throw new IllegalPlaceException(object, x, y);
        }
    }
}
