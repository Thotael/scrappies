package com.thotael.scrappies.world;

public class OutsideTheMapPlacementException extends Exception {

    public OutsideTheMapPlacementException(int width, int height, int x, int y) {
        super(prepareMessage(width, height, x, y));
    }

    private static String prepareMessage(int width, int height, int x, int y) {
        String msg = "Trying to place object outside the map:\n";
        if (x >= width) {
            msg += "x = " + x + ", map width range 0-" + (width - 1) + "\n";
        }
        if (y >= height) {
            msg += "y = " + y + ", map height range 0-" + (height - 1) + "\n";
        }
        return msg;
    }
}
