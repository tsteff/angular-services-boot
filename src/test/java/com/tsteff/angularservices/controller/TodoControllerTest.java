package com.tsteff.angularservices.controller;

import org.junit.Before;
import org.junit.Test;

import com.tsteff.angularservices.domain.Todo;
import com.tsteff.angularservices.repository.TodoRepository;

import static org.mockito.Mockito.*;

public class TodoControllerTest {

    private TodoController todoController;
    private TodoRepository todoRepository = mock(TodoRepository.class);

    @Before
    public void setup() {
        todoController = new TodoController(todoRepository);
    }

    @Test
    public void shouldFindAllTodos() {
        // when
        todoController.findTodos();

        // then
        verify(todoRepository).findAll();
    }

    @Test
    public void shouldFindATodo() {
        // when
        todoController.findTodo(1);

        // then
        verify(todoRepository).find(1);
    }

    @Test
    public void shouldAddTodo() {
        // given
        Todo todo = new Todo(1, "title", "description");

        // when
        todoController.addTodo(todo);

        // then
        verify(todoRepository).save(todo);
    }

    @Test
    public void shouldUpdateTodo() {
        // given
        Integer todoId = 100;
        Todo todo = new Todo(todoId, "new", "description");
        Todo savedTodo = new Todo(todoId, "old", "description");

        // when
        when(todoRepository.find(todoId)).thenReturn(savedTodo);
        todoController.updateTodo(todo, todoId);

        // then
        todoRepository.find(todoId);
        todoRepository.save(todo);
    }

    @Test
    public void shouldDeleteATodo() {
        // given
        Integer todoId = 100;

        // when
        todoController.deleteTodo(todoId);

        // then
        verify(todoRepository).delete(todoId);
    }
}