package com.tsteff.angularservices.repository;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.tsteff.angularservices.domain.Todo;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class DummyTodoRepositoryTest {

    private DummyTodoRepository dummyTodoRepository;

    @Before
    public void setup() {
        dummyTodoRepository = new DummyTodoRepository();
    }

    @Test
    public void shouldRetrieveTodo() {
        // given
        Integer id = 1;
        dummyTodoRepository.save(new Todo(id, "Voltron", "Visit"));

        // when
        Todo todo = dummyTodoRepository.find(id);

        // then
        assertThat(todo.getTitle(), is("Voltron"));
        assertThat(todo.getDescription(), is("Visit"));
    }

    @Test
    public void shouldAddAndReturnAllTodos() {
        // given
        Todo voltronTodo = new Todo(1, "Voltron", "Visit");
        Todo astroTodo = new Todo(2, "Astro Boy", "Say Good Bye");
        dummyTodoRepository.save(voltronTodo);
        dummyTodoRepository.save(astroTodo);

        // when
        List<Todo> todos = dummyTodoRepository.findAll();

        // then
        assertThat(todos, hasItems(voltronTodo, astroTodo));
        assertThat(todos.size(), is(2));
    }

    @Test
    public void shouldDeleteATodo() {
        // given
        dummyTodoRepository.save(new Todo(1, "He Man", "via Grayskull"));
        dummyTodoRepository.save(new Todo(2, "Voltron", "Visit"));
        dummyTodoRepository.save(new Todo(3, "Astro Boy", "Say Good Bye"));

        // when
        dummyTodoRepository.delete(2);

        // then
        assertThat(dummyTodoRepository.find(2), is(nullValue()));
        assertThat(dummyTodoRepository.find(1), is(notNullValue()));
        assertThat(dummyTodoRepository.find(3), is(notNullValue()));
    }
}