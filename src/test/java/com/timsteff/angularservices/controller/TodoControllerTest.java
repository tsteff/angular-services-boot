package com.timsteff.angularservices.controller;

import org.junit.Before;
import org.junit.Test;

import com.timsteff.angularservices.repository.TodoRepository;

import static org.mockito.Mockito.*;

public class TodoControllerTest {

    private TodoController todoController;
    private TodoRepository todoRepository = mock(TodoRepository.class);

    @Before
    public void setup() {
        todoController = new TodoController(todoRepository);
    }

    @Test
    public void shouldCallTodoRepositoryOnGetTodoListRequest() {
        // when
        todoController.getTodoList();

        // then
        verify(todoRepository).getAll();
    }
}