package br.com.saraiva;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class OptionalTest {

    @Test
    public void testMap() {
        final Optional<String> s = Optional.of("test");
        assertEquals(Optional.of("TEST"), s.map(String::toUpperCase));
    }

    @Test
    public void testMapNotFlat() {
        assertEquals(Optional.of(Optional.of("STRING")),
                Optional.of("string")
                        .map(s -> Optional.of("STRING")));
    }

    @Test
    public void testFlatMap() {
        assertEquals(Optional.of("STRING"), Optional
                .of("string")
                .flatMap(s -> Optional.of("STRING")));
    }
}
