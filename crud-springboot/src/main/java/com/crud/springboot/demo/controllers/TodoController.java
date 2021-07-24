package com.crud.springboot.demo.controllers;


import com.crud.springboot.demo.model.MyTodo;
import com.crud.springboot.demo.services.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/kabita/todo")
public class TodoController {

   // @Autowired   /////////////////////////////////// why not???
    TodoService todoService;

    public TodoController(TodoService todoService) {

        this.todoService = todoService;
    }

    //The function receives a GET request, processes it and gives back a list of Todo as a response.
    @GetMapping
    public ResponseEntity<List<MyTodo>> getAllTodos() {
        List<MyTodo> todos = todoService.getTodos();
        return new ResponseEntity<>(todos, HttpStatus.OK);
    }

    //The function receives a GET request, processes it, and gives back a list of Todo as a response.
    @GetMapping({"/{todoId}"})
    public ResponseEntity<MyTodo> getTodo(@PathVariable Long todoId) {
        return new ResponseEntity(todoService.getTodoById(todoId), HttpStatus.OK);  /////////// why no <>??
    }

}


/*
* @RestController annotation marks this class as a controller that can process the incoming HTTP requests.
@RequestMapping("/api/v1/todo") annotation sets the base path to the resource endpoints in the controller as /api/v1/todo.
We inject the TodoService through our contractor to be able to use the various methods defined in it within the TodoController class.
@GetMapping annotation indicates that the function processes a GET request.
@PostMapping annotation indicates that a function processes a POST request.
@PutMapping annotation indicates that a function processes a PUT request.
@DeleteMapping annotation indicates that a function processes a DELETE request.
* */
