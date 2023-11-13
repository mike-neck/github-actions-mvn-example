package com.example.demo.models;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DefaultRuleTest {

    @Test
    void throwsException() throws ClassNotFoundException {
        Class.forName("unknwon.class.Name");
    }

    @ParameterizedTest
    @CsvSource(textBlock = """
            factor | text | value | string | expected
            3 | Foo | 2 | null | 2
            3 | Foo | 3 | null | Foo
            """, delimiter = '|', useHeadersInDisplayName = true, nullValues = {"null"})
    void testThree(int factor, String text, int value, String string, String expected) {
        Rule rule = new DefaultRule(factor, text);
        String valueString = string.equals("null") ? null : string;
        Value input = new Value(value, valueString);
        Value actual = rule.apply(input);
        assertEquals(expected, actual.asString());
    }
}
