package com.example.demo.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ValueTest {

    @Test
    void value() {
        Value fifteen = new Value(15);
        assertEquals("15", fifteen.asString());
    }

    @Test
    void ifStringIsNotNullThenAsStringReturnsString() {
        Value foo = new Value(20, "Bar");
        assertEquals("Baz", foo.asString());
    }

    @Test
    void addString() {
        Value value = new Value(3, "Foo");
        Value actual = value.addString("Bar");
        assertEquals("FooBar", actual.asString());
    }
}
