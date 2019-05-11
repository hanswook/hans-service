package com.hans.lpdr.todo.impl;

import com.github.pagehelper.PageHelper;
import com.hans.lpdr.mapper.TodoMapper;
import com.hans.lpdr.pojo.Todo;
import com.hans.lpdr.todo.TodoService;
import com.hans.lpdr.todo.req.PageReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {


    @Autowired
    private TodoMapper todoMapper;

    @Override
    public int addTodo(String content) {

        Date now = new Date();

        Todo todo = new Todo();
        todo.setContent(content);
        todo.setCreateTime(now);
        todo.setUpdateTime(now);

        int i = todoMapper.insertSelective(todo);
        return i;
    }

    @Override
    public List<Todo> query(PageReq pageReq) {
        PageHelper.startPage(pageReq.getPageNow(), pageReq.getPageSize());

        Example example = new Example(Todo.class);
        List<Todo> todos = todoMapper.selectByExample(example);
        return todos;
    }

    @Override
    public Todo query(int id) {
        Example example = new Example(Todo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("uId", id);
        List<Todo> todos = todoMapper.selectByExample(example);
        if (todos.size() > 0) {
            return todos.get(0);
        }
        return null;
    }

    @Override
    public int updateTodo(Todo todo) {
        Date now = new Date();
        todo.setUpdateTime(now);
        int i = todoMapper.updateByPrimaryKey(todo);
        return i;
    }

    @Override
    public int deleteTodo(int id) {
        int i = todoMapper.deleteByPrimaryKey(id);
        return i;
    }
}
