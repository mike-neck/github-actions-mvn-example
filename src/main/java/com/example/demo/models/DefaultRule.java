package com.example.demo.models;

import org.springframework.lang.NonNull;

public record DefaultRule(
        int factor,
        @NonNull String text
) implements Rule {
    @Override
    public @NonNull Value apply(@NonNull Value value) {
        if (value.value() % factor == 0) {
            return value.addString(text);
        } else {
            return value;
        }
    }
}
