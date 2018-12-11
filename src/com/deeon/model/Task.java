package com.deeon.model;

import java.io.Serializable;
import java.util.UUID;

import static java.util.UUID.randomUUID;

public class Task implements Serializable {

    private final UUID id;
    private final String name;

    public Task(final String name) {

        this.id = randomUUID();
        this.name = name;

    }

    public Task(final UUID uuid, final String name) {

        this.id = uuid;
        this.name = name;


    }

    public String getName() {
        return name;
    }

    public UUID getId() {
        return id;
    }

    @Override
    public String toString() {
        return name;

    }
}
