package com.example.demo.models;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RuleCollectionTest {

    @Test
    void noRule() {
        RuleCollection rules = new RuleCollection(List.of());
        List<String> list = IntStream.rangeClosed(1, 5)
                .mapToObj(Value::new)
                .map(rules::apply)
                .map(Value::asString)
                .toList();

        assertEquals(List.of("1", "2", "3", "4", "5"), list);
    }

    @Test
    void singleRule() {
        RuleCollection rules = new RuleCollection(List.of(
                value -> value.value() % 3 == 0 ?
                        value.addString("Foo") :
                        value
        ));

        List<String> list = IntStream.rangeClosed(1, 5)
                .mapToObj(Value::new)
                .map(rules::apply)
                .map(Value::asString)
                .toList();

        assertEquals(List.of("1", "2", "Foo", "4", "5"), list);
    }

    @Test
    void nullPointerException() {
        RuleCollection rules = new RuleCollection(List.of(
                value -> value.value() % 3 == 0 ?
                        value.addString("Foo") :
                        new Value(value.value(), value.string().substring(1))
        ));

        List<String> list = IntStream.rangeClosed(1, 5)
                .mapToObj(Value::new)
                .map(rules::apply)
                .map(Value::asString)
                .toList();

        assertEquals(List.of("1", "2", "Foo", "4", "5"), list);
    }
}
