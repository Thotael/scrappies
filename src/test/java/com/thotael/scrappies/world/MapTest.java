package com.thotael.scrappies.world;

import com.thotael.scrappies.world.animalcule.Scrappy;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MapTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();
    private WorldMap map;

    @Before
    public void before() {
        map = new WorldMap(3, 3);
    }

    @Test
    public void create_emptyMap_correctlyFilled() {
        // given
        map = new WorldMap(0, 0);

        // then
        assertThat(map.toString()).isEqualTo("");
    }

    @Test
    public void create_1x1Map_correctlyFilled() {
        // given
        map = new WorldMap(1, 1);

        // then
        assertThat(map.toString()).isEqualTo("_\n");
    }

    @Test
    public void create_2x1Map_correctlyFilled() {
        // given
        map = new WorldMap(2, 1);

        // then
        assertThat(map.toString()).isEqualTo("__\n");
    }

    @Test
    public void create_2x2Map_correctlyFilled() {
        // given
        map = new WorldMap(2, 2);

        // then
        assertThat(map.toString()).isEqualTo(
                "__\n" +
                "__\n"
        );
    }

    @Test
    public void create_3x3Map_correctlyFilled() {
        // given
        map = new WorldMap(3, 3);

        // then
        assertThat(map.toString()).isEqualTo(
                "___\n" +
                "___\n" +
                "___\n"
        );
    }

    @Test
    public void placedScrappy_isDisplayed() throws OutsideTheMapPlacementException {
        // given
        Scrappy scrappy = new Scrappy();

        // when
        map.place(scrappy, 1, 1);

        // then
        assertThat(map.toString()).isEqualTo(
                "___\n" +
                "_$_\n" +
                "___\n"
        );
    }

    @Test
    public void placedScrappy_tooBigHeight() {
        // given
        map = new WorldMap(5, 5);
        Scrappy scrappy = new Scrappy();

        // when
        assertThatThrownBy(() -> map.place(scrappy, 1, 15))

        // then
                .isInstanceOf(OutsideTheMapPlacementException.class)
                .hasMessage("Trying to place object outside the map:\n" +
                        "y = 15, map height range 0-4\n");
    }

    @Test
    public void placedScrappy_tooBigWidth() throws OutsideTheMapPlacementException {
        // given
        map = new WorldMap(5, 5);
        Scrappy scrappy = new Scrappy();

        // when
        assertThatThrownBy(() -> map.place(scrappy, 15, 1))

        // then
                .isInstanceOf(OutsideTheMapPlacementException.class)
                .hasMessage("Trying to place object outside the map:\n" +
                        "x = 15, map width range 0-4\n");
    }

    @Test
    public void placedScrappy_tooBigWidthAndHeight() throws OutsideTheMapPlacementException {
        // given
        map = new WorldMap(5, 5);
        Scrappy scrappy = new Scrappy();

        // when
        assertThatThrownBy(() -> map.place(scrappy, 15, 15))

        // then
                .isInstanceOf(OutsideTheMapPlacementException.class)
                .hasMessage("Trying to place object outside the map:\n" +
                        "x = 15, map width range 0-4\n" +
                        "y = 15, map height range 0-4\n");
    }

    @Test
    public void placedScrappy_equalWidthAndHeight() throws OutsideTheMapPlacementException {
        // given
        map = new WorldMap(3, 2);
        Scrappy scrappy = new Scrappy();

        // when
        assertThatThrownBy(() -> map.place(scrappy, 3, 2))

        // then
                .isInstanceOf(OutsideTheMapPlacementException.class)
                .hasMessage("Trying to place object outside the map:\n" +
                        "x = 3, map width range 0-2\n" +
                        "y = 2, map height range 0-1\n");
    }
}