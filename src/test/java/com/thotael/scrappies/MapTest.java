package com.thotael.scrappies;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MapTest {

    private Map map;

    @Test
    public void create_emptyMap_correctlyFilled() {
        // given
        map = new Map(0, 0);

        // when
        String result = map.toString();

        // then
        assertThat(result, is(""));
    }

    @Test
    public void create_1x1Map_correctlyFilled() {
        // given
        map = new Map(1, 1);

        // when
        String result = map.toString();

        // then
        assertThat(result, is("_"));
    }

    @Test
    public void create_2x1Map_correctlyFilled() {
        // given
        map = new Map(2, 1);

        // when
        String result = map.toString();

        // then
        assertThat(result, is("__"));
    }

    @Test
    public void create_2x2Map_correctlyFilled() {
        // given
        map = new Map(2, 2);

        // when
        String result = map.toString();

        // then
        assertThat(result, is(
                "__\n" +
                        "__"
        ));
    }

    @Test
    public void create_3x3Map_correctlyFilled() {
        // given
        map = new Map(3, 3);

        // when
        String result = map.toString();

        // then
        assertThat(result, is(
                "___\n" +
                        "___\n" +
                        "___"
        ));
    }
}