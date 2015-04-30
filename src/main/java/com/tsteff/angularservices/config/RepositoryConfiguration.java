package com.tsteff.angularservices.config;

import com.tsteff.angularservices.repository.DummyTodoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tsteff.angularservices.repository.TodoRepository;

@Configuration
public class RepositoryConfiguration {

    @Bean
    public TodoRepository todoRepository() {
        return new DummyTodoRepository();
    }
}
