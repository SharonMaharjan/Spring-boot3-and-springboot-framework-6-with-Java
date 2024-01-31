package com.in28minutes.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.in28minutes.springboot.myfirstwebapp.todo.TodoSevice.TodoService;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoControllerJpa {
	
	private TodoService todoService;
	
	public TodoControllerJpa(TodoService todoService) {
		super();
		this.todoService = todoService;
	}

	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap model) {
		String username = getLoggedInUsername(model);
		List<Todo> todos = todoService.findByUsername(username);
		model.addAttribute("todos",todos);
		return "listTodo";}

	private String getLoggedInUsername(ModelMap model) {
		return (String)model.get("name");
	}
	
	public List<Todo> findByUsername(String username){
		
	Predicate<? super Todo> predicate = todo -> todo.getUsername().equaIgnoreCase(username;
	return todos.stream().filter(predicate).toList();

}
	@RequestMapping(value = "add-todo", method =RequestMethod.GET)
	public String showNewTodoPage(ModelMap model) {
		String username = getLoggedInUsername(model);
		Todo todo = new Todo(0,username,"Default Desc",LocalDate.now().plusYears(1),false);
		model.put("todo", todo);
		return "todo";}
	
	@RequestMapping(value = "add-todo", method =RequestMethod.POST)
	public String addNewTodoPage(ModelMap model,@Valid Todo todo,BindingResult result) {
		if(result.hasErrors()) {
			
			return "todo";
		}
		String username = getLoggedInUsername(model);
		todoService.addTodo(username, todo.getDescription(), todo.getTargetDate(), false);
		return "redirect:list-todos";}
	
	@RequestMapping(value = "update-todo", method =RequestMethod.POST)
	public String updateTodo(ModelMap model,@Valid Todo todo,BindingResult result) {
		if(result.hasErrors()) {
			
			return "todo";
		}
		String username = getLoggedInUsername(model);
		todo.setUsername(username);
		todoService.updateTodo(todo);
		return "redirect:list-todos";}
	
	@RequestMapping("delete-todos")
	public String deleteTodo(@RequestParam int id) {
		todoService.deleteById(id);
		return "redirect:list-todos";}
	
	@RequestMapping("update-todos")
	public String showUpdateTodoPage(@RequestParam int id,ModelMap model) {
		Todo todo = todoService.findById(id);
		model.addAttribute("todo",todo);
		return "todo";}

	
}