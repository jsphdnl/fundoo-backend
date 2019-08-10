package com.fundooapp.app.repository;

import com.fundooapp.app.entity.Entity;
import com.fundooapp.app.event.Event;

public interface EventHandler<T extends Event<Entity>> {

    void onEvent(T event);

    void onEventDelete(T event);

}

