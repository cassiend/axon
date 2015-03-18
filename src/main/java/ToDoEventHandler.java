import org.axonframework.eventhandling.annotation.EventHandler;

public class ToDoEventHandler {

    @EventHandler
    public void handle(ToDoItemCreatedEvent toDoItemCreatedEvent) {
        System.out.println("We've got something to do: " + toDoItemCreatedEvent.getDescription() + " (" + toDoItemCreatedEvent.getTodoId() + ")");
    }

    @EventHandler
    public void handle(ToDoItemCompletedEvent toDoItemCompletedEvent){
        System.out.println("We've completed a task: " + toDoItemCompletedEvent.getTodoId());
    }
}
