package com.tsteff.angularservices.repository;

import com.tsteff.angularservices.domain.Todo;

import java.util.List;

public interface TodoRepository {
    List<Todo> getAll();
    void save(Todo todo);
}
