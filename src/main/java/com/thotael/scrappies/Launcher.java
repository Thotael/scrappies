package com.thotael.scrappies;

import com.thotael.scrappies.world.Map;

public class Launcher {

    public static void main(String[] args) {
        Map map = new Map(30, 10);
        String print = map.toString();
        System.out.println(print);
    }

}
