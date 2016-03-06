package com.thotael.scrappies.world.terrain;

import com.thotael.scrappies.world.MapObject;

public class Ground implements MapObject {

    @Override
    public String getAppearance() {
        return "_";
    }

    @Override
    public String toString() {
        return "[" + this.getClass().getSimpleName() + ": " + getAppearance() + "]";
    }
}
