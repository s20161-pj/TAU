import org.example.intefaces.ITodoService;

import java.util.Arrays;
import java.util.List;

public class TodoServiceStub implements ITodoService {
    public List<String> retrieveTodos(String user) {
        return Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
    }
}
