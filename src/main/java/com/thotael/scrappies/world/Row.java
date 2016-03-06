package com.thotael.scrappies.world;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Row {

    private List<MapObject> elements = new ArrayList<>();

    public Row(int length, MapObject object) {
        fill(length, object);
    }

    public List<MapObject> getElements() {
        return elements;
    }

    public void fill(int length, MapObject object) {
        elements = Stream.generate(() -> object)
                .limit(length)
                .collect(Collectors.toList());
    }
}
