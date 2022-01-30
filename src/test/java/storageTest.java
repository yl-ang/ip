import org.junit.jupiter.api.Test;
import duke.storage.Storage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class storageTest {

    @Test
    public void loadTest() {
        assertEquals("[T][ ] sleep", new Storage("data/tasks.txt").load().get(0).toString());
    }

}
