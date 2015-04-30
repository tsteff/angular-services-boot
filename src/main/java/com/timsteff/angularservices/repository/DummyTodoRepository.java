package com.timsteff.angularservices.repository;

import java.util.ArrayList;
import java.util.List;

import com.timsteff.angularservices.domain.Todo;

public class DummyTodoRepository implements TodoRepository{

    private List<Todo> todoList = new ArrayList<Todo>();

    @Override
    public List<Todo> getAll() {
        return todoList;
    }

    @Override
    public void save(Todo todo) {
        todoList.add(todo);
    }
}
