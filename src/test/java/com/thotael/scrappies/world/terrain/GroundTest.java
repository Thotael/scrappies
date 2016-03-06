package com.thotael.scrappies.world.terrain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GroundTest {

    @Test
    public void testGetAppearance() throws Exception {
        // given
        Ground ground = new Ground();
        // then
        assertThat(ground.getAppearance()).isEqualTo("_");
    }

    @Test
    public void testToString() throws Exception {
        // given
        Ground ground = new Ground();

        // then
        assertThat(ground.toString()).isEqualTo("[Ground: _]");
    }
}