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
    public void shouldAddAndReturnAllTodos() {
        // given
        dummyTodoRepository.save(new Todo("Visit Voltron"));
        dummyTodoRepository.save(new Todo("Say Good Bye to the Astro Boy"));

        // when
        List<Todo> todos = dummyTodoRepository.getAll();

        // then
        assertThat(todos.get(0).getName(), is("Visit Voltron"));
        assertThat(todos.get(1).getName(), is("Say Good Bye to the Astro Boy"));
        assertThat(todos.size(), is(2));
    }
}