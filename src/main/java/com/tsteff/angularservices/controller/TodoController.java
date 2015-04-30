package com.tsteff.angularservices.controller;

import java.util.List;

import com.tsteff.angularservices.domain.Todo;
import com.tsteff.angularservices.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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