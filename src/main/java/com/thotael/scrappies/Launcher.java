package com.thotael.scrappies;

import com.thotael.scrappies.world.Map;
import com.thotael.scrappies.world.OutsideTheMapPlacementException;
import com.thotael.scrappies.world.animalcule.Scrappy;

public class Launcher {

    public static void main(String[] args) throws OutsideTheMapPlacementException {
        Map map = new Map(10, 1);
        map.place(new Scrappy(), 15, 8);
        System.out.println(map);
    }

}
