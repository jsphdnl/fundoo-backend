package com.fundooapp.app.repository;

import com.fundooapp.app.entity.Entity;
import com.fundooapp.app.event.Event;

import java.util.Date;

public interface EventRepository<T extends Event<Entity>> {
    T save(T t);

    void delete(String eventKey, Date timestamp);

    T findOne(String id);
}
