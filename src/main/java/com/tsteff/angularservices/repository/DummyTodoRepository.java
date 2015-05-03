package com.tsteff.angularservices.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.tsteff.angularservices.domain.Todo;

public class DummyTodoRepository implements TodoRepository{

    private Map<Integer, Todo> todoList = new ConcurrentHashMap<Integer, Todo>();

    @Override
    public List<Todo> findAll() {
        return new ArrayList<Todo>(todoList.values());
    }

    @Override
    public Todo save(Todo todo) {
        if (todo.getId() == null) {
            todo.setId(getNextId());
        }
        todoList.put(todo.getId(), todo);
        return todo;
    }

    @Override
    public Todo find(Integer id) {
        return todoList.get(id);
    }

    @Override
    public void delete(Integer id) {
        todoList.remove(id);
    }

    private Integer getNextId() {
        if (todoList.isEmpty()) {
            return 1;
        } else {
            return Collections.max(todoList.keySet()) + 1;
        }
    }
}
