package com.thotael.scrappies.world.terrain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MountainTest {

    @Test
    public void testGetAppearance() throws Exception {
        // given
        Mountain mountain = new Mountain();

        // then
        assertThat(mountain.getAppearance()).isEqualTo("^");
    }

    @Test
    public void testToString() throws Exception {
        // given
        Mountain mountain = new Mountain();

        // then
        assertThat(mountain.toString()).isEqualTo("[Mountain: ^]");
    }
}