package com.fundooapp.app.event;

import com.fundooapp.app.entity.Entity;

import java.util.Date;
import java.util.UUID;

public abstract class Event<T extends Entity> {

    protected String aggregateId;
    protected Date timestamp;
    protected String type;
    protected String id;
    protected String traceId;
    protected String updateBy;
    protected String eventedPersona;

    public Event() {
    }

    public Event(String type, String traceId) {
        this.id = UUID.randomUUID().toString();
        this.timestamp = new Date();
        this.type = type;
        this.traceId = traceId;
    }

    public String getType() {
        return this.type;
    }

    public String getId() {
        return this.id;
    }

    public abstract T getEntity();

    public abstract String getAggregateId();

    public abstract Date getTimestamp();

    public abstract String getUpdateBy();

    public abstract String getEventedPersona();

    public void setAggregateId(String aggregateId) {
        this.aggregateId = aggregateId;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public String getTraceId() {
        return traceId;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public void setEventedPersona(String eventedPersona) {
        this.eventedPersona = eventedPersona;
    }
}
