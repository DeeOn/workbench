package com.deeon.controller;

import com.deeon.model.ITaskStorage;
import com.deeon.model.SQLTaskStorage;
import com.deeon.view.ConsoleView;
import com.deeon.view.IView;
import com.google.inject.AbstractModule;

public class AppConModule extends AbstractModule {
    @Override
    public void configure() {
        bind(IView.class).to(ConsoleView.class);
        bind(ITaskStorage.class).to(SQLTaskStorage.class);
    }
}
