package com.timsteff.angularservices.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.timsteff.angularservices.repository.DummyTodoRepository;
import com.timsteff.angularservices.repository.TodoRepository;

@Configuration
public class RepositoryConfiguration {

    @Bean
    public TodoRepository todoRepository() {
        return new DummyTodoRepository();
    }
}
