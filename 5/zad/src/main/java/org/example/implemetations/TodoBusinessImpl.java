package org.example.implemetations;

import org.example.intefaces.ITodoService;

import java.util.ArrayList;
import java.util.List;

public class TodoBusinessImpl {
    private ITodoService todoService;

    public TodoBusinessImpl(ITodoService toDoService) {
        this.todoService = toDoService;
    }

    public List<String> retrieveTodosRelatedToSpring(String user) {
        List<String> filteredTodos = new ArrayList<String>();
        List<String> allTodos = todoService.retrieveTodos(user);
        for (String todo : allTodos) {
            if (todo.contains("Spring")) {
                filteredTodos.add(todo);
            }
        }
        return filteredTodos;
    }
}