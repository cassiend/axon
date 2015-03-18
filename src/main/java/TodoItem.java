import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;

public class TodoItem extends AbstractAnnotatedAggregateRoot {

    @AggregateIdentifier
    private String todoId;

    public TodoItem() {
    }

    @CommandHandler
    public TodoItem(CreateToDoItemCommand createToDoItemCommand) {
        apply(new ToDoItemCreatedEvent(createToDoItemCommand.getTodoId(), createToDoItemCommand.getDescription()));
    }

    @EventHandler
    public void on(ToDoItemCreatedEvent toDoItemCreatedEvent) {
        this.todoId = toDoItemCreatedEvent.getTodoId();
    }

    @CommandHandler
    public void markCompleted(MarkCompletedCommand markCompletedCommand){
        apply(new ToDoItemCompletedEvent(markCompletedCommand.getTodoId()));
    }
}
