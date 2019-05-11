package com.hans.lpdr.todo;

import com.hans.lpdr.pojo.Todo;
import com.hans.lpdr.todo.req.PageReq;

import java.util.List;

public interface TodoService {


    int addTodo(String content);


    List<Todo> query(PageReq pageReq);


    Todo query(int id);


    int updateTodo(Todo todo);

    int deleteTodo(int id);


}
