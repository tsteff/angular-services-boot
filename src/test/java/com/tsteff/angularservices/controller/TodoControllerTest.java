package com.tsteff.angularservices.controller;

import com.tsteff.angularservices.repository.TodoRepository;
import org.junit.Before;
import org.junit.Test;

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