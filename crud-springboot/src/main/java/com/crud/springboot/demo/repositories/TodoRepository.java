package com.crud.springboot.demo.repositories;

import com.crud.springboot.demo.model.MyTodo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
 * The CrudRespository interface takes in the model and the type of the ID, in our case the model is MyTodo
 * and the ID type is Long. We are now able to use all the CrudRepository methods save(), findOne(), findById(), findAll(),
 * count(), delete(), deleteById() without providing implementation.
 * @Repository annotation marks this interface as a Spring Data JPA repository.
 */
@Repository
public interface TodoRepository extends CrudRepository<MyTodo, Long> {

}
