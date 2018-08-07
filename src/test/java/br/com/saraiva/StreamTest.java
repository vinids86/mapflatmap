package br.com.saraiva;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class StreamTest {

    @Test
    public void testMap() {

        final List<String> expected = Arrays.asList("A", "B");

        final List<String> actual = Stream.of("a", "b")
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        assertEquals(expected, actual);
    }

    @Test
    public void testMapNotFlat() {

        final List<List<String>> expected = Arrays.asList(Collections.singletonList("A"), Collections.singletonList("B"));

        final List<Stream<String>> actual = Stream.of(Collections.singletonList("a"), Collections.singletonList("b"))
                .map(l -> l.stream().map(String::toUpperCase))
                .collect(Collectors.toList());

        assertEquals(expected, actual);
    }

    @Test
    public void testFlatMap() {

        final List<String> expected = Arrays.asList("A", "B");

        List<List<String>> list = new ArrayList<>();
        List<String> nestedList = new ArrayList<>();
        nestedList.add("a");
        nestedList.add("b");
        list.add(nestedList);

        final List<String> actual = list.stream()
                .flatMap(Collection::stream)
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        assertEquals(expected, actual);
    }
}
