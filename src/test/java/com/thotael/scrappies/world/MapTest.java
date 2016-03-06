package com.thotael.scrappies.world;

import com.thotael.scrappies.animalcule.Scrappy;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MapTest {

    private Map map;

    @Before
    public void before() {
        map = new Map(3, 3);
    }

    @Test
    public void create_emptyMap_correctlyFilled() {
        // given
        map = new Map(0, 0);

        // then
        assertThat(map.toString(), is(""));
    }

    @Test
    public void create_1x1Map_correctlyFilled() {
        // given
        map = new Map(1, 1);

        // then
        assertThat(map.toString(), is("_"));
    }

    @Test
    public void create_2x1Map_correctlyFilled() {
        // given
        map = new Map(2, 1);

        // then
        assertThat(map.toString(), is("__"));
    }

    @Test
    public void create_2x2Map_correctlyFilled() {
        // given
        map = new Map(2, 2);

        // then
        assertThat(map.toString(), is(
                "__\n" +
                "__"
        ));
    }

    @Test
    public void create_3x3Map_correctlyFilled() {
        // given
        map = new Map(3, 3);

        // then
        assertThat(map.toString(), is(
                "___\n" +
                "___\n" +
                "___"
        ));
    }

    @Test
    public void placedScrappy_isDisplayed() {
        // given
        Scrappy scrappy = new Scrappy();

        // when
        map.place(scrappy, 1, 1);

        // then
        assertThat(map.toString(), is(
                "___\n" +
                "_$_\n" +
                "___"
        ));
    }
}