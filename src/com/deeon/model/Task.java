package com.deeon.model;

import java.io.Serializable;
import java.util.UUID;

import static java.util.UUID.randomUUID;

public class Task implements Serializable {

    private final String name;
    private final UUID id;

    public Task(final String name) {

        this.name = name;
        id = randomUUID();

    }

    public String getName() {
        return name;
    }
}
