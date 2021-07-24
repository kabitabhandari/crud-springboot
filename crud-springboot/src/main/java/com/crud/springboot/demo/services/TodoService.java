package com.crud.springboot.demo.services;

import com.crud.springboot.demo.model.MyTodo;


import java.util.List;
import java.util.Optional;

// A service is an interface from which different implementations of the same functions can be made.
//The interface below defines the base CRUD operations that we will implement in our TodoServiceImpl class.

public interface TodoService {
    List<MyTodo> getTodos();

    Optional<MyTodo> getTodoById(Long id);

    MyTodo insert(MyTodo todo);

    void updateTodo(Long id, MyTodo todo);

    void deleteTodo(Long todoId);
}
