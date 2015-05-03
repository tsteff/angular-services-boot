package com.tsteff.angularservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tsteff.angularservices.domain.Todo;
import com.tsteff.angularservices.repository.TodoRepository;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private TodoRepository todoRepository;

    @Autowired
    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Todo> findTodos() {
        return todoRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Todo findTodo(@PathVariable Integer id) {
        return todoRepository.find(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Todo addTodo(@RequestBody Todo todo) {
        return todoRepository.save(todo);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Todo updateTodo(@RequestBody Todo todo, @PathVariable Integer id) {
        Todo savedTodo = todoRepository.find(id);
        savedTodo.setTitle(todo.getTitle());
        savedTodo.setDescription(todo.getDescription());
        return todoRepository.save(savedTodo);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteTodo(@PathVariable Integer id) {
        todoRepository.delete(id);
    }
}