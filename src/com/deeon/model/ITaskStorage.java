package com.deeon.model;

import java.util.List;

public interface ITaskStorage {

    List<Task> getTaskCollection();
    int getSize();
    void updateStorage(List<Task> list);
}
