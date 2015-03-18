import org.axonframework.test.FixtureConfiguration;
import org.axonframework.test.Fixtures;
import org.junit.Before;
import org.junit.Test;

public class TodoItemTest {
    public static final String FIRST_TODO = "first todo";
    public static final String FIRST_TODO_DESCRIPTION = "first todo description";
    private FixtureConfiguration<TodoItem> fixture;

    @Before
    public void setUp() {
        fixture = Fixtures.newGivenWhenThenFixture(TodoItem.class);
    }

    @Test
    public void testCreateToDoItem() throws Exception {
        fixture.given()
                .when(new CreateToDoItemCommand(FIRST_TODO, FIRST_TODO_DESCRIPTION))
                .expectEvents(new ToDoItemCreatedEvent(FIRST_TODO, FIRST_TODO_DESCRIPTION));
    }

    @Test
    public void testMarkToDoItemAsCompleted() throws Exception {
        fixture.given(new ToDoItemCreatedEvent(FIRST_TODO, FIRST_TODO_DESCRIPTION))
                .when(new MarkCompletedCommand(FIRST_TODO))
                .expectEvents(new ToDoItemCompletedEvent(FIRST_TODO));
    }
}