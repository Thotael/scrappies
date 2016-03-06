package com.thotael.scrappies.animalcule;

import com.thotael.scrappies.world.animalcule.Scrappy;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class ScrappyTest {

    private Scrappy scrappy;

    @Before
    public void before() {
        scrappy = new Scrappy();
    }

    @Test
    public void construction() {
        // when
        scrappy = new Scrappy();

        // then
        assertNotNull(scrappy);
    }

    @Test
    public void appearance() {
        // when
        String appearance = scrappy.getAppearance();

        // then
        assertThat(appearance, is("$"));
    }

}