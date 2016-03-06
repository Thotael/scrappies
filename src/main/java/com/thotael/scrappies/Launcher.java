package com.thotael.scrappies;

import com.thotael.scrappies.world.WorldMap;
import com.thotael.scrappies.world.animalcule.Scrappy;
import com.thotael.scrappies.world.terrain.Mountain;

public class Launcher {

    public static void main(String[] args) {
        WorldMap map = new WorldMap(7, 5);
        map.place(new Scrappy(), 3, 4);
        System.out.println(map);


        System.out.println(new Mountain());
    }

}
