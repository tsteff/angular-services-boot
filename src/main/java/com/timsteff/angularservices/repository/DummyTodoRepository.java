package com.timsteff.angularservices.repository;

import java.util.ArrayList;
import java.util.List;

import com.timsteff.angularservices.domain.Todo;

public class DummyTodoRepository implements TodoRepository{

    private List<Todo> todoList = new ArrayList<Todo>();

    public DummyTodoRepository() {
        todoList.add(new Todo("test 1"));
        todoList.add(new Todo("test 2"));
    }

    @Override
    public List<Todo> getAll() {
        return todoList;
    }
}
