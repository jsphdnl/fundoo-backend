package com.fundooapp.app.entity;

import com.fundooapp.app.event.UserBaseEvent;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import java.util.UUID;

@UserDefinedType("type_user")
public class UserEntity implements Entity{

    @Id
    private String uuid;

    private String name;

    private String email;

    private int age;

    private String status;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UserEntity(String name, String email, int age, String status){
        this.name = name;
        this.email = email;
        this.age = age;
        this.status = status;
        this.uuid = UUID.randomUUID().toString();
    }

    public UserEntity() {

    }

    public UserEntity(String uuid) {
        this.uuid = uuid;
    }



    @Transient
    public UserBaseEvent formUser(String updateBy, String eventedPersona) {

        UserBaseEvent event = new UserBaseEvent(this, "created",
                "trace123");

        event.setUpdateBy(updateBy);

        event.setEventedPersona(eventedPersona);

        return event;
    }

    @Override
    public String getId() {
        return this.uuid;
    }
}
