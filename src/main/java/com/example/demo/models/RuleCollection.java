package com.example.demo.models;

import org.springframework.lang.NonNull;

import java.util.Collection;

public record RuleCollection(
        @NonNull Collection<Rule> rules
) implements Rule {

    @NonNull
    @Override
    public Value apply(@NonNull Value value) {
        Value v = value;
        for (Rule rule : rules) {
            v = rule.apply(v);
        }
        return v;
    }
}
