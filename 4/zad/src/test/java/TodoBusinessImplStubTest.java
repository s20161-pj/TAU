import org.example.implemetations.TodoBusinessImpl;
import org.example.intefaces.ITodoService;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TodoBusinessImplStubTest {
    @Test
    public void usingAStub() {
        ITodoService todoService = new TodoServiceStub();
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
        List<String> todos = todoBusinessImpl.retrieveTodosRelatedToSpring("Ranga");
        assertEquals(2, todos.size());

    }
}