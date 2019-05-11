package com.hans.lpdr.todo;


import com.hans.lpdr.entity.JSONResult;
import com.hans.lpdr.pojo.Todo;
import com.hans.lpdr.todo.req.DeleteTodoReq;
import com.hans.lpdr.todo.req.PageReq;
import com.hans.lpdr.todo.req.UpdateTodoReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("todo")
public class TodoController {

    @Autowired
    private TodoService todoService;


    @RequestMapping("/add")
    public JSONResult addTodo(String content) {
        int i = todoService.addTodo(content);
        if (i > 0) {
            return JSONResult.ok("增加todo成功!");
        }
        return JSONResult.errorMsg("增加todo失败!");

    }

    @RequestMapping(value = "query", method = RequestMethod.POST)
    public JSONResult queryList(@RequestBody PageReq pageReq) {
        List<Todo> query = todoService.query(pageReq);
        return JSONResult.ok(query);
    }


    @RequestMapping(value = "update", method = RequestMethod.POST)
    public JSONResult updateTodo(@RequestBody UpdateTodoReq updateTodoReq) {
        int todoId = updateTodoReq.getTodoId();
        if (todoId < 0) {
            return JSONResult.errorMsg("更新失败,请检查todoId");
        }
        Todo query = todoService.query(todoId);
        if (query == null) {
            return JSONResult.errorMsg("没有该条todo，请检查todoId");
        }
        query.setContent(updateTodoReq.getContent());
        int i = todoService.updateTodo(query);
        if (i > 0) {
            return JSONResult.ok().setMsg("更新成功");
        }
        return JSONResult.errorMsg("更新失败");
    }


    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public JSONResult deleteTodo(@RequestBody DeleteTodoReq deleteTodoReq) {

        int todoId = deleteTodoReq.getTodoId();
        if (todoId < 0) {
            return JSONResult.errorMsg("删除失败,请检查todoId");
        }

        int i = todoService.deleteTodo(todoId);
        if (i > 0) {
            return JSONResult.ok().setMsg("删除成功");
        }
        return JSONResult.errorMsg("删除失败");

    }
}
