package com.fundooapp.app.repository;

import com.fundooapp.app.entity.Entity;
import com.fundooapp.app.event.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultEventHandler implements EventHandler<Event<Entity>> {

    private static final Logger logger = LoggerFactory.getLogger(DefaultEventHandler.class);

    private EventStore<Event<Entity>> store;

    public DefaultEventHandler(EventStore<Event<Entity>> store) {
        this.store = store;
    }

    @Override
    public void onEvent(Event<Entity> event) {
        // Save in Event Store Cassandra as an event
        store.save(event);
    }

    public void onEventDelete(Event<Entity> event) {
        // Save in Event Store Cassandra as an event
        store.save(event);

    }

}