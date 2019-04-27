package com.merapar.nowakowski.bartlomiej.analyzer;

import com.merapar.nowakowski.bartlomiej.analyzer.handler.LocalDateTimeAdapter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;

public class LocalDateTimeAdapterTest {

    LocalDateTimeAdapter localDateTimeAdapter;

    @Before
    public void setUp() {
        localDateTimeAdapter = new LocalDateTimeAdapter();
    }

    @After
    public void tearDown() {
        localDateTimeAdapter = null;
    }

    @Test
    public void shouldUnmarshal() {
        assertThat(LocalDateTime.parse("2015-07-14T18:39:27.757"))
                .isEqualTo(localDateTimeAdapter.unmarshal("2015-07-14T18:39:27.757"));
    }

    @Test
    public void shouldMarshal() {
        assertThat("2015-07-14T18:39:27.757")
                .isEqualTo(localDateTimeAdapter.marshal(LocalDateTime.parse("2015-07-14T18:39:27.757")));
    }
}
