package com.deeon.controller;

import com.deeon.model.ITaskStorage;
import com.deeon.model.SQLTaskStorage;
import com.deeon.view.GUIView;
import com.deeon.view.IGUIView;
import com.google.inject.AbstractModule;

public class GUIAppConModule extends AbstractModule {

    @Override
    public void configure() {
        bind(IGUIView.class).to(GUIView.class);
        bind(ITaskStorage.class).to(SQLTaskStorage.class);
    }
}
