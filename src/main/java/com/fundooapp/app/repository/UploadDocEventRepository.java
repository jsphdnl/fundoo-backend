package com.fundooapp.app.repository;

import com.fundooapp.app.entity.Entity;
import com.fundooapp.app.event.Event;
import com.fundooapp.app.event.UploadDocBaseEvent;
import com.fundooapp.app.event.UserBaseEvent;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface UploadDocEventRepository
        extends CrudRepository<UploadDocBaseEvent, String>, EventRepository<Event<Entity>> {

    @Query("delete from upload where aggregateId=:aggregateId and timestamp=:timestamp")
    public void delete(@Param("aggregateId") String aggregateId, @Param("timestamp") Date timestamp);

    @Query("select * from upload where aggregateId=:aggregateId order by timestamp desc limit 1")
    public UploadDocBaseEvent findOne(@Param("aggregateId") String aggregateId);

    @Query("select * from upload where aggregateId=:aggregateId order by timestamp asc")
    public List<UploadDocBaseEvent> findAllEvents(@Param("aggregateId") String aggregateId);


}