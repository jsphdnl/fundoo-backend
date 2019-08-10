package com.fundooapp.app.event;

import com.fundooapp.app.entity.Entity;
import com.fundooapp.app.entity.UserEntity;
import org.springframework.data.annotation.AccessType;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;
import java.util.Date;

@Table("user")
@AccessType(AccessType.Type.FIELD)
public class UserBaseEvent extends Event<Entity> {

    private UserEntity entity;

    public UserBaseEvent() {

    }

    public UserBaseEvent(UserEntity entity, String eventName, String traceId) {
        super(eventName, traceId);
        this.entity = entity;
    }

    @Override
    @AccessType(AccessType.Type.PROPERTY)
    @PrimaryKeyColumn(name = "aggregateId", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    public String getAggregateId() {
        return this.entity.getId();
    }

    @Override
    @AccessType(AccessType.Type.PROPERTY)
    @PrimaryKeyColumn(name = "timestamp", ordinal = 0, type = PrimaryKeyType.CLUSTERED)
    public Date getTimestamp() {
        return this.timestamp;
    }

    @Override
    @AccessType(AccessType.Type.PROPERTY)
    public UserEntity getEntity() {
        return this.entity;
    }

    public void setEntity(UserEntity entity) {
        this.entity = entity;
    }

    @Override
    public String toString() {
        return "UserBaseEvent [entity=" + entity + "]";
    }

    @Override
    @AccessType(AccessType.Type.PROPERTY)
    public String getUpdateBy() {
        return this.updateBy;
    }

    @Override
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    @Override
    @AccessType(AccessType.Type.PROPERTY)
    public String getEventedPersona() {
        return this.eventedPersona;
    }

    @Override
    public void setEventedPersona(String eventedPersona) {
        this.eventedPersona = eventedPersona;
    }

}
