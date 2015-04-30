package com.timsteff.angularservices.repository;

import com.timsteff.angularservices.domain.Todo;

import java.util.List;

public interface TodoRepository {
    List<Todo> getAll();
    void save(Todo todo);
}
