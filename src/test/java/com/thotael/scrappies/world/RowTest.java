package com.thotael.scrappies.world;

import com.thotael.scrappies.world.terrain.Ground;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RowTest {

    private Row row;

    @Before
    public void before() {
        row = new Row(2, new Ground());
    }

    @Test
    public void creationSize() throws Exception {
        // given
        int width = 2;
        Ground element = new Ground();

        // when
        row = new Row(width, element);

        // then
        assertThat(row.getElements().size()).isEqualTo(width);
    }

    @Test
    public void creationContent() throws Exception {
        // given
        int width = 3;
        Ground obj = new Ground();
        List<Object> objects = Arrays.asList(new Ground[] {obj, obj, obj});

        // when
        row = new Row(width, obj);

        // then
        assertThat(row.getElements()).isEqualTo(objects);
    }
}