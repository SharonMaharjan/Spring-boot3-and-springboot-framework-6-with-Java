package com.in28minutes.springboot.myfirstwebapp.todo.TodoSevice;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.in28minutes.springboot.myfirstwebapp.todo.Todo;

import jakarta.persistence.criteria.Predicate;
import jakarta.validation.Valid;
@Service
public class TodoService {
private static List<Todo> todos = new ArrayList<>();
private static int todosCount = 0;
static { 
	todos.add(new Todo(++todosCount,"in28minutes","learn",LocalDate.now().plusYears(1),false));
	todos.add(new Todo(++todosCount,"in28minutes","learn AWS",LocalDate.now().plusYears(2),false));
	todos.add(new Todo(++todosCount,"in28minutes","learn Azure",LocalDate.now().plusYears(3),false));
	todos.add(new Todo(++todosCount,"in28minutes","learn devops",LocalDate.now().plusYears(4),false));
}
public List<Todo> findByUsername(String username){return todos;}
public void addTodo(String username,String description,LocalDate  targetDate,boolean done) {
	Todo todo = new Todo(++todosCount,username,description,targetDate,done);
	todos.add(todo);
}
public void deleteById(int id) {
	Predicate<? super Todo> predicate
	= todo -> todo.getId()== id;
	todos.removeIf(predicate);
}

public Todo findById(int id) {
	Predicate<? super Todo> predicate = todo -> todo.getId()== id;
	todos.stream().filter(predicate).findFirst().get();
	return todo;
}
public void updateTodo(@Valid Todo todo) {
	deleteById(todo.getId());
	todos.add(todo);
}
}
