package com.thotael.scrappies.world;

public class IllegalPlaceException extends RuntimeException {

    public IllegalPlaceException(MapObject object, int x, int y) {
        super(prepareMessage(object, x, y));
    }

    private static String prepareMessage(MapObject object, int x, int y) {
        return "[" + x + ", " + y + "] Trying to place something on illegal object: " + object;
    }
}
