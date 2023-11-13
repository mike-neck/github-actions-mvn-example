package com.example.demo.models;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

public record Value(
        int value,
        @Nullable String string
) {

    public Value(int value) {
        this(value, null);
    }

    public @NonNull String asString() {
        if (string == null) {
            return Integer.toString(value());
        }
        return string;
    }

    public @NonNull Value addString(String str) {
        return new Value(value(), string + str);
    }
}
