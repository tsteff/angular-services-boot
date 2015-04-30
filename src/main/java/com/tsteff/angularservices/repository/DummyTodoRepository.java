package com.tsteff.angularservices.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.tsteff.angularservices.domain.Todo;

public class DummyTodoRepository implements TodoRepository{

    private Map<String, Todo> todoList = new ConcurrentHashMap<String, Todo>();

    @Override
    public List<Todo> getAll() {
        return new ArrayList<Todo>(todoList.values());
    }

    @Override
    public void save(Todo todo) {
        todoList.put(todo.getTitle(), todo);
    }

    @Override
    public Todo find(String title) {
        return todoList.get(title);
    }
}
