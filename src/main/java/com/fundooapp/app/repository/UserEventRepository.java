package com.fundooapp.app.repository;

import com.fundooapp.app.entity.Entity;
import com.fundooapp.app.event.Event;
import com.fundooapp.app.event.UserBaseEvent;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface UserEventRepository
        extends CrudRepository<UserBaseEvent, String>, EventRepository<Event<Entity>> {

    @Query("delete from user where aggregateId=:aggregateId and timestamp=:timestamp")
    public void delete(@Param("aggregateId") String aggregateId, @Param("timestamp") Date timestamp);

    @Query("select * from user where aggregateId=:aggregateId order by timestamp desc limit 1")
    public UserBaseEvent findOne(@Param("aggregateId") String aggregateId);

    @Query("select * from user where aggregateId=:aggregateId order by timestamp asc")
    public List<UserBaseEvent> findAllEvents(@Param("aggregateId") String aggregateId);


}