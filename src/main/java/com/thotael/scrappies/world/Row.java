package com.thotael.scrappies.world;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Row {

    private List<MapObject> elements = new ArrayList<>();

    public Row(int length, MapObject object) {
        elements = getFilledList(length, object);
    }

    public Row(int length, MapObject object, MapObject border) {
        elements.add(border);
        elements.addAll(getFilledList(length - 2, object));
        elements.add(border);
    }

    public List<MapObject> getElements() {
        return elements;
    }

    public List<MapObject> getFilledList(int length, MapObject object) {
        return Stream.generate(() -> object)
                .limit(length)
                .collect(Collectors.toList());
    }
}
