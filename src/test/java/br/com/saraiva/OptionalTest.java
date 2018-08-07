package br.com.saraiva;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class OptionalTest {

    @Test
    public void testMap() {

        final Optional<String> expected = Optional.of("TEST");
        final Optional<String> actual = Optional.of("test").map(String::toUpperCase);

        assertEquals(expected, actual);
    }

    @Test
    public void testMapNotFlat() {

        final Optional<Optional<String>> expected = Optional.of(Optional.of("STRING"));
        final Optional<Optional<String>> actual = Optional.of("string").map(s -> Optional.of("STRING"));

        assertEquals(expected, actual);
    }

    @Test
    public void testFlatMap() {

        final Optional<String> expected = Optional.of("STRING");
        final Optional<String> actual = Optional.of("string").flatMap(s -> Optional.of("STRING"));

        assertEquals(expected, actual);
    }
}
