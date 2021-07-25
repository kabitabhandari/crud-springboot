package com.crud.springboot.demo.bootstrap;

import com.crud.springboot.demo.model.MyTodo;
import com.crud.springboot.demo.model.TodoStatus;
import com.crud.springboot.demo.repositories.TodoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TodoLoader implements CommandLineRunner {
    public final TodoRepository todoRepository;  // yaha @autowired why not write?

    public TodoLoader(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        loadTodos();
        insertTodos();
    }

    private void insertTodos() {
        todoRepository.save(new MyTodo( "notitle", "nodescription", TodoStatus.COMPLETED));
    }

    private void loadTodos() {
        if (todoRepository.count() == 0) {
            todoRepository.save(
                    MyTodo.builder()
                            .title("Go to market")
                            .description("Buy eggs from market")
                            .todoStatus(TodoStatus.NOT_COMPLETED)
                            .build()
            );
            todoRepository.save(
                    MyTodo.builder()
                            .title("Go to school")
                            .description("Complete assignments")
                            .todoStatus(TodoStatus.NOT_COMPLETED)
                            .build()
            );
            System.out.println(">>> Sample Todos Loaded");
        }
    }
}
