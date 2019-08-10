package com.fundooapp.app.userDetails;

import com.fundooapp.app.command.UserCommand;
import com.fundooapp.app.entity.Entity;
import com.fundooapp.app.entity.UserEntity;
import com.fundooapp.app.event.Event;
import com.fundooapp.app.event.UserBaseEvent;
import com.fundooapp.app.repository.EventHandler;
import com.fundooapp.app.repository.UserEventRepository;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
public class UserDetailsController {

    @Autowired
    @Qualifier(value = "userEventHandler")
    private EventHandler<Event<Entity>> eventEventHandler;

    @Autowired
    private UserEventRepository userEventRepository;

    @PostMapping
    public ResponseEntity<UserDetails> saveUserDetails(
            @RequestBody(required = true) UserCommand userCommand){

        UserDetails userDetails = new UserDetails();

        UserEntity userEntity = new UserEntity(userCommand.getName(), userCommand.getEmail(),
                userCommand.getAge(), userCommand.getStatus());

        UserBaseEvent baseEvent = userEntity.formUser("create", MDC.get("traceId"));

        baseEvent.setUpdateBy("system");
        baseEvent.setEventedPersona("dealer");
        baseEvent.setAggregateId(userEntity.getUuid());

        eventEventHandler.onEvent(baseEvent);

        UserBaseEvent userBaseEvent = userEventRepository.findOne(baseEvent.getAggregateId());

        UserDetails details = getUserDetails(userBaseEvent);

        return ResponseEntity.ok().body(details);
    }

    @GetMapping(value = "/allUsers")
    public ResponseEntity<List<UserDetails>> getAllUserDetails(){

        Iterable<UserBaseEvent> listUser = userEventRepository.findAll();

        List<UserDetails> users = new ArrayList<>();

        listUser.forEach(userBaseEvent -> {
            UserDetails details = getUserDetails(userBaseEvent);
            users.add(details);
        });

        return ResponseEntity.ok().body(users);
    }

    @GetMapping(value = "/userDetails")
    public ResponseEntity<UserDetails> getUserDetails(@RequestParam("userId") String userId ){

        UserBaseEvent user = userEventRepository.findOne(userId);

        UserDetails details = getUserDetails(user);


        return ResponseEntity.ok().body(details);
    }

    private UserDetails getUserDetails(UserBaseEvent user) {
        UserDetails details = new UserDetails();
        details.setName(user.getEntity().getName());
        details.setId(user.getEntity().getId());
        details.setAge(user.getEntity().getAge());
        details.setEmail(user.getEntity().getEmail());
        details.setSignStatus(user.getEntity().getStatus().isEmpty() ? false : true);
        return details;
    }
}
