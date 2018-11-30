package com.deeon.model;

import java.util.List;

public interface ITaskStorage {

    List<Task> getTaskCollection();
    void updateStorage(final List<Task> list);
}
