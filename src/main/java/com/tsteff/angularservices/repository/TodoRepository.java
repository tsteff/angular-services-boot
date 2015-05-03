package com.tsteff.angularservices.repository;

import com.tsteff.angularservices.domain.Todo;

import java.util.List;

public interface TodoRepository {
    List<Todo> findAll();
    Todo save(Todo todo);
    Todo find(Integer id);
    void delete(Integer id);
}
