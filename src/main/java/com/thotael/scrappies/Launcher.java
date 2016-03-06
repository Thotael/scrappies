package com.thotael.scrappies;

import com.thotael.scrappies.world.MapController;
import com.thotael.scrappies.world.WorldMap;
import com.thotael.scrappies.world.animalcule.Scrappy;

public class Launcher {

    public static void main(String[] args) {
        WorldMap map = new WorldMap(7, 5);
        MapController mapController = new MapController(map);
        mapController.place(new Scrappy(), 3, 3);

        System.out.println(map);
    }

}
