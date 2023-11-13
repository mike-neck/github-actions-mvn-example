package com.example.demo.models;

import org.springframework.lang.NonNull;

public interface Rule {

    @NonNull Value apply(@NonNull Value value);
}
