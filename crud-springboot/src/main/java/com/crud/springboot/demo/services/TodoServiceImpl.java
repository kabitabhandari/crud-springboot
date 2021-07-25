package com.crud.springboot.demo.services;

import com.crud.springboot.demo.model.MyTodo;
import com.crud.springboot.demo.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService{

    @Autowired
    TodoRepository todoRepository;

    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }
    @Override
    public List<MyTodo> getTodos() {
        List<MyTodo> todos = new ArrayList<>();
        //todoRepository.findAll().forEach((e1)->todos.add(e1));
        todoRepository.findAll().forEach(todos::add);
        return todos;
    }

    @Override
    public Optional<MyTodo> getTodoById(Long id) {
        return todoRepository.findById(id);
    }

    @Override
    public MyTodo insert(MyTodo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public void updateTodo(Long id, MyTodo todo) {
        MyTodo todoFromDb = todoRepository.findById(id).get();
        System.out.println(todoFromDb.toString());
        todoFromDb.setTodoStatus(todo.getTodoStatus());
        todoFromDb.setDescription(todo.getDescription());
        todoFromDb.setTitle(todo.getTitle());
        todoRepository.save(todoFromDb);
    }

    @Override
    public void deleteTodo(Long todoId) {
        todoRepository.deleteById(todoId);
    }

}
