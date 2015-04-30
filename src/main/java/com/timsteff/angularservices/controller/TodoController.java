package com.timsteff.angularservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.timsteff.angularservices.domain.Todo;
import com.timsteff.angularservices.repository.TodoRepository;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private TodoRepository todoRepository;

    @Autowired
    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Todo> getTodoList() {
        return todoRepository.getAll();
    }
}