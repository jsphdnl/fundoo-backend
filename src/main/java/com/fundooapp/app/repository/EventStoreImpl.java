package com.fundooapp.app.repository;

import com.fundooapp.app.entity.Entity;
import com.fundooapp.app.event.Event;

public class EventStoreImpl implements EventStore<Event<Entity>> {

    EventRepository<Event<Entity>> eventRepository;

    public EventStoreImpl() {

    }

    public EventStoreImpl(EventRepository<Event<Entity>> eventRepository) {
        super();
        this.eventRepository = eventRepository;
    }

    public void save(Event<Entity> event) {
        eventRepository.save(event);

    }

    public void rollBack(Event<Entity> event) {
        eventRepository.delete(event.getAggregateId(), event.getTimestamp());

    }

    public Event<Entity> getAggregatedEntity(String aggRootId) {
        return null;
    }

}