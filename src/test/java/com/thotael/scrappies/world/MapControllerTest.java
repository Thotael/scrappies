package com.thotael.scrappies.world;

import com.thotael.scrappies.world.animalcule.Scrappy;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MapControllerTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private WorldMap map;
    private MapController mapController;

    @Before
    public void before() {
        map = new WorldMap(7, 5);
        mapController = new MapController(map);
    }

    @Test
    public void placedScrappy_isDisplayed() throws OutsideTheMapException {
        // given
        Scrappy scrappy = new Scrappy();

        // when
        mapController.place(scrappy, 1, 1);

        // then
        assertThat(map.toString()).isEqualTo(
                "^^^^^^^\n" +
                        "^$____^\n" +
                        "^_____^\n" +
                        "^_____^\n" +
                        "^^^^^^^\n"
        );
    }

    @Test
    public void placedScrappy_tooBigHeight() {
        // given
        Scrappy scrappy = new Scrappy();

        // when
        assertThatThrownBy(() -> mapController.place(scrappy, 1, 15))

                // then
                .isInstanceOf(OutsideTheMapException.class)
                .hasMessage("Trying to reach outside the map:\n" +
                        "y = 15, map height range 0-4\n");
    }

    @Test
    public void placedScrappy_tooBigWidth() throws OutsideTheMapException {
        // given
        Scrappy scrappy = new Scrappy();

        // when
        assertThatThrownBy(() -> mapController.place(scrappy, 15, 1))

                // then
                .isInstanceOf(OutsideTheMapException.class)
                .hasMessage("Trying to reach outside the map:\n" +
                        "x = 15, map width range 0-6\n");
    }

    @Test
    public void placedScrappy_tooBigWidthAndHeight() throws OutsideTheMapException {
        // given
        Scrappy scrappy = new Scrappy();

        // when
        assertThatThrownBy(() -> mapController.place(scrappy, 15, 15))

                // then
                .isInstanceOf(OutsideTheMapException.class)
                .hasMessage("Trying to reach outside the map:\n" +
                        "x = 15, map width range 0-6\n" +
                        "y = 15, map height range 0-4\n");
    }

    @Test
    public void placedScrappy_equalWidthAndHeight() throws OutsideTheMapException {
        // given
        Scrappy scrappy = new Scrappy();

        // when
        assertThatThrownBy(() -> mapController.place(scrappy, 7, 5))

                // then
                .isInstanceOf(OutsideTheMapException.class)
                .hasMessage("Trying to reach outside the map:\n" +
                        "x = 7, map width range 0-6\n" +
                        "y = 5, map height range 0-4\n");
    }

    @Test
    public void placeObject_OnMountain() throws OutsideTheMapException {
        // given
        Scrappy scrappy = new Scrappy();

        // when
        assertThatThrownBy(() -> mapController.place(scrappy, 6, 4))

                // then
                .isInstanceOf(IllegalPlaceException.class)
                .hasMessage("[6, 4] Trying to place something on illegal object: [Mountain: ^]");
    }
}