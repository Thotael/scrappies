package com.thotael.scrappies;

import com.thotael.scrappies.world.OutsideTheMapException;
import com.thotael.scrappies.world.WorldMap;
import com.thotael.scrappies.world.animalcule.Scrappy;

public class Launcher {

    public static void main(String[] args) throws OutsideTheMapException {
        WorldMap map = new WorldMap(7, 5);
        map.place(new Scrappy(), 3, 3);
        System.out.println(map);
    }

}
