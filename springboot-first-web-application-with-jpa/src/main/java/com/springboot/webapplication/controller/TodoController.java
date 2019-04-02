package com.springboot.webapplication.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springboot.webapplication.model.Todo;
import com.springboot.webapplication.repository.TodoRepository;

@Controller // this will map the Controller to be picked up by the DispacherServlet
@SessionAttributes("name")
public class TodoController {
	// creating a service class for the validation here
	
	
	@Autowired 
	TodoRepository todoRepository;
	
	
	//adding the functionality for the initBinder which binds different type of other than the string to be used in the program
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		//date => dd/MM/yyyy
		SimpleDateFormat dateFormat =new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat,false));
	}
	// List-TODO method for the TODO list
	@RequestMapping(value = "/list-todos", method = RequestMethod.GET) // this will map the login as the start of
																		// spring-boot
	public String showTodosList(ModelMap model) {
		String name = getLoggedInUserName(model);
		//adding the changes for the JPA repository
		model.put("todos", todoRepository.findByUser(name));
	
		//model.put("todos", service.retrieveTodos(name));
		return "list-todos";
	}
	/**
	 * @param model
	 * @return
	 */
	private String getLoggedInUserName(ModelMap model) {
		return (String) model.get("name");
	}

	// this is the method for the showing TODO Add Page
	@RequestMapping(value = "/add-todo", method = RequestMethod.GET)
	public String showAddTodoPage(ModelMap model) {
		//adding the values for the default value of model
		model.addAttribute("todo", new Todo(0,getLoggedInUserName(model),"Default Desc",new Date(),false));
		return "todo";
	}

	// Delete-TODO method for the TODO list
	@RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
	public String deleteTodos(@RequestParam int id) {
		
		// calling the method for the todos-delete
		//adding the changes for the JPA repository
		todoRepository.deleteById(id);
		//	service.deleteTodo(id);
		return "redirect:/list-todos";
	}

	// Add-TODO method for the TODO list
	@RequestMapping(value = "/add-todo", method = RequestMethod.POST)
	public String addTodos(ModelMap model, @Valid Todo todo,BindingResult result) { //adding the binding result to see the validation result
		// calling the method for the todos-add
		//also calling the validation of the results
		if (result.hasErrors()) {
			return("todo");
		}
		//adding the code for the repository
		todo.setUser(getLoggedInUserName(model));
		todoRepository.save(todo);
		
		//service.addTodo(getLoggedInUserName(model), todo.getDesc(), todo.getTargDate(), false);
		return "redirect:/list-todos";
	}
	// Update-TODO page method for the TODO list
		@RequestMapping(value = "/update-todo", method = RequestMethod.GET)
		public String updateTodoPage(@RequestParam int id,ModelMap model) {
			// calling the method for the todos-delete
			//adding the changes for the JPA repository
			//Todo todo = service.retrieveTodo(id); //retrieve the todo from the controller and take it to todo page
			Optional<Todo> todo = todoRepository.findById(id) ;
			
			
			//then put it back to the view using the model
			model.put("todo", todo);
			return "todo"; //this will redirect them back to todo page
		}
		// Update-TODO  method for the TODO list
				@RequestMapping(value = "/update-todo", method = RequestMethod.POST)
				public String updateTodo(ModelMap model,@Valid Todo todo,BindingResult result) {
					
					//calling the validation of the results
					if (result.hasErrors()) {
						return("todo");
					}
					//also setting the user for the update here as essential field
					todo.setUser(getLoggedInUserName(model));
					// calling the method for the todo-update
					
					//adding the changes for the JPA repository
					todoRepository.save(todo);
					
					//service.updateTodo(todo); //retrieve the todo from the controller and take it to todo page
					//then put it back to the view using the model
					
					return "redirect:/list-todos"; //this will redirect them back to todo page
				}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}//class
