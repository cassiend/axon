public class ToDoItemCompletedEvent {

    private String todoId;

    public ToDoItemCompletedEvent(String todoId) {
        this.todoId = todoId;
    }

    public String getTodoId() {
        return todoId;
    }
}
