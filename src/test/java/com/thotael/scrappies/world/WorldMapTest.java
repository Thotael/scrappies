package com.thotael.scrappies.world;

import com.thotael.scrappies.world.animalcule.Scrappy;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WorldMapTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();
    private WorldMap map;

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
    public void placedScrappy_isDisplayed() throws OutsideTheMapException {
        // given
        map = new WorldMap(3, 3);
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
                .isInstanceOf(OutsideTheMapException.class)
                .hasMessage("Trying to reach outside the map:\n" +
                        "y = 15, map height range 0-4\n");
    }

    @Test
    public void placedScrappy_tooBigWidth() throws OutsideTheMapException {
        // given
        map = new WorldMap(5, 5);
        Scrappy scrappy = new Scrappy();

        // when
        assertThatThrownBy(() -> map.place(scrappy, 15, 1))

        // then
                .isInstanceOf(OutsideTheMapException.class)
                .hasMessage("Trying to reach outside the map:\n" +
                        "x = 15, map width range 0-4\n");
    }

    @Test
    public void placedScrappy_tooBigWidthAndHeight() throws OutsideTheMapException {
        // given
        map = new WorldMap(5, 5);
        Scrappy scrappy = new Scrappy();

        // when
        assertThatThrownBy(() -> map.place(scrappy, 15, 15))

        // then
                .isInstanceOf(OutsideTheMapException.class)
                .hasMessage("Trying to reach outside the map:\n" +
                        "x = 15, map width range 0-4\n" +
                        "y = 15, map height range 0-4\n");
    }

    @Test
    public void placedScrappy_equalWidthAndHeight() throws OutsideTheMapException {
        // given
        map = new WorldMap(3, 2);
        Scrappy scrappy = new Scrappy();

        // when
        assertThatThrownBy(() -> map.place(scrappy, 3, 2))

        // then
                .isInstanceOf(OutsideTheMapException.class)
                .hasMessage("Trying to reach outside the map:\n" +
                        "x = 3, map width range 0-2\n" +
                        "y = 2, map height range 0-1\n");
    }

    @Test
    public void getScrappyFromMap_tooBigX() throws OutsideTheMapException {
        // given
        map = new WorldMap(7, 5);
        map.place(new Scrappy(), 3, 3);

        // when
        assertThatThrownBy(() -> map.getObject(7, 3))

                // then
                .isInstanceOf(OutsideTheMapException.class)
                .hasMessage("Trying to reach outside the map:\n" +
                        "x = 7, map width range 0-6\n");
    }

    @Test
    public void getScrappyFromMap_tooBigY() throws OutsideTheMapException {
        // given
        map = new WorldMap(7, 5);
        map.place(new Scrappy(), 3, 3);

        // when
        assertThatThrownBy(() -> map.getObject(3, 5))

                // then
                .isInstanceOf(OutsideTheMapException.class)
                .hasMessage("Trying to reach outside the map:\n" +
                        "y = 5, map height range 0-4\n");
    }

    @Test
    public void getScrappyFromMap_tooBigXY() throws OutsideTheMapException {
        // given
        map = new WorldMap(7, 5);
        map.place(new Scrappy(), 3, 3);

        // when
        assertThatThrownBy(() -> map.getObject(7, 5))

                // then
                .isInstanceOf(OutsideTheMapException.class)
                .hasMessage("Trying to reach outside the map:\n" +
                        "x = 7, map width range 0-6\n" +
                        "y = 5, map height range 0-4\n");
    }

    @Test
    public void getScrappyFromMap_withinTheMap() throws OutsideTheMapException {
        // given
        map = new WorldMap(7, 5);
        Scrappy scrappy = new Scrappy();
        map.place(scrappy, 3, 3);

        // when
        MapObject object = map.getObject(3, 3);

        // then
        assertThat(object).isEqualTo(scrappy);
    }
}