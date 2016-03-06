package com.thotael.scrappies.world.terrain;

import com.thotael.scrappies.world.MapObject;

public class Mountain implements MapObject {

    @Override
    public String getAppearance() {
        return "^";
    }

    @Override
    public String toString() {
        return "[" + this.getClass().getSimpleName() + ": " + getAppearance() + "]";
    }
}
