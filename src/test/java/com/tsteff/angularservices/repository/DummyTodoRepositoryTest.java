package com.tsteff.angularservices.repository;

import com.tsteff.angularservices.domain.Todo;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
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
        String title = "Voltron";
        dummyTodoRepository.save(new Todo(title, "Visit"));

        // when
        Todo todo = dummyTodoRepository.find(title);

        // then
        assertThat(todo.getDescription(), is("Visit"));
    }

    @Test
    public void shouldAddAndReturnAllTodos() {
        // given
        dummyTodoRepository.save(new Todo("Voltron", "Visit"));
        dummyTodoRepository.save(new Todo("Astro Boy", "Say Good Bye"));

        // when
        List<Todo> todos = dummyTodoRepository.getAll();

        // then
        assertThat(todos.get(0).getTitle(), is("Voltron"));
        assertThat(todos.get(0).getDescription(), is("Visit"));
        assertThat(todos.get(1).getTitle(), is("Astro Boy"));
        assertThat(todos.get(1).getDescription(), is("Say Good Bye"));
        assertThat(todos.size(), is(2));
    }
}