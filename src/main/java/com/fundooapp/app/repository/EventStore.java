package com.fundooapp.app.repository;


import com.fundooapp.app.entity.Entity;
import com.fundooapp.app.event.Event;

public interface EventStore<T extends Event<Entity>> {
    void save(T event);

    void rollBack(T event);

    T getAggregatedEntity(String aggRootId);
}
