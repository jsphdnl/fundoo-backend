package com.fundooapp.app;

import com.fundooapp.app.entity.Entity;
import com.fundooapp.app.event.Event;
import com.fundooapp.app.repository.DefaultEventHandler;
import com.fundooapp.app.repository.EventStore;
import com.fundooapp.app.repository.EventStoreImpl;
import com.fundooapp.app.repository.UserEventRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableAutoConfiguration
public class AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

	@Bean(name = "userEventHandler")
	public DefaultEventHandler getTusMigrationHandler(UserEventRepository repo) {
		EventStore<Event<Entity>> store = new EventStoreImpl(repo);
		return new DefaultEventHandler(store);
	}

}
