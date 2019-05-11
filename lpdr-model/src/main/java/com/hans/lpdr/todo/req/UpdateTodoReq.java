package com.hans.lpdr.todo.req;

public class UpdateTodoReq {

    private int todoId;
    private String content;

    public int getTodoId() {
        return todoId;
    }

    public void setTodoId(int todoId) {
        this.todoId = todoId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
